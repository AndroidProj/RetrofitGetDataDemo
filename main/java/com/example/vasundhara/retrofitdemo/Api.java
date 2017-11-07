package com.example.vasundhara.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vasundhara on 10/14/2017.
 */

public interface Api {

    String BASE_URL = "https://api.androidhive.info/feed/";

    @GET("feed.json")
    Call<FeedList> getFeedList();
}
