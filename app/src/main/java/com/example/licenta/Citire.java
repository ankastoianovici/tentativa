package com.example.licenta;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Citire extends AppCompatActivity {
    BottomNavigationView nav;
    @Override
    @Nullable
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        nav=findViewById(R.id.nav);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ServerDetails:
                        openRuntimeDevelopment();
                        break;
                   /* case R.id.Browse:
                        openRuntimeDevelopment();
                        break;
                    case R.id.DataAccess:
                        openRuntimeDevelopment();
                        break;
                    case R.id.AlarmsEvents:
                        openRuntimeDevelopment();
                        break;*/
                    case R.id.Runtime:
                        replaceFragment(new develop());
                        break;
                    case R.id.Deploy:
                        replaceFragment(new Deploy());
                        break;
                }
                return false;
            }
        });
    }
    private void openRuntimeDevelopment() {
        Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent4);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }
}
