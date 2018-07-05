package com.example.android.mytourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaceDetailActivity extends AppCompatActivity {

    private String placeName;
    private String placeInfo;
    private String placeAddress;
    private int placeImageId;
    private String hours;
    private String website;
    private String locationUri;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        final Place currentPlace = (Place) getIntent().getSerializableExtra("placeObj");

        placeName = currentPlace.getmName();
        placeAddress = currentPlace.getmLocation();
        placeInfo = currentPlace.getmInfo();
        placeImageId = currentPlace.getmImageId();
        hours = currentPlace.getmWorkingHours();
        website = currentPlace.getmWebsite();
        locationUri = currentPlace.getmLocationUri();
        phone = currentPlace.getmPhoneNo();

        setTitle(placeName);

//        Images List
        int[] imgArray = {R.drawable.aga_khan_palace,R.drawable.shinde_chhatri,R.drawable.shaniwar_wada_palace,
                            R.drawable.pashan_lake,R.drawable.parvati_hill_temple};
        LinearLayout imageList = (LinearLayout) findViewById(R.id.image_list);
        for(int i=0; i<5; i++){
            ImageView img = new ImageView(this);
            img.setImageResource(imgArray[i]);
            img.setPadding(10,10,10,10);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(PlaceDetailActivity.this,GalleryActivity.class);
                    i.putExtra("placeObj",currentPlace);
                    startActivity(i);
                }
            });

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    150,150);

            imageList.addView(img, layoutParams);
        }


        TextView placeNameView = (TextView) findViewById(R.id.detail_place_name);
        placeNameView.setText(placeName);

        TextView placeAddressView = (TextView) findViewById(R.id.detail_place_address);
        placeAddressView.setText(placeAddress);
        placeAddressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+locationUri);
                Intent map = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(map);
            }
        });

        TextView placeInfoView = (TextView) findViewById(R.id.detail_place_info);
        placeInfoView.setText(placeInfo);

        ImageView placeImageView = (ImageView) findViewById(R.id.detail_place_image);
        placeImageView.setImageResource(placeImageId);

        TextView phoneView = (TextView) findViewById(R.id.detail_place_phone);
        phoneView.setText(phone);

        TextView hoursView = (TextView) findViewById(R.id.detail_place_working_hours);
        hoursView.setText(hours);

        TextView websiteView = (TextView) findViewById(R.id.detail_place_website);
        websiteView.setText(website);
        websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse(website));
                startActivity(url);
            }
        });

    }
}
