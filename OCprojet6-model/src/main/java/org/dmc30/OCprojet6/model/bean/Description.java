package org.dmc30.OCprojet6.model.bean;

public class Description {

    private int id;
    private String description;

    public Description() {
    }

    public Description(int description_id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
