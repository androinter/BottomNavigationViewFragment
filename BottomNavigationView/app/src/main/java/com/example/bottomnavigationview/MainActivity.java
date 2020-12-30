package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Camera");
        getFragment(new Camera());

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.cameraid){
                    getSupportActionBar().setTitle("Camera");
                    getFragment(new Camera());
                } else if (menuItem.getItemId() == R.id.shareid){
                    getSupportActionBar().setTitle("Share");
                    getFragment(new Share());
                } else if (menuItem.getItemId() == R.id.search){
                    getSupportActionBar().setTitle("Search");
                    getFragment(new Search());
                }
                return true;
            }
        });
    }

    private void getFragment(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.container,fragment);
        fragmentTransaction.commit();
    }
}
