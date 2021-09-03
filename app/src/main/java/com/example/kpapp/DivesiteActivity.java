package com.example.kpapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DivesiteActivity extends AppCompatActivity{
    private RecyclerView divesitelist;
    private DatabaseReference mdatabase;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divesite);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("divesite");
        mdatabase.keepSynced(true);
        mdatabase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {


            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult()));
                }
            }
        });
        Log.d("result",mdatabase.toString());
        divesitelist =(RecyclerView)findViewById(R.id.rycleview);
        divesitelist.setHasFixedSize(true);
        divesitelist.setLayoutManager(new LinearLayoutManager(this));
        firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<Divesitemodel,divesiteholder>
                (Divesitemodel.class,R.layout.divesitecyle,divesiteholder.class,mdatabase) {
            @Override
            protected void populateViewHolder(divesiteholder viewHolder, Divesitemodel model, int position) {
                viewHolder.setLabeltempat(model.getLabeltempat());
                viewHolder.setpictempat(getApplication(),model.getPictempat());
                viewHolder.setPin(getApplication(),model.getPin());
                viewHolder.setNamatempat(model.getNamatempat());
            }
        };
        divesitelist.setAdapter(firebaseRecyclerAdapter);
    }



    @Override
    protected void onStart() {
        super.onStart();

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

