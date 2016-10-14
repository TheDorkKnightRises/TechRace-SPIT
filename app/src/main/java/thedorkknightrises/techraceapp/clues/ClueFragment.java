package thedorkknightrises.techraceapp.clues;

import android.animation.Animator;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import thedorkknightrises.techraceapp.AppConstants;
import thedorkknightrises.techraceapp.R;
import thedorkknightrises.techraceapp.ui.DetailsActivity;

public class ClueFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ClueFragment() {
    }

    public static ClueFragment newInstance(int columnCount) {
        ClueFragment fragment = new ClueFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);

        // Set the adapter
        if (recyclerView != null) {
            final Context context = recyclerView.getContext();
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            SharedPreferences pref = getActivity().getSharedPreferences(AppConstants.PREFS, Context.MODE_PRIVATE);
            view.findViewById(R.id.redbull_banner).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailsActivity.class);
                    i.putExtra("image", R.drawable.redbull);
                    i.putExtra("location", getResources().getString(R.string.redbull_event));
                    i.putExtra("location_desc", getResources().getString(R.string.redbull_desc_long));
                    context.startActivity(i);
                }
            });
            List<ClueContent.Clue> ITEMS = ((pref.getInt(AppConstants.PREFS_GROUP, 1) > 1) ? ClueContent.ITEMS_2 : ClueContent.ITEMS_1).subList(0, pref.getInt(AppConstants.PREFS_LEVEL, 0));
            recyclerView.setAdapter(new ClueAdapter(ITEMS, getActivity()));
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getActivity().invalidateOptionsMenu();
        final FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        if (fab.getVisibility() == View.VISIBLE) {
            fab.animate().scaleX(0).scaleY(0).setDuration(300).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    fab.setClickable(false);
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    fab.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                    fab.setClickable(true);
                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            }).start();
        }
        super.onActivityCreated(savedInstanceState);
    }
}
