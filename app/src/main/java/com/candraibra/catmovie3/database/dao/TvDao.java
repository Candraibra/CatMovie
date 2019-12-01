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
import androidx.room.Update;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;

import java.util.List;

@Dao
public interface TvDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TvResults tv);

    @Delete()
    void delete(TvResults tv);

    @Query("SELECT * from tvTable ORDER BY name ASC")
    LiveData<List<TvResults>> getAllTv();

    @Query("SELECT * from tvTable WHERE id =:id")
    LiveData<TvResults> getTvById(int id);
}
