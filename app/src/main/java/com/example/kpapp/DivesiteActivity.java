package com.example.kpapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Divesite  extends AppCompatActivity{
    private RecyclerView divesitelist;
    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divesite);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("divesite");
        mdatabase.keepSynced(true);
        divesitelist =(RecyclerView)findViewById(R.id.rycleview);
        divesitelist.setHasFixedSize(true);
        divesitelist.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<divesiteadapter,divesiteholder>firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<divesiteadapter,divesiteholder>
                () {
            @Override
            protected void populateViewHolder(divesiteholder viewHolder, divesiteadapter model, int position) {
                viewHolder.setLabeltempat(model.getLabeltempat());
                viewHolder.setpictempat(getApplication(),model.getPictempat());
                viewHolder.setPin(getApplication(),model.getPin());
                viewHolder.setNamatempat(model.getNamatempat());
            }
        };
    }
    public static class divesiteholder extends android.support.v7.widget.RecyclerView.ViewHolder
    {
        View mView;
        public divesiteholder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setpictempat(Application ctx,String pictempat){
            ImageView post_pictempat=(ImageView) mView.findViewById(R.id.mainpic);
            Picasso.get().load(pictempat).into(post_pictempat);

        }
        public void setLabeltempat (String labeltempat){
            TextView post_labeltempat=(TextView)mView.findViewById(R.id.tempatlbl);
            post_labeltempat.setText(labeltempat);
        }
        public void setPin(Application application, String pin){
            ImageView post_pin=(ImageView) mView.findViewById(R.id.pin);
            Picasso.get().load(pin).into(post_pin);
        }
        public void setNamatempat(String namatempat){
            TextView post_namatempat=(TextView) mView.findViewById(R.id.tempatsite);
            post_namatempat.setText(namatempat);
        }
    }
}

