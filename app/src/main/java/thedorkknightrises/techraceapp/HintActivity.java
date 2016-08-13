package thedorkknightrises.techraceapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.mikelau.magictoast.MagicToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flipview.FlipView;

public class HintActivity extends Activity {

    final String TAG = "HintActivity";
    int flippedTile = -1;
    int matches = 0;

    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.hint_background)
    ImageView hintBackground;

    FlipView[] tiles = new FlipView[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        ButterKnife.bind(this);

        setTiles();

        Bundle extras = getIntent().getExtras();

        TileAdapter tileAdapter = new TileAdapter(this);
        // TODO: use bundle to pass and recieve data
        gridView.setAdapter(tileAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, i + " : " + view.toString());
            }
        });
    }

    private void setTiles() {
        for (int i = 0; i < 9; i++)
            tiles[i] = new FlipView(this);
    }

    class TileAdapter extends BaseAdapter {

        Context mContext;

        /**
         * | image resource of icon | position of match |
         */
        int[][] icons;

        public TileAdapter(Context context) {
            mContext = context;
            icons = new int[9][2];
            // Setting default icons with consecutive matches
            for (int i = 0; i < 9; i++) {
                icons[i][0] = R.drawable.ic_clear_white_24dp;
                icons[i][1] = (i%2 == 0)? i+1 : i-1;
            }
        }

        public TileAdapter(Context context, int[][] icons) {
            this(context);
            this.icons = icons;
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
                flipView.setFrontImage(R.drawable.ic_action_done);
                flipView.setRearImage(R.drawable.ic_clear_white_24dp);
                flipView.setClickable(true);
                flipView.setOnClickListener(getOnClickListener(i, flipView));
            } else {
                flipView = (FlipView) view;
            }
            return flipView;
        }

        public View.OnClickListener getOnClickListener(final int i, final FlipView flipView) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flippedTile == i) return;
                    // if tile is currently active
                    flipView.flip(true);
                    Log.d(TAG, "FlippedTile: " + flippedTile);
                    if (flippedTile != -1) {
                        final FlipView flippedView = (FlipView) gridView.getChildAt(flippedTile);
                        if (i == icons[flippedTile][1]) { // Tiles matched
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
                            flipView.flip(false);
                            flippedView.flip(false);
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
}
