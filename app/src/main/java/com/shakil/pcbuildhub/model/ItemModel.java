package com.shakil.pcbuildhub.model;

public class ItemModel {
    private int id;
    private String title;
    private double price;
    private String arrivedDate;
    private String companyName;


    public ItemModel(int id, String title, double price, String arrivedDate, String companyName) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.arrivedDate = arrivedDate;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArrivedDate() {
        return arrivedDate;
    }

    public void setArrivedDate(String arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
