package com.eatery.models;

public class BlueBerryDecorator extends AddOnsDecorator {
    public BlueBerryDecorator(Item itemToBeDecorated) {
        super(itemToBeDecorated);
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() + 3;
    }
}
