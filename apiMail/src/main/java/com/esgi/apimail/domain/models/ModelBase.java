package com.esgi.apimail.domain.models;

public abstract class ModelBase {
    private Long id;

    public ModelBase() {
        this(null);
    }

    public ModelBase(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
