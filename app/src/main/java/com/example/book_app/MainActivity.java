package com.example.book_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.content.Intent;
import android.os.Bundle;

import com.example.book_app.Adapter.BookAdapter;
import com.example.book_app.Models.Datatypes;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding ;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    toolbar = findViewById(R.id.toolbar);
    drawerLayout=findViewById(R.id.drawlayout);
    navigationView=findViewById(R.id.navigation);
    binding.bottomNavigationView.setSelectedItemId(R.id.content);




    binding.bottomNavigationView.setOnItemSelectedListener(item -> {

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
                startActivity(new Intent(getApplicationContext(),MainProfile.class));
                overridePendingTransition(0,0);

                break;
        }
        return true;
    });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        ArrayList<Datatypes> list = new ArrayList<>();



         
        BookAdapter bd = new BookAdapter(list,this);
        binding.recyclerView.setAdapter(bd);
        binding.Rec2.setAdapter(bd);


//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        binding.recyclerView.setLayoutManager(linearLayoutManager);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,0);

        binding.recyclerView.setLayoutManager((staggeredGridLayoutManager));

        StaggeredGridLayoutManager staggy = new StaggeredGridLayoutManager(1,0);

        binding.Rec2.setLayoutManager((staggy));




//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
//        binding.recyclerView.setLayoutManager(gridLayoutManager);

        FirebaseDatabase.getInstance().getReference().child("books").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    Datatypes model = snapshot1.getValue(Datatypes.class);
                    list.add(model);
                   bd.notifyDataSetChanged();


                    
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }





}