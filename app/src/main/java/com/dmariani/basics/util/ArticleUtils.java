package com.dmariani.basics.util;

import android.content.Context;

import com.dmariani.basics.model.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author danielle.mariani
 */

public class ArticleUtils {

    public static List<Article> fromJson(Context context, int resourceId) {

        // read json file
        InputStream inputStream = context.getResources().openRawResource(resourceId);
        Reader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

        // parse json using Gson to get a list of Feature objects
        // since the json file contains a list of feature
        // we need to create a Type to parse the file properly
        Type listType = new TypeToken<List<Article>>(){}.getType();

        Gson gson = new Gson();
        return gson.fromJson(reader, listType);
    }

}
