/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 10:03 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 9:55 PM
 *
 */

package com.candraibra.catmovie3.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.adapter.MoviePagedListAdapter;
import com.candraibra.catmovie3.adapter.TvPagedListAdapter;
import com.candraibra.catmovie3.viewmodel.FavoriteViewModel;
import com.candraibra.catmovie3.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteFragment extends Fragment {
    @BindView(R.id.rv_movie)
    public RecyclerView rvMovie;
    @BindView(R.id.shimmerLayout)
    public ShimmerFrameLayout shimmerFrameLayout;
    @BindView(R.id.shimmerLayout_2)
    public ShimmerFrameLayout shimmerFrameLayout2;
    @BindView(R.id.rv_tv)
    public RecyclerView rvTv;

    private MoviePagedListAdapter movieAapter;
    private TvPagedListAdapter tvAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @NonNull
    private FavoriteViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavoriteViewModel.class);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            FavoriteViewModel viewModel = obtainViewModel(getActivity());
            movieAapter = new MoviePagedListAdapter(getActivity());
            tvAdapter = new TvPagedListAdapter(getActivity());
            viewModel.getAllMovie().observe(this, results -> {
                if (results != null) {
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    movieAapter.submitList(results);
                    rvMovie.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    rvMovie.setHasFixedSize(true);
                    rvMovie.setAdapter(movieAapter);
                } else {
                    Toast.makeText(getActivity(), "List Movie Null", Toast.LENGTH_SHORT).show();
                }
            });
            viewModel.getAllTv().observe(this, results -> {
                if (results != null) {
                    shimmerFrameLayout2.stopShimmer();
                    shimmerFrameLayout2.setVisibility(View.GONE);
                    tvAdapter.submitList(results);
                    rvTv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    rvTv.setHasFixedSize(true);
                    rvTv.setAdapter(tvAdapter);

                } else {
                    Toast.makeText(getActivity(), "List Tv Null", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}
