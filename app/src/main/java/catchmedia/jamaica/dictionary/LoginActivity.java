package catchmedia.jamaica.dictionary;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import SharedPreferences.SessionManager;
import database.DatabaseHandler;
import database.DatabaseInfo;
import database.User;
import database.Word;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

	// Values for email and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;

	// UI references.
	private EditText mEmailView;
	private EditText mPasswordView;
	private TextView forgetPassword;

	DatabaseHandler db = new DatabaseHandler(this);
	List<Word> words = new ArrayList<Word>();
	User user = new User();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		final SessionManager session = new SessionManager(this);
		// check to make sure login else  reedirect it 
		session.LoginAlready();
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		// Set up the login form.
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		// mEmail = getIntent().getStringExtra(EXTRA_EMAIL);
		mEmailView = (EditText) findViewById(R.id.email);
		mEmailView.setText(mEmail);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});
		
		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin();
						if (login(mPasswordView.getText().toString(),
								mEmailView.getText().toString())) {
							try {
								session.createLoginSession(mPasswordView.getText()
												.toString(), mEmailView
										.getText().toString());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							startActivity(new Intent(LoginActivity.this,
									HomeActivity.class));
						} else {
							Log.i("failure", "faliure");
						}
					}
				});

		// forgot Activity password
		forgetPassword = (TextView) findViewById(R.id.LessonTextView);
		forgetPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(LoginActivity.this,
						ForgettingActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public boolean login(String password, String email) {

		words = db.getAllWords();
		Log.i("Word Size", words.size() + " ");
		for(Word x: words)
		{
			Log.i("Word", x.toString());
		}
		
		if(words.size() == 0 )
		{
			DatabaseInfo info = new DatabaseInfo(db);
			info.insertWords();
		}
		
		List<User> users = new ArrayList<User>();
		users = db.getAllUsers();

		try {
			//password = AESencrp.encrypt(password);
			for (User user : users) {
				Log.i(user.getEmail(), user.getPassword());
				if (user.getEmail().compareTo(email) == 0
						&& user.getPassword().compareTo(password) == 0) {
					Log.i("SuccessFull", "Successfull");
					return true;
				} else {
					Log.i("Failure", password);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {

		// Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
		} else if (!mEmail.contains("@")) {
			mEmailView.setError(getString(R.string.error_invalid_email));
		}
	}
}
