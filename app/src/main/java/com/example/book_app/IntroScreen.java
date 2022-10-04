package com.example.book_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class IntroScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);


;



        Intent intent =new Intent(this,MainActivity.class);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (Exception exception) {
                    exception.printStackTrace();

                }
                finally {

                    startActivity(intent);

                    finish();
                }
            }
        };thread.start();

    }
}