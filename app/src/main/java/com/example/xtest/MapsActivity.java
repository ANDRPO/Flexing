package com.example.xtest;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xtest.generic.MapsResponce;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback {

    private boolean mLocationPermissionGranted;
    private GoogleMap mMap;
    private Button search, ZaPivasom;
    LocationManager locationManager;
    String provider;
    Marker IMmarker, Tap;
    LatLng Vihod, Vhod;
    LatLng MyPos, Pivopos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        search = findViewById(R.id.b_maps_positioning);
        // Construct a FusedLocationProviderClient.
        FusedLocationProviderClient mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        ZaPivasom = findViewById(R.id.marshrut);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMap.getMyLocation() != null) {
                    Location location = mMap.getMyLocation();
                    Log.e("DATA", String.valueOf(location.getLongitude()));
                    Toast.makeText(getApplicationContext(),location.getProvider().toString() + String.valueOf(location.getLatitude()) + String.valueOf(location.getLongitude()), Toast.LENGTH_SHORT).show();
                    mMap.setOnMyLocationClickListener(new GoogleMap.OnMyLocationClickListener() {
                        @Override
                        public void onMyLocationClick(@NonNull Location location) {
                            MyPos = new LatLng(location.getLatitude(), location.getLongitude());
                            IMmarker = mMap.addMarker(new MarkerOptions()
                                    .position(MyPos)
                                    .title("MyPosition")
                                    .snippet("Gobuhat?"));
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

                MapsJson.getInstance().getApi().getRoute(MyStrPos, PivoStrPos, Q.MapsToken).enqueue(new Callback<MapsResponce>() {
                    @Override
                    public void onResponse(Call<MapsResponce> call, Response<MapsResponce> response) {
                        Log.e("O DA", response.body().getRoutes().toString());

                    }

                    @Override
                    public void onFailure(Call<MapsResponce> call, Throwable t) {

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
                Pivopos = latLng;
                Tap = mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Baldesh")
                        .snippet("EDEM ZA PIVASOM S DAD VOVOI"));
            }
        });
    }



    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        if(IMmarker != null)
            IMmarker.remove();
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
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
