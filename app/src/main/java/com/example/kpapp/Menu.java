package com.example.kpapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.appcompat.app.AppCompatActivity;
public class Menu extends AppCompatActivity {
    SliderView sliderView;
    int[] images = {R.drawable.kura,
            R.drawable.dive1,
            R.drawable.ikan,
            R.drawable.karang,
            R.drawable.ikan1,
            R.drawable.karang1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        ImageView imageView1 = (ImageView) findViewById(R.id.text2);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, DivesiteActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageview2 = (ImageView) findViewById(R.id.logo);
        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, About.class);
                startActivity(intent);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.text3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
