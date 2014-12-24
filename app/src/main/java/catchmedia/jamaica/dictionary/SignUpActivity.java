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
 * Activity Which Allows person to Sign Up
 */
public class SignUpActivity extends Activity {

	// Values for email and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;
	// UI references.
	private EditText mEmailView;
	private EditText mPasswordView;
	private TextView mLoginStatusMessageView;
	private TextView errors;

	/* database user */

	DatabaseHandler db = new DatabaseHandler(this);
	User user = new User();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sign_up);
		final SessionManager session = new SessionManager(this);
		errors = (TextView) findViewById(R.id.error);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		// Set up the login form.
		mEmailView = (EditText) findViewById(R.id.email);
		mEmailView.setText(mEmail);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							return true;
						}
						return false;
					}
				});

		findViewById(R.id.login_form);
		findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						if (SignUp(mEmailView.getText().toString(),
								mPasswordView.getText().toString(), errors)) {
							try {
								session.createLoginSession(
										(mPasswordView.getText().toString()),
										mEmailView.getText().toString());
							} catch (Exception e) {
							}
							startActivity(new Intent(SignUpActivity.this,
									HomeActivity.class));
						}
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

	public boolean SignUp(String email, String password, TextView errors) {
		List<User> users = new ArrayList<User>();
        List<Word> words = new ArrayList<Word>();

        words = db.getAllWords();

		errors.setText(" ");
		users = db.getAllUsers();
        //Todo make this into a function
        if(words.size() == 0 )
        {
            DatabaseInfo info = new DatabaseInfo(db);
            info.insertWords();
        }
		check();
		try {
			if (!checkEmail(users, email)) {

				user.setEmail(email);
				user.setPassword(password);
				db.createUser(user);
				Log.i("Account", "Account Created");
				errors.setText("Account Created ");
				return true;

			} else {
				errors.setText("This email is Already been used");
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void check() { // Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();
		boolean cancel = false;
		View focusView = null;
		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!mEmail.contains("@")) {
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}
	}

	public boolean checkEmail(List<User> users, String email) {
		for (User x : users) {
			if (x.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
}
