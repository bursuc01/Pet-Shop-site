package com.example.petshop.Model.response;

import java.util.List;

public class FetchEntities<T> {
    private List<T> fetched;

    private T saved;

    public T getSaved() {
        return saved;
    }

    public void setSaved(T saved) {
        this.saved = saved;
    }

    public void setFetched(List<T> fetched) {
        this.fetched = fetched;
    }

    public List<T> getFetched() {
        return fetched;
    }
}
