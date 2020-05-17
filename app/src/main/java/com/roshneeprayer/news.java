package com.roshneeprayer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.roshneeprayer.Models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class news extends Fragment {
RecyclerView recyclerView_news;
    List<News> newsData;
    public news() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView_news=view.findViewById(R.id.recylerview_news);
        newsData=new ArrayList<>();
        recyclerView_news.setLayoutManager(new LinearLayoutManager(getContext()));

        newsData.add(new News("","",""));
        newsData.add(new News("","",""));
        newsData.add(new News("","",""));
        newsData.add(new News("","",""));
        newsAdapter newsAdapter=new newsAdapter(getContext(),newsData);
        recyclerView_news.setAdapter(newsAdapter);
        return  view;
    }
}
/////////////////////////////////
class newsAdapter extends RecyclerView.Adapter<newsAdapter.newsholder>{
   Context context;
   List<News> news;

    public newsAdapter(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }

    List<news> newsData;

    @NonNull
    @Override
    public newsAdapter.newsholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.news_layout,parent,false);
        newsholder myholder=new newsholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull newsAdapter.newsholder holder, int position) {
        Uri uri = Uri.parse("android.resource://com.roshneeprayer/drawable/putramosque");
        Picasso.get().load(uri).fit().centerCrop().into(holder.imageView_masjid);
        holder.imageView_masjid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,NewsDetails.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class newsholder extends RecyclerView.ViewHolder {
        ImageView imageView_masjid;

        public newsholder(@NonNull View itemView) {
            super(itemView);
            imageView_masjid=itemView.findViewById(R.id.news_imageview);
        }
    }
}