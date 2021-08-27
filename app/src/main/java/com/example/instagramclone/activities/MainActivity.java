package com.example.instagramclone.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.instagramclone.R;
import com.example.instagramclone.fragments.HomeFragment;
import com.example.instagramclone.fragments.NotificationFragment;
import com.example.instagramclone.fragments.ProfileFragment;
import com.example.instagramclone.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.nav_search:
                        fragment = new SearchFragment();
                        break;

                    case R.id.nav_add:
                        //setting fragment as null because it will be using an Activity
                        fragment = null;
                        Intent intent = new Intent(MainActivity.this, PostActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_heart:
                        fragment = new NotificationFragment();
                        break;

                    case R.id.nav_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                displayFragment();
                return false;
            }
        });

    }

    // displays the  fragment within the layout container by performing a 'FragmentTransaction'
   private void displayFragment(){
        //checking if the fragment is not null to prevent the app from
       // crashing when 'nav_add'(icon) is clicked
       //because the 'nav_add'(icon) won't be using a fragment..
       //'nav_add'(icon) will be using an Activity.
       if (fragment != null){
           FragmentManager fragmentManager = getSupportFragmentManager();
           fragmentManager.beginTransaction()
                   .replace(R.id.fragment_container, fragment, null)
                   .setReorderingAllowed(true)
                   .addToBackStack(null)
                   .commit();
       }       }

}