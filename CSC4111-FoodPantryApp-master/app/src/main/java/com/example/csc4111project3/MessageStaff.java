package com.example.csc4111project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.*;

public class MessageStaff extends AppCompatActivity{

    //variables
    private Button RefreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_staff);

        //use name and accessID to check for messages


        //declare variables
        RefreshButton = (Button) findViewById(R.id.RefreshButton);

        RefreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //repeat process after create
            }
        });
    }
}
