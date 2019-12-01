/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 11:33 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/22/19 8:30 PM
 *
 */

package com.candraibra.catmovie3.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MovieResults movie);

    @Update()
    void update(MovieResults movie);

    @Delete()
    void delete(MovieResults movie);

    @Query("SELECT * from movieresults ORDER BY title ASC")
    LiveData<List<MovieResults>> getAllMovies();
}
