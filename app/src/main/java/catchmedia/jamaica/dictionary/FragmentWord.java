package catchmedia.jamaica.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import database.DatabaseHandler;
import database.Word;

public class FragmentWord extends Fragment {

	// List view
	private ListView lv;

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
		
		lv = (ListView)rootView.findViewById(R.id.list_view);
		
      //  inputSearch = (EditText) rootView.findViewById(R.id.inputSearch);
        
        // Adding items to listview

        adapt = new Adapter(getActivity().getBaseContext(),words);

        lv.setAdapter(adapt);
      
        lv.setTextFilterEnabled(true);
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
