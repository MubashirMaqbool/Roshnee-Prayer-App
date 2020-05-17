package com.roshneeprayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.roshneeprayer.Models.Masjid;

import java.util.ArrayList;
import java.util.List;

public class LikedMosque extends AppCompatActivity {
RecyclerView recyclerView_likedmosque;
    List<LikedMosque> masjidData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_liked_mosque);
        masjidData=new ArrayList<>();

    }
}
