package catchmedia.jamaica.dictionary;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import catchmedia.jamaica.dictionary.adapter.Adapter;
import database.DatabaseHandler;
import database.Word;


public class SearchResultsActivity extends Activity {

    ArrayList<Word> filteredWords;
    private ListView listView;
    AdView mAdView;

    Adapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        ActionBar actionBar = getActionBar();
        filteredWords = new ArrayList<Word>();

        // Enabling Back navigation on Action Bar icon
        actionBar.setDisplayHomeAsUpEnabled(true);
        handleIntent(getIntent());

        listView = (ListView) findViewById(R.id.list_view);
        listViewAdapter = new Adapter(getApplicationContext(), filteredWords);
        listView.setAdapter(listViewAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    assetFileDescriptor = getApplicationContext().getAssets().openFd(listViewAdapter.getItem(position).getAudiofile());
                    MediaPlayer player = new MediaPlayer();
                    player.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                // search action
                return true;
            case R.id.About_Us:
                Intent i = new Intent(SearchResultsActivity.this, AboutUs.class);
                startActivity(i);
            case R.id.Tell_A_Friend:
                ShareContact();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void ShareContact() {
        String shareBody = "Download the App from" +
                " https://play.google.com/store/apps/details?id=catchmedia.jamaica.dictionary." +
                " To learn more about us visit us at www.catchmedia.co " +
                "Thank you ";

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Download Our App ");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        DatabaseHandler db = new DatabaseHandler(this);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            //use the query to search your data somehow
            String query = intent.getStringExtra(SearchManager.QUERY);
            List<Word> words = db.getAllWords();

            for (Word x : words) {
                if (x.getWord().toLowerCase().contains(query.toLowerCase())) {
                    filteredWords.add(x);
                }
            }

            if (filteredWords.isEmpty()) {
                if(query.length() <2 ){
                    for (Word x : words) {
                        filteredWords.add(x);
                   }
                    return;
                }
                String subquery = query.substring(0,2);
                for (Word x : words) {
                        if (x.getWord().toLowerCase().contains(subquery.toLowerCase()))
                        {
                            filteredWords.add(x);
                        }
                    }
               }
        }
        Collections.sort(filteredWords, Word.WordNameComparator);
    }
}

