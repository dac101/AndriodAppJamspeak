package utility;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import org.json.JSONObject;


/**
 * Created by dacorie on 01/04/2015.
 */
public class GooglePlace {

    // Google API Key
    private static final String API_KEY = "AIzaSyAHmM1TPrxRq1a_RCqJ_Om4EwdI-P6MqKg";

    // Google Places serach url's
    private static final String PLACES_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
    private static final String PLACES_TEXT_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
    private static final String PLACES_DETAILS_URL = "https://maps.googleapis.com/maps/api/place/details/json?";

    private double _latitude;
    private double _longitude;
    private double _radius;

    public JSONObject values;
    public VolleyError errors ;
    public JSONObject getValue(Context context){

        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, "https://maps.googleapis.com/maps/api/place/search/json?location=-33.88471,151.218237&radius=100&sensor=true&key=AIzaSyAHmM1TPrxRq1a_RCqJ_Om4EwdI-P6MqKg", null,
                        new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        values = response;
                        Log.d("Response", response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(jsObjRequest);
        return values;
    }


}
