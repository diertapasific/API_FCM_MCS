package com.example.uas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas.R;
import com.example.uas.models.api;

import java.util.List;

public class api_adapter extends RecyclerView.Adapter<api_adapter.ViewHolder> {
    private Context context;
    private List<api> apis;

    public api_adapter(List<api> apis, Context context) {
        this.apis = apis;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idAPI, bodyAPI, titleAPI;

        public ViewHolder(@NonNull View view) {
            super(view);
            idAPI = view.findViewById(R.id.idAPI);
            bodyAPI = view.findViewById(R.id.bodyAPI);
            titleAPI = view.findViewById(R.id.titleAPI);
        }
    }

    @NonNull
    @Override
    public api_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_api_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        api api = apis.get(position);
        holder.idAPI.setText(getuserID(api.getId()));
        holder.bodyAPI.setText(api.getBody());
        holder.titleAPI.setText(api.getTitle());
    }

    private String getuserID(Integer userId) {

        return  userId + "";
    }

    @Override
    public int getItemCount() {
        return apis.size();
    }

}
