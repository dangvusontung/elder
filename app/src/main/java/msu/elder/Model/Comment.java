package msu.elder.Model;

public class Comment {
    int id;
    int userreply;
    String username;
    String comment;

    public Comment() {

    }

    public Comment(int id, int userreply, String username, String comment) {
        this.id = id;
        this.userreply = userreply;
        this.username = username;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getUserreply() {
        return userreply;
    }

    public void setUserreply(int userreply) {
        this.userreply = userreply;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
