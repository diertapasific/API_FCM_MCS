package com.example.uas.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.uas.R;
import com.example.uas.adapters.api_adapter;
import com.example.uas.models.api;
import com.example.uas.data_base.dataBaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private Context context;
    private RecyclerView recycleViewAPI;
    private dataBaseHelper apiDataBase;
    private String URL = "https://jsonplaceholder.typicode.com/posts";
    private api_adapter apiAdapter;
    private List<api> apis;
    private RequestQueue requestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        this.context = getContext();
        recycleViewAPI = view.findViewById(R.id.recycleViewHomeAPI);
        fetch();

        return view;
    }

    private void fetch() {
        apiDataBase = new dataBaseHelper(context);
        requestQueue = Volley.newRequestQueue(context);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL, null, response -> {
            try {
                apis = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonObject = response.getJSONObject(i);

                    Integer id = jsonObject.getInt("id");
                    Integer userId = jsonObject.getInt("userId");
                    String title = jsonObject.getString("title");
                    String body = jsonObject.getString("body");
                    insertToDatabase(userId, id, title, body);
                    api api = new api(userId, id, title, body);
                    apis.add(api);
                }
                setRecyclerview(apis, context);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, Throwable::printStackTrace);
        requestQueue.add(request);
    }

    private void setRecyclerview(List<api> apis, Context context) {
        apiAdapter = new api_adapter(apis, context);
        recycleViewAPI.setAdapter(apiAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycleViewAPI.setLayoutManager(layoutManager);
    }

    private void insertToDatabase(Integer userId, Integer id, String title, String body) {
        apiDataBase.createAPI(id, userId, title, body);
    }
}