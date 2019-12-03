
package com.example.meuuniversomarvel.model.events;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;


@Entity(tableName = "eventos")
public class ResultEvents implements Parcelable {
    public ResultEvents(Characters characters, Comics comics, Creators creators, String description, String end, @NonNull Long id, String modified, Next next, Previous previous, String resourceURI, Series series, String start, Stories stories, Thumbnail thumbnail, String title, List<Url> urls) {
        this.characters = characters;
        this.comics = comics;
        this.creators = creators;
        this.description = description;
        this.end = end;
        this.id = id;
        this.modified = modified;
        this.next = next;
        this.previous = previous;
        this.resourceURI = resourceURI;
        this.series = series;
        this.start = start;
        this.stories = stories;
        this.thumbnail = thumbnail;
        this.title = title;
        this.urls = urls;
    }

    @Expose
    private Characters characters;
    @Expose
    private Comics comics;
    @Expose
    private Creators creators;
    @Expose
    private String description;
    @Expose
    private String end;

    @Expose
    @PrimaryKey
    @NonNull
    private Long id;
    @Expose
    private String modified;
    @Expose
    private Next next;
    @Expose
    private Previous previous;
    @Expose
    private String resourceURI;
    @Expose
    private Series series;
    @Expose
    private String start;
    @Expose
    private Stories stories;
    @Expose
    private Thumbnail thumbnail;
    @Expose
    private String title;
    @Expose
    private List<Url> urls;

    protected ResultEvents(Parcel in) {
        description = in.readString();
        end = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        modified = in.readString();
        resourceURI = in.readString();
        start = in.readString();
        title = in.readString();
    }

    public static final Creator<ResultEvents> CREATOR = new Creator<ResultEvents>() {
        @Override
        public ResultEvents createFromParcel(Parcel in) {
            return new ResultEvents(in);
        }

        @Override
        public ResultEvents[] newArray(int size) {
            return new ResultEvents[size];
        }
    };

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

    public Previous getPrevious() {
        return previous;
    }

    public void setPrevious(Previous previous) {
        this.previous = previous;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        parcel.writeString(end);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(modified);
        parcel.writeString(resourceURI);
        parcel.writeString(start);
        parcel.writeString(title);
    }
}
