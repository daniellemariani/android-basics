package com.dmariani.basics.model;

import java.util.List;

/**
 * Feature model class
 *
 * @author danielle.mariani
 */

public class Feature {

    public static final String FEATURE_COLLAPSING_TOOLBAR_1 = "FEATURE_COLLAPSING_TOOLBAR_1";
    public static final String FEATURE_COLLAPSING_TOOLBAR_2 = "FEATURE_COLLAPSING_TOOLBAR_2";
    public static final String FEATURE_COLLAPSING_IMAGE_TOOLBAR = "FEATURE_COLLAPSING_IMAGE_TOOLBAR";
    public static final String FEATURE_QUICK_RETURN = "FEATURE_QUICK_RETURN";
    public static final String FEATURE_TABLAYOUT = "FEATURE_TABLAYOUT";
    public static final String FEATURE_TABLAYOUT_WITH_IMAGE = "FEATURE_TABLAYOUT_WITH_IMAGE";
    public static final String FEATURE_BOTTOM_NAVIGATION_VIEW = "FEATURE_BOTTOM_NAVIGATION_VIEW";
    public static final String FEATURE_BOTTOM_SHEET = "FEATURE_BOTTOM_SHEET";

    private String id;
    private String name;
    private String description;
    private List<Feature> subFeatures;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Feature> getSubFeatures() {
        return subFeatures;
    }

}
