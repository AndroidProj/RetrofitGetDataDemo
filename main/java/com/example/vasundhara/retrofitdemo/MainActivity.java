package com.example.vasundhara.retrofitdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> name;
    public ArrayList<String> id;
    public ArrayList<String> image;
    public ArrayList<String> status;
    public ArrayList<String> profilePic;
    public ArrayList<String> timeStamp;
    public ArrayList<String> url;
    MyCustomBaseAdapter customBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = (ListView) findViewById(R.id.lvCustomList);
        name = new ArrayList<>();
        id = new ArrayList<>();
        image = new ArrayList<>();
        status = new ArrayList<>();
        profilePic = new ArrayList<>();
        timeStamp = new ArrayList<>();
        url = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api apicall = retrofit.create(Api.class);

        Call<FeedList> call = apicall.getFeedList();

        call.enqueue(new Callback<FeedList>() {
            @Override
            public void onResponse(Call<FeedList> call, Response<FeedList> response) {
                FeedList listResponse = response.body();
                if (listResponse != null) {
                    List<Feed> resultList = listResponse.getResult();
//                    Log.d("name:", resultList.get(0).getName());
                    for (int i = 0; i < resultList.size(); i++) {
                        name.add(resultList.get(i).getName());
                        id.add(resultList.get(i).getId());
                        image.add(resultList.get(i).getImage());
                        status.add(resultList.get(i).getStatus());
                        profilePic.add(resultList.get(i).getProfilePic());
                        timeStamp.add(resultList.get(i).getTimeStamp());
                        url.add(resultList.get(i).getUrl());
                    }
                    customBaseAdapter = new MyCustomBaseAdapter();
                    lv.setAdapter(customBaseAdapter);
                }
            }

            @Override
            public void onFailure(Call<FeedList> call, Throwable t) {

            }
        });
    }

    public class MyCustomBaseAdapter extends BaseAdapter {
        public int getCount() {
            return name.size();
        }

        public Object getItem(int position) {
            return name.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            View v = convertView;
            if (v == null) {
                LayoutInflater mInflater = getLayoutInflater();
                v = mInflater.inflate(R.layout.layout_list_item, null);
                holder = new ViewHolder();
                holder.id_tv = (TextView) v.findViewById(R.id.text_id);
                holder.name_tv = (TextView) v.findViewById(R.id.text_name);
                holder.status_tv = (TextView) v.findViewById(R.id.text_status);
                holder.timeStamp_tv = (TextView) v.findViewById(R.id.text_timestamp);
                holder.url_tv = (TextView) v.findViewById(R.id.text_url);
                holder.profile_img = (ImageView) v.findViewById(R.id.img_profile);
                holder.image_img = (ImageView) v.findViewById(R.id.img_image);
                v.setTag(holder);
            } else {
                holder = (ViewHolder) v.getTag();
            }



            holder.id_tv.setText(id.get(position));
            holder.name_tv.setText(name.get(position));
            holder.status_tv.setText(status.get(position));
            holder.timeStamp_tv.setText(timeStamp.get(position));
            holder.url_tv.setText(url.get(position));
            Glide.with(MainActivity.this)
                    .load(profilePic.get(position))
                    .into(holder.profile_img);
            Glide.with(MainActivity.this)
                    .load(image.get(position))
                    .into(holder.image_img);
            return v;
        }

        class ViewHolder {
            TextView id_tv, name_tv, status_tv, timeStamp_tv, url_tv;
            ImageView profile_img, image_img;
        }
    }
}
