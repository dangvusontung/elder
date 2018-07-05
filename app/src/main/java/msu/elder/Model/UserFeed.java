package msu.elder.Model;

import java.io.Serializable;

public class UserFeed implements Serializable {
    int id_newsfeed;
    int id_userfeed;
    String status_newsfeed;
    String image_newsfeed;

    public UserFeed() {

    }

    public UserFeed(int id_newfeed, int id_userfeed, String status_newfeed, String image_newfeed) {
        this.id_newsfeed = id_newfeed;
        this.id_userfeed = id_userfeed;
        this.status_newsfeed = status_newfeed;
        this.image_newsfeed = image_newfeed;
    }

    public int getId_newfeed() {
        return id_newsfeed;
    }

    public void setId_newfeed(int id_newfeed) {
        this.id_newsfeed = id_newfeed;
    }

    public int getId_userfeed() {
        return id_userfeed;
    }

    public void setId_userfeed(int id_userfeed) {
        this.id_userfeed = id_userfeed;
    }

    public String getStatus_newfeed() {
        return status_newsfeed;
    }

    public void setStatus_newfeed(String status_newfeed) {
        this.status_newsfeed = status_newfeed;
    }

    public String getImage_newfeed() {
        return image_newsfeed;
    }

    public void setImage_newfeed(String image_newfeed) {
        this.image_newsfeed = image_newfeed;
    }
}
