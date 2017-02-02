package com.dmariani.basics.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dmariani.basics.R;

/**
 * Feature Activity that shows how to implement a Collapsing Toolbar Layout
 * with a Floating Action Button
 *
 * @author danielle.mariani
 */
public class ScrollingFloatingButtonActivity extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        return new Intent(context, ScrollingFloatingButtonActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_floating_button);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_button);

        // init toolbar
        setSupportActionBar(toolbar);

        // enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // init floating action button
        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.floating_action_button_perform, Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ScrollingFloatingButtonActivity.this, R.string.snackbar_action_perform, Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Navigate to Parent Activity
            NavUtils.navigateUpFromSameTask(this);
            return true;
        } else if (id == R.id.action_settings) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
