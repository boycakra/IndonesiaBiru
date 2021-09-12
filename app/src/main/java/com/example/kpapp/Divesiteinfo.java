package com.example.kpapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Divesiteinfo extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divesiteinfo);
        String tempat= getIntent().getStringExtra("Divesitenamatempat");
        String labeltempat= getIntent().getStringExtra("Divesitelabel");
        String Gambardivesite= getIntent().getStringExtra("Gambardivesite");

        ImageView post_pictempat=(ImageView)findViewById(R.id.gambardivesite);
        Picasso.get().load(Gambardivesite).into(post_pictempat);

        TextView post_labeltempat=(TextView)findViewById(R.id.textinfo);
        post_labeltempat.setText(labeltempat);

        TextView post_namatempat=(TextView)findViewById(R.id.diveinfo);
        post_namatempat.setText(tempat);

    }
}
