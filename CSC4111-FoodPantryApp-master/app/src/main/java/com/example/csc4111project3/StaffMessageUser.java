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
        FirebaseAuth auth = FirebaseAuth.getInstance();

        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //conversion to String
                String recipient =  Recipient.getText().toString().trim();
                String subject =  MessageSubject.getText().toString().trim();
                String messageContent =  MessageSend.getText().toString().trim();

                //data validation. check for empty values
                if(recipient.isEmpty()){
                    Recipient.setError("Recipient is required");
                    Recipient.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(recipient).matches()) {
                    Recipient.setError("Provide valid user email");
                    Recipient.requestFocus();
                    return;
                }
                if(subject.isEmpty()){
                    MessageSubject.setError("Subject is required");
                    MessageSubject.requestFocus();
                    return;
                }
                if(messageContent.isEmpty()){
                    MessageSend.setError("A message is required");
                    MessageSend.requestFocus();
                    return;
                }


                Message sMessage = new Message(recipient, subject, messageContent);

                //check for user existing
                //if recipient == name or email
                //allow
                //else
                //deny

                FirebaseDatabase.getInstance().getReference("Message")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(sMessage).addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(StaffMessageUser.this, "Message sent", Toast.LENGTH_SHORT).show();

                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(StaffMessageUser.this, "Message failed to send", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                finish(); //fill later
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

}