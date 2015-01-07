package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import java.util.List;


/**
 * Created by Dacorie Smith on 10/9/13.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

	private static final String TABLE_WORD = "word";

	// Column column name
	private static final String KEY_ID = "id";

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

	// private static final String LOG = DatabaseHandler.class.getName();
	// Database Version
	private static final int DATABASE_VERSION = 7;

	// Database Name
	private static final String DATABASE_NAME = "jamaicaDictionary";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// creating required tables
		db.execSQL(CREATE_TABLE_WORD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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


	/** 
	 * 
	 * @param id
	 * @param tableName
	 */
}
