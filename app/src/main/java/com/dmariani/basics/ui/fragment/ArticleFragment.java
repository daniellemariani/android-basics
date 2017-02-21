package com.dmariani.basics.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmariani.basics.R;
import com.dmariani.basics.model.Article;
import com.squareup.picasso.Picasso;

/**
 * @author danielle.mariani
 */

public class ArticleFragment extends Fragment {

    private static final String ARG_ARTICLE = "ARTICLE";

    private Article article;

    public static ArticleFragment newInstance(Article article) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_ARTICLE, article);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            article = bundle.getParcelable(ARG_ARTICLE);
            init();
        }
    }

    private void init() {
        TextView textTitle = (TextView) getView().findViewById(R.id.textview_title);
        ImageView imageView = (ImageView) getView().findViewById(R.id.image_article);
        TextView textImage = (TextView) getView().findViewById(R.id.textview_image_description);
        TextView textContent = (TextView) getView().findViewById(R.id.textview_content);

        textTitle.setText(article.getLongTitle());
        textContent.setText(article.getContent());
        textImage.setText(article.getImageDescription());
        Picasso.with(getContext()).load(article.getImageUrl()).into(imageView);
    }
}
