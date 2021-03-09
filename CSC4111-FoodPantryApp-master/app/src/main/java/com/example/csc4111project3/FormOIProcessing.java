package com.example.csc4111project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.*;

public class FormOIProcessing extends AppCompatActivity implements AdapterView.OnItemSelectedListener{ //This is the class that will be handling the food selection portion of the user submission form

    //---------
    //VARIABLES
    //---------
    //Creates the spinner objects, as well as the arrays with the food item selections, and a submit button
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Button submit;
    private static final String[] carbohydrates = {"Bread", "Black Beans", "Rice"};
    private static final String[] vegetables = {"Green Beans", "Carrots", "Corn"};
    private static final String[] fruits = {"Pineapple", "Apple", "Orange"};

    //-------------------------------------------------------------
    //onCreate Override to establish the code upon entering the page
    //-------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //captures the instance of the application
        setContentView(R.layout.activity_order_form); //sets the content view to the order form
        submit = (Button) findViewById(R.id.submitButton);

        spinner1 = (Spinner) findViewById(R.id.spinner1); //ties spinner to carbohydrate spinner within activity_order_form.xml
        spinner2 = (Spinner) findViewById(R.id.spinner2); //ties spinner to vegetable spinner within activity_order_form.xml
        spinner3 = (Spinner) findViewById(R.id.spinner3); //ties spinner to fruit spinner within activity_order_form.xml

        //The below code creates ArrayAdaptors to the respective spinners, linking the contents of the ingredient arrays to the dropdown list items
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(FormOIProcessing.this,
                android.R.layout.simple_spinner_dropdown_item, carbohydrates);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(FormOIProcessing.this,
                android.R.layout.simple_spinner_dropdown_item, vegetables);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(FormOIProcessing.this,
                android.R.layout.simple_spinner_dropdown_item, fruits);

        //The below code simply links an android menu resource to each adapter, as to give them a layout
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Sets the carbohydrate array adaptor and a listener to the spinner objects for later use
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        //Sets the vegetable array adaptor and a listener to the spinner objects for later use
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        //Sets the fruit array adaptor and a listener to the spinner objects for later use
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        //Sets a listener override for the submit button, telling the button press where to go
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //TO BE FILLED WITH CODE NECESSARY FOR SUBMITTING THE FORM INFO: This is merely a placeholder for demonstration
            }
        });

    }

    //-----------------------------------------------------------------------------------------------------------------------------------
    //onItemSelected Override to establish what the items selected will do (requires SQL/JSON code down the road to store and send items)
    //-----------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        //A switch reader that will cycle through each array item (WORK IN PROGRESS, WILL NEED TO BE MODIFIED TO ACCOUNT FOR DIFFERENT AMOUNTS OF EACH FOOD ITEM TYPE)
        switch (position) {
            case 0:
                // This is where the code for the carbohydrate choice will be placed
                break;
            case 1:
                // This is where the vegetable choice will be placed
                break;
            case 2:
                // This is where the fruit choice will be placed
                break;

        }
    }

    //-------------------------------------------------------------------------------------
    //onNothingSelected Override to make sure the adaptor at least handles nothing selected
    //-------------------------------------------------------------------------------------
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


}

