package com.example.android.mytourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        final Object currentObj = getIntent().getSerializableExtra("placeObj");

        if(currentObj.getClass() == Place.class ) {

            final Place currentPlace = (Place) currentObj;

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
            int[] imgArray = {R.drawable.aga_khan_palace, R.drawable.shinde_chhatri, R.drawable.shaniwar_wada_palace,
                    R.drawable.pashan_lake, R.drawable.parvati_hill_temple};
            LinearLayout imageList =  findViewById(R.id.image_list);
            for (int i = 0; i < 5; i++) {
                ImageView img = new ImageView(this);
                img.setImageResource(imgArray[i]);
                img.setPadding(10, 10, 10, 10);

                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(PlaceDetailActivity.this, GalleryActivity.class);
                        i.putExtra("placeObj", currentPlace);
                        startActivity(i);
                    }
                });

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        150, 150);

                imageList.addView(img, layoutParams);
            }


            TextView placeNameView =  findViewById(R.id.detail_place_name);
            placeNameView.setText(placeName);

            TextView placeAddressView =  findViewById(R.id.detail_place_address);
            placeAddressView.setText(placeAddress);
            placeAddressView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + locationUri);
                    Intent map = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(map);
                }
            });

            TextView placeInfoView =  findViewById(R.id.detail_place_info);
            placeInfoView.setText(placeInfo);

            ImageView placeImageView =  findViewById(R.id.detail_place_image);
            placeImageView.setImageResource(placeImageId);

            TextView phoneView =  findViewById(R.id.detail_place_phone);
            phoneView.setText(phone);

            TextView hoursView =  findViewById(R.id.detail_place_working_hours);
            hoursView.setText(hours);

            TextView websiteView =  findViewById(R.id.detail_place_website);
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

        else if( currentObj.getClass() == Food.class){

            final Food currentFood = (Food) currentObj;

            placeName = currentFood.getName();
            placeAddress = currentFood.getLocation();
            locationUri = currentFood.getLocation();


            HorizontalScrollView horizontalScrollView = findViewById(R.id.image_list_horizontal_scroll);
            horizontalScrollView.setVisibility(View.GONE);

            TextView phoneLbl = findViewById(R.id.phone_label);
            phoneLbl.setVisibility(View.GONE);

            TextView hoursLbl = findViewById(R.id.hours_label);
            hoursLbl.setVisibility(View.GONE);

            TextView placeNameView = findViewById(R.id.detail_place_name);
            placeNameView.setText(currentFood.getName());

            TextView locationView = findViewById(R.id.detail_place_address);
            locationView.setText(currentFood.getLocation());

            TextView websiteView = findViewById(R.id.detail_place_website);
            websiteView.setText(currentFood.getWebsite());

            TextView infoView = findViewById(R.id.detail_place_info);
            infoView.setText(currentFood.getInfo());

            ImageView imageView = findViewById(R.id.detail_place_image);
            imageView.setImageResource(currentFood.getImgId());


        }


    }
}
