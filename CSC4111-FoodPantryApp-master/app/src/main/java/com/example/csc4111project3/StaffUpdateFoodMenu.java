package com.example.csc4111project3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class StaffUpdateFoodMenu extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        EditText Food_Name = (EditText) findViewById(R.id.Food_Name);
        EditText Food_Type = (EditText) findViewById(R.id.Food_Type);
        EditText Quantity = (EditText) findViewById(R.id.Quantity);
        Button Update_Food_Menu = (Button) findViewById(R.id.Update_Food_Menu);
        FirebaseAuth auth = FirebaseAuth.getInstance();

        Update_Food_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn = Food_Name.getText().toString().trim();
                String ft = Food_Type.getText().toString().trim();
                int q = Integer.parseInt(Quantity.getText().toString().trim());

                if(fn.isEmpty()) {
                    Food_Name.setError("Food name is required");
                    Food_Name.requestFocus();
                    return;
                }
                if(ft.isEmpty()) {
                    Food_Type.setError("Food type is required");
                    Food_Type.requestFocus();
                    return;
                }

                PantryMenu item = new PantryMenu(fn, ft, q);

                FirebaseDatabase.getInstance().getReference("Menu")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(item).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(StaffUpdateFoodMenu.this, "Food item added successfully", Toast.LENGTH_SHORT).show();

                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(StaffUpdateFoodMenu.this, "Pantry update failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
