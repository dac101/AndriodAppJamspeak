package catchmedia.jamaica.dictionary;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import database.DatabaseHandler;
import database.User;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */ 
public class ForgettingActivity extends Activity {

	DatabaseHandler db = new DatabaseHandler(this);
	EditText email;
	TextView showpassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgetting);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	
		Button forget = (Button) findViewById(R.id.button1);
		forget.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				
				 email = (EditText) findViewById(R.id.forgetemail);
				 showpassword = (TextView) findViewById(R.id.showpassword);
				
				List<User> users = new ArrayList<User>();
				users = db.getAllUsers();
				
				Log.i("vv", email.getText().toString());
				for (User user : users) {
					 if(user.getEmail().toLowerCase(Locale.US).equals(email.getText().toString().toLowerCase(Locale.US))){
						 showpassword.setText(user.getPassword());
					 }
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.forgetting, menu);
		return true;
	}

}
