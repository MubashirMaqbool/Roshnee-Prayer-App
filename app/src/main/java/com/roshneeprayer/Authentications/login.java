package com.roshneeprayer.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.roshneeprayer.BottomBar;
import com.roshneeprayer.R;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
    }

    public void LoginAndShowBottomActivty(View view){
        Intent intent=new Intent(getApplicationContext(), BottomBar.class);
        startActivity(intent);
    }
}
