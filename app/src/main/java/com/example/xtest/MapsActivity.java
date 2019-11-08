package com.example.xtest;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xtest.adapters.Marker_adapter;
import com.example.xtest.generic.GenMaps.Generic;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private Button search, ZaPivasom;
    Marker IMmarker, Tap;
    LatLng MyPos, Pivopos;
    Polyline polyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        search = findViewById(R.id.b_maps_positioning);
        ZaPivasom = findViewById(R.id.marshrut);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMap.getMyLocation() != null) {
                    Location location = mMap.getMyLocation();
                    Log.e("DATA", String.valueOf(location.getLongitude()));
                    Toast.makeText(getApplicationContext(), location.getProvider() + location.getLatitude() + location.getLongitude(), Toast.LENGTH_SHORT).show();
                    mMap.setOnMyLocationClickListener(new GoogleMap.OnMyLocationClickListener() {
                        @Override
                        public void onMyLocationClick(@NonNull Location location) {
                            MyPos = new LatLng(location.getLatitude(), location.getLongitude());
                            IMmarker = mMap.addMarker(new MarkerOptions()
                                    .position(MyPos)
                                    .title("MyPosition")
                                    .snippet("Gobuhat?")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
                        }
                    });
                }
            }
        });

        ZaPivasom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double MyLat = MyPos.latitude;
                Double MyLong = MyPos.longitude;
                Double PivoLat = Pivopos.latitude;
                Double PivoLong = Pivopos.longitude;
                String MyStrPos = MyLat.toString() + "," + MyLong.toString();
                String PivoStrPos = PivoLat.toString() + "," + PivoLong.toString();
                Log.e("MYSTR", MyStrPos);
                Log.e("PIVOSTR", PivoStrPos);

                MapsJson.getInstance().getApi().getRoute(MyStrPos, PivoStrPos, Q.MapsToken).enqueue(new Callback<Generic>() {
                    @Override
                    public void onResponse(Call<Generic> call, Response<Generic> response) {
                        try {
                            if (response.isSuccessful()) {
                                if (polyline != null)
                                    polyline.remove();

                                List<LatLng> pointsdecode;
                                List<LatLng> points = new ArrayList<>();
                                points.add(new LatLng(response.body().routes.get(0).legs.get(0).start_location.lat, response.body().routes.get(0).legs.get(0).start_location.lng));

                                for (int i = 0; i < response.body().routes.get(0).legs.get(0).steps.size(); i++) {
                                    Log.e("O DA", String.valueOf(response.body().routes.get(0).legs.get(0).steps.get(i).polyline.getPoints()));
                                    pointsdecode = PolyUtil.decode(response.body().routes.get(0).legs.get(0).steps.get(i).polyline.getPoints());
                                    points.addAll(pointsdecode);
                                }

                                points.add(new LatLng(response.body().routes.get(0).legs.get(0).end_location.lat, response.body().routes.get(0).legs.get(0).end_location.lng));

                                PolylineOptions line = new PolylineOptions();
                                line.width(6f).color(Color.argb(100, 255, 0, 150));
                                LatLngBounds.Builder latLngBuilder = new LatLngBounds.Builder();


                                for (int i = 0; i < points.size(); i++) {
                                    Log.e("DECODER", points.get(i).toString());
                                    line.add(points.get(i));
                                    latLngBuilder.include(points.get(i));
                                }

                                polyline = mMap.addPolyline(line);
                                int size = getResources().getDisplayMetrics().widthPixels;
                                LatLngBounds latLngBounds = latLngBuilder.build();
                                CameraUpdate track = CameraUpdateFactory.newLatLngBounds(latLngBounds, size, size, 25);
                                mMap.moveCamera(track);
                            }
                        }
                        catch (Exception e){
                            Toast.makeText(getApplicationContext(), "Указана недостижимая область", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Generic> call, Throwable t) {
                        Log.e("NOMARSHRUT", t.toString());
                    }
                });
            }
        });
//
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        // TODO: Before enabling the My Location layer, you must request
        // location permission from the user. This sample does not include
        // a request for location permission.
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (Tap != null)
                    Tap.remove();
                Pivopos = latLng;

                Tap = mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Baldesh")
                        .snippet("EDEM ZA PIVASOM S DAD VOVOI")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

                MarkerInfo markerInfo = new MarkerInfo("wqewqewew", "qwewqeasdas", "Kirill");
                Marker_adapter marker_adapter = new Marker_adapter(markerInfo, R.layout.marker, MapsActivity.this);
                mMap.setInfoWindowAdapter(marker_adapter);
                Tap.setTag(markerInfo);
                Tap.showInfoWindow();
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        Toast.makeText(MapsActivity.this, "BALDESH", Toast.LENGTH_SHORT).show();
                        MarkerInfo markerGet = (MarkerInfo) marker.getTag();
                        Log.e("CHECK", markerGet.getDescription());
                    }
                });

                Tap.setTitle("QWEasd123");
            }
        });
    }


    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        if (IMmarker != null)
            IMmarker.remove();
        if (mMap.getMyLocation() != null) {
            MyPos = new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude());
            IMmarker = mMap.addMarker(new MarkerOptions()
                    .position(MyPos)
                    .title("SASHA TI KOSTIL")
                    .snippet("SASHA NEEET NE KURI TRAVU")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
            Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        }
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

}
/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */
