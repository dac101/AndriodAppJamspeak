package catchmedia.jamaica.dictionary;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import SharedPreferences.SessionManager;
import database.DatabaseHandler;
import database.User;
import database.UserLesson;
import database.Word;
import utility.PieGraph;
import utility.PieSlice;

public class ProgressActivity extends Activity {
	
	PieGraph pg;
	PieSlice psFood, psPlace, psGreeting;
	int food, thing, greeting;
	DatabaseHandler db = new DatabaseHandler(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress);
		
		
		
		final SessionManager session = new SessionManager(this);
		HashMap<String, String> h = new HashMap<String, String>();
		Button logout = (Button) findViewById(R.id.Logout);

		h = session.getUserDetails();

		Iterator<String> myVeryOwnIterator = h.keySet().iterator();

		while (myVeryOwnIterator.hasNext()) {
			String key = (String) myVeryOwnIterator.next();
			String value = (String) h.get(key);
			Log.i("Key: " + key, " Value: " + value);
		}
		populateGraph();
		displayCompletionRate(food,thing,greeting);
		
		Log.i("Greeeting Food Thing", " " + greeting + " " + food + " " + thing );
		
		logout.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				session.logoutUser();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		getMenuInflater().inflate(R.menu.progress, menu);
		return true;
	}

	/**
	 * loop over a hash map Not going to google it again
	 */
	public void loopOverHashmap(HashMap<?, ?> h) {
		Iterator<?> myVeryOwnIterator = h.keySet().iterator();

		while (myVeryOwnIterator.hasNext()) {
			String key = (String) myVeryOwnIterator.next();
			String value = (String) h.get(key);
			Log.i("Key: " + key, " Value: " + value);
		}
	}
	/**
	 * 
	 * @param food
	 * @param places
	 * @param greeting
	 */
	public void displayCompletionRate(int food,int places,int greeting  )
	{
		TextView foodPro = (TextView) findViewById(R.id.foodPro);
		TextView thingPro = (TextView) findViewById(R.id.thingPro);
		TextView greetingPro = (TextView) findViewById(R.id.greetingPro);
		
		pg = (PieGraph)findViewById(R.id.pie);
		pg.setThickness(25);
		psFood = new PieSlice();
		psFood.setColor(Color.RED);
		psFood.setValue(food);
		psFood.setTitle("food");
		foodPro.setText(food + "");
		
		psPlace = new PieSlice();
		psPlace.setTitle("places");
		psPlace.setColor(Color.GREEN);
		psPlace.setValue(places);
		thingPro.setText(places + "");
		
		psGreeting = new PieSlice();
		psGreeting.setColor(Color.YELLOW);
		psGreeting.setValue(greeting);
		psGreeting.setTitle("greeting");
		greetingPro.setText(greeting + "");
		
		pg.addSlice(psFood);
		pg.addSlice(psPlace);
		pg.addSlice(psGreeting);
	}
	
	public void populateGraph()
	{
		SessionManager session = new SessionManager(this);
		HashMap<String, String> h = new HashMap<String, String>();
		List<UserLesson> userWord = new ArrayList<UserLesson>();
		userWord = db.getAllUserLesson();
		List<User> users = new ArrayList<User>();
		List<Word> words = new ArrayList<Word>();
		
		String value = "";
		int userid = 0;
		
		h = session.getUserDetails();
		users = db.getAllUsers();
		words = db.getAllWords();
		
		Iterator<String> myVeryOwnIterator = h.keySet().iterator();

		while (myVeryOwnIterator.hasNext()) {
			String key = (String) myVeryOwnIterator.next();
			value = (String) h.get(key);
			break;
		}
		
		for(User x : users)
		{
			if(x.getEmail().contains(value))
			{
			   userid= 	x.getId();
			   break;
			}
		}
		
		for(UserLesson x : userWord )
		{
			Log.i("userId " + x.getUser_id(), "Wrord Id:" + x.getLesson_id());
			if(x.getUser_id() ==  userid)
			{
				for(Word y:words)
				{
					if(y.getId() == x.getLesson_id())
					{
						if(y.getCategory().contains("food"))
						{
							food++;
						}

						if(y.getCategory().contains("greeting"))
						{
							greeting++;
						}

						if(y.getCategory().contains("things"))
						{
							thing++;
						}
						break;
					}
				}
			}
		}
		
	}
}
