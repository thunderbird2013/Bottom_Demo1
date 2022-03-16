package com.example.bottom_demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new Home());
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        Objects.requireNonNull(getSupportActionBar()).hide();
        bottomNavigationView.setOnItemSelectedListener(this);

    }

public boolean loadFragment(Fragment fragment)
{
    if(fragment!=null)
    {
         getSupportFragmentManager().beginTransaction()
                 .replace(R.id.parent_container, fragment)
                 .commit();
    }

    return true;
}



    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId())
        {
            case R.id.homeId:
                fragment = new Home();
                break;

            case R.id.bookId:
                fragment = new Test();
                break;
        }


        return loadFragment(fragment);
    }
}