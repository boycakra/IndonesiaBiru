package com.example.HangoutIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);


//        ImageView joinnow = (ImageView)findViewById(R.id.joinbutton);
//        joinnow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("https://indonesia-biru.com/join-us/"));
//                startActivity(intent);
//            }
//        });

        CardView imageView1 = (CardView) findViewById(R.id.text2);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, DivesiteActivity.class);
                startActivity(intent);
            }
        });
        CardView imageview2 = (CardView) findViewById(R.id.logo);
        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, About.class);
                startActivity(intent);
            }
        });
        CardView imageView3 = (CardView) findViewById(R.id.text3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
