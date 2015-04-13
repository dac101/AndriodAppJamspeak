package catchmedia.jamaica.dictionary;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.util.ArrayList;

import database.DatabaseHandler;
import database.Marker;
import utility.GooglePlace;
import utility.Helper;
import utility.MapUtilities;

public class MapActivity extends FragmentActivity  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    // Google Map
    private GoogleMap googleMap;
    GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        try {
            initilizeMap();
            MapUtilities.setMapSetting(googleMap);

            mGoogleApiClient = new GoogleApiClient.Builder(this.getApplicationContext())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API).build();
            mGoogleApiClient.connect();

            Intent intent = getIntent();
            DatabaseHandler db = new DatabaseHandler(this);
            final java.util.List<Marker> markers = db.getAllMarker();
            final GooglePlace place = new GooglePlace(mGoogleApiClient);
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());


            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, place.Url, null,
                            new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {

                                    place.geolocation(getApplicationContext());
                                    place.setJsonObject(response);

                                    for(Marker x: place.parsePlaces(response))
                                    {
                                        markers.add(x);
                                    }

                                    for(Marker x : markers){
                                        googleMap.addMarker(getMarkerOptions(x));
                                    }

                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(),
                                    "Network Related issue", Toast.LENGTH_LONG)
                                    .show();

                            for(Marker x : markers){
                                googleMap.addMarker(getMarkerOptions(x));
                            }

                        }
                    });

            queue.add(jsObjRequest);

            for(Marker x : markers)
            {
                if(intent.getStringExtra("name").equals(x.getName()))
                {
                    MapUtilities.setCameraPosition(x, 9, googleMap);
                    break;
                }
                MapUtilities.setCameraPosition(x, 9, googleMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MarkerOptions getMarkerOptions(Marker x) {
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(
                           x.getLatitude(),
                           x.getLongitude()))
                           .title(x.getName() + " \n" + " \n" + x.getType());

        marker.icon(BitmapDescriptorFactory.defaultMarker(Helper.setIconColor(x)));
        return marker;
    }


    public void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    /**
     * function to load map. If map is not created it will create it for you
     */

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}