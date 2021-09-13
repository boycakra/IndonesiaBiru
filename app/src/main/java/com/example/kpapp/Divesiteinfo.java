package com.example.kpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        ImageView imageView1 = (ImageView) findViewById(R.id.text1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Divesiteinfo.this, Menu.class);
                startActivity(intent);
            }
        });
        ImageView imageview2 = (ImageView) findViewById(R.id.logo);
        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Divesiteinfo.this, About.class);
                startActivity(intent);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.text3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Divesiteinfo.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView4 =(ImageView) findViewById(R.id.text2);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Divesiteinfo.this,DivesiteActivity.class);
                startActivity(intent);
            }
        });
    }

}
