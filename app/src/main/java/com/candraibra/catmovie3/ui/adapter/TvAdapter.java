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
import com.candraibra.catmovie3.data.entity.tv.TvResults;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.MyViewHolder> {

    private List<TvResults> tvList;

    private Context mContext;

    public TvAdapter(Context context, List<TvResults> tvList) {
        this.tvList = tvList;
        this.mContext = context;
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
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500" + tvList.get(i).getPosterPath()).placeholder(R.drawable.loading).into(holder.imgPhoto);

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
