/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/22/19 9:52 AM
 *
 */

package com.candraibra.catmovie3.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.data.network.tv.TvResults;
import com.candraibra.catmovie3.utils.EspressoIdlingResource;
import com.candraibra.catmovie3.viewmodel.DetailViewModel;
import com.candraibra.catmovie3.viewmodel.ViewModelFactory;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTvActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "tv_id";
    @BindView(R.id.img_poster)
    public ImageView imgPoster;
    @BindView(R.id.tv_desc)
    public TextView tvDesc;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.progressBar)
    public ProgressBar progressBar;
    @BindView(R.id.backButton)
    public ImageButton btnBack;
    @BindView(R.id.btn_fav)
    public ImageButton btnFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);
        ButterKnife.bind(this);
        TvResults selectedTv;
        selectedTv = getIntent().getParcelableExtra(EXTRA_TV);
        ViewModelFactory factory = ViewModelFactory.getInstance(this.getApplication());
        DetailViewModel viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel.class);
        viewModel.setTvId(Objects.requireNonNull(selectedTv).getId());
        btnBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
        btnFav.setOnClickListener(v -> Toast.makeText(this, "Feature not ready yet", Toast.LENGTH_SHORT).show());
        if (selectedTv.getId() != 0) {
            EspressoIdlingResource.increment();
            viewModel.getTvById().observe(this, results -> {
                progressBar.setVisibility(View.GONE);
                Glide.with(this).load("https://image.tmdb.org/t/p/w780" + results.getBackdropPath()).into(imgPoster);
                tvDesc.setText(results.getOverview());
                tvTitle.setText(results.getName());
                EspressoIdlingResource.decrement();
            });
        } else {
            Log.d("DetailMovie", "movie id = 0");
        }
    }

}

