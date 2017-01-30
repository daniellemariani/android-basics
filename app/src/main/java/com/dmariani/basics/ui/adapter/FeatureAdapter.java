package com.dmariani.basics.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmariani.basics.R;
import com.dmariani.basics.model.Feature;
import com.dmariani.basics.ui.listener.OnFeatureClickListener;

import java.util.List;

/**
 * Feature Adapter implemented by a RecyclerView to display a list of feature items
 *
 * @author danielle.mariani
 */
public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewHolder> {

    private List<Feature> features;
    private OnFeatureClickListener onFeatureClickListener;

    public FeatureAdapter(List<Feature> features) {
        this.features = features;
    }

    /**
     * Custom click listener
     *
     * @param onFeatureClickListener
     */
    public void setOnFeatureClickListener(OnFeatureClickListener onFeatureClickListener) {
        this.onFeatureClickListener = onFeatureClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a ViewHolder, we inflate the view related to the ViewHolder
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feature, parent, false));
    }

    @Override
    public void onBindViewHolder(FeatureAdapter.ViewHolder holder, int position) {
        Feature feature = features.get(position);
        holder.feature = feature;
        holder.name.setText(feature.getName());
        holder.description.setText(feature.getDescription());
    }

    @Override
    public int getItemCount() {
        return features == null ? 0 : features.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;
        private Feature feature;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textview_feature_name);
            description = (TextView) itemView.findViewById(R.id.textview_feature_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onFeatureClickListener != null) {
                        onFeatureClickListener.onFeatureClick(feature);
                    }
                }
            });
        }
    }
}
