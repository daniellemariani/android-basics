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

/**
 * @author danielle.mariani
 */

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FrameLayout container;
    private BottomNavigationView bottomNavigationView;

    public static Intent getIntent(Context context) {
        return new Intent(context, BottomNavigationActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        container = (FrameLayout) findViewById(R.id.container);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_navigation_gallery:
                navigateToGalleryFragment();
                return true;
            case R.id.bottom_navigation_search:
                navigateToSearchFragment();
                return true;
            case R.id.bottom_navigation_call:
                navigateToCallFragment();
                return true;
        }

        return false;
    }

    private void navigateToGalleryFragment() {
        navigateTo(SimpleFragment.newInstance(R.string.bottom_navigation_gallery,
                R.drawable.ic_gallery));
    }

    private void navigateToSearchFragment() {
        navigateTo(SimpleFragment.newInstance(R.string.bottom_navigation_search,
                R.drawable.ic_browser));
    }

    private void navigateToCallFragment() {
        navigateTo(SimpleFragment.newInstance(R.string.bottom_navigation_call,
                R.drawable.ic_call));
    }

    private void navigateTo(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
