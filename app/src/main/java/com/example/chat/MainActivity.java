package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.chat.database.DBMethods;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainLinerLayout;
    public static boolean isAuth = false;
    FrameLayout mainFrame;
    static FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFrame=findViewById(R.id.mainFrame);
         fm = getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.mainFrame, new StartFragment() ).commit();


        if(savedInstanceState != null) {
            isAuth = savedInstanceState.getBoolean("isAuth");
            Chat.showChatList(MainActivity.this, mainLinerLayout);
        }
        else{
            DBMethods dbMethods = new DBMethods(MainActivity.this);
            String token = dbMethods.getToken();
            if(token != null && !token.equals("0")){
                Auth.userAuth(token, MainActivity.this, mainLinerLayout);
                isAuth = true;
            }else{
                Auth.showAuth(MainActivity.this, mainLinerLayout);
            }
        }
        mainLinerLayout = findViewById(R.id.mainLinerLayout);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isAuth", isAuth);
    }
    public static void changeFragment(Fragment fragment){
        FragmentTransaction transaction= fm.beginTransaction();
        transaction.replace(R.id.mainFrame, fragment).commit();
    }
}