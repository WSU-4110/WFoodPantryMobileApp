package com.example.csc4111project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.*;

public class StaffMessageUser extends AppCompatActivity{

    //variables
    private EditText Recipient;
    private EditText MessageSubject;
    private EditText MessageSend;
    private Button SendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffmessage_user);

        //declare variables
        Recipient = (EditText) findViewById(R.id.Recipient);
        MessageSubject = (EditText) findViewById(R.id.MessageSubject);
        MessageSend = (EditText) findViewById(R.id.MessageSend);
        SendButton = (Button) findViewById(R.id.SendButton);

        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //fill later
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

}