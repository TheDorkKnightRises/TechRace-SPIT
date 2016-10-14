package thedorkknightrises.techraceapp.clues;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import thedorkknightrises.techraceapp.R;
import thedorkknightrises.techraceapp.locations.LocationContent;
import thedorkknightrises.techraceapp.ui.DetailsActivity;

public class ClueAdapter extends RecyclerView.Adapter<ClueAdapter.ViewHolder> {

    private final List<ClueContent.Clue> mValues;
    private final Context context;

    public ClueAdapter(List<ClueContent.Clue> items, Context context) {
        mValues = items;
        this.context = context;
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
        holder.mNameView.setText(mValues.get(position).name);
        holder.mDescView.setText(Html.fromHtml(mValues.get(position).details));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra("image", LocationContent.ITEMS.get(holder.getAdapterPosition() + 1).image);
                i.putExtra("clue", mValues.get(holder.getAdapterPosition()).details);
                i.putExtra("location", LocationContent.ITEMS.get(holder.getAdapterPosition() + 1).name);
                i.putExtra("location_desc", LocationContent.ITEMS.get(holder.getAdapterPosition() + 1).details);
                context.startActivity(i);
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
