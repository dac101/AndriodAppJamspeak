package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Dacorie Smith on 10/9/13.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
	// Table Names

	private static final String TABLE_LESSON = "lessons";
	private static final String TABLE_LESSON_WORD = "lessons_words";
	private static final String TABLE_PICTURE = "pictures";
	private static final String TABLE_USER_LESSON = "user_lesson";
	private static final String TABLE_WORD = "word";
	private static final String TABLE_MARKERS = "markers";
	private static final String TABLE_USER = "user";

	// Column column name
	private static final String KEY_ID = "id";

	// Note For Users
	private static final String KEY_USER_PASSWORD = "password";
	private static final String KEY_USER_EMAIL = "email";
	// USERS create statement
	private static final String CREATE_TABLE_USER = "CREATE TABLE "
			+ TABLE_USER + "(" + KEY_ID + " integer PRIMARY KEY,"
			+ KEY_USER_PASSWORD + " TEXT," + KEY_USER_EMAIL + " TEXT " + ")";

	// Notes FOR LESSONS
	private static final String KEY_LESSON_NAME = "name";
	private static final String KEY_LESSON_PROGRESS = "progress";
	private static final String KEY_LESSON_DETAIL = "detail";

	// LESSON create statement
	private static final String CREATE_TABLE_LESSON = "CREATE TABLE "
			+ TABLE_LESSON + "(" + KEY_ID + " integer PRIMARY KEY,"
			+ KEY_LESSON_NAME + " TEXT," + KEY_LESSON_PROGRESS + " integer,"
			+ KEY_LESSON_DETAIL + " TEXT " + ")";

	// Notes Table words
	private static final String KEY_WORD = "word";
	private static final String KEY_WORD_TRANSLATION = "translation";
	private static final String KEY_CATEGORY = "category";
	private static final String KEY_WordOrPhrase = "word_Or_phrase";
	private static final String KEY_AudioFile = "audiofile";

	// Word create Statements

	private static final String CREATE_TABLE_WORD = " CREATE TABLE "
			+ TABLE_WORD + "(" + KEY_ID + " INTEGER PRIMARY KEY ," + KEY_WORD
			+ " TEXT," + KEY_WORD_TRANSLATION + " TEXT," + KEY_WordOrPhrase
			+ " integer," + KEY_AudioFile + " TEXT," + KEY_CATEGORY + " TEXT "
			+ ")";

	// Notes Table lessons_words

	private static final String KEY_LESSON_PICTURE_ID = "picture_id";
	private static final String KEY_LESSON_COMPLETED = "completed";
	private static final String KEY_LESSON_ID = "lessonId";
	private static final String KEY_LESSON_WORD_ID = "word_id";

	// Lesson_word create statement
	private static final String CREATE_TABLE_LESSON_WORD = " CREATE TABLE "
			+ TABLE_LESSON_WORD + "(" + KEY_LESSON_ID + " TEXT, "
			+ KEY_LESSON_PICTURE_ID + " Integer, " + KEY_LESSON_WORD_ID
			+ " integer , " + KEY_LESSON_COMPLETED + " integer  " + ")";

	// Notes Table Pictures
	private static final String KEY_PICTURE_LOCATION = "fileLocation";
	private static final String KEY_PICTURE_FILENAME = "fileName";
	private static final String KEY_PICTURE_TRANSLATION = "picture_translation";

	// PICTURE create statement
	private static final String CREATE_TABLE_PICTURE = "CREATE TABLE "
			+ TABLE_PICTURE + "(" + KEY_ID + " integer PRIMARY KEY,"
			+ KEY_PICTURE_LOCATION + " TEXT," + KEY_PICTURE_FILENAME + " TEXT,"
			+ KEY_PICTURE_TRANSLATION + " TEXT ," + KEY_CATEGORY + " TEXT "
			+ ")";

	// User_lesson

	// Notes Table User_lesson

	private static final String KEY_USER_ID = "user_id";
	private static final String KEY_COMPLETED = "lesson_id";

	// PICTURE create statement

	private static final String CREATE_TABLE_USER_LESSON = "CREATE TABLE "
			+ TABLE_USER_LESSON + "(" + KEY_USER_ID + " integer,"
			+ KEY_LESSON_ID + " integer," + KEY_COMPLETED + " integer " + ")";

	// Markers
	private static final String KEY_MARKERS_ADDRESS = "address";
	private static final String KEY_MARKERS_LONGITUDE = "longitude";
	private static final String KEY_MARKERS_LATITUDE = "latitude";
	private static final String KEY_MARKERS_NAME = "name";

	private static final String CREATE_TABLE_MARKERS = "CREATE TABLE "
			+ TABLE_MARKERS + "(" + KEY_USER_ID + " NTEGER PRIMARY KEY," 
			+ KEY_MARKERS_ADDRESS + " text,"
			+ KEY_MARKERS_LONGITUDE + " real," 
			+ KEY_MARKERS_LATITUDE + " real," 
			+ KEY_MARKERS_NAME + " Text " + ")";

	// private static final String LOG = DatabaseHandler.class.getName();
	// Database Version
	private static final int DATABASE_VERSION = 6;

	// Database Name
	private static final String DATABASE_NAME = "jamaicaDictionary";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// creating required tables
		db.execSQL(CREATE_TABLE_WORD);
		db.execSQL(CREATE_TABLE_USER);
		db.execSQL(CREATE_TABLE_MARKERS);
		db.execSQL(CREATE_TABLE_PICTURE);
		db.execSQL(CREATE_TABLE_USER_LESSON);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_LESSON);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKERS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PICTURE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORD);

		// create table
		onCreate(db);
	}

	// ------------------------Word Table CRUD(Create,Read,Update,Delete)
	// Method----------------//

	public void createWord(Word word) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_WORD, word.getWord());
		values.put(KEY_WordOrPhrase, word.getWord_or_phrase());
		values.put(KEY_AudioFile, word.getAudiofile());
		values.put(KEY_WORD_TRANSLATION, word.getTranslation());
		values.put(KEY_CATEGORY, word.getCategory());

		db.insert(TABLE_WORD, null, values);
		db.close();
	}

	public List<Word> getAllWords() {
		List<Word> word = new ArrayList<Word>();
		String selectQuery = "SELECT * FROM " + TABLE_WORD;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Word t = new Word();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setWord(c.getString(c.getColumnIndex(KEY_WORD)));
				t.setCategory(c.getString(c.getColumnIndex(KEY_CATEGORY)));
				t.setTranslation(c.getString(c
						.getColumnIndex(KEY_WORD_TRANSLATION)));
				t.setAudiofile(c.getString(c.getColumnIndex(KEY_AudioFile)));
				// adding to tags list
				word.add(t);
			} while (c.moveToNext());
		}
		return word;
	}

	public Word find(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		List<Word> word = new ArrayList<Word>();
		String selectQuery = "SELECT * FROM " + TABLE_WORD + " Where id = "
				+ id;
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Word t = new Word();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setWord(c.getString(c.getColumnIndex(KEY_WORD)));
				t.setCategory(c.getString(c.getColumnIndex(KEY_CATEGORY)));
				t.setTranslation(c.getString(c
						.getColumnIndex(KEY_WORD_TRANSLATION)));
				t.setAudiofile(c.getString(c.getColumnIndex(KEY_AudioFile)));
				word.add(t);
			} while (c.moveToNext());
		}

		return word.get(0);
	}

	public int updateWord(Word word) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_WORD, word.getWord());
		values.put(KEY_WordOrPhrase, word.getWord_or_phrase());
		values.put(KEY_AudioFile, word.getTranslation());
		values.put(KEY_WORD_TRANSLATION, word.getTranslation());
		values.put(KEY_CATEGORY, word.getCategory());

		// updating row
		return db.update(TABLE_WORD, values, KEY_ID + " = ?",
				new String[] { String.valueOf(word.getId()) });
	}

	// ------------------------Table Lesson CRUD(Create,Read,Update,Delete)
	// Method----------------//

	public boolean createLesson(Lesson lesson) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_LESSON_NAME, lesson.getLessonName());
		values.put(KEY_LESSON_DETAIL, lesson.getLessonDetail());
		values.put(KEY_LESSON_PROGRESS, lesson.getProgress());

		long id = db.insert(TABLE_LESSON, null, values);

		if (id != 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Lesson> getAllLessons() {
		List<Lesson> lesson = new ArrayList<Lesson>();
		String selectQuery = "SELECT * FROM " + TABLE_LESSON;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Lesson t = new Lesson();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setLessonDetail(c.getString(c
						.getColumnIndex(KEY_LESSON_DETAIL)));
				t.setLessonName(c.getString(c.getColumnIndex(KEY_LESSON_NAME)));
				t.setProgress(c.getFloat(c.getColumnIndex(KEY_LESSON_PROGRESS)));
				// adding to tags list
				lesson.add(t);
			} while (c.moveToNext());
		}
		return lesson;
	}

	public Lesson findLesson(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		List<Lesson> x = new ArrayList<Lesson>();
		String selectQuery = "SELECT * FROM " + TABLE_LESSON + " Where id = "
				+ id;
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Lesson t = new Lesson();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setLessonDetail(c.getString(c
						.getColumnIndex(KEY_LESSON_DETAIL)));
				t.setLessonName(c.getString(c.getColumnIndex(KEY_LESSON_NAME)));
				t.setProgress(c.getFloat(c.getColumnIndex(KEY_LESSON_PROGRESS)));
				// adding to tags list
				x.add(t);
			} while (c.moveToNext());
		}
		return x.get(0);
	}

	public int updateLesson(Lesson x) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_ID, x.getId());
		values.put(KEY_LESSON_NAME, x.getLessonName());
		values.put(KEY_LESSON_DETAIL, x.getLessonDetail());
		values.put(KEY_LESSON_PROGRESS, x.getProgress());

		// updating row
		return db.update(TABLE_LESSON, values, KEY_ID + " = ?",
				new String[] { String.valueOf(x.getId()) });
	}

	// ------------------------Table User CRUD(Create,Read,Update,Delete)
	// Method----------------//

	public boolean createUser(User x) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_USER_PASSWORD, x.getPassword());
		values.put(KEY_USER_EMAIL, x.getEmail());

		long id = db.insert(TABLE_USER, null, values);

		if (id != 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> getAllUsers() {
		List<User> y = new ArrayList<User>();
		String selectQuery = "SELECT * FROM " + TABLE_USER;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				User x = new User();
				x.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				x.setEmail(c.getString((c.getColumnIndex(KEY_USER_EMAIL))));
				x.setPassword(c.getString((c.getColumnIndex(KEY_USER_PASSWORD))));
				y.add(x);
			} while (c.moveToNext());
		}
		return y;
	}

	public User findUser(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		List<User> y = new ArrayList<User>();
		String selectQuery = "SELECT * FROM " + TABLE_USER + " Where id = "
				+ id;
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				User x = new User();
				x.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				x.setEmail(c.getString((c.getColumnIndex(KEY_USER_EMAIL))));
				x.setPassword(c.getString((c.getColumnIndex(KEY_USER_PASSWORD))));
				// adding to tags list
				y.add(x);

				// adding to tags list
				y.add(x);
			} while (c.moveToNext());
		}
		return y.get(0);
	}

	public int updateUser(User x) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_ID, x.getId());
		values.put(KEY_USER_EMAIL, x.getEmail());
		values.put(KEY_USER_PASSWORD, x.getPassword());

		// updating row
		return db.update(TABLE_LESSON, values, KEY_ID + " = ?",
				new String[] { String.valueOf(x.getId()) });
	}

	// ------------------------Table Picture CRUD(Create,Read,Update,Delete)
	// Method----------------//

	public boolean createPicture(Picture x) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_PICTURE_FILENAME, x.getFile_Name());
		values.put(KEY_PICTURE_LOCATION, x.getPicture_Location());
		values.put(KEY_PICTURE_TRANSLATION, x.getTranslation());
		values.put(KEY_CATEGORY, x.getCategory());

		long id = db.insert(TABLE_PICTURE, null, values);

		if (id != 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Picture> getAllPictures() {
		List<Picture> y = new ArrayList<Picture>();
		String selectQuery = "SELECT * FROM " + TABLE_PICTURE;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Picture x = new Picture();
				x.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				x.setFile_Name(c.getString((c
						.getColumnIndex(KEY_PICTURE_FILENAME))));
				x.setPicture_Location(c.getString((c
						.getColumnIndex(KEY_PICTURE_LOCATION))));
				x.setTranslation(c.getString((c
						.getColumnIndex(KEY_PICTURE_TRANSLATION))));
				x.setCategory(c.getString((c.getColumnIndex(KEY_CATEGORY))));
				y.add(x);
			} while (c.moveToNext());
		}
		return y;
	}

	public Picture findPicture(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		List<Picture> y = new ArrayList<Picture>();
		String selectQuery = "SELECT * FROM " + TABLE_PICTURE + " Where id = "
				+ id;
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Picture x = new Picture();
				x.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				x.setFile_Name(c.getString((c
						.getColumnIndex(KEY_PICTURE_FILENAME))));
				x.setPicture_Location(c.getString((c
						.getColumnIndex(KEY_PICTURE_LOCATION))));
				x.setTranslation(c.getString((c
						.getColumnIndex(KEY_PICTURE_TRANSLATION))));
				// adding to tags list
				y.add(x);

				// adding to tags list
				y.add(x);
			} while (c.moveToNext());
		}
		return y.get(0);
	}

	public int updatePicture(Picture x) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_ID, x.getId());
		values.put(KEY_PICTURE_FILENAME, x.getFile_Name());
		values.put(KEY_PICTURE_LOCATION, x.getPicture_Location());
		values.put(KEY_PICTURE_TRANSLATION, x.getTranslation());
		values.put(KEY_CATEGORY, x.getCategory());

		// updating row
		return db.update(TABLE_PICTURE, values, KEY_ID + " = ?",
				new String[] { String.valueOf(x.getId()) });
	}

	// ------------------------ "Lesson_Word" table methods ----------------//
    /**
     *  @author Dacorie Smith Function to write to database
     *  **/
	public long createlessonWord(LessonWord x) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_LESSON_WORD_ID, x.getWord_id());
		values.put(KEY_LESSON_ID, x.getLesson_id());
		values.put(KEY_LESSON_COMPLETED, x.getCompleted());

		long id = db.insert(TABLE_LESSON_WORD, null, values);

		return id;
	}

	public List<LessonWord> getAllLessonWord() {
		List<LessonWord> y = new ArrayList<LessonWord>();
		String selectQuery = "SELECT * FROM " + TABLE_LESSON_WORD;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				LessonWord x = new LessonWord();
				x.setWord_id(c.getInt((c.getColumnIndex(KEY_ID))));
				x.setWord_id(c.getInt(c

						.getColumnIndex(KEY_LESSON_PICTURE_ID)));
				x.setCompleted(c.getInt(c.getColumnIndex(KEY_LESSON_COMPLETED)));
				x.setLesson_id(c.getInt(c.getColumnIndex(KEY_LESSON_ID)));
				y.add(x);
			} while (c.moveToNext());
		}
		return y;
	}

	public LessonWord findLessonWord(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		List<LessonWord> y = new ArrayList<LessonWord>();
		String selectQuery = "SELECT * FROM " + TABLE_LESSON_WORD
				+ " Where id = " + id;
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				LessonWord x = new LessonWord();
				x.setWord_id(c.getInt((c.getColumnIndex(KEY_ID))));
				x.setWord_id(c.getInt(c
						.getColumnIndex(KEY_LESSON_WORD_ID)));
				x.setCompleted(c.getInt(c.getColumnIndex(KEY_LESSON_COMPLETED)));
				x.setLesson_id(c.getInt(c.getColumnIndex(KEY_LESSON_ID)));
				y.add(x);
			} while (c.moveToNext());
		}
		return y.get(0);
	}

	public int updateLessoneWord(LessonWord x) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_LESSON_WORD_ID, x.getWord_id());

		values.put(KEY_LESSON_ID, x.getLesson_id());
		values.put(KEY_LESSON_COMPLETED, x.getCompleted());


		// updating row
		return db.update(TABLE_LESSON_WORD, values, KEY_LESSON_WORD_ID + " = ?",
				new String[] { String.valueOf(x.getWord_id()) });
	}

	/** 
	 * 
	 * @param id
	 * @param tableName
	 */
	
	public long createUserLesson(UserLesson x) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_USER_ID, x.getUser_id());
		values.put(KEY_LESSON_ID, x.getLesson_id());
		values.put(KEY_COMPLETED, x.isCompleted());

		long id = db.insert(TABLE_USER_LESSON, null, values);

		return id;
	}

	public List<UserLesson> getAllUserLesson() {
		List<UserLesson> y = new ArrayList<UserLesson>();
		String selectQuery = "SELECT * FROM " + TABLE_USER_LESSON;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				UserLesson x = new UserLesson();
				x.setUser_id(c.getInt((c.getColumnIndex(KEY_USER_ID))));
				x.setLesson_id(c.getInt(c
						.getColumnIndex(KEY_LESSON_ID)));
				x.setCompleted(c.getInt(c.getColumnIndex(KEY_COMPLETED)));
				y.add(x);
			} while (c.moveToNext());
		}
		return y;
	}

	public UserLesson findUserLesson(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		List<UserLesson> y = new ArrayList<UserLesson>();
		String selectQuery = "SELECT * FROM " + TABLE_USER_LESSON
				+ " Where id = " + id;
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				UserLesson x = new UserLesson();
				x.setUser_id(c.getInt((c.getColumnIndex(KEY_USER_ID))));
				x.setLesson_id(c.getInt(c
						.getColumnIndex(KEY_LESSON_WORD_ID)));
				x.setCompleted(c.getInt(c.getColumnIndex(KEY_COMPLETED)));
				y.add(x);
			} while (c.moveToNext());
		}
		return y.get(0);
	}

	public int updateLessoneWord(UserLesson x) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_USER_ID, x.getUser_id());
		values.put(KEY_LESSON_ID, x.getLesson_id());
		values.put(KEY_COMPLETED, x.isCompleted());


		// updating row
		return db.update(TABLE_USER_LESSON, values, KEY_LESSON_ID + " = ?",
				new String[] { String.valueOf(x.getLesson_id()) });
	}
	
	
	/**
	 * 
	 * @param id
	 * @param tableName
	 */
	
	public void createMarker(Marker marker) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_MARKERS_ADDRESS, marker.getAddress());
		values.put(KEY_MARKERS_LATITUDE, marker.getLatitude());
		values.put(KEY_MARKERS_LONGITUDE, marker.getLongitude());
		values.put(KEY_MARKERS_NAME, marker.getName());

		db.insert(TABLE_WORD, null, values);
		db.close();
	}

	public List<Marker> getAllMarker() {
		List<Marker> word = new ArrayList<Marker>();
		String selectQuery = "SELECT * FROM " + TABLE_WORD;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Marker t = new Marker();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setAddress(c.getString(c.getColumnIndex(KEY_MARKERS_ADDRESS)));
				t.setLatitude(c.getFloat(c.getColumnIndex(KEY_MARKERS_LATITUDE)));
				t.setLongitude(c.getFloat(c
						.getColumnIndex(KEY_MARKERS_LONGITUDE)));
				t.setName(c.getString(c.getColumnIndex(KEY_MARKERS_NAME)));
				word.add(t);
			} while (c.moveToNext());
		}
		return word;
	}

	public Marker findMarker(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		List<Marker> word = new ArrayList<Marker>();
		String selectQuery = "SELECT * FROM " + TABLE_MARKERS + " Where id = "
				+ id;
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Marker t = new Marker();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setAddress(c.getString(c.getColumnIndex(KEY_MARKERS_ADDRESS)));
				t.setLatitude(c.getFloat(c.getColumnIndex(KEY_MARKERS_LATITUDE)));
				t.setLongitude(c.getFloat(c
						.getColumnIndex(KEY_MARKERS_LONGITUDE)));
				t.setName(c.getString(c.getColumnIndex(KEY_MARKERS_NAME)));
				word.add(t);
			} while (c.moveToNext());
		}

		return word.get(0);
	}

	public int updateMarker(Marker marker) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, marker.getId());
		values.put(KEY_MARKERS_ADDRESS, marker.getAddress());
		values.put(KEY_MARKERS_LATITUDE, marker.getLatitude());
		values.put(KEY_MARKERS_LONGITUDE, marker.getLongitude());
		values.put(KEY_MARKERS_NAME, marker.getName());


		// updating row
		return db.update(TABLE_LESSON_WORD, values, KEY_ID + " = ?",
				new String[] { String.valueOf(marker.getId()) });
	}
	
	
	
	// ------------- Additional Database function -------//

	public int delete(int id, String tableName) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(tableName, KEY_ID + " = ?",new String[] { String.valueOf(id) });
	}
	
	public String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());

		Date date = new Date();
		return dateFormat.format(date);
	}

	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen())
			db.close();
	}
}
