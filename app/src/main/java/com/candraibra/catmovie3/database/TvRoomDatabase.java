/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 11:43 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 11:43 AM
 *
 */

package com.candraibra.catmovie3.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.candraibra.catmovie3.data.entity.tv.TvResults;

@Database(entities = {TvResults.class}, version = 1, exportSchema = false)
public abstract class TvRoomDatabase extends RoomDatabase {
    private static volatile TvRoomDatabase INSTANCE;

    public static TvRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TvRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TvRoomDatabase.class, "tvDb")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract TvDao tvDao();
}
