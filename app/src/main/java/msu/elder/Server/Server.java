package msu.elder.Server;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;




public class Server extends AppCompatActivity {
    public static String Localhost = "text";
    public static String ImageURL = "http://"+Localhost+"/get_newsfeed.php";
    public static String Notification_CreateURL = "http://"+Localhost+"/create_notification.php";
    public static String Notification_GetURL = "http://"+Localhost+"/get_notification.php";
    public static String LikeURL = "http://"+Localhost+"/create_like.php";
    public static String NewsfeedURL = "http://"+Localhost+"/get_newsfeed.php";

}
