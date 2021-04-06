package com.example.csc4111project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.*;
    ///// THIS PAGE IS TO BE REWORKED INTO A SIGN UP PAGE FOR NEW USERS, AND HAS BEEN UNHOOKED CURRENTLY FROM MENU FUNCTIONS /////
    public class FormPIProcessing extends AppCompatActivity { //This is the class that will be handling the contact information portion of the user submission form

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState); //captures the instance of the application
            setContentView(R.layout.activity_info_form); //sets the content view to the information form

            //---------
            //VARIABLES
            //---------
            //Creates the EditText and Button objects needed for the form
            EditText FirstName;
            EditText LastName;
            EditText Phone;
            EditText Email;
            Button Submit;

            //Links the aforementioned objects to their respective items within activity_info_form.xml
            FirstName = findViewById(R.id.FirstName);
            LastName = findViewById(R.id.LastName);
            Phone = findViewById(R.id.Phone);
            Email = findViewById(R.id.Email);
            Submit = findViewById(R.id.submit);

            //Sets a listener override for the submit button, telling the button press where to go
            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FormPIProcessing.this, MainActivity.class);
                    startActivity(intent); //Begins the activity using the intent created
                }
            });

        }
    }
