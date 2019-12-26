/*
 * *
 *  * Created by Candra Ibra Sanie on 12/26/19 7:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/26/19 7:37 PM
 *
 */

package com.candraibra.catmovie3.data.entity.movie;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "movieTable")
public class MovieResults implements Parcelable {

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview;

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    private String originalLanguage;

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    private String originalTitle;

    @ColumnInfo(name = "video")
    @SerializedName("video")
    private boolean video;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @Ignore
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    private String posterPath;

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    private String backdropPath;

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    private String releaseDate;

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    private double popularity;

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    private double voteAverage;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    private boolean adult;

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    private int voteCount;

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

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public MovieResults(String overview, String originalLanguage, String originalTitle, boolean video, String title, String posterPath, String backdropPath, String releaseDate, double popularity, double voteAverage, int id, boolean adult, int voteCount) {
        this.overview = overview;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.video = video;
        this.title = title;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
        this.voteAverage = voteAverage;
        this.id = id;
        this.adult = adult;
        this.voteCount = voteCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.overview);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalTitle);
        dest.writeByte(this.video ? (byte) 1 : (byte) 0);
        dest.writeString(this.title);
        dest.writeList(this.genreIds);
        dest.writeString(this.posterPath);
        dest.writeString(this.backdropPath);
        dest.writeString(this.releaseDate);
        dest.writeDouble(this.popularity);
        dest.writeDouble(this.voteAverage);
        dest.writeInt(this.id);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeInt(this.voteCount);
    }


    protected MovieResults(Parcel in) {
        this.overview = in.readString();
        this.originalLanguage = in.readString();
        this.originalTitle = in.readString();
        this.video = in.readByte() != 0;
        this.title = in.readString();
        this.genreIds = new ArrayList<>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.posterPath = in.readString();
        this.backdropPath = in.readString();
        this.releaseDate = in.readString();
        this.popularity = in.readDouble();
        this.voteAverage = in.readDouble();
        this.id = in.readInt();
        this.adult = in.readByte() != 0;
        this.voteCount = in.readInt();
    }

    public static final Parcelable.Creator<MovieResults> CREATOR = new Parcelable.Creator<MovieResults>() {
        @Override
        public MovieResults createFromParcel(Parcel source) {
            return new MovieResults(source);
        }

        @Override
        public MovieResults[] newArray(int size) {
            return new MovieResults[size];
        }
    };

}