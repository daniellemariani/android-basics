package com.dmariani.basics.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * @author danielle.mariani
 */
public class Article implements Parcelable {

    private int id;
    private String shortTitle;
    private String longTitle;
    private String content;
    private String imageUrl;

    @SerializedName("imageText")
    private String imageDescription;

    public Article() {
    }

    private Article(Parcel in) {
        id = in.readInt();
        shortTitle = in.readString();
        longTitle = in.readString();
        content = in.readString();
        imageUrl = in.readString();
        imageDescription = in.readString();
    }

    public int getId() {
        return id;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(shortTitle);
        parcel.writeString(longTitle);
        parcel.writeString(content);
        parcel.writeString(imageUrl);
        parcel.writeString(imageDescription);
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
