package com.dmariani.basics.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dmariani.basics.R;
import com.dmariani.basics.model.Article;
import com.dmariani.basics.ui.adapter.ViewPagerAdapter;
import com.dmariani.basics.util.ArticleUtils;

import java.util.List;

/**
 * Feature Activity that shows how to implement the TabLayout
 *
 * @author danielle.mariani
 */
public class TabActivity extends AppCompatActivity {

    private ViewPager viewPager;

    public static Intent getIntent(Context context) {
        return new Intent(context, TabActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        // init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // init tabs and view pager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initViewPager() {
        List<Article> articles = ArticleUtils.fromJson(this, R.raw.articles);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), articles);
        viewPager.setAdapter(adapter);
    }
}
