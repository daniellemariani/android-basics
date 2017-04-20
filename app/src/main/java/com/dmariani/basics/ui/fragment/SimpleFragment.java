package com.dmariani.basics.ui.fragment;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmariani.basics.R;

/**
 * @author danielle.mariani
 */
public class SimpleFragment extends Fragment {

    private static final String ARG_MESSAGE = "ARG_MESSAGE";
    private static final String ARG_IMAGE = "ARG_IMAGE";

    public static final SimpleFragment newInstance(@StringRes int messageResourceId, @DrawableRes int imageResourceId) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_MESSAGE, messageResourceId);
        bundle.putInt(ARG_IMAGE, imageResourceId);

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static final SimpleFragment newInstance(@StringRes int messageResourceId) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_MESSAGE, messageResourceId);

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView textView = (TextView) getView().findViewById(R.id.textview_message);
        ImageView imageView = (ImageView) getView().findViewById(R.id.image);

        Bundle bundle = getArguments();
        if (bundle != null) {

            if (bundle.containsKey(ARG_MESSAGE)) {
                textView.setText(bundle.getInt(ARG_MESSAGE));
            }

            if (bundle.containsKey(ARG_IMAGE)) {
                imageView.setImageResource(bundle.getInt(ARG_IMAGE));
            }
        }
    }
}
