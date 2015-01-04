package catchmedia.jamaica.dictionary;

import android.app.Activity;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.media.MediaPlayer;

import java.io.IOException;
import java.util.ArrayList;

import catchmedia.jamaica.dictionary.adapter.Adapter;
import database.DatabaseHandler;
import database.Word;

public class FragmentWord extends Fragment {

	private ListView listView;

	Adapter listViewAdapter;

	// database
	DatabaseHandler db;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        ArrayList<Word>	words = (ArrayList<Word>) db.getAllWords();
		View rootView = inflater.inflate(R.layout.activity_fragment_word,container, false);
		
		listView = (ListView)rootView.findViewById(R.id.list_view);
        listViewAdapter = new Adapter(getActivity().getBaseContext(),words);
        listView.setAdapter(listViewAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    assetFileDescriptor = getActivity().getAssets().openFd(listViewAdapter.getItem(position).getAudiofile());
                    MediaPlayer player = new MediaPlayer();
                    player.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		db = new DatabaseHandler(activity);
	}

}
