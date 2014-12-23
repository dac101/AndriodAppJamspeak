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
        words.add(new Word("ackee",
                "African fruit introduced in Jamaica in 1778", "food", 1, ""));
        words.add(new Word("Bulla ", "Cake", "food", 1, ""));
        words.add(new Word("Nyam  ", "To eat. Mek wi nyam. (Lets eat.)",
                "food", 1, ""));
        words.add(new Word("Nyami  ", "Expression of one who eats too much.",
                "food", 1, ""));

        /**
         * Greeting
         */
        words.add(new Word("Yeh ", "Yes", "greeting", 1, ""));
        words.add(new Word("Wappun ","What�s happening? This is "
                + "the most popular greeting used. Always say this instead of "
                + "the American, �What�s up.�", "greeting", 1, ""));
        words.add(new Word("Wa (wah) ", "What", "greeting", 1, ""));
        words.add(new Word("Tanks", "Thank", "greeting", 1, ""));
        words.add(new Word("My yute",
                "- My youth. Friendly expression of calling a friend "
                        + "or youger one. Hey my yute. (Hey my friend).",
                "greeting", 1, ""));
        words.add(new Word("More time ",
                "Popular expression for saying good-bye."
                        + " This must be said with power and voice."
                        + " More time! (Later!)", "greeting", 1, ""));
        words.add(new Word("Link up ",
                "Slang for �Hooking up�; getting or meeting together, ect."
                        + " Mi link yu up layta."
                        + " (I�ll get with you later.)", "greeting", 1, ""));
        words.add(new Word("Lickle more", "- A saying of goodbye.", "greeting",
                1, ""));
        words.add(new Word(
                "Jah guide",
                "A Rasta farewell and good-bye. Literally says that �God shall guide.�",
                "A saying of goodbye.", 1, ""));
        words.add(new Word(
                "Inna di lights ",
                "Expression to say tomorrow. See you inna di lights. (See you tomorrow.)",
                "greeting", 1, ""));
        words.add(new Word(
                "Irie (I-ree) ",
                "Means everything is alright. Expression of feeling great and cool",
                "greeting", 1, ""));

        /**
         * Things
         */
        words.add(new Word(
                "Mon ",
                "Perhaps the single most important Jamaican word, "
                        + "�Mon� can represent every person in Jamaica�man, woman,"
                        + " and child.", "things", 1, ""));
        words.add(new Word(
                "Mash it up ",
                "Expression of doing well; like, �Break a leg�; be a big success.",
                "things", 1, ""));
        words.add(new Word(
                "Leggo",
                "To let go; leave, let�s go. She leggo har numba. (She gave out her number.)",
                "things", 1, ""));
        words.add(new Word("Jamdown", "Word for Jamaica.", "things", 1, ""));
        words.add(new Word("Higgla",
                "A street vendor; comes from the British word higgler.",
                "things", 1, ""));
        words.add(new Word("Fren", "Friend", "things", 1, ""));
        words.add(new Word(
                "Fimi",
                " fi she, fi yu, fi �Im Mine, hers, yours, his. Shows possession. A fi mi cyar. (My car). Fi dem. (Theirs.)",
                "things", 1, ""));

        for (Word x : words) {
            db.createWord(x);
        }
    }
}

