/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 4:47 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 4:33 PM
 *
 */

package com.candraibra.catmovie3.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MovieResults movie);

    @Delete()
    void delete(MovieResults movie);

    @Query("SELECT * from movieTable WHERE id =:id")
    LiveData<MovieResults> getMovieById(int id);

    @Query("SELECT * from movieTable ORDER BY title ASC")
    LiveData<List<MovieResults>> getAllMovie();
}
