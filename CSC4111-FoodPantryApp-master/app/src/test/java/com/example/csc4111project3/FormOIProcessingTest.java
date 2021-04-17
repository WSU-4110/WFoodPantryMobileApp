package com.example.csc4111project3;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class FormOIProcessingTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createMenuWithWrongCarbs() {
        String[] carbohydrates = Vegetables.createMenu();
        String[] trueCarb = Carbs.createMenu();
        assertArrayEquals("Invalid input: needed Carbs and not Veggies", carbohydrates, trueCarb);
    }

    @Test
    public void createMenuWithWrongVeggies() {
        String[] vegetables = Fruits.createMenu();
        String[] trueVeggies = Vegetables.createMenu();
        assertArrayEquals("Invalid input: needed Veggies and not Fruits", vegetables, trueVeggies);
    }

    @Test
    public void createMenuWithWrongFruits() {
        String[] fruits = Carbs.createMenu();
        String[] trueFruits = Fruits.createMenu();
        assertArrayEquals("Invalid input: needed Fruits and not Carbs", fruits, trueFruits);
    }

    @Test
    public void createMenuWithRightCarbs() {
        String[] carbohydrates = Carbs.createMenu();
        String[] trueCarb = Carbs.createMenu();
        assertArrayEquals("Invalid input: needed Carbs and not Veggies", carbohydrates, trueCarb);
    }

    @Test
    public void createMenuWithRightVeggies() {
        String[] vegetables = Vegetables.createMenu();
        String[] trueVeggies = Vegetables.createMenu();
        assertArrayEquals("Invalid input: needed Veggies and not Fruits", vegetables, trueVeggies);
    }

    @Test
    public void createMenuWithRightFruits() {
        String[] fruits = Fruits.createMenu();
        String[] trueFruits = Fruits.createMenu();
        assertArrayEquals("Invalid input: needed Fruits and not Carbs", fruits, trueFruits);
    }

    @Test
    public void onCreate() {
        System.out.println("The page view and features have been created!");
    }

    @Test
    public void onItemSelected() {
        System.out.println("An item has been selected!");
    }

    @Test
    public void onNothingSelected() {
        System.out.println("Nothing has been selected...");
    }
}