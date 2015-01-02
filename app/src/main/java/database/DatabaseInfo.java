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
         * food
         */
        words.add(new Word("ackee","African fruit introduced in Jamaica in 1778", "food", 1, ""));
        words.add(new Word("Bulla ", "Cake", "food", 1, ""));
        words.add(new Word("Nyam  ", "To eat. Mek wi nyam. (Lets eat.)", "food", 1, ""));
        words.add(new Word("Nyami  ", "Expression of one who eats too much.","food", 1, ""));

        /**
         * Greeting
         */
        words.add(new Word("Yeh ", "Yes", "greeting", 1, ""));
        words.add(new Word("Wappun ","What's happening? ", "greeting", 1, ""));
        words.add(new Word("Wah ", "What", "greeting", 1, ""));
        words.add(new Word("Tanks", "Thank", "greeting", 1, ""));
        words.add(new Word("My yute"," My youth. Friendly expression of calling a friend.", "greeting", 1, ""));
        words.add(new Word("More time ","Popular expression for saying good-bye.","greeting", 1, ""));
        words.add(new Word("Link up ","Slang for Hooking up.", "greeting", 1, ""));
        words.add(new Word("Likkle more", "A saying of goodbye.", "greeting",  1, ""));
        words.add(new Word( "Jah guide","A Rasta farewell and good-bye. means God shall guide.","greeting", 1, ""));
        words.add(new Word("Inna di lates ","Expression to say tomorrow","greeting", 1, ""));
        words.add(new Word( "Irie","Means everything is alright.", "greeting", 1, ""));

        /**
         * Things
         */
        words.add(new Word("Mon"," can represent every person  man, woman,and child.", "things", 1, ""));
        words.add(new Word("Mash it up ", "Expression of doing well","things", 1, ""));
        words.add(new Word("Leggo","To let go", "things", 1, ""));
        words.add(new Word("Jamdown", "Word for Jamaica.", "things", 1, ""));
        words.add(new Word("Higgla","A street vendor.", "things", 1, ""));
        words.add(new Word("Fren", "Friend", "things", 1, ""));
        words.add(new Word("Fimi", " Shows possession. A fi mi car.","things", 1, ""));


        for (Word x : words) {
            db.createWord(x);
        }
    }
}

