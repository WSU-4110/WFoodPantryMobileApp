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

public class MenuPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private MenuItem navContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.menu_page_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            // sets the about page to be the first page to appear upon signing in
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AboutPage()).commit();
            navigationView.setCheckedItem(R.id.nav_about);
        }

        //this code will handle clicking on the items in the navMenu

    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        /*int id = item.getItemId();

        if (id == R.id.nav_contact) {
            Intent intent = new Intent(MenuPage.this, ContactPage.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.nav_about) {
            return true;
        }
        else if (id == R.id.nav_check_orders) {
            return true;
        }

        return false;*/

        switch (item.getItemId()){
            case R.id.nav_about: // if "about" is clicked
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutPage()).commit();
                break;
            case R.id.nav_contact: // if "contact" is clicked
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactPage()).commit();
                break;
            case R.id.nav_order: // if "order" is clicked
                Intent i = new Intent(this,FormPIProcessing.class); //creates a new intent to send the user to the order form page "activity_info_form.xml"
                this.startActivity(i); //starts the activity using the intent
                break;
            case R.id.nav_log_off:
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}//end of MenuPage Class