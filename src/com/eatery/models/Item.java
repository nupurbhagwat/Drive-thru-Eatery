package com.eatery.models;

public abstract class Item {
    private int itemId;
    String itemName;
    double price;
    Boolean visibility;
    int offers;
    String type;

    Item(int itemId, String itemName, double price, Boolean visibility, int offers, String type){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.visibility = visibility;
        this.offers = offers;
        this.type = type;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public int getOffers() {
        return offers;
    }

    public void setOffers(int offers) {
        this.offers = offers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    abstract public double getTotalPrice();

}
