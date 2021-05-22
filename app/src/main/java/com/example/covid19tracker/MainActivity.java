package com.example.covid19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.covid19tracker.fragments.AboutFragment;
import com.example.covid19tracker.fragments.CountryFragment;
import com.example.covid19tracker.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                Fragment temp =null;

                switch (menuItem.getItemId())
                {
                    case R.id.home_btn : temp = new HomeFragment();
                        break;
                    case R.id.country_btn : temp = new CountryFragment();
                        break;
                    case R.id.about_btn : temp = new AboutFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,temp).commit();
                return true;
            }
        });
    }
}
