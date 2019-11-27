
package com.example.meuuniversomarvel.model.characters;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;


@Entity(tableName = "perso")
public class ResultCharacters implements Parcelable {

    @Expose
    private Comics comics;
    @Expose
    private String description;
    @Expose
    private Events events;

    @Expose
    @PrimaryKey
    @NonNull
    private Long id;
    @Expose
    private String modified;
    @Expose
    private String name;
    @Expose
    private String resourceURI;
    @Expose
    private Series series;
    @Expose
    private Stories stories;
    @Expose
    private Thumbnail thumbnail;
    @Expose
    private List<Url> urls;

    protected ResultCharacters(Parcel in) {
        description = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        modified = in.readString();
        name = in.readString();
        resourceURI = in.readString();
    }

    public static final Creator<ResultCharacters> CREATOR = new Creator<ResultCharacters>() {
        @Override
        public ResultCharacters createFromParcel(Parcel in) {
            return new ResultCharacters(in);
        }

        @Override
        public ResultCharacters[] newArray(int size) {
            return new ResultCharacters[size];
        }
    };

    public ResultCharacters(Comics comics, String description, Events events, @NonNull Long id, String modified, String name, String resourceURI, Series series, Stories stories, Thumbnail thumbnail, List<Url> urls) {
        this.comics = comics;
        this.description = description;
        this.events = events;
        this.id = id;
        this.modified = modified;
        this.name = name;
        this.resourceURI = resourceURI;
        this.series = series;
        this.stories = stories;
        this.thumbnail = thumbnail;
        this.urls = urls;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(modified);
        parcel.writeString(name);
        parcel.writeString(resourceURI);
    }
}
