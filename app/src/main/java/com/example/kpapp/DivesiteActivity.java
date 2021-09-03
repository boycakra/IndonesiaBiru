package com.example.kpapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DivesiteActivity extends AppCompatActivity{
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
        FirebaseRecyclerAdapter<Divesitemodel,divesiteholder>firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<Divesitemodel,divesiteholder>
                (Divesitemodel.class,R.layout.divesitecyle,divesiteholder.class,mdatabase) {
            @Override
            protected void populateViewHolder(divesiteholder viewHolder, Divesitemodel model, int position) {
                viewHolder.setLabeltempat(model.getLabeltempat());
                viewHolder.setpictempat(getApplication(),model.getPictempat());
                viewHolder.setPin(getApplication(),model.getPin());
                viewHolder.setNamatempat(model.getNamatempat());
            }
        };
    }
    public static class divesiteholder extends RecyclerView.ViewHolder
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

