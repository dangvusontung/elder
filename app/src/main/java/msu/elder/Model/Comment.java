package msu.elder.Model;

public class Comment {
    int id;
    int user_reply;
    String username;
    String comment;

    public Comment() {

    }

    public Comment(int id, int user_reply, String username, String comment) {
        this.id = id;
        this.user_reply = user_reply;
        this.username = username;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getUser_reply() {
        return user_reply;
    }

    public void setUser_reply(int user_reply) {
        this.user_reply = user_reply;
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
