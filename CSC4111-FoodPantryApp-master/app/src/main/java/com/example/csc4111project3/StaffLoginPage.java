package com.example.csc4111project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StaffLoginPage extends AppCompatActivity {
    private EditText AccessID;
    private EditText Password;
    private Button Login;
    private Button SwapLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);

        AccessID = (EditText) findViewById(R.id.AccessID);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.login);
        SwapLogin = (Button) findViewById(R.id.loginswap);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffLoginPage.this, StaffMenuPage.class);
                startActivity(intent);
            }
        });
        SwapLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffLoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
