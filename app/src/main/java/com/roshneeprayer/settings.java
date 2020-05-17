package com.roshneeprayer;

import android.app.Dialog;
import android.content.Context;
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

import com.roshneeprayer.Models.settingHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class settings extends Fragment {
    RecyclerView recyclerView,recyclerView2;
    List<settingHelper> list;
    public settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_settings, container, false);
        recyclerView=view.findViewById(R.id.rec1);
        recyclerView2=view.findViewById(R.id.rec2);;
        initData();
        initRecyclerView();
        initData1();
        initRecyclerView1();
        return  view;
    }
    private void initData() {
        list = new ArrayList<>();
        list.add(new settingHelper("EDIT MY DETAIL",""));
        list.add(new settingHelper("MY LOCATION","New York"));
        list.add(new settingHelper("CHANGE PASSWORD",""));
    }
    private void initRecyclerView() {
        Adapter movieAdapter = new Adapter(list,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(movieAdapter);
    }
    private void initData1() {
        list = new ArrayList<>();
        list.add(new settingHelper("NOTIFICATION",""));
        list.add(new settingHelper("PRIVACY POPLICY",""));
        list.add(new settingHelper("TERMS OPF USE",""));
        list.add(new settingHelper("HELP AND SUPPORT",""));
    }
    private void initRecyclerView1() {
        Adapter movieAdapter = new Adapter(list,getContext());
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setAdapter(movieAdapter);
    }
}
//Adapter Setting////////////////////////////////
class Adapter extends RecyclerView.Adapter<Adapter.holder>{
    List<settingHelper> movieList;
    Context context;
    Dialog dialog;

    public Adapter(List<settingHelper> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);
        final Adapter. holder evh = new Adapter.holder(v);
        dialog=new Dialog(parent.getContext());
        dialog.setContentView(R.layout.dialoglayout);
//        evh.icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//            }
//        });
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        final settingHelper movie = movieList.get(position);
        holder.heading.setText(movie.getHeading());
        holder.subheading.setText(movie.getSubheading());
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (movie.getHeading().equals("CHANGE PASSWORD")){
                    dialog.show();
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class holder extends RecyclerView.ViewHolder{
        TextView heading, subheading;
        ImageView icon;
        public holder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            subheading = itemView.findViewById(R.id.heading1);
            icon=itemView.findViewById(R.id.icon);
        }
    }
}
