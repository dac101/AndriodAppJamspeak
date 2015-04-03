package utility;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import org.json.JSONObject;


/**
 * Created by dacorie on 01/04/2015.
 */
public class GooglePlaces {
    /** Global instance of the HTTP transport. */
    private static final HttpTransport HTTP_TRANSPORT = new
            NetHttpTransport();

    // Google API Key
    private static final String API_KEY = "AIzaSyD_2BsiMZeRBBlN5jMtXWICNWZhwx9IgiY";

    // Google Places serach url's
    private static final String PLACES_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
    private static final String PLACES_TEXT_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
    private static final String PLACES_DETAILS_URL = "https://maps.googleapis.com/maps/api/place/details/json?";

    private double _latitude;
    private double _longitude;
    private double _radius;
    public JSONObject d;

    public JSONObject getValue(){

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, "https://maps.googleapis.com/maps/api/place/search/json?location=-33.88471,151.218237&radius=100&sensor=true&key=AIzaSyAHmM1TPrxRq1a_RCqJ_Om4EwdI-P6MqKg", null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(response + "", "places");
                        System.out.println("Response: " + response.toString());
                        d = response;
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });
        return d;
    }


}
