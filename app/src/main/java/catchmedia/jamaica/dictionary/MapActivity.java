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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import database.DatabaseHandler;
import database.Marker;
import utility.GooglePlace;
import utility.Helper;
import utility.MapUtilities;

public class MapActivity extends FragmentActivity {

    // Google Map
    private GoogleMap googleMap;
    JSONObject places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        try {
            initilizeMap();
            MapUtilities.setMapSetting(googleMap);

            Intent intent = getIntent();
            DatabaseHandler db = new DatabaseHandler(this);
            java.util.List<Marker> markers = db.getAllMarker();
            GooglePlace place = new GooglePlace();
            places = place.getValue(getApplicationContext());


            for(Marker x : markers){
                googleMap.addMarker(getMarkerOptions(x));
            }

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

}