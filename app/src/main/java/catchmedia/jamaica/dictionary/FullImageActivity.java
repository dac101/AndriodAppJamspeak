package catchmedia.jamaica.dictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import catchmedia.jamaica.dictionary.adapter.ImageAdapter;
import utility.ImageInfo;

public class FullImageActivity extends Activity {
 
	ArrayList<ImageInfo> info = new ArrayList<ImageInfo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_image);
		
		//call function
		getImages();
		// get intent data
		Intent i = getIntent();
		
		// Selected image id
		int position = i.getExtras().getInt("id");
		ImageAdapter imageAdapter = new ImageAdapter(this,info);
		
		ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
		imageView.setImageResource(imageAdapter.test.get(position).getId());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.full_image, menu);
		return true;
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
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}

}
