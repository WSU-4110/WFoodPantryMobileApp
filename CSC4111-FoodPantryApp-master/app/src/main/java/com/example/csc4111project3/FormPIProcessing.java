package com.example.csc4111project3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import java.lang.*;
import java.util.concurrent.TimeUnit;


public class FormPIProcessing extends AppCompatActivity { //This is the class that will be handling the contact information portion of the user submission form

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //captures the instance of the application
        setContentView(R.layout.activity_info_form); //sets the content view to the information form

        //---------
        //VARIABLES
        //---------
        //Declare the EditText and Button objects needed for the form. And firebaseAuth object.
        //Links the aforementioned objects to their respective items within activity_info_form.xml
        EditText FirstName = (EditText) findViewById(R.id.FirstName);
        EditText LastName = (EditText) findViewById(R.id.LastName);
        EditText Phone = (EditText) findViewById(R.id.Phone);
        EditText Email = (EditText) findViewById(R.id.Email);
        EditText Password = (EditText) findViewById(R.id.textpassword);
        Button Submit = (Button) findViewById(R.id.submit);
        FirebaseAuth mAuth;

        //initialize firebase
        mAuth = FirebaseAuth.getInstance();

        //Sets a listener override for the submit button, telling the button press where to go
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to register the user
                //data cleanup, convert to Strings
                String fName = FirstName.getText().toString().trim();
                String lName = LastName.getText().toString().trim();
                String phone = Phone.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String pword = Password.getText().toString().trim();

                //data validation. check for empty values
                if(fName.isEmpty()){
                    FirstName.setError("First name is required");
                    FirstName.requestFocus();
                    return;
                }
                if(lName.isEmpty()){
                    LastName.setError("Last name is required");
                    LastName.requestFocus();
                    return;
                }
                if(phone.isEmpty()){
                    Phone.setError("Phone number is required");
                    Phone.requestFocus();
                    return;
                }
                if(email.isEmpty()){
                    Email.setError("Email is required");
                    Email.requestFocus();
                    return;
                }
                //check if it's a valid email
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Email.setError("Provide valid email");
                    Email.requestFocus();
                    return;
                }

                if(pword.isEmpty()){
                    Password.setError("Enter secure password");
                    Password.requestFocus();
                    return;
                }

                //firebase password char length needs to be 6<=, must validate
                if(pword.length() < 6){
                    Password.setError("Password must be >=6 characters");
                    Password.requestFocus();
                    return;
                }

                //now create the user, first check if user exists
                mAuth.createUserWithEmailAndPassword(email, pword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                //create new user
                                User user = new User(fName, lName, phone, email);

                                //send to database
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) { //has the user been sent?
                                        if(task.isSuccessful()){
                                            //give successful message pause for a second and return to main activity
                                            Toast.makeText(FormPIProcessing.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                            //handle exception
                                            try {
                                                TimeUnit.SECONDS.sleep(2);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            //code to navigate back to main activity
                                            Intent intent = new Intent(FormPIProcessing.this, MainActivity.class);
                                            startActivity(intent); //Begins the activity using the intent created
                                        //handle failure
                                        } else {
                                            Toast.makeText(FormPIProcessing.this, "Failed to register", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {//in case of failure
                                Toast.makeText(FormPIProcessing.this, "Failed to register", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        }); //send of submit button OnClick
    }//end of OnCreate method.
}// end of FormPIProcessing class
