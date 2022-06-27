package com.example.HangoutIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DivesiteActivity extends AppCompatActivity{
    private RecyclerView divesitelist;
    private DatabaseReference mdatabase;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangoutlist);
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
                (Divesitemodel.class,R.layout.hangoutcycle,divesiteholder.class,mdatabase) {
            @Override
            protected void populateViewHolder(divesiteholder viewHolder, Divesitemodel model, int position) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), Divesiteinfo.class);

                        intent.putExtra("kapasitas",model.getKapasitas());
                        intent.putExtra("Divesitelabel",model.getLabeltempat());
                        intent.putExtra("Divesitenamatempat",model.getNamatempat());
                        intent.putExtra("Gambardivesite",model.getPictempat());
                        intent.putExtra("Deskripsi",model.getDeskripsi());
                        intent.putExtra("longtitude",model.getLongtitude().toString());
                        intent.putExtra("latitude",model.getLatitude().toString());

                        //Toast.makeText(v.getContext(),model.getLongtitude().toString(),Toast.LENGTH_LONG).show();
                        v.getContext().startActivity(intent);

                    }
                });

                viewHolder.setkapasitas(model.getKapasitas());
                viewHolder.setLabeltempat(model.getLabeltempat());
                viewHolder.setpictempat(getApplication(),model.getPictempat());
                viewHolder.setPin(getApplication(),model.getPin());
                viewHolder.setNamatempat(model.getNamatempat());
                viewHolder.setdeskripsi(model.getDeskripsi());
                viewHolder.setLongtitude(model.getLongtitude());
                viewHolder.setLatitude(model.getLatitude());
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

        public  void setkapasitas(String kapasitas){
            TextView post_kapasitas=(TextView) mView.findViewById(R.id.kapasitas);
            post_kapasitas.setText((kapasitas));
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
        public  void setdeskripsi(String deskripsi){
            TextView post_deskripsi=(TextView) mView.findViewById(R.id.deskripsidivesite);
            post_deskripsi.setText((deskripsi));
        }
        public  void setLongtitude(Double longtitude){
            TextView post_longtitude=(TextView)mView.findViewById(R.id.longdivesite);
            post_longtitude.setText(Double.toString(longtitude));
        }
        public  void setLatitude(Double latitude){
            TextView post_latitude=(TextView)mView.findViewById(R.id.latdivesite);
            post_latitude.setText(Double.toString((latitude)));
        }
    }
}

