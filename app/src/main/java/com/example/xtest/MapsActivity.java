package com.example.xtest;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xtest.generic.GenMaps.Generic;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
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
                        if(polyline != null)
                            polyline.remove();
                        Log.e("O DA", String.valueOf(response.body().routes.get(0).legs.get(0).steps.get(0).polyline.getPoints()));
                        List<LatLng> points;
                        List<LatLng> points2;
                        points = PolyUtil.decode(response.body().routes.get(0).legs.get(0).steps.get(0).polyline.getPoints());
                        points2 = PolyUtil.decode(response.body().routes.get(0).overview_polyline.getPoints());
                        for (int i = 0; i < points.size(); i++) {
                            Log.e("DECODER", points.get(i).toString());
                        }
                        PolylineOptions line = new PolylineOptions();
                        line.width(6f).color(R.color.quantum_googgreen);
                        LatLngBounds.Builder latLngBuilder = new LatLngBounds.Builder();

                        for (int i = 0; i < points.size(); i++) {
                            line.add(points.get(i));
                            latLngBuilder.include(points.get(i));
                        }

                        for (int i = 0; i < points2.size(); i++) {

                            line.add(points2.get(i));
                            latLngBuilder.include(points2.get(i));
                        }

                        polyline = mMap.addPolyline(line);
                        int size = getResources().getDisplayMetrics().widthPixels;
                        LatLngBounds latLngBounds = latLngBuilder.build();
                        CameraUpdate track = CameraUpdateFactory.newLatLngBounds(latLngBounds, size, size, 25);
                        mMap.moveCamera(track);
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
                if(Tap != null)
                    Tap.remove();
                Pivopos = latLng;
                Tap = mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Baldesh")
                        .snippet("EDEM ZA PIVASOM S DAD VOVOI")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
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
        if(mMap.getMyLocation() != null) {
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
