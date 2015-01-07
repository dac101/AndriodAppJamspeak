package database;

import java.util.ArrayList;

/**
 * Created by dacorie on 19/12/2014.
 */

public class DatabaseInfo {

    public Word word;
    public ArrayList<Word> words;
    public DatabaseHandler db;

    public DatabaseInfo(DatabaseHandler db) {
        this.db = db;
    }

    public void insertWords() {
        words = new ArrayList<Word>();
        /**
         * Foodss
         */
        words.add(new Word("ackee", "African fruit introduced in Jamaica in 1778", "Foods", 1, ""));
        words.add(new Word("Bulla ", "Cake", "Foods", 1, ""));
        words.add(new Word("Nyam  ", "To eat. Mek wi nyam. (Lets eat.)", "Foods", 1, ""));
        words.add(new Word("Nyami  ", "Expression of one who eats too much.", "Foods", 1, ""));

        /**
         * Greetings
         */
        words.add(new Word("Yeh ", "Yes", "Greetings", 1, ""));
        words.add(new Word("Wappun ", "What's happening? ", "Greetings", 1, ""));
        words.add(new Word("Wah ", "What", "Greetings", 1, ""));
        words.add(new Word("Tanks", "Thank", "Greetings", 1, ""));
        words.add(new Word("My yute", " My youth. Friendly expression of calling a friend.", "Greetings", 1, ""));
        words.add(new Word("More time ", "Popular expression for saying good-bye.", "Greetings", 1, ""));
        words.add(new Word("Link up ", "Slang for Hooking up.", "Greetings", 1, ""));
        words.add(new Word("Likkle more", "A saying of goodbye.", "Greetings", 1, ""));
        words.add(new Word("Jah guide", "A Rasta farewell and good-bye. means God shall guide.", "Greetings", 1, ""));
        words.add(new Word("Inna di lates ", "Expression to say tomorrow", "Greetings", 1, ""));
        words.add(new Word("Irie", "Means everything is alright.", "Greetings", 1, ""));

        /**
         * Things
         */
        words.add(new Word("Mon", " can represent every person  man, woman,and child.", "Things", 1, ""));
        words.add(new Word("Mash it up ", "Expression of doing well", "Things", 1, ""));
        words.add(new Word("Leggo", "To let go", "Things", 1, ""));
        words.add(new Word("Jamdown", "Word for Jamaica.", "Things", 1, ""));
        words.add(new Word("Higgla", "A street vendor.", "Things", 1, ""));
        words.add(new Word("Fren", "Friend", "Things", 1, ""));
        words.add(new Word("Fimi", " Shows possession. A fi mi car.", "Things", 1, ""));


        for (Word x : words) {
            db.createWord(x);
        }
    }
}

