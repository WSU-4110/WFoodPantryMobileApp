package com.example.csc4111project3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffMenuPageTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {
        System.out.println("Created page for staff menu");
    }

    @Test
    public void onBackPressed() {
        System.out.println("Going back...");
    }

    @Test
    public void onNavigationItemSelected() {
        System.out.println("New item selected");
    }
}