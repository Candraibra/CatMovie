/*
 * *
 *  * Created by Candra Ibra Sanie on 2/19/20 4:26 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 1/13/20 3:11 PM
 *
 */

package com.candraibra.catmovie3.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.ui.activity.DetailMovieActivity;
import com.candraibra.catmovie3.ui.adapter.MovieAdapter;
import com.candraibra.catmovie3.ui.adapter.MovieAdapterCourusel;
import com.candraibra.catmovie3.utils.EspressoIdlingResource;
import com.candraibra.catmovie3.utils.ItemClickSupport;
import com.candraibra.catmovie3.viewmodel.MovieViewModel;
import com.candraibra.catmovie3.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieFragment extends Fragment {
    @BindView(R.id.rv_upcoming)
    public RecyclerView recyclerView;
    @BindView(R.id.rv_popular)
    public RecyclerView courusel;
    @BindView(R.id.shimmerLayout)
    public ShimmerFrameLayout shimmer;

    @BindView(R.id.shimmerLayoutTop)
    public ShimmerFrameLayout shimmer2;


    @BindView(R.id.container)
    public ConstraintLayout container;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie2, container, false);
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
            EspressoIdlingResource.increment();
            viewModel.mLiveMovieData().observe(this, results -> {
                if (results != null) {
                    MovieAdapter movieAdapter = new MovieAdapter(getActivity(), results);
                    shimmer.stopShimmer();
                    shimmer.setVisibility(View.GONE);
                    ItemClickSupport.addTo(recyclerView).setOnItemClickListener((recyclerView, position, v) -> {
                        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, results.get(position));
                        startActivity(intent);
                    });
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(movieAdapter);
                    movieAdapter.notifyDataSetChanged();
                    EspressoIdlingResource.decrement();
                }
            });
            EspressoIdlingResource.increment();
            viewModel.mLiveUpcomingMovie().observe(this, results -> {
                if (results != null) {
                    MovieAdapterCourusel movieAdapterCourusel = new MovieAdapterCourusel(getActivity(), results);
                    shimmer2.stopShimmer();
                    shimmer2.setVisibility(View.GONE);
                    ItemClickSupport.addTo(courusel).setOnItemClickListener((recyclerView, position, v) -> {
                        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, results.get(position));
                        startActivity(intent);
                    });
                    courusel.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    courusel.setHasFixedSize(true);
                    courusel.setAdapter(movieAdapterCourusel);
                    movieAdapterCourusel.notifyDataSetChanged();
                    EspressoIdlingResource.decrement();
                }
            });


        }
    }

    @OnClick(R.id.logo)
    public void test() {
        BlankFragment fragment2 = new BlankFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_container, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
