package utility;

import android.content.Context;
import android.location.Location;
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

import org.json.JSONObject;


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

    // Google client to interact with Google API
    private GoogleApiClient mGoogleApiClient;

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    public JSONObject values;

    public GooglePlace(GoogleApiClient mGoogleApiClient) {
        this.mGoogleApiClient = mGoogleApiClient;
        geolocationData();
    }

    public GooglePlace() {
    }

    public JSONObject getPlaces(final Context context){

        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());

        String Url = PLACES_SEARCH_URL + "location=" + _latitude + "," + _longitude + "&radius=1000&sensor=true&key=" + API_KEY;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Url, null,
                        new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        values = response;
                        Log.d("Response", response.toString());
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
        return values;
    }

    public void geolocationData() {

        mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {
             _latitude = mLastLocation.getLatitude();
             _longitude = mLastLocation.getLongitude();

        } else {
          _latitude=  -33.88471;
          _longitude =151.218237;

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
}
