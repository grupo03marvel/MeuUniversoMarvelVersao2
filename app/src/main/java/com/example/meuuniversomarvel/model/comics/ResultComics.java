
package com.example.meuuniversomarvel.model.comics;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;

@Entity(tableName = "comics")
public class ResultComics implements Parcelable {
    @Expose
    private Characters characters;
    @Expose
    private List<Object> collectedIssues;
    @Expose
    private List<Object> collections;
    @Expose
    private Creators creators;
    @Expose
    private List<Date> dates;
    @Expose
    private String description;
    @Expose
    private String diamondCode;
    @Expose
    private Long digitalId;
    @Expose
    private String ean;
    @Expose
    private Events events;
    @Expose
    private String format;

    @Expose
    @PrimaryKey
    @NonNull
    private Long id;
    @Expose
    private List<Image> images;
    @Expose
    private String isbn;
    @Expose
    private String issn;
    @Expose
    private Long issueNumber;
    @Expose
    private String modified;
    @Expose
    private Long pageCount;
    @Expose
    private List<Price> prices;
    @Expose
    private String resourceURI;
    @Expose
    private Series series;
    @Expose
    private Stories stories;
    @Expose
    private List<TextObject> textObjects;
    @Expose
    private Thumbnail thumbnail;
    @Expose
    private String title;
    @Expose
    private String upc;
    @Expose
    private List<Url> urls;
    @Expose
    private String variantDescription;
    @Expose
    private List<Object> variants;

    public ResultComics(Characters characters, List<Object> collectedIssues, List<Object> collections, Creators creators, List<Date> dates, String description, String diamondCode, Long digitalId, String ean, Events events, String format, @NonNull Long id, List<Image> images, String isbn, String issn, Long issueNumber, String modified, Long pageCount, List<Price> prices, String resourceURI, Series series, Stories stories, List<TextObject> textObjects, Thumbnail thumbnail, String title, String upc, List<Url> urls, String variantDescription, List<Object> variants) {
        this.characters = characters;
        this.collectedIssues = collectedIssues;
        this.collections = collections;
        this.creators = creators;
        this.dates = dates;
        this.description = description;
        this.diamondCode = diamondCode;
        this.digitalId = digitalId;
        this.ean = ean;
        this.events = events;
        this.format = format;
        this.id = id;
        this.images = images;
        this.isbn = isbn;
        this.issn = issn;
        this.issueNumber = issueNumber;
        this.modified = modified;
        this.pageCount = pageCount;
        this.prices = prices;
        this.resourceURI = resourceURI;
        this.series = series;
        this.stories = stories;
        this.textObjects = textObjects;
        this.thumbnail = thumbnail;
        this.title = title;
        this.upc = upc;
        this.urls = urls;
        this.variantDescription = variantDescription;
        this.variants = variants;
    }

    protected ResultComics(Parcel in) {
        description = in.readString();
        diamondCode = in.readString();
        if (in.readByte() == 0) {
            digitalId = null;
        } else {
            digitalId = in.readLong();
        }
        ean = in.readString();
        format = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        isbn = in.readString();
        issn = in.readString();
        if (in.readByte() == 0) {
            issueNumber = null;
        } else {
            issueNumber = in.readLong();
        }
        modified = in.readString();
        if (in.readByte() == 0) {
            pageCount = null;
        } else {
            pageCount = in.readLong();
        }
        resourceURI = in.readString();
        title = in.readString();
        upc = in.readString();
        variantDescription = in.readString();
    }

    public static final Creator<ResultComics> CREATOR = new Creator<ResultComics>() {
        @Override
        public ResultComics createFromParcel(Parcel in) {
            return new ResultComics(in);
        }

        @Override
        public ResultComics[] newArray(int size) {
            return new ResultComics[size];
        }
    };

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public List<Object> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<Object> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<Object> getCollections() {
        return collections;
    }

    public void setCollections(List<Object> collections) {
        this.collections = collections;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public Long getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(Long digitalId) {
        this.digitalId = digitalId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public Long getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Long issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
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

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<TextObject> textObjects) {
        this.textObjects = textObjects;
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

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public List<Object> getVariants() {
        return variants;
    }

    public void setVariants(List<Object> variants) {
        this.variants = variants;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeString(diamondCode);
        if (digitalId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(digitalId);
        }
        parcel.writeString(ean);
        parcel.writeString(format);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(isbn);
        parcel.writeString(issn);
        if (issueNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(issueNumber);
        }
        parcel.writeString(modified);
        if (pageCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(pageCount);
        }
        parcel.writeString(resourceURI);
        parcel.writeString(title);
        parcel.writeString(upc);
        parcel.writeString(variantDescription);
    }
}
