package catchmedia.jamaica.dictionary;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import database.Word;
import utility.ImageInfo;


public class Adapter extends ArrayAdapter<Word>{

	private ArrayList<Word> originalList;
	private ArrayList<Word> wordList;
	private Context context;
	private Filter filter;
    ArrayList<ImageInfo> info ;

	public Adapter(Context context,
			ArrayList<Word> wordList) {
		super(context, R.layout.row_layout, wordList);
		this.wordList = new ArrayList<Word>();
		this.wordList.addAll(wordList);
		this.originalList = new ArrayList<Word>();
		this.originalList.addAll(wordList);
		this.context = context;
       this.info = new ArrayList<ImageInfo>();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null)
		{
			LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.row_layout,parent,false);
			
		}
		Word word = wordList.get(position);
		
		TextView wordView = (TextView) convertView.findViewById(R.id.Wordname);
        TextView typeOfWord = (TextView) convertView.findViewById(R.id.TypeOfWord);
        ImageView wordImage = (ImageView) convertView.findViewById(R.id.wordImage);
		wordView.setText(word.getWord());
        typeOfWord.setText(word.getCategory());
     //   wordImage.setImageResource(R.drawable.ackee_jamaicaword);

        Field[] drawables = R.drawable.class.getFields();
        int[] resArray = new int[drawables.length];
        for (int i = 0; i < drawables.length; i++) {
            try {
                if (drawables[i].getName().contains(word.getWord().substring(0,2))) {
                    resArray[i] = drawables[i].getInt(null);
                    wordImage.setImageResource(drawables[i].getInt(null));
                    break;
                }else{
                    wordImage.setImageResource(R.drawable.ackee_jamaicaword);

                }
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



		return convertView;
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		
		if(filter == null){
			filter = new WordFilter();
		}
		return filter;
	}
	
	private class WordFilter extends Filter{

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			// TODO Auto-generated method stub
			constraint = constraint.toString().toLowerCase();
			FilterResults result = new FilterResults();
			if (constraint != null && constraint.toString().length() > 0) {
				ArrayList<Word> filteredItems = new ArrayList<Word>();

				for (int i = 0, l = originalList.size(); i < l; i++) {
					Word word = originalList.get(i);
					if (word.getWord().toLowerCase()
							.contains(constraint))
						filteredItems.add(word);
				}
				result.count = filteredItems.size();
				result.values = filteredItems;
			} else {
				synchronized (this) {
					result.values = originalList;
					result.count = originalList.size();
				}
			}
			return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			// TODO Auto-generated method stub
			wordList = (ArrayList<Word>) results.values;
			for(Word word: wordList)
			{
				Log.i("filter Result" , word.toString());
			}
			notifyDataSetChanged();
			clear();
			for (int i = 0, l = wordList.size(); i < l; i++)
				add(wordList.get(i));
			notifyDataSetInvalidated();
		}

		
		
	}

}
