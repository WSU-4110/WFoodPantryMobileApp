package com.example.csc4111project3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class StaffMenuPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffmenu_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.menu_page_drawer_layout_staff);
        navigationView = (NavigationView) findViewById(R.id.nav_view_staff);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            // sets the about page to be the first page to appear upon signing in
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_staff,
                    new StaffCheckOrders()).commit();
            navigationView.setCheckedItem(R.id.nav_check_orders);
        }

        //this code will handle clicking on the items in the navMenu
    }


    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_check_orders: // if "check orders" is clicked
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_staff,
                        new StaffCheckOrders()).commit();
                break;
            case R.id.nav_message_user: // if "message user" is clicked
                Intent i = new Intent(this,StaffMessageUser.class);
                this.startActivity(i); //starts the activity using the intent
                break;
            case R.id.nav_push_update: // if "push update" is clicked
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_staff,
                        new StaffPushUpdate()).commit();
                break;
            case R.id.nav_update_menu:
                Intent j = new Intent(this, StaffUpdateFoodMenu.class);
                this.startActivity(j);
                break;
            case R.id.nav_view_applications: // if "view applications" is clicked
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_staff,
                        new StaffViewApplications()).commit();
                break;
            case R.id.nav_log_off:
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}//end StaffMenuPage class