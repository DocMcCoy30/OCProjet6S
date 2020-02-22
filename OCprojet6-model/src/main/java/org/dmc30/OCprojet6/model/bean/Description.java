package org.dmc30.OCprojet6.model.bean;

public class Description {

    private int id;
    private String description;
    private String info;

    public Description() {
    }

    public Description(int id, String description, String info) {
        this.id = id;
        this.description = description;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
