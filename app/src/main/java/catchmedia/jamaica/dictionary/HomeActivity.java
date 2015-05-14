package catchmedia.jamaica.dictionary;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import catchmedia.jamaica.dictionary.adapter.TabsPagerAdapter;
import database.DatabaseHandler;
import database.DatabaseInfo;
import database.Word;

public class HomeActivity extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    private TabsPagerAdapter tabsPagerAdapter;
    private ActionBar actionBar;
    DatabaseHandler db = new DatabaseHandler(this);
    AdView mAdView;

    private String[] tabsTitles = {"Words","Places"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeDatabase();

        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdView = (AdView)findViewById(R.id.adView);

        tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabsPagerAdapter);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        for (String tab_name : tabsTitles) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

       //  AdRequest adRequest = new AdRequest.Builder()
        // .build();
       //   mAdView.loadAd(adRequest);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    public void initializeDatabase() {
        List<Word> words = db.getAllWords();

        if (words.size() == 0) {
            DatabaseInfo info = new DatabaseInfo(db);
            info.insertWords();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_lesson, menu);
        // Associate searchable configuration with the SearchView

        SearchManager searchManager =  (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on  the action bar items
        if(item.getItemId() == R.id.About_Us)
        {

        }

        switch (item.getItemId()) {
            case R.id.action_search:
                // search action
                return true;
            case R.id.About_Us:
                Intent i = new Intent(HomeActivity.this, AboutUs.class);
                startActivity(i);
                return true;
            case R.id.Tell_A_Friend:
                String shareBody = "Download the App from" +
                        " https://play.google.com/store/apps/details?id=catchmedia.jamaica.dictionary." +
                        " To learn more about us visit us at www.catchmedia.co " +
                        "Thank you ";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Download Our App ");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}