package catchmedia.jamaica.dictionary.adapter;

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

import catchmedia.jamaica.dictionary.R;
import database.Word;
import utility.ImageInfo;


public class Adapter extends ArrayAdapter<Word>{

	private ArrayList<Word> originalList;
	private ArrayList<Word> wordList;
	private Context context;
	private Filter filter;
    ArrayList<ImageInfo> info ;

	public Adapter(Context context,	ArrayList<Word> wordList) {
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

        convertView = getRowLayoutView(convertView, parent);
        Word word = wordList.get(position);
        Field[] drawables = R.drawable.class.getFields();

		TextView wordView = (TextView) convertView.findViewById(R.id.Wordname);
        TextView typeOfWord = (TextView) convertView.findViewById(R.id.TypeOfWord);
        TextView wordMeaning = (TextView) convertView.findViewById(R.id.wordMeaning);
        ImageView wordImage = (ImageView) convertView.findViewById(R.id.wordImage);

        InitializeVariable(word, wordView, typeOfWord, wordMeaning);
        findImageForWord(word, wordImage, drawables);
        checkImageResource(wordImage);

        return convertView;
	}

    public void checkImageResource(ImageView wordImage) {
        if (wordImage.getResources()== null)
        {
            wordImage.setImageResource(R.drawable.ackee_jamaicaword);
        }
    }

    public View getRowLayoutView(View convertView, ViewGroup parent) {
        if(convertView == null)
    {
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.row_layout,parent,false);

    }
        return convertView;
    }

    public void InitializeVariable(Word word, TextView wordView, TextView typeOfWord, TextView wordMeaning) {
        wordView.setText(word.getWord());
        typeOfWord.setText(word.getCategory());
        wordMeaning.setText(word.getTranslation());
        word.setAudiofile(word.getWord().replaceAll(" ","")+ ".mp3");
    }

    public void findImageForWord(Word word, ImageView wordImage, Field[] drawables) {
        for (int i = 0; i < drawables.length; i++) {
            try {
                String currentPic = drawables[i].getName().toLowerCase().split("_")[0];
                if (currentPic.toLowerCase().contains(word.getWord().toLowerCase().replaceAll(" ",""))) {
                    wordImage.setImageResource(drawables[i].getInt(null));
                    break;
                }
                if(currentPic.toLowerCase().contains(word.getWord().toLowerCase().substring(0,2))){
                    wordImage.setImageResource(drawables[i].getInt(null));
                }
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
