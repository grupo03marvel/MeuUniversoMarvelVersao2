
package com.example.meuuniversomarvel.model.comics;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Date {

    @Expose
    private String date;
    @Expose
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
