package com.example.csc4111project3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StaffLoginPage extends AppCompatActivity {
    private EditText accessID;
    private EditText password;
    private Button login;
    private Button swapLogin;
    private FirebaseAuth mAuth; //shared firebase object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);

        mAuth = FirebaseAuth.getInstance();

        accessID = (EditText) findViewById(R.id.AccessID);
        password = (EditText) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.login);
        swapLogin = (Button) findViewById(R.id.loginswap);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                staffLogin();
            }
        });
        swapLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffLoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    //private method to handle staff login once login button is clicked
    private void staffLogin() {
        //convert user input to Strings
        String staffEmail = accessID.getText().toString().trim();
        String pWord = password.getText().toString().trim();

        //user input validation
        if(staffEmail.isEmpty()){
            accessID.setError("Please enter login email");
            accessID.requestFocus();
            return;
        }
        //check if it's a valid email
        if(!Patterns.EMAIL_ADDRESS.matcher(staffEmail).matches()) {
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

        //firebase password char length needs to be at least 6, must validate
        if(pWord.length() < 6){
            password.setError("Password must be at least 6 characters");
            password.requestFocus();
            return;
        }
        //sign the user in using email and password and allow them to go to the menu
        mAuth.signInWithEmailAndPassword(staffEmail, pWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //check to see if successful
                if (task.isSuccessful() && staffEmail.startsWith("staff")){
                    //log into staff profile
                    //move into the staff menu page
                    Intent intent = new Intent(StaffLoginPage.this, StaffMenuPage.class);
                    startActivity(intent);
                    //give message if login for staff fails
                } else {
                    Toast.makeText(StaffLoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }//end of userLogin method
}
