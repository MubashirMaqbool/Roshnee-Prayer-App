package com.roshneeprayer;

import android.content.Context;
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
import android.widget.TextView;

import com.roshneeprayer.Models.Masjid;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {
    RecyclerView recyclerView_posts;
    List<Masjid> masjidData;
    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView_posts=view.findViewById(R.id.recylerview_masjid);
        masjidData=new ArrayList<>();
        masjidData.add(new Masjid("Putra Mosque","4.5 KM", R.drawable.putramosque));
        masjidData.add(new Masjid("Putra Mosque","4.5 KM", R.drawable.putramosque));
        masjidData.add(new Masjid("Putra Mosque","4.5 KM", R.drawable.putramosque));
        recyclerView_posts.setLayoutManager(new LinearLayoutManager(getContext()));
        MasjidAdapter masjidAdapter=new MasjidAdapter(getContext(),masjidData);
        recyclerView_posts.setAdapter(masjidAdapter);
        return  view;
    }
}
//////////////////////////////////////////////
class  MasjidAdapter extends RecyclerView.Adapter<MasjidAdapter.masjidHolder>{
    Context context;
    List<Masjid> masjidsData;

    public MasjidAdapter(Context context, List<Masjid> masjidsData) {
        this.context = context;
        this.masjidsData = masjidsData;
    }

    @NonNull
    @Override
    public masjidHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.masjid_layout,parent,false);
        masjidHolder masjidholder=new masjidHolder(view);
        return masjidholder;
    }

    @Override
    public void onBindViewHolder(@NonNull masjidHolder holder, int position) {
        Uri uri = Uri.parse("android.resource://com.roshneeprayer/drawable/putramosque");
        Picasso.get().load(uri).fit().centerCrop().into(holder.imageView_masjid);

    }

    @Override
    public int getItemCount() {
        return masjidsData.size();
    }


    public class masjidHolder extends  RecyclerView.ViewHolder{
        ImageView imageView_masjid,imageView_likemasjid;
        TextView textView_distance;
        public masjidHolder(@NonNull View itemView) {
            super(itemView);
            textView_distance=itemView.findViewById(R.id.distance);
            imageView_masjid=itemView.findViewById(R.id.masjid_imageview);
            imageView_likemasjid=itemView.findViewById(R.id.likebutton);
        }
    }
}