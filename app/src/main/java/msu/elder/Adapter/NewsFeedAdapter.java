package msu.elder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import msu.elder.Activity.CommentActivity;
import msu.elder.Model.NewsFeed;
import msu.elder.R;

import de.hdodenhof.circleimageview.CircleImageView;
import msu.elder.Server.Server;

public class NewsFeedAdapter extends BaseAdapter {
    ArrayList<NewsFeed> newsFeeds;
    Context context;
    int id_user;

    public NewsFeedAdapter(ArrayList<NewsFeed> newsFeeds, Context context, int id_user) {
        this.newsFeeds = newsFeeds;
        this.context = context;
        this.id_user = id_user;
    }

    @Override
    public int getCount() {
        return newsFeeds.size();
    }

    @Override
    public Object getItem(int position) {
        return newsFeeds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        convertView = LayoutInflater.from(context).inflate(R.layout.x_newsfeed_list, null);

        viewHolder.avatar = (CircleImageView) convertView.findViewById(R.id.newsfeed_avatar);
        viewHolder.image = (ImageView) convertView.findViewById(R.id.newsfeed_image);
        viewHolder.like = (ImageView) convertView.findViewById(R.id.newsfeed_like);
        viewHolder.comment = (ImageView) convertView.findViewById(R.id.newsfeed_comment);
        viewHolder.status = (TextView) convertView.findViewById(R.id.newsfeed_status);
        viewHolder.username = (TextView) convertView.findViewById(R.id.newsfeed_username);
        final NewsFeed newsFeed = (NewsFeed) getItem(position); //from the Models
        //If there is usable data, replace with the default ones
        viewHolder.username.setText(newsFeed.getUsername_newsfeed().toString());
        if (newsFeed.getAvatar_newsfeed().length() > 0) {
            Picasso.with(context).load(Server.ImageURL + newsFeed.getAvatar_newsfeed()).placeholder(R.drawable.ic_avatar).into(viewHolder.avatar);
        }
        viewHolder.status.setText(newsFeed.getStatus_newsfeed().toString());
        if (newsFeed.getImage_newsfeed().length() > 0) {
            Picasso.with(context).load(Server.ImageURL + newsFeed.getStatus_newsfeed()).placeholder(R.mipmap.ic_blank_thumbnail).into(viewHolder.image);
        }
        viewHolder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("id_newsfeed", newsFeed.getId_newsfeed()); //get shit from the NewsFeed model
                intent.putExtra("id_user", id_user);
                //Toast.makeText(context," ", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });
        viewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //when press like button, "like" and add a notification
                v.setSelected(true);
                Like(newsFeed);
                NoticeNotification(newsFeed.getId_newsfeed(), 0);
            }
        });

        return convertView;
    }

    private void NoticeNotification(int newsFeed, final int status) {
        final String id_user_noti = String.valueOf(id_user);
        final String newsFeed_noti = String.valueOf(newsFeed);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Notification_CreateURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response == null) {
                    Toast.makeText(context, "Like Fail!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Loading: " + response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>(); //an array with key and value, while the value are id of newsfeed, id of user and the status
                hashMap.put("id_newsfeed", newsFeed_noti);
                hashMap.put("id_user", id_user_noti);
                hashMap.put("status", String.valueOf(status));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void Like(NewsFeed newsFeed) {
        final String id_user_noti = String.valueOf(id_user);
        final String newsFeed_noti = String.valueOf(newsFeed);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.LikeURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response == null) {
                    Toast.makeText(context, "Like Fail!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Loading: " + response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>(); //an array with key and value, while the value are id of newsfeed, id of user and the status
                hashMap.put("id_newsfeed", newsFeed_noti);
                hashMap.put("id_user", id_user_noti);
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    public class ViewHolder {
        CircleImageView avatar;
        ImageView image, like, comment;
        TextView status, username;

    }

}
