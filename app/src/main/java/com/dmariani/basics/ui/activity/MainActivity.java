package com.dmariani.basics.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dmariani.basics.R;
import com.dmariani.basics.model.Feature;
import com.dmariani.basics.ui.adapter.FeatureAdapter;
import com.dmariani.basics.ui.listener.OnFeatureClickListener;
import com.dmariani.basics.ui.navigation.MainActivityNavigation;
import com.dmariani.basics.util.FeatureUtils;

import java.util.List;

/**
 * Main Activity
 *
 * @author danielle.mariani
 */
public class MainActivity extends AppCompatActivity implements MainActivityNavigation, OnFeatureClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // create linear layout manager to place items vertically
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // get list of features from json file
        List<Feature> features = FeatureUtils.fromJson(this, R.raw.features);

        // init adapter to display feature items
        FeatureAdapter adapter = new FeatureAdapter(features);
        adapter.setOnFeatureClickListener(this);
        recyclerView.setAdapter(adapter);

        // add divider item decoration to recycler
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onFeatureClick(Feature feature) {
        String id = feature.getId();

        if (id.equals(Feature.FEATURE_COLLAPSING_TOOLBAR_1)) {
            navigateToCollapsingToolbarSample();
        } else if (id.equals(Feature.FEATURE_COLLAPSING_TOOLBAR_2)) {
            navigateToFloatButtonToolbarSample();
        } else if (id.equals(Feature.FEATURE_COLLAPSING_IMAGE_TOOLBAR)) {
            navigateToCollapsingImageToolbarSample();
        } else if (id.equals(Feature.FEATURE_QUICK_RETURN)) {
            navigateToQuickReturnSample();
        } else if (id.equals(Feature.FEATURE_TABLAYOUT)) {
            navigateToTabLayoutSample();
        } else {
            Toast.makeText(this, "Navigate to Feature: " + feature.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void navigateToCollapsingToolbarSample() {
        startActivity(ScrollingActivity.getIntent(this));
    }

    @Override
    public void navigateToFloatButtonToolbarSample() {
        startActivity(ScrollingFloatingButtonActivity.getIntent(this));
    }

    @Override
    public void navigateToCollapsingImageToolbarSample() {
        startActivity(ScrollingImageActivity.getIntent(this));
    }

    @Override
    public void navigateToQuickReturnSample() {
        startActivity(QuickReturnActivity.getIntent(this));
    }

    @Override
    public void navigateToTabLayoutSample() {
        startActivity(TabActivity.getIntent(this));
    }
}
