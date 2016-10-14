package thedorkknightrises.techraceapp.locations;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import thedorkknightrises.techraceapp.AppConstants;
import thedorkknightrises.techraceapp.R;
import thedorkknightrises.techraceapp.clues.ClueContent;
import thedorkknightrises.techraceapp.ui.DetailsActivity;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private final List<LocationContent.Location> mValues;
    private final Context context;

    public LocationAdapter(List<LocationContent.Location> items, Context context) {
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
        holder.mDescView.setText(Html.fromHtml(mValues.get(position).details));
        holder.mNameView.setText(mValues.get(position).name);
        final SharedPreferences pref = context.getSharedPreferences(AppConstants.PREFS, Context.MODE_PRIVATE);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra("image", mValues.get(holder.getAdapterPosition()).image);
                i.putExtra("location", mValues.get(holder.getAdapterPosition()).name);
                i.putExtra("location_desc", mValues.get(holder.getAdapterPosition()).details);
                List<ClueContent.Clue> ITEMS = (pref.getInt(AppConstants.PREFS_GROUP, 1) > 1) ? ClueContent.ITEMS_2 : ClueContent.ITEMS_1;
                if ((holder.getAdapterPosition() - 1) != -1)
                    i.putExtra("clue", ITEMS.get(holder.getAdapterPosition() - 1).details);
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
        public LocationContent.Location mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDescView = (TextView) view.findViewById(R.id.location_desc);
            mNameView = (TextView) view.findViewById(R.id.location_name);
        }
    }
}
