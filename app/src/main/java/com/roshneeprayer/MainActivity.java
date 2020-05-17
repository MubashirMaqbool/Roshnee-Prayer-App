package com.roshneeprayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.roshneeprayer.Slider.OnBoardingActivity;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    ImageView imageView,imageView_logo;
  CountDownTimer countDownTimer;
    Animation animationUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // animationUp= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        //imageView.setAnimation(animationUp);
        imageView_logo=findViewById(R.id.imageView2);
       // imageView_logo.setAnimation(animationUp);
        Uri uri = Uri.parse("android.resource://com.roshneeprayer/drawable/splashscreen");
        try {
            InputStream stream = getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       // Picasso.get().load(uri).into(imageView);
        Glide
                .with(this)
                .load(uri)
                .autoClone()
                .placeholder(R.drawable.splashscreen)
                .into(imageView);
        countDownTimer=new CountDownTimer(3000,300) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent=new Intent(getApplicationContext(), OnBoardingActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadout);
            }
        }.start();
    }
}
