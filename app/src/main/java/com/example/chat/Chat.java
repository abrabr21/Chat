package com.example.chat;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Chat {
    public static void showChatList(Context context, LinearLayout linearLayout){
        linearLayout.removeAllViews();
        RecyclerView recyclerView= new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        ArrayList<String> name =new ArrayList<>();
        name.add("Petya");name.add("Vasya"); name.add("Kolya");
        ChatListAdapter chatListAdapter= new ChatListAdapter(context, name);
        recyclerView.setAdapter(chatListAdapter);
        linearLayout.addView(recyclerView);

    }
}
