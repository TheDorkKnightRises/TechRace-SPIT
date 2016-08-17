package thedorkknightrises.techraceapp.clues;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import thedorkknightrises.techraceapp.R;

public class ClueAdapter extends RecyclerView.Adapter<ClueAdapter.ViewHolder> {

    private final List<ClueContent.Clue> mValues;

    public ClueAdapter(List<ClueContent.Clue> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDescView.setText(mValues.get(position).details);
        holder.mNameView.setText(mValues.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mDescView;
        public final TextView mNameView;
        public ClueContent.Clue mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDescView = (TextView) view.findViewById(R.id.location_desc);
            mNameView = (TextView) view.findViewById(R.id.location_name);
        }
    }
}
