package com.dmariani.basics.util;

import android.content.Context;

import com.dmariani.basics.model.Feature;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Util method for Feature objects
 *
 * @author danielle.mariani
 */
public class FeatureUtils {

    /**
     * It parses a Json file an generate a list of Features
     *
     * @param context
     * @param resourceId raw json file id
     * @return List<Feature> features
     */
    public static List<Feature> fromJson(Context context, int resourceId) {

        // read json file
        InputStream inputStream = context.getResources().openRawResource(resourceId);
        Reader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

        // parse json using Gson to get a list of Feature objects
        // since the json file contains a list of feature
        // we need to create a Type to parse the file properly
        Type listType = new TypeToken<List<Feature>>(){}.getType();

        Gson gson = new Gson();
        return gson.fromJson(reader, listType);

    }
}
