package com.example.csc4111project3;

public class Orders {
    String email;
    String protein;
    String vegetable;
    String fruit;
    String date;
    String orderProgress;

    public Orders(String email, String protein, String vegetable, String fruit, String date, String orderProgress) {

        this.email = email;
        this.protein = protein;
        this.vegetable = vegetable;
        this.fruit = fruit;
        this.date = date;
        this.orderProgress = orderProgress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderProgress() {
        return orderProgress;
    }

    public void setOrderProgress(String orderProgress) {
        this.orderProgress = orderProgress;
    }
}
