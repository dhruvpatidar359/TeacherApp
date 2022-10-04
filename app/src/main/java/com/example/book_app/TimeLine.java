package com.example.book_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TimeLine extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstudent);
    bottomNavigationView =findViewById(R.id.bottomNavigationView);
    bottomNavigationView.setSelectedItemId(R.id.student);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.student:
                    break;

                case R.id.content:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(0,0);
                    break;


                case R.id.profile:
                    startActivity(new Intent(getApplicationContext(),MainProfile.class));
                    overridePendingTransition(0,0);
                    break;
            }
            return true;
        });



    }
}