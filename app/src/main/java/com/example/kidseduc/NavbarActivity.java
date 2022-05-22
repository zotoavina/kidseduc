package com.example.kidseduc;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;


import com.example.kidseduc.views.MenuActivity;
import com.example.kidseduc.views.SettingsFragment;

import java.io.Serializable;

public class NavbarActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);
        Serializable page = getIntent().getSerializableExtra("destination");
        if(page == null){
            //loading the default fragment
            loadFragment(new MenuActivity());
        }
        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    private void loadFragmentByDestination( Serializable page){

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_navbar, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    private boolean loadFragment( PreferenceFragment fragment) {
        //switching fragment
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_navbar, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        PreferenceFragment fr = null;
        boolean res = false;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new MenuActivity();
                res = loadFragment(fragment);
                break;

            case R.id.navigation_profil:
                fragment = new ProfilFragment();
                res = loadFragment(fragment);
                break;

            case R.id.navigation_settings:
                fr = new SettingsFragment();
                res = loadFragment(fr);
                break;
        }
        return  res;
    }
}