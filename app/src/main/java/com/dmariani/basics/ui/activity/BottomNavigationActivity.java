package com.dmariani.basics.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.dmariani.basics.R;
import com.dmariani.basics.ui.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Feature Activity that shows how to implement a BottomNavigationView
 *
 * @author danielle.mariani
 */

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragments;

    public static Intent getIntent(Context context) {
        return new Intent(context, BottomNavigationActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // initialize fragments
        fragments = new ArrayList<>();
        fragments.add(SimpleFragment.newInstance(R.string.bottom_navigation_gallery,
                R.drawable.ic_gallery));
        fragments.add(SimpleFragment.newInstance(R.string.bottom_navigation_search,
                R.drawable.ic_browser));
        fragments.add(SimpleFragment.newInstance(R.string.bottom_navigation_call,
                R.drawable.ic_call));

        // set first fragment as default
        navigateTo(fragments.get(0));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_navigation_gallery:
                navigateTo(fragments.get(0));
                return true;
            case R.id.bottom_navigation_search:
                navigateTo(fragments.get(1));
                return true;
            case R.id.bottom_navigation_call:
                navigateTo(fragments.get(2));
                return true;
        }

        return false;
    }

    private void navigateTo(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
