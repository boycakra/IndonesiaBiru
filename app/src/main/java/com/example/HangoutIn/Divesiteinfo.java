package com.example.HangoutIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Divesiteinfo extends AppCompatActivity {
    String longtitude;
    String latitude;
    String tempat;
    String gambardivesite;
    SliderView sliderView;
    int[] images = {R.drawable.kura,
            R.drawable.dive1,
            R.drawable.ikan,
            R.drawable.karang,
            R.drawable.ikan1,
            R.drawable.karang1};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangoutinfo);
        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        tempat= getIntent().getStringExtra("Divesitenamatempat");
        String labeltempat= getIntent().getStringExtra("Divesitelabel");
        gambardivesite= getIntent().getStringExtra("Gambardivesite");
        String Deskripsi= getIntent().getStringExtra("Deskripsi");
        longtitude = getIntent().getStringExtra("longtitude");
        latitude = getIntent().getStringExtra("latitude");

//        ImageView post_pictempat=(ImageView)findViewById(R.id.gambardivesite);
//        Picasso.get().load(gambardivesite).into(post_pictempat);

        TextView post_labeltempat=(TextView)findViewById(R.id.textinfo);
        post_labeltempat.setText(labeltempat);

        TextView post_namatempat=(TextView)findViewById(R.id.diveinfo);
        post_namatempat.setText(tempat);

        TextView post_deskripsi=(TextView)findViewById(R.id.deskripsi);
        post_deskripsi.setText(Deskripsi);

        CardView mapsite = (CardView) findViewById(R.id.map_location);
        mapsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Eachdivesite.class);
                intent.putExtra("longtitude",longtitude);
                intent.putExtra("latitude",latitude);
                intent.putExtra("Divesitenamatempat",tempat);
                intent.putExtra("Gambardivesite",gambardivesite);
                v.getContext().startActivity(intent);
            }
        });


    }

}
