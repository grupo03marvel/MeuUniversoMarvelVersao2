
package com.example.meuuniversomarvel.model.charactersId;

import com.google.gson.annotations.Expose;

import java.util.List;


@SuppressWarnings("unused")
public class Comics {

    @Expose
    private Long available;
    @Expose
    private String collectionURI;
    @Expose
    private List<Object> items;
    @Expose
    private Long returned;

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Long getReturned() {
        return returned;
    }

    public void setReturned(Long returned) {
        this.returned = returned;
    }

}
