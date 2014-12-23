package catchmedia.jamaica.dictionary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import utility.ImageInfo;

/**
 * 
 * @author Dacorie Smith
 * @my Hack arrayList adapter
 * @Use to dynamically get the images
 */
public class ImageAdapter extends BaseAdapter {
	private Context mContext;
		
	//keep all image in an arrayList
	public ArrayList<ImageInfo> test;
	// Constructor
	public ImageAdapter(Context c){
		mContext = c;
	}
	
	// Constructor
		public ImageAdapter(Context c,ArrayList<ImageInfo> info){
			this.test = info;
			mContext = c;
		}

	@Override
	public int getCount() {
		return test.size();
	}

	@Override
	public Object getItem(int position) {
		return test.get(position).getId();
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {			
		ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(test.get(position).getId());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
	}
	
	public void getDrawable()
	{
	}
}

