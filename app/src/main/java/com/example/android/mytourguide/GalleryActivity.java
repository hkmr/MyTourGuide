package com.example.android.mytourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Place currentPlace = (Place) getIntent().getSerializableExtra("placeObj");
        setTitle(currentPlace.getmName());

        GridView gallery = (GridView) findViewById(R.id.images_gallery);
        gallery.setAdapter(new ImageAdapter(this));

    }
}
