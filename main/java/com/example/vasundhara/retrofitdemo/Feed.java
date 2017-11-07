package com.example.vasundhara.retrofitdemo;

/**
 * Created by Vasundhara on 10/14/2017.
 */

public class Feed {

    private String id;
    private String name;
    private String image;
    private String status;
    private String profilePic;
    private String timeStamp;
    private String url;

    public Feed(String id, String name, String image, String status, String profilePic, String timeStamp, String url) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.profilePic = profilePic;
        this.timeStamp = timeStamp;
        this.url = url;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getUrl() {
        return url;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
