package com.example.chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.net.Socket;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
   public static boolean isAuth= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayout mainLinearLayout;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLinearLayout=findViewById(R.id.mainLinerLayout);
        if(savedInstanceState !=null)
            isAuth=savedInstanceState.getBoolean("isAuth");


        if(!isAuth){
            Auth.showAuth(MainActivity.this, mainLinearLayout);

        }else{
            Chat.showChatList(MainActivity.this, mainLinearLayout);
        }
    }
    @Override
    public void onSaveInstanceState (Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isAuth",isAuth);
    }
}
