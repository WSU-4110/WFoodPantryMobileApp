package com.example.csc4111project3;

import org.junit.*;

public class StaffUpdateFoodMenuTest {
    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void onCreate(){
        PantryMenu testItem = new PantryMenu("Pork", "Meat", 3);
        assert testItem.food.equals("Pork");
        assert testItem.foodType.equals("Meat");
        System.out.println("Successfully created");
    }

    @Test
    public void onComplete() {
        System.out.println("Successfully completed");
    }
}
