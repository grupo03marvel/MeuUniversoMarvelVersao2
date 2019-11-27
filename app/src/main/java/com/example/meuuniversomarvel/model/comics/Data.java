
package com.example.meuuniversomarvel.model.comics;

import com.google.gson.annotations.Expose;

import java.util.List;

@SuppressWarnings("unused")
public class Data {

    @Expose
    private Long count;
    @Expose
    private Long limit;
    @Expose
    private Long offset;
    @Expose
    private List<ResultComics> results;
    @Expose
    private Long total;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public List<ResultComics> getResults() {
        return results;
    }

    public void setResults(List<ResultComics> resultComics) {
        this.results = resultComics;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
