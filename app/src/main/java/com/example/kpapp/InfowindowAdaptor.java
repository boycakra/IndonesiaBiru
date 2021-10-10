package com.example.kpapp;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InfowindowAdaptor implements GoogleMap.InfoWindowAdapter {
    Context context;

    public InfowindowAdaptor(Context context) {
        this.context= context;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View getInfoWindow(@NonNull @NotNull Marker marker) {
        View infview = LayoutInflater.from(context).inflate(R.layout.windowmaps,null);
        TextView title = infview.findViewById(R.id.titleinfowindow);
        ImageView image = infview.findViewById(R.id.infoWindowButton);
        title.setText(marker.getTitle());
        Picasso.get().load(marker.getSnippet()).into(image);
        return infview;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View getInfoContents(@NonNull @NotNull Marker marker) {
        return null;
    }
}
