package com.eatery.models;

public class Drinks extends Item {
    public Drinks(int itemId, String itemName, int price, Boolean visibility, int offers, String type) {
        super(itemId, itemName, price, visibility, offers, type);
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

    @Override
    public void changePrice() {

    }
}