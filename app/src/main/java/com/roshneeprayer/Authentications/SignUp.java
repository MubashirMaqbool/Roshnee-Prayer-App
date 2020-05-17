package com.roshneeprayer.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.roshneeprayer.BottomBar;
import com.roshneeprayer.R;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void SignUpAndShowBottomActivty(View view){
        Intent intent=new Intent(getApplicationContext(), BottomBar.class);
        startActivity(intent);
    }
}
