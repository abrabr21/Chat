package com.example.chat;

import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Auth {
    public static void showAuth(Context context, LinearLayout linearLayout){
        LinearLayout.LayoutParams lp= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,20,0,20);
        TextView loginTextview= new TextView(context);
        EditText loginEditText= new EditText(context);
        EditText passEditText= new EditText(context);
        Button loginBtn= new Button(context);
        Button registerBtn=new Button(context);
        loginTextview.setText("Authorization");
        loginTextview.setGravity(Gravity.CENTER);
        loginTextview.setTextSize(TypedValue.COMPLEX_UNIT_SP,24 );
        loginEditText.setHint("Log IN");
        loginEditText.setLayoutParams(lp);
        passEditText.setLayoutParams(lp);
        passEditText.setHint("Password");
        registerBtn.setText("Registration");
        passEditText.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD );
        loginBtn.setLayoutParams(lp);
        loginBtn.setText("Come in");
        linearLayout.addView(loginTextview);
        linearLayout.addView(loginEditText);
        linearLayout.addView(passEditText);
        linearLayout.addView(loginBtn);
        linearLayout.addView(registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userAuth(loginEditText.getText().toString(), passEditText.getText().toString())) {

                    Intent intent = new Intent(context, RegActivity.class);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context, "Invalid Log or Pass",Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chat.showChatList(context, linearLayout);
            }
        });
    }
    private static boolean userAuth(String login, String pass){

        boolean isAuth= false;
        if(login.equals("admin")&&pass.equals("12345")) isAuth=true;
        return isAuth;
    }
}
