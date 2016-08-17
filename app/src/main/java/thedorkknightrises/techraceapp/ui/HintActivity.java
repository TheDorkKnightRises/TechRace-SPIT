package thedorkknightrises.techraceapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.mikelau.magictoast.MagicToast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flipview.FlipView;
import thedorkknightrises.techraceapp.R;

public class HintActivity extends Activity {

    final String TAG = "HintActivity";
    int flippedTile = -1;
    int matches = 0;
    int[] icons = {
            R.drawable.ic_account_circle_white_24dp,
            R.drawable.ic_help_white_24dp,
            R.drawable.ic_extension_white_24dp,
            R.drawable.ic_center_focus_weak_white_24dp
    };

    SharedPreferences pref;
    SharedPreferences.Editor edit;

    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.hint_background)
    ImageView hintBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        ButterKnife.bind(this);

        pref = getSharedPreferences("Prefs", MODE_PRIVATE);
        int hintsRemaining = pref.getInt("hints_remaining", -1);
        edit = pref.edit();
        edit.putInt("hints_remaining", hintsRemaining - 1);
        edit.apply();

        Bundle extras = getIntent().getExtras();
        int drawableHint = extras.getInt("hint_drawable", -1);
        TileAdapter tileAdapter;

        if (drawableHint == -1) tileAdapter = new TileAdapter(this);
        else tileAdapter = new TileAdapter(this, getTiles(drawableHint));

        gridView.setAdapter(tileAdapter);
    }

    private List<Tile> getTiles(int drawableHint) {
        Random random = new Random();

        List<Tile> tiles = new ArrayList<>(9);
        int hintPosition = random.nextInt(9);
        tiles.add(new Tile(drawableHint, -1));

        for (int i = 0; i < 4; i++) {
            tiles.add(new Tile(icons[i], -1));
            tiles.add(new Tile(icons[i], -1));
        }
        // Shuffle tiles
        Collections.shuffle(tiles);

        // Match positions of tiles
        for (int i = 0; i < 9; i++) {
            Tile t1 = tiles.get(i);
            for (int j = 0; j < 9; j++) {
                Tile t2 = tiles.get(j);
                if (i != j && t1.getDrawable() == t2.getDrawable()) {
                    t1.setMatchPosition(j);
                    t2.setMatchPosition(i);
                    tiles.set(i, t1);
                    tiles.set(j, t2);
                    break;
                }
            }
        }

        log(tiles);
        return tiles;
    }

    private void log(List<Tile> tiles) {
        String log = "";
        for (int i = 0; i < tiles.size(); i++)
            log += "\n" + tiles.get(i).toString();
        Log.d(TAG, log);
    }

    class TileAdapter extends BaseAdapter {

        Context mContext;
        List<Tile> tiles;

        public TileAdapter(Context context) {
            mContext = context;
            tiles = new ArrayList<>(9);
            // Setting default tiles with consecutive matches
            for (int i = 0; i < 9; i++) {
                tiles.add(new Tile(R.drawable.ic_clear_white_24dp,
                        (i%2 == 0)? i+1 : i-1));
            }
        }

        public TileAdapter(Context context, List<Tile> tiles) {
            this(context);
            this.tiles = tiles;
        }

        @Override
        public int getCount() {
            return 9;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            final FlipView flipView;
            if (view == null) {
                flipView = new FlipView(mContext);
                flipView.setLayoutParams(new GridView.LayoutParams(256, 256));
                flipView.setPadding(8, 8, 8, 8);
                flipView.setForegroundGravity(Gravity.CENTER);
                flipView.setFrontImage(R.drawable.ic_hint_white_24dp);
                flipView.setRearImage(tiles.get(i).getDrawable());
                flipView.setClickable(true);
                flipView.setOnClickListener(getOnClickListener(i, flipView));
            } else {
                flipView = (FlipView) view;
            }
            return flipView;
        }

        private View.OnClickListener getOnClickListener(final int i, final FlipView flipView) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flippedTile == i) return;
                    // if tile is currently active
                    flipView.flip(true);
                    Log.d(TAG, "FlippedTile: " + flippedTile);
                    if (flippedTile != -1) {
                        final FlipView flippedView = (FlipView) gridView.getChildAt(flippedTile);
                        if (i == tiles.get(flippedTile).getMatchPosition()) { // Tiles matched
                            Log.d(TAG, "Icons match");
                            flippedView.setVisibility(View.INVISIBLE);
                            flipView.setVisibility(View.INVISIBLE);
                            MagicToast.showSuccess(getApplicationContext(), "Match");
                            matches++;

                            // All matched but one
                            if (matches == 4) {
                                Log.d(TAG, "All matched but one");
                                hintBackground.setVisibility(View.VISIBLE);

                                // TODO: Show the icon
                            }
                        } else { // Tiles don't match
                            Log.d(TAG, "Icons don't match");
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Reverse them
                                    flipView.flip(false);
                                    flippedView.flip(false);
                                }
                            }, 1000);
                            MagicToast.showError(getApplicationContext(), "No Match");
                        }
                        flippedTile = -1;
                    } else {
                        flipView.flip(true);
                        flippedTile = i;
                    }
                    Log.d(TAG, "Position: " + i);
                }
            };
        }
    }

    class Tile {
        private int matchPosition;
        private int drawable;

        public Tile(int drawable, int matchPosition) {
            this.drawable = drawable;
            this.matchPosition = matchPosition;
        }

        public int getDrawable() {
            return drawable;
        }

        public void setDrawable(int drawable) {
            this.drawable = drawable;
        }

        public int getMatchPosition() {
            return matchPosition;
        }

        public void setMatchPosition(int matchPosition) {
            this.matchPosition = matchPosition;
        }

        @Override
        public String toString() {
            return drawable + "\t" + matchPosition;
        }
    }
}
