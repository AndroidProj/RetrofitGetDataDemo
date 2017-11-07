package com.example.vasundhara.retrofitdemo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Vasundhara on 10/14/2017.
 */

public class FeedList {
    @SerializedName("feed")
    private ArrayList<Feed> mResult;

    public ArrayList<Feed> getResult() {
        return mResult;
    }

    public void setResult(ArrayList<Feed> result) {
        mResult = result;
    }
}
