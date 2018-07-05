package msu.elder.Model;

public class Notification {
    String username_notification;
    int id_newsfeed;
    int status;

    public Notification() {

    }

    public Notification(String username_notification, int id_newfeed, int status) {
        this.username_notification = username_notification;
        this.id_newsfeed = id_newfeed;
        this.status = status;
    }

    public String getUsername_notification() {
        return username_notification;
    }

    public void setUsername_notification(String username_notification) {
        this.username_notification = username_notification;
    }

    public int getId_newfeed() {
        return id_newsfeed;
    }

    public void setId_newfeed(int id_newfeed) {
        this.id_newsfeed = id_newfeed;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
