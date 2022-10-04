package com.example.book_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainProfile extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        bottomNavigationView =findViewById(R.id.bottomNavigationView);
    bottomNavigationView.setSelectedItemId(R.id.profile);
    bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.student:
                    startActivity(new Intent(getApplicationContext(), TimeLine.class));
                    overridePendingTransition(0,0);

                    break;

                case R.id.content:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(0,0);
                    break;


                case R.id.profile:
//                    startActivity(new Intent(getApplicationContext(),MainProfile.class));
//                    overridePendingTransition(0,0);
                    break;
            }
            return true;
        });





            LinearLayout personalinfo, experience, review;
            TextView personalinfobtn, experiencebtn, reviewbtn;

                personalinfo = findViewById(R.id.personalinfo);
                experience = findViewById(R.id.experience);
                review = findViewById(R.id.review);
                personalinfobtn = findViewById(R.id.personalinfobtn);
                experiencebtn = findViewById(R.id.experiencebtn);
                reviewbtn = findViewById(R.id.reviewbtn);
                /*making personal info visible*/
                personalinfo.setVisibility(View.VISIBLE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.GONE);


                personalinfobtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        personalinfo.setVisibility(View.VISIBLE);
                        experience.setVisibility(View.GONE);
                        review.setVisibility(View.GONE);
                        personalinfobtn.setTextColor(getResources().getColor(R.color.blue));
                        experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                        reviewbtn.setTextColor(getResources().getColor(R.color.grey));

                    }
                });

                experiencebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        personalinfo.setVisibility(View.GONE);
                        experience.setVisibility(View.VISIBLE);
                        review.setVisibility(View.GONE);
                        personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                        experiencebtn.setTextColor(getResources().getColor(R.color.blue));
                        reviewbtn.setTextColor(getResources().getColor(R.color.grey));

                    }
                });

                reviewbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        personalinfo.setVisibility(View.GONE);
                        experience.setVisibility(View.GONE);
                        review.setVisibility(View.VISIBLE);
                        personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                        experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                        reviewbtn.setTextColor(getResources().getColor(R.color.blue));

                    }
                });
            }
        }





