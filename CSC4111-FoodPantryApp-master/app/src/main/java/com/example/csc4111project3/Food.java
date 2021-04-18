package com.example.csc4111project3;

public class Food {
    String food;
    String foodType;
    Long quantity;

    public Food(){

    }

    public Food(String food, String foodType, Long quantity) {
        this.food = food;
        this.foodType = foodType;
        this.quantity = quantity;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
