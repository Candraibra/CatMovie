/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 10:03 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 10:03 PM
 *
 */

package com.candraibra.catmovie3.database.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.candraibra.catmovie3.data.entity.tv.TvResults;

@Dao
public interface TvDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TvResults tv);

    @Delete()
    void delete(TvResults tv);

    @Query("SELECT * from tvTable ORDER BY name ASC")
    DataSource.Factory<Integer, TvResults> getAllTv();

    @Query("SELECT * from tvTable WHERE id =:id")
    LiveData<TvResults> getTvById(int id);
}
