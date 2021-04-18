package com.example.csc4111project3;


import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import java.lang.*;

public class FormOIProcessing extends AppCompatActivity implements AdapterView.OnItemSelectedListener{ //This is the class that will be handling the food selection portion of the user submission form

    //---------
    //VARIABLES
    //---------
    //Creates the spinner objects, as well as the arrays with the food item selections, and a submit button
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Button submit;
    private Button cancel;
    private static ArrayList<String> protein = new ArrayList<String>();
    private static ArrayList<String> vegetables = new ArrayList<String>();
    private static ArrayList<String> fruits = new ArrayList<String>();
    public static String orderUFirst;
    public static String orderULast;
    public static String orderUEmail;
    public static String orderProtein;
    public static String orderVeggie;
    public static String orderFruit;
    public static String orderDate;
    private static String orderInProgress = "In progress";


    //-------------------------------------------------------------
    //onCreate Override to establish the code upon entering the page
    //-------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //captures the instance of the application
        setContentView(R.layout.activity_order_form); //sets the content view to the order form
        submit = (Button) findViewById(R.id.submitButton);
        cancel = (Button) findViewById(R.id.cancelButton);
        spinner1 = (Spinner) findViewById(R.id.spinner1); //ties spinner to protein spinner within activity_order_form.xml
        spinner2 = (Spinner) findViewById(R.id.spinner2); //ties spinner to vegetable spinner within activity_order_form.xml
        spinner3 = (Spinner) findViewById(R.id.spinner3); //ties spinner to fruit spinner within activity_order_form.xml

        //The below code creates ArrayAdaptors to the respective spinners, linking the contents of the ingredient arrays to the dropdown list items
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(FormOIProcessing.this,
                android.R.layout.simple_spinner_dropdown_item, protein);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(FormOIProcessing.this,
                android.R.layout.simple_spinner_dropdown_item, vegetables);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(FormOIProcessing.this,
                android.R.layout.simple_spinner_dropdown_item, fruits);

        //The below code simply links an android menu resource to each adapter, as to give them a layout
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        //-----------------------------------------------------------------------------------------------------------------------------------
        // Protein Spinner Setup: Includes the following:
        // - adapter setting
        // - dynamic database accessors to retrieve the food items from Firebase for dynamic menu
        // - item listener to store selected food for order
        //-----------------------------------------------------------------------------------------------------------------------------------
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        Query databasePro = FirebaseDatabase.getInstance().getReference("Menu").orderByChild("foodType").equalTo("Protein");
        databasePro.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
                protein.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Food food = snapshot.getValue(Food.class);
                    String foodName = food.getFood();
                    protein.add(foodName);
                }
                adapter1.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                orderProtein = spinner1.getSelectedItem().toString();
                String tester = "The item selected is: " + orderProtein;
                Toast.makeText(FormOIProcessing.this, tester, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                orderProtein = "None";

            }
        });
        //-----------------------------------------------------------------------------------------------------------------------------------
        // END OF PROTEIN SPINNER SETUP
        //-----------------------------------------------------------------------------------------------------------------------------------



        //-----------------------------------------------------------------------------------------------------------------------------------
        // Vegetable Spinner Setup: Includes the following:
        // - adapter setting
        // - dynamic database accessors to retrieve the food items from Firebase for dynamic menu
        // - item listener to store selected food for order
        //-----------------------------------------------------------------------------------------------------------------------------------
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Query databaseVeg = FirebaseDatabase.getInstance().getReference("Menu").orderByChild("foodType").equalTo("Vegetable");
        databaseVeg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
                vegetables.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Food food = snapshot.getValue(Food.class);
                    String foodName = food.getFood();
                    vegetables.add(foodName);
                }
                adapter2.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                orderVeggie = spinner2.getSelectedItem().toString();
                String tester = "The item selected is: " + orderVeggie;
                Toast.makeText(FormOIProcessing.this, tester, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                orderVeggie = "None";
            }
        });
        //-----------------------------------------------------------------------------------------------------------------------------------
        // END OF VEGETABLE SPINNER SETUP
        //-----------------------------------------------------------------------------------------------------------------------------------


        //-----------------------------------------------------------------------------------------------------------------------------------
        // Fruit Spinner Setup: Includes the following:
        // - adapter setting
        // - dynamic database accessors to retrieve the food items from Firebase for dynamic menu
        // - item listener to store selected food for order
        //-----------------------------------------------------------------------------------------------------------------------------------
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        Query databaseFru = FirebaseDatabase.getInstance().getReference("Menu").orderByChild("foodType").equalTo("Fruit");
        databaseFru.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
                fruits.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Food food = snapshot.getValue(Food.class);
                    String foodName = food.getFood();
                    fruits.add(foodName);
                }
                adapter3.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                orderFruit = spinner3.getSelectedItem().toString();
                String tester = "The item selected is: " + orderFruit;
                Toast.makeText(FormOIProcessing.this, tester, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                orderFruit = "None";

            }
        });
        //-----------------------------------------------------------------------------------------------------------------------------------
        // END OF FRUIT SPINNER SETUP
        //-----------------------------------------------------------------------------------------------------------------------------------



        //Sets a listener override for the submit button, telling the button press where to go
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    String email = user.getEmail();
                    orderUEmail = email;
                }

                Query databaseUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("email").equalTo(orderUEmail);
                databaseUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            User user = snapshot.getValue(User.class);
                            orderUFirst = user.getFirstName();
                            orderULast = user.getLastName();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
                orderDate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                Orders item = new Orders(orderUEmail, orderProtein, orderVeggie, orderFruit, orderDate, orderInProgress);
                FirebaseDatabase.getInstance().getReference("Orders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(item).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(FormOIProcessing.this, "The order was completed successfully!", Toast.LENGTH_SHORT).show();

                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(FormOIProcessing.this, "The order has failed. Please contact W Pantry at 1-XXX-XXX-XXXX for assistance ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                finish();
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(FormOIProcessing.this);
                builder1.setMessage("Are you sure you would like to cancel? The info placed for the order will not be saved, and you will be returned to the home page!");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                finish();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    //-------------------------------------------------------------------------------------
    //onNothingSelected Override to make sure the adaptor at least handles nothing selected
    //-------------------------------------------------------------------------------------
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


}

