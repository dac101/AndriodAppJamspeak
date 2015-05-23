package api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.NamedRunnable;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import catchmedia.jamaica.dictionary.R;
import model.Marker;

/**
 * Created by dacorie on 21/05/2015.
 */
public class JamaicaDataApi {

    public JamaicaDataApi() {

    }


 /*   public void GetAllTourismAttraction( RequestQueue queue ,Context context)
    {

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET,context.getString(R.string.ApiAddress), null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {


                             for( Marker marker :  parsePlaces(response)){
                                    Log.d("marker", marker.toString());
                             }
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        VolleyLog.d("Error", error.getMessage());
                    }
                });

        queue.add(jsObjRequest);
    }
*/

    public void GetAllTourismAttractionOkHttp (String url) throws IOException
    {

        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        Reader body = response.body().charStream();



        Log.d("response",body.toString());

    }


    public ArrayList<Marker> parsePlaces(JSONObject jsonObject)  {
        ArrayList<Marker> markers = new ArrayList<Marker>();
        try {

            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonfile = jsonArray.getJSONObject(i);
                Marker mark = new Marker();
                mark.setType(jsonfile.getString("Theme").toLowerCase());
                mark.setLatitude(jsonfile.getDouble("Latitude"));
                mark.setLongitude(jsonfile.getDouble("Longitude"));
                mark.setName(jsonfile.getString("Name"));
                mark.setAddress(jsonfile.getString("Address") + " " + jsonfile.getString("CityTown") +  jsonfile.getString("Parish") );
                markers.add(mark);
            }
            Log.d("JSonArray", jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return markers;
    }

}
