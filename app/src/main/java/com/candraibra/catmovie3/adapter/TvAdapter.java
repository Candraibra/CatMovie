/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/19/19 7:33 AM
 *
 */

package com.candraibra.catmovie3.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.data.network.tv.TvResults;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.MyViewHolder> {

    private Activity activity;
    private List<TvResults> tvList;

    public TvAdapter(Activity activity, List<TvResults> tvList) {
        this.activity = activity;
        this.tvList = tvList;
    }

    private List<TvResults> getTvList() {
        return tvList;
    }

    @NonNull
    @Override
    public TvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_rv, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.MyViewHolder holder, int i) {
        holder.tvTitle.setText(tvList.get(i).getName());
        holder.tvDesc.setText(tvList.get(i).getOverview());
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500" + tvList.get(i).getPosterPath()).placeholder(R.drawable.loading).into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return tvList.size();
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
