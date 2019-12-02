/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 8:32 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/2/19 8:31 AM
 *
 */

package com.candraibra.catmovie3.ui.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.data.entity.tv.TvResults;
import com.candraibra.catmovie3.ui.activity.DetailTvActivity;

public class TvPagedListAdapter extends PagedListAdapter<TvResults, TvPagedListAdapter.NoteViewHolder> {
    private static DiffUtil.ItemCallback<TvResults> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvResults>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(TvResults oldNote, TvResults newNote) {
                    return oldNote.getName().equals(newNote.getName());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(TvResults oldNote, @NonNull TvResults newNote) {
                    return oldNote.equals(newNote);
                }
            };
    private final Activity activity;

    public TvPagedListAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_fav, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NoteViewHolder holder, int position) {
        final TvResults movieResults = getItem(position);
        if (movieResults != null) {
            holder.tvTitle.setText(movieResults.getName());
            Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500" + movieResults.getPosterPath()).placeholder(R.drawable.loading).into(holder.imgPhoto);
            holder.imgPhoto.setOnClickListener(v -> {
                Intent intent = new Intent(activity, DetailTvActivity.class);
                intent.putExtra(DetailTvActivity.EXTRA_TV, movieResults);
                activity.startActivity(intent);
            });
        }
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private ImageView imgPhoto;

        NoteViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imgPhoto = itemView.findViewById(R.id.img_poster);

        }
    }
}
