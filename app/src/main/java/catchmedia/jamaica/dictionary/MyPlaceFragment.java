package catchmedia.jamaica.dictionary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseHandler;
import database.Marker;
import utility.GooglePlace;
import utility.Helper;
import utility.ImageInfo;


public class MyPlaceFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {


    GooglePlace place;
    GoogleApiClient mGoogleApiClient;

    public MyPlaceFragment() {
        // Required empty public constructor
    }

    ArrayList<ImageInfo> info = new ArrayList<ImageInfo>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final View rootView = inflater.inflate(R.layout.fragment_my_place, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view);

        Helper.getImages("travel", info);

        gridView.setAdapter(new MyAdapter(rootView.getContext(), info));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                List<Marker> markers;
                DatabaseHandler db = new DatabaseHandler(rootView.getContext());
                Marker mark = new Marker();
                markers = db.getAllMarker();

                for (Marker marker : markers) {
                    if (marker.getName().contains(info.get(position).getName())) {
                        mark = marker;
                        break;
                    } else {
                        mark = marker;
                    }
                }

                // Sending intent
                Intent i = new Intent(getActivity(),
                        MapActivity.class);
                // passing array index
                i.putExtra("name", mark.getName());
                startActivity(i);
            }
        });

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onConnected(Bundle bundle) {
        place.geolocationData();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    private class MyAdapter extends BaseAdapter {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;


        public MyAdapter(Context context, ArrayList<ImageInfo> info) {
            inflater = LayoutInflater.from(context);

            for (ImageInfo x : info) {
                items.add(new Item(x.getName().replace("_gallery", ""), x.getId()));
            }
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            ImageView picture;
            TextView name;

            if (v == null) {
                v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView) v.getTag(R.id.picture);
            name = (TextView) v.getTag(R.id.text);

            Item item = (Item) getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);

            return v;
        }

        private class Item {
            final String name;
            final int drawableId;

            Item(String name, int drawableId) {
                this.name = name;
                this.drawableId = drawableId;
            }
        }
    }

}
