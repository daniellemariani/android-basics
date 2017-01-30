package com.dmariani.basics.model;

import java.util.List;

/**
 * Feature model class
 *
 * @author danielle.mariani
 */

public class Feature {

    public static final String FEATURE_COLLAPSE_TOOLBAR_I = "FEATURE_COLLAPSE_TOOLBAR_I";

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
