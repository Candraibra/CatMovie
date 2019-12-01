/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 11:33 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/22/19 5:56 PM
 *
 */

package com.candraibra.catmovie3.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;

@Database(entities = {MovieResults.class}, version = 1, exportSchema = false)
public abstract class MovieRoomDatabase extends RoomDatabase {
    private static volatile MovieRoomDatabase INSTANCE;

    public static MovieRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieRoomDatabase.class, "movieDb")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract MovieDao tvDao();
}
