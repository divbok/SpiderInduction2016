package com.example.user.moviesapp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 7/23/2016.
 */
public class Movie {
    @Expose
    @SerializedName("Title")
    private String title;
@Expose
    @SerializedName("Year")
    private String year;
@Expose
    @SerializedName("Genre")
    private String genre;
@Expose
    @SerializedName("Director")
    private String director;
@Expose
    @SerializedName("Plot")
    private String plot;
@Expose
    @SerializedName("Poster")
    private String poster;

    private String imdbRating;
@Expose
    @SerializedName("imdbID")
    private String imdbId;
@Expose
    @SerializedName("Type")
    private String type;
@Expose
    @SerializedName("Response")
    private String response;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
