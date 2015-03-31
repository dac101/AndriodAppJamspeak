package catchmedia.jamaica.dictionary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseHandler;
import database.Marker;
import utility.ImageInfo;


public class MyPlaceFragment extends Fragment {


    public MyPlaceFragment() {
        // Required empty public constructor
    }
    ArrayList<ImageInfo> info = new ArrayList<ImageInfo>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        final View rootView = inflater.inflate(R.layout.fragment_my_place, container, false);
        GridView gridView = (GridView)rootView.findViewById(R.id.grid_view);

        getImages("a");
        gridView.setAdapter(new MyAdapter(rootView.getContext(),info));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                List<Marker> markers = new ArrayList<Marker>();
                DatabaseHandler db = new DatabaseHandler(rootView.getContext());
                Marker mark = new Marker();
                markers = db.getAllMarker();
                for(Marker x : markers){
                    if(x.getName().contains(info.get(position).getName())){
                        mark = x;
                        break;
                    }

                }
                // Sending intent
                Intent i = new Intent(getActivity(),
                        MapActivity.class);
                // passing array index
                i.putExtra("longitude", mark.getLongitude());
                i.putExtra("latitude", mark.getLatitude());
                i.putExtra("website",mark.getWebsite());
                i.putExtra("number",mark.getNumber());
                i.putExtra("email",mark.getEmail());
                i.putExtra("name",mark.getName());
                startActivity(i);
            }
        });
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    private class MyAdapter extends BaseAdapter {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;



        public MyAdapter(Context context,ArrayList<ImageInfo> info) {
            inflater = LayoutInflater.from(context);

            for(ImageInfo x : info ){
                items.add(new Item(x.getName().replace("_gallery", ""),x.getId()));
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

    /**
     * @param @dyamically gets all the images id and name put it
     * @param @class call ImageInfo
     * @by using fields
     */
    public void getImages(String imageFilter) {
        Field[] drawables = R.drawable.class.getFields();
        ArrayList<Integer> ids = new ArrayList<Integer>();

        int[] resArray = new int[drawables.length];

        for (int i = 0; i < drawables.length; i++) {
            try {
                if (drawables[i].getName().contains(imageFilter)) {
                    resArray[i] = drawables[i].getInt(null);
                    ids.add(drawables[i].getInt(null));
                    info.add(new ImageInfo(drawables[i].getName(), drawables[i].getInt(null)));
                }
            } catch (IllegalAccessException e) {
                return;
            } catch (IllegalArgumentException e) {
              return;
            }
        }
    }
}
