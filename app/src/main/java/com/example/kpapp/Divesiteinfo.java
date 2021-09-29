package com.example.kpapp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Divesiteinfo extends AppCompatActivity {
    String longtitude;
    String latitude;
    String tempat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divesiteinfo);
        tempat= getIntent().getStringExtra("Divesitenamatempat");
        String labeltempat= getIntent().getStringExtra("Divesitelabel");
        String Gambardivesite= getIntent().getStringExtra("Gambardivesite");
        String Deskripsi= getIntent().getStringExtra("Deskripsi");
        longtitude = getIntent().getStringExtra("longtitude");
        latitude = getIntent().getStringExtra("latitude");

        ImageView post_pictempat=(ImageView)findViewById(R.id.gambardivesite);
        Picasso.get().load(Gambardivesite).into(post_pictempat);

        TextView post_labeltempat=(TextView)findViewById(R.id.textinfo);
        post_labeltempat.setText(labeltempat);

        TextView post_namatempat=(TextView)findViewById(R.id.diveinfo);
        post_namatempat.setText(tempat);

        TextView post_deskripsi=(TextView)findViewById(R.id.deskripsi);
        post_deskripsi.setText(Deskripsi);

        ImageView mapsite = (ImageView) findViewById(R.id.map_location);
        mapsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Eachdivesite.class);
                intent.putExtra("longtitude",longtitude);
                intent.putExtra("latitude",latitude);
                intent.putExtra("Divesitenamatempat",tempat);
                v.getContext().startActivity(intent);
            }
        });


    }

}
