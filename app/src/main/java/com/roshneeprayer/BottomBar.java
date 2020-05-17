package com.roshneeprayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BottomBar extends AppCompatActivity {
  DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    public void onBackPressed() {
         if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                 drawerLayout.closeDrawer(GravityCompat.START);
         }
         else {
             super.onBackPressed();
         }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navview);

          getSupportActionBar().setHomeButtonEnabled(true);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_bar);
         bottomNavigationView=findViewById(R.id.bottom_navigation_bar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new home()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new home();
                        break;
                    case R.id.nav_setting:
                        selectedFragment = new settings();
                        break;
                    case R.id.nav_qibla:
                        selectedFragment = new masjid();
                        break;
                    case R.id.nav_prayers:
                        selectedFragment = new masjid();
                        break;
                    case R.id.nav_news:
                        selectedFragment = new news();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
        //actionBar.setIcon(R.drawable.ic_bell_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bottomactionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bell:
                Intent intent=new Intent(getApplicationContext(),Notifications.class);
                startActivity(intent);
                break;
            case R.id.like:
                Intent intentliked=new Intent(getApplicationContext(),LikedMosque.class);
                startActivity(intentliked);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return  true;
    }
}
