package com.dmariani.basics.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dmariani.basics.model.Article;
import com.dmariani.basics.ui.fragment.ArticleFragment;

import java.util.List;

/**
 * @author danielle.mariani
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Article> articles;

    public ViewPagerAdapter(FragmentManager fm, List<Article> articles) {
        super(fm);
        this.articles = articles;
    }

    @Override
    public Fragment getItem(int position) {
        return ArticleFragment.newInstance(articles.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return articles.get(position).getShortTitle();
    }

    @Override
    public int getCount() {
        return articles == null ? 0 : articles  .size();
    }
}
