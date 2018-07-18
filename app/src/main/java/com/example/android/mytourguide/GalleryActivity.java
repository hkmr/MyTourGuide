package com.example.android.mytourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

public class GalleryActivity extends AppCompatActivity {

    Place currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        currentPlace = (Place) getIntent().getSerializableExtra("placeObj");

        Place currentPlace = (Place) getIntent().getSerializableExtra("placeObj");
        setTitle(currentPlace.getmName());

        GridView gallery = (GridView) findViewById(R.id.images_gallery);
        gallery.setAdapter(new ImageAdapter(this));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            Intent intent = new Intent(GalleryActivity.this,PlaceDetailActivity.class);
            intent.putExtra("placeObj", currentPlace);
            startActivity(intent);
            return true;
        }
        return false;

    }
}
