package com.example.csc4111project3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.lang.*;

public class MainActivity extends AppCompatActivity {
    private EditText accessID;
    private EditText password;
    private Button login;
    private Button swapLogin;
    private FirebaseAuth mAuth; //shared firebase object
    private TextView forgotpassword;
    private Button signup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        //initialize variables
        accessID = (EditText) findViewById(R.id.AccessID);
        password = (EditText) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.login);
        swapLogin = (Button) findViewById(R.id.loginswap);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        signup = (Button) findViewById(R.id.signup);


        //logs user in
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //run login function to get user profile
                userLogin();
            }
        });

        //swaps login to staff
        swapLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaffLoginPage.class);
                startActivity(intent);
            }
        });

        //takes user to signup/FormPIProcessing form
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormPIProcessing.class);
                startActivity(intent);
            }
        });
    }//end of OnCreate method


    //private method to handle user login once login button is clicked
    private void userLogin() {
        //convert user input to Strings
        String userEmail = accessID.getText().toString().trim();
        String pWord = password.getText().toString().trim();

        //user input validation
        if(userEmail.isEmpty()){
            accessID.setError("Please enter login email");
            accessID.requestFocus();
            return;
        }
        //check if it's a valid email
        if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            accessID.setError("Provide valid email");
            accessID.requestFocus();
            return;
        }

        //validate password for empty and # of chars. firebase needs >=6
        if(pWord.isEmpty()){
            password.setError("Enter secure password");
            password.requestFocus();
            return;
        }

        //firebase password char length needs to be 6<=, must validate
        if(pWord.length() < 6){
            password.setError("Password must be >=6 characters");
            password.requestFocus();
            return;
        }
        //sign the user in using email and password and allow them to go to the menu
        mAuth.signInWithEmailAndPassword(userEmail, pWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //check to see if successful
                if (task.isSuccessful()) {
                    //log into user profile
                    //move into the menu page
                    Intent intent = new Intent(MainActivity.this, MenuPage.class);
                    startActivity(intent);
                //give message if login failure
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }//end of userLogin method
}//end of MainActivity class