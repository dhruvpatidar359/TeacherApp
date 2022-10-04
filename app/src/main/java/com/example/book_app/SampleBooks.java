package com.example.book_app;
// not the part of project only for the pdf
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import xute.storyview.StoryModel;
import xute.storyview.StoryView;

public class SampleBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_books);

        StoryView storyView = findViewById(R.id.storyView);
        storyView.resetStoryVisits();
        ArrayList<StoryModel> uris = new ArrayList<>();
        uris.add(new StoryModel("https://www.planwallpaper.com/static/images/animals-4.jpg","Steve","Yesterday"));
        uris.add(new StoryModel("https://static.boredpanda.com/blog/wp-content/uuuploads/albino-animals/albino-animals-3.jpg","Grambon","10:15 PM"));
        storyView.setImageUris(uris);

    }
}