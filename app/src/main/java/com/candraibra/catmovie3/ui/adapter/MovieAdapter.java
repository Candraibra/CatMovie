/*
 * *
 *  * Created by Candra Ibra Sanie on 2/19/20 4:26 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 2/19/20 4:26 PM
 *
 */

package com.candraibra.catmovie3.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<MovieResults> movieList;

    private Context mContext;

    public MovieAdapter(Context context, List<MovieResults> movieList) {
        this.movieList = movieList;
        this.mContext = context;
    }


    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_rv, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int i) {
        holder.tvTitle.setText(movieList.get(i).getTitle());
        holder.tvDesc.setText(movieList.get(i).getOverview());
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath()).placeholder(R.drawable.loading).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDesc;
        ImageView imgPhoto;

        MyViewHolder(View view) {
            super(view);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            imgPhoto = itemView.findViewById(R.id.iv_poster);

        }
    }
}