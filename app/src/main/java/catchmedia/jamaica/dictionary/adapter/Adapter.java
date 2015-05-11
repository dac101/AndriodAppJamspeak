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

import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.ArrayList;

import catchmedia.jamaica.dictionary.R;
import database.Word;
import utility.ImageInfo;


public class Adapter extends ArrayAdapter<Word>{

	private ArrayList<Word> originalList;
	private ArrayList<Word> wordList;
	private Context context;

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

                    //wordImage.setImageResource(drawables[i].getInt(null));
                    Picasso.with(context)
                            .load(drawables[i].getInt(null))
                            .resize(250, 250)
                            .centerCrop()
                            .into(wordImage);

                    break;
                }
                if(currentPic.toLowerCase().contains(word.getWord().toLowerCase().substring(0,2))){
                    //wordImage.setImageResource(drawables[i].getInt(null));
                    Picasso.with(context)
                            .load(drawables[i].getInt(null))
                            .resize(250,250)
                            .centerCrop()
                            .into(wordImage);

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

}
