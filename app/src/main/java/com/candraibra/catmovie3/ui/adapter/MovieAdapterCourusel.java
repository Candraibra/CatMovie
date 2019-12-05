/*
 * *
 *  * Created by Candra Ibra Sanie on 12/5/19 7:29 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/5/19 7:29 AM
 *
 */

package com.candraibra.catmovie3.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;

import java.util.List;

public class MovieAdapterCourusel extends RecyclerView.Adapter<MovieAdapterCourusel.MyViewHolder> {

    private Activity activity;
    private List<MovieResults> movieList;

    public MovieAdapterCourusel(Activity activity, List<MovieResults> movieList) {
        this.activity = activity;
        this.movieList = movieList;
    }


    private List<MovieResults> getMovieList() {
        return movieList;
    }

    @NonNull
    @Override
    public MovieAdapterCourusel.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_popular, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterCourusel.MyViewHolder holder, int i) {
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500" + movieList.get(i).getBackdropPath()).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;

        MyViewHolder(View view) {
            super(view);
            imgPhoto = itemView.findViewById(R.id.img_poster);

        }
    }
}