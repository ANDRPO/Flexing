package com.example.xtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xtest.MarkerInfo;
import com.example.xtest.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

public class Marker_adapter implements GoogleMap.InfoWindowAdapter {

    private MarkerInfo markerInfo;
    private int listId;
    private Context context;

    public Marker_adapter(MarkerInfo markerInfo, int listId, Context context) {
        this.markerInfo = markerInfo;
        this.listId = listId;
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }


    @Override
    public View getInfoContents(Marker marker) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(listId, null);

//        ImageView image = v.findViewById(R.id.image_marker);
//        TextView title = v.findViewById(R.id.title_marker);
//        TextView description = v.findViewById(R.id.description_marker);
//
//        Picasso.get()
//                .load(markerInfo.getImage())
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .into((ImageView) v.findViewById(R.id.image_marker));
//        title.setText(markerInfo.getTitle());
//        description.setText(markerInfo.getDescription());

        return v;
    }
}
