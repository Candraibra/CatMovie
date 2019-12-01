/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 8:59 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 8:33 PM
 *
 */

package com.candraibra.catmovie3.ui.fragment;

import android.content.Intent;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.adapter.MovieAdapter;
import com.candraibra.catmovie3.ui.activity.DetailMovieActivity;
import com.candraibra.catmovie3.utils.ItemClickSupport;
import com.candraibra.catmovie3.viewmodel.MovieViewModel;
import com.candraibra.catmovie3.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteFragment extends Fragment {
    @BindView(R.id.rv_movie)
    public RecyclerView recyclerView;
    @BindView(R.id.shimmerLayout)
    public ShimmerFrameLayout shimmer;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @NonNull
    private MovieViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            MovieViewModel viewModel = obtainViewModel(getActivity());
            viewModel.mLiveMovieData().observe(this, results -> {
                MovieAdapter movieAdapter = new MovieAdapter(getActivity(), results);
                shimmer.stopShimmer();
                shimmer.setVisibility(View.GONE);
                if (results != null) {
                    ItemClickSupport.addTo(recyclerView).setOnItemClickListener((recyclerView, position, v) -> {
                        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, results.get(position));
                        startActivity(intent);
                    });
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(movieAdapter);
                    movieAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(getActivity(), "List Null", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}
