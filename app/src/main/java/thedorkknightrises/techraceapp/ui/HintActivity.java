package thedorkknightrises.techraceapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flipview.FlipView;
import thedorkknightrises.techraceapp.AppConstants;
import thedorkknightrises.techraceapp.R;

public class HintActivity extends AppCompatActivity {

    final String TAG = "HintActivity";
    int flippedTile = -1;
    int matches = 0;
    boolean backPressFlag = false;
    int[] icons = {
            R.drawable.ic_account_circle_white_24dp,
            R.drawable.ic_help_white_24dp,
            R.drawable.ic_extension_white_24dp,
            R.drawable.ic_center_focus_weak_white_24dp,
            R.drawable.ic_info_white_24dp,
            R.drawable.ic_settings_white_24dp
    };

    SharedPreferences pref;
    SharedPreferences.Editor edit;

    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.hintRootView)
    CoordinatorLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        ButterKnife.bind(this);

        pref = getSharedPreferences(AppConstants.PREFS, MODE_PRIVATE);
        int hintsRemaining = pref.getInt(AppConstants.PREFS_HINTS, -1);
        edit = pref.edit();
        edit.putInt(AppConstants.PREFS_HINTS, hintsRemaining - 1);
        edit.apply();

        TileAdapter tileAdapter = new TileAdapter(this, getTiles());
        gridView.setAdapter(tileAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_help:
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);

                TextView head = new TextView(this);
                head.setText(R.string.action_help);
                head.setTextSize(24);
                head.setTextColor(Color.WHITE);
                head.setPadding(0, 0, 0, 16);

                TextView content = new TextView(this);
                content.setText(R.string.hints_desc);
                content.setTextSize(20);

                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setBackgroundColor(Color.DKGRAY);
                linearLayout.setPadding(48, 48, 48, 64);
                linearLayout.addView(head);
                linearLayout.addView(content);

                bottomSheetDialog.setTitle(R.string.action_help);
                bottomSheetDialog.setContentView(linearLayout);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                bottomSheetDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!backPressFlag) {
            Toast.makeText(getApplicationContext(), "You lose a hint if you go back now",
                    Toast.LENGTH_SHORT).show();
            backPressFlag = true;

            // Thread to change backPressedFlag to false after 3000ms
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        backPressFlag = false;
                    }
                }
            }).start();
            return;
        }
        super.onBackPressed();
    }

    private List<Tile> getTiles() {
        Random random = new Random();

        List<Tile> tiles = new ArrayList<>(12);

        for (int i = 0; i < 12; i++) {
            tiles.add(new Tile(icons[i%6], -1));
        }
        // Shuffle tiles
        Collections.shuffle(tiles);

        // Match positions of tiles
        for (int i = 0; i < 12; i++) {
            Tile t1 = tiles.get(i);
            for (int j = 0; j < 12; j++) {
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

        public TileAdapter(Context context, List<Tile> tiles) {
            mContext = context;
            this.tiles = tiles;
        }

        @Override
        public int getCount() {
            return 12;
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
                            flippedView.animate().scaleX(0).scaleY(0).withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    flippedView.setVisibility(View.GONE);
                                }
                            }).start();
                            flipView.animate().scaleX(0).scaleY(0).withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    flipView.setVisibility(View.GONE);
                                }
                            }).start();
                            Snackbar snackbar = Snackbar.make(rootView, "Match", Snackbar.LENGTH_SHORT);
                            snackbar.getView().setBackgroundColor(getResources().getColor(R.color.successGreen));
                            snackbar.show();
                            matches++;

                            // All matched but one
                            if (matches == 6) {
                                Log.d(TAG, "All matched");
                                pref = getSharedPreferences(AppConstants.PREFS, MODE_PRIVATE);
                                edit = pref.edit();
                                edit.putBoolean(AppConstants.PREFS_BONUS, true);
                                edit.apply();
                                finish();
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
                            Snackbar snackbar = Snackbar.make(rootView, "No Match", Snackbar.LENGTH_SHORT);
                            snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            snackbar.show();
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
