package com.example.kpapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        ImageView imageView1 = (ImageView) findViewById(R.id.text1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, Menu.class);
                startActivity(intent);
            }
        });
        ImageView imageview2 = (ImageView) findViewById(R.id.text2);
        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, DivesiteActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.text3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
