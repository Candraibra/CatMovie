/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 11:30 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/28/19 11:13 AM
 *
 */

package com.candraibra.catmovie3.data.entity.tv;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
@Entity(tableName = "tvTable")
public class TvResults implements Parcelable {

    @ColumnInfo(name = "first_air_date")
    @SerializedName("first_air_date")
    private String firstAirDate;

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview;

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    private String originalLanguage;

    @Ignore
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    private String posterPath;

    @Ignore
    @SerializedName("origin_country")
    private List<String> originCountry;

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    private String backdropPath;

    @ColumnInfo(name = "original_name")
    @SerializedName("original_name")
    private String originalName;

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    private double popularity;

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    private double voteAverage;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    private int voteCount;


    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public static final Parcelable.Creator<TvResults> CREATOR = new Parcelable.Creator<TvResults>() {
        @Override
        public TvResults createFromParcel(Parcel source) {
            return new TvResults(source);
        }

        @Override
        public TvResults[] newArray(int size) {
            return new TvResults[size];
        }
    };

    public TvResults(String firstAirDate, String overview, String originalLanguage,  String posterPath,  String backdropPath, String originalName, double popularity, double voteAverage, String name, int id, int voteCount) {
        this.firstAirDate = firstAirDate;
        this.overview = overview;
        this.originalLanguage = originalLanguage;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.originalName = originalName;
        this.popularity = popularity;
        this.voteAverage = voteAverage;
        this.name = name;
        this.id = id;
        this.voteCount = voteCount;
    }

    private TvResults(Parcel in) {
        this.firstAirDate = in.readString();
        this.overview = in.readString();
        this.originalLanguage = in.readString();
        this.genreIds = new ArrayList<>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.posterPath = in.readString();
        this.originCountry = in.createStringArrayList();
        this.backdropPath = in.readString();
        this.originalName = in.readString();
        this.popularity = in.readDouble();
        this.voteAverage = in.readDouble();
        this.name = in.readString();
        this.id = in.readInt();
        this.voteCount = in.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstAirDate);
        dest.writeString(this.overview);
        dest.writeString(this.originalLanguage);
        dest.writeList(this.genreIds);
        dest.writeString(this.posterPath);
        dest.writeStringList(this.originCountry);
        dest.writeString(this.backdropPath);
        dest.writeString(this.originalName);
        dest.writeDouble(this.popularity);
        dest.writeDouble(this.voteAverage);
        dest.writeString(this.name);
        dest.writeInt(this.id);
        dest.writeInt(this.voteCount);
    }
}