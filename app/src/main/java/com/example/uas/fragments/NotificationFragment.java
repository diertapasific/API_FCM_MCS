package com.example.uas.fragments;

import static com.example.uas.models.MyFirebaseMessagingService.notificationMessage;
import static com.example.uas.models.MyFirebaseMessagingService.notificationTitle;
import static com.example.uas.models.MyFirebaseMessagingService.notifications;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uas.R;
import com.example.uas.adapters.notifications_adapter;

public class NotificationFragment extends Fragment{
        private View view;
    private notifications_adapter notificationAdapter;
    private Context context;
    private RecyclerView recycleViewNotifications;
    private String notificationTitleString, notificationMessageString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(notificationTitle!=null|| notificationMessage !=null){
            view = inflater.inflate(R.layout.fragment_notification, container, false);
            notificationTitleString = notificationTitle;
            notificationMessageString = notificationMessage;

            recycleViewNotifications = view.findViewById(R.id.recycleViewNotifications);

            this.context = getContext();

            notificationAdapter = new notifications_adapter(notifications, context);
            recycleViewNotifications.setAdapter(notificationAdapter);

            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            recycleViewNotifications.setLayoutManager(layoutManager);
        }
        return view;
    }
}