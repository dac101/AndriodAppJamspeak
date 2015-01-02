package catchmedia.jamaica.dictionary;

import android.app.Activity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.media.MediaPlayer;


import java.io.IOException;
import java.util.ArrayList;

import database.DatabaseHandler;
import database.Word;

public class FragmentWord extends Fragment {

	// List view
	private ListView listView;

	// Listview Adapter
	Adapter adapt;
	
	// Listview Adapter
	ArrayAdapter<String> adapterr;
	ArrayAdapter<Word> words;
	
	// Search EditText
	EditText inputSearch;

	// database
	DatabaseHandler db;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
      
		ArrayList<Word> words = new ArrayList<Word>();
		words = (ArrayList<Word>) db.getAllWords();
	
        Log.i("Word", words.size() + "");
		View rootView = inflater.inflate(R.layout.activity_fragment_word,
				container, false);
		
		listView = (ListView)rootView.findViewById(R.id.list_view);
		
      //  inputSearch = (EditText) rootView.findViewById(R.id.inputSearch);
        
        // Adding items to listview

        adapt = new Adapter(getActivity().getBaseContext(),words);
        listView.setAdapter(adapt);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AssetFileDescriptor afd = null;
                try {
                    afd = getActivity().getAssets().openFd(adapt.getItem(position).getAudiofile());
                    MediaPlayer player = new MediaPlayer();
                    player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        /**
         * Enabling Search Filter
         * */
//        inputSearch.addTextChangedListener(new TextWatcher() {
//
//			@Override
//			public void onTextChanged(CharSequence cs, int start, int before, int count) {
//				// When user changed the Text
//				Log.i("User input", cs.toString());
//				adapt.getFilter().filter(cs.toString());
//			}
//
//				@Override
//			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//					int arg3) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void afterTextChanged(Editable arg0) {
//				// TODO Auto-generated method stub
//			}
//		});
		

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		db = new DatabaseHandler(activity);
	}

}
