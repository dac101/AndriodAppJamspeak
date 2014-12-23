package catchmedia.jamaica.dictionary;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import utility.ImageInfo;

public class GalleryActivity extends Activity {

	ArrayList<ImageInfo> info = new ArrayList<ImageInfo>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);

		GridView gridView = (GridView) findViewById(R.id.grid_view);

		getImages();
		gridView.setAdapter(new MyAdapter(this,info));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				// Sending image id to FullScreenActivity
				Intent i = new Intent(getApplicationContext(),
						FullImageActivity.class);
				// passing array index
				i.putExtra("id", position);
				startActivity(i);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		getMenuInflater().inflate(R.menu.gallery, menu);
		return true;
	}

	//My adapter for the image remember to move   to its own 
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
	 * @param dyamically gets all the images id and name put it 
	 * @param class call ImageInfo
	 * @by using fields
	 */
	public void getImages() {
		Field[] drawables = R.drawable.class.getFields();
		ArrayList<Integer> ids = new ArrayList<Integer>();

		int[] resArray = new int[drawables.length];

		for (int i = 0; i < drawables.length; i++) {
			try {
				if (drawables[i].getName().contains("_gallery")) {
					resArray[i] = drawables[i].getInt(null);
					ids.add(drawables[i].getInt(null));
					info.add(new ImageInfo(drawables[i].getName(), drawables[i].getInt(null)));
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(ImageInfo x : info)
		{
		 Log.i("Name:" + x.getName(), "Id :" + x.getId());	
		}
	}
}
