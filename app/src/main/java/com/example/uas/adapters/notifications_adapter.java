package com.example.uas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.uas.R;
import com.example.uas.models.notification;
import java.util.List;

public class notifications_adapter extends RecyclerView.Adapter<notifications_adapter.ViewHolder>{
    private Context context;
    private List<notification> notifications;

    public notifications_adapter(List<notification> notifications, Context context) {
        this.notifications = notifications;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView bodyNotifications, titleNotifications, timeNotifications;
        public ViewHolder(@NonNull View view) {
            super(view);
            bodyNotifications = view.findViewById(R.id.bodyNotifications);
            titleNotifications = view.findViewById(R.id.titleNotifications);
            timeNotifications = view.findViewById(R.id.timeNotifications);
        }
    }

    @NonNull
    @Override
    public notifications_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_notifications, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull notifications_adapter.ViewHolder holder, int position) {
        notification notification = notifications.get(position);
        holder.bodyNotifications.setText(notification.getBody());
        holder.titleNotifications.setText(notification.getTitle());
        holder.timeNotifications.setText(notification.getTime());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}