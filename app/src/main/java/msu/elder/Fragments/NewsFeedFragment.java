package msu.elder.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import msu.elder.Activity.NewsFeedDetailActivity;
import msu.elder.Adapter.NewsFeedAdapter;
import msu.elder.Model.NewsFeed;
import msu.elder.R;
import msu.elder.Server.Server;

public class NewsFeedFragment extends Fragment {
    ListView listView;
    ArrayList<NewsFeed> newsFeeds;
    NewsFeedAdapter newsFeedAdapter;
    int id_user;
    int id_newsfeed = 0;
    String newsfeed_avatar = "";
    String newsfeed_username = "";
    String newsfeed_status = "";
    String newsfeed_image = "";

    View footer; //for a progress bar
    Boolean loading;

    public NewsFeedFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newsfeed, container, false);
        footer = LayoutInflater.from(getContext()).inflate(R.layout.x_progress_bar, null);

        id_user = getArguments().getInt("id_user");
        listView = (ListView) view.findViewById(R.id.newsfeedlist);
        newsFeeds = new ArrayList<>();
        newsFeedAdapter = new NewsFeedAdapter(newsFeeds, getContext(), id_user);
        listView.setAdapter(newsFeedAdapter);
        getData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //getting data cross-activities with Intent
                Intent intent = new Intent(getContext(), NewsFeedDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", (Serializable) parent.getAdapter().getItem(position));
                intent.putExtra("key", bundle);
                startActivity(intent);
            }
        });

        return view;

    }

    public void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.NewsfeedURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) { //if there is a response, get them
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id_newsfeed = jsonObject.getInt("id");
                            newsfeed_avatar = jsonObject.getString("avatar");
                            newsfeed_username = jsonObject.getString("username");
                            newsfeed_status = jsonObject.getString("status");
                            newsfeed_image = jsonObject.getString("image");
                            newsFeeds.add(new NewsFeed(id_newsfeed, newsfeed_avatar, newsfeed_username, newsfeed_status, newsfeed_image));
                            //Toast.makeText(getContext(), "status: " + newsfeed_status, Toast.LENGTH_SHORT).show();
                            newsFeedAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(getContext(), "No Data!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }


}