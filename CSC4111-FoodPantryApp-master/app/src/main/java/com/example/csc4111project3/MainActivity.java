package com.example.csc4111project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.*;

public class MainActivity extends AppCompatActivity {
    private EditText AccessID;
    private EditText Password;
    private Button Login;
    private Button SwapLogin;
    private FirebaseAuth mAuth; //shared firebase object
    private TextView forgotpassword;
    private Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        AccessID = (EditText) findViewById(R.id.AccessID);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.login);
        SwapLogin = (Button) findViewById(R.id.loginswap);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        Signup = (Button) findViewById(R.id.signup);


        //logs user in
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuPage.class);
                startActivity(intent);
            }
        });

        //swaps login to staff
        SwapLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaffLoginPage.class);
                startActivity(intent);
            }
        });

        //takes user to signup page
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormPIProcessing.class);
                startActivity(intent);
            }
        });
    }
}