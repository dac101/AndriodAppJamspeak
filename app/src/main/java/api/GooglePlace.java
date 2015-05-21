package api;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import model.Marker;


/**
 * Created by dacorie on 01/04/2015.
 */
public class GooglePlace  {

    // Google API Key
    private static final String API_KEY = "AIzaSyAHmM1TPrxRq1a_RCqJ_Om4EwdI-P6MqKg";

    // Google Places serach url's
    private static final String PLACES_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";

    private double _latitude;
    private double _longitude;
    private Location mLastLocation;
    private JSONObject jsonObject;

    public String Url;

    // Google client to interact with Google API
    private GoogleApiClient mGoogleApiClient;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    public GooglePlace(GoogleApiClient mGoogleApiClient) {
        this.mGoogleApiClient = mGoogleApiClient;
        geolocationData();
        Url = PLACES_SEARCH_URL + "location=" + _latitude + "," + _longitude + "&radius=1000&sensor=true&key=" + API_KEY;
    }

    public GooglePlace(GoogleApiClient mGoogleApiClient, Context context) {
        this.mGoogleApiClient = mGoogleApiClient;
        getPlaces(context);
    }



    public GooglePlace() {
    }

    public void getPlaces(final Context context){
        final JSONObject[] jsonObject = {new JSONObject()};

        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());

         Url = PLACES_SEARCH_URL + "location=" + _latitude + "," + _longitude + "&radius=1000&sensor=true&key=" + API_KEY;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Url, null,
                        new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        setJsonObject(response);
                      //  Log.d("Response", response.toString());
                        parsePlaces(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,
                                "Network Related issue", Toast.LENGTH_LONG)
                                .show();
                    }
                });

        queue.add(jsObjRequest);

    }


    public void geolocation(Context context) {
        LocationManager locationManager = (LocationManager)context. getSystemService(Context.LOCATION_SERVICE);


        mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        Location location;
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location == null){
            _latitude =  18.0233783 ;
            _longitude = -76.7681047;

        }else{
            _latitude =location.getLatitude();
            _longitude = location.getLongitude();
        }

    }

    public ArrayList<Marker> parsePlaces(JSONObject jsonObject)  {
        ArrayList<Marker> markers = new ArrayList<Marker>();
        try {

            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonfile = jsonArray.getJSONObject(i);
               Marker mark = new Marker();
               mark.setType(jsonfile.getJSONArray("types").get(0).toString());
               mark.setLatitude(jsonfile.getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
               mark.setLongitude(jsonfile.getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
               mark.setName(jsonfile.getString("name"));
               mark.setAddress(jsonfile.getString("vicinity"));
               markers.add(mark);
            }
            Log.d("JSonArray", jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
             return markers;
    }

    public void geolocationData() {

        mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {
             _latitude = mLastLocation.getLatitude();
             _longitude = mLastLocation.getLongitude();

        } else {
            _latitude = 17.9833;
            _longitude = -76.7484358;

        }

    }

    public boolean checkPlayServices(Context context) {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(context);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, (android.app.Activity) context,  PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(context,
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();

            }
            return false;
        }
        return true;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
