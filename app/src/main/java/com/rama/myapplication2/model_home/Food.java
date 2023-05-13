package com.rama.myapplication2.model_home;

public class Food {
    private String name;
    private String description;
    private int price;
    private int image;
    private int quantity;

    public Food(String name, String description, int price, int image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
