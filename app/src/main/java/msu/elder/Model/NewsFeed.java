package msu.elder.Model;

public class NewsFeed {
    int id_newsfeed;
    String avatar_newsfeed;
    String username_newsfeed;
    String status_newsfeed;
    String image_newsfeed;

    public NewsFeed() {

    }

    public NewsFeed(int id_newsfeed, String avatar_newsfeed, String username_newsfeed, String status_newsfeed, String image_newsfeed) {
        this.id_newsfeed = id_newsfeed;
        this.avatar_newsfeed = avatar_newsfeed;
        this.username_newsfeed = username_newsfeed;
        this.status_newsfeed = status_newsfeed;
        this.image_newsfeed = image_newsfeed;
    }

    public int getId_newsfeed() {
        return id_newsfeed;
    }

    public void setId_newsfeed(int id_newsfeed) {
        this.id_newsfeed = id_newsfeed;
    }

    public String getAvatar_newsfeed() {
        return avatar_newsfeed;
    }

    public void setAvatar_newsfeed(String avatar_newsfeed) {
        this.avatar_newsfeed = avatar_newsfeed;
    }

    public String getUsername_newsfeed() {
        return username_newsfeed;
    }

    public void setUsername_newsfeed(String username_newsfeed) {
        this.username_newsfeed = username_newsfeed;
    }

    public String getStatus_newsfeed() {
        return status_newsfeed;
    }

    public void setStatus_newsfeed(String status_newsfeed) {
        this.status_newsfeed = status_newsfeed;
    }

    public String getImage_newsfeed() {
        return image_newsfeed;
    }

    public void setImage_newsfeed(String image_newsfeed) {
        this.image_newsfeed = image_newsfeed;
    }
}
