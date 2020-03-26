package com.gridev.androidappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Fragment

        homeFragment = new HomeFragment();
        homeFragment.setOnCalculateClickListener(new HomeFragment.OnCalculateClickListener() {
            @Override
            public void onClick() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainContainer, new CalculateWeightFragment())
                        .commit();
            }
        });

        homeFragment.setOnResultClickListener(new HomeFragment.OnResultClickListener(){
            @Override
            public void onClick() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainContainer, new ResultListFragment())
                        .commit();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainContainer, homeFragment)
                .commit();

    }
}
