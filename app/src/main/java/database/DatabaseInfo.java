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
         * Foods
         */
        words.add(new Word("ackee", "African fruit introduced in Jamaica in 1778", "Foods", 1, ""));
        words.add(new Word("Bulla ", "Cake", "Foods", 1, ""));
        words.add(new Word("Nyam  ", "To eat. Mek wi nyam. (Lets eat.)", "Foods", 1, ""));
        words.add(new Word("Nyami  ", "Expression of one who eats too much.", "Foods", 1, ""));
        words.add(new Word("BAMMY ", " a pancake made out of cassava.", "Foods", 1, ""));

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
        words.add(new Word("Agony", "The sensations felt during sex.", "Greetings", 1, ""));
        words.add(new Word("babylon", "the corrupt establishment, the system, Church and  State", "Greetings", 1, ""));
        words.add(new Word("bad", " good, great", "Greetings", 1, ""));
        words.add(new Word("badness", " hooligan behavior, violence for its own sake", "Greetings", 1, ""));
        words.add(new Word("bafan", "clumsy; awkward  ", "Greetings", 1, ""));
        words.add(new Word("baggy", " underpants for a woman or child. ", "Greetings", 1, ""));
        words.add(new Word("bald Head", "one without dreadlocks. ", "Greetings", 1, ""));
        words.add(new Word("bandulu", "ne without dreadlocks. ", "Greetings", 1, ""));
        words.add(new Word("bangarang", "uproar, disorder, disturbance. ", "Greetings", 1, ""));
        words.add(new Word("bex", " vex (verb), or vexed (adjective).", "Greeting", 1, ""));
        words.add(new Word("bly", " chance, must get a bly, must get a chance", "Greeting", 1, ""));
        words.add(new Word("bredren", " one's fellow male Rastas ", "Greeting", 1, ""));
        words.add(new Word("brindle", " to be angry ", "Greeting", 1, ""));
        words.add(new Word("bun", "to have one's spouse or girl/boy-friend cheat on oneself ", "Greeting", 1, ""));
        words.add(new Word("cease & sekkle", "stop everything and relax!", "Greeting", 1, ""));
        words.add(new Word("cha & cho", " a disdainful expletive  pshaw!  very common, mild explanation    expressing impatience, vexation or disappointment", "Greeting", 1, ""));
        words.add(new Word("chakachaka", "messy, disorderly, untidy.", "Greeting", 1, ""));
        words.add(new Word("chalice", " a pipe for smoking herb, usually made from coconut shell and tubing, used ritually by Rastas .", "Greeting", 1, ""));

        /**.
         * Things
         */
        words.add(new Word("Monn", " can represent every person  man, woman,and child.", "Things", 1, ""));
        words.add(new Word("Mash it up ", "Expression of doing well", "Things", 1, ""));
        words.add(new Word("Leggo", "To let go", "Things", 1, ""));
        words.add(new Word("Jamdown", "Word for Jamaica.", "Things", 1, ""));
        words.add(new Word("Higgla", "A street vendor.", "Things", 1, ""));
        words.add(new Word("Fren", "Friend", "Things", 1, ""));
        words.add(new Word("Fimi", " Shows possession. A fi mi car.", "Things", 1, ""));
        words.add(new Word("bat", "  butterfly or moth. English bat, the flying rodent, is a rat-bat.", "Things", 1, ""));
        words.add(new Word("batty", "bottom; backside; anus.", "Things", 1, ""));
        words.add(new Word("coil", "money", "Greeting", 1, ""));
        words.add(new Word("chimmy", "chamber pot", "Greeting", 1, ""));
        words.add(new Word("cool runnings", "a greeting; things are going smoothly ", "Things", 1, ""));
        words.add(new Word("coolie", "the traditional Jamaican epithet for East Indians", "Things", 1, ""));
        words.add(new Word("craven", "greedy", "Things", 1, ""));
        words.add(new Word("cris", "crisp; popularly used for anything brand-new, slick-looking.", "Things", 1, ""));
        words.add(new Word("crosses", "problems, vexations, trials; bad luck, misfortunes", "Things", 1, ""));
        words.add(new Word("crucial", "serious, great, hard, dread  ", "Things", 1, ""));

        words.add(new Word("dada", "father", "Things", 1, ""));
        words.add(new Word("cuss-cuss", "a quarrel or fracas, with lots of cursing.", "Things", 1, ""));
        words.add(new Word("dandada", "the highest of DON'S   ", "Things", 1, ""));
        words.add(new Word("dawta", "a girl, woman, sister, girlfriend  ", "Things", 1, ""));
        words.add(new Word("don", "one who is respected, master of a situation  ", "Things", 1, ""));
        words.add(new Word("donkya", "from don't care; careless, sloppy, lacking ambition", "Things", 1, ""));
        words.add(new Word("deh", "here  ", "Things", 1, ""));
        words.add(new Word("di", "the  ", "Things", 1, ""));
        words.add(new Word("dis", "this", "Things", 1, ""));
        words.add(new Word("dis-ya", "this ", "Things", 1, ""));
        words.add(new Word("djew", "It means a light rain or drizzle.", "Things", 1, ""));
        words.add(new Word("dread", "a person with dreadlocks ", "Things", 1, ""));
        words.add(new Word("duck-ants", " white ants, or termites. ", "Things", 1, ""));
        words.add(new Word("duppy", "a ghost  ", "Things", 1, ""));
        words.add(new Word("dutchy", "  dutch cooking pot, low round-bottomed heavy pot. ", "Things", 1, ""));
        words.add(new Word("ease-up", " to forgive, to lighten up  ", "Things", 1, ""));
        words.add(new Word("fassy", "eczema-like scratchy sores on the skin; also a verb meaning to cause    oneself to be covered with fassy by scratchin", "Things", 1, ""));
        words.add(new Word("fayva", " to favour, resemble, or look like;", "Things", 1, ""));
        words.add(new Word("feel no way", " don't take offense, don't be sorry, don't worry", "Things", 1, ""));
        words.add(new Word("fenky-fenky", "   (from finicky) choosy, proud, stuck-up.", "Things", 1, ""));
        words.add(new Word("fiesty", " impudent, rude, out of order, cheeky.", "Things", 1, ""));
        words.add(new Word("first light", "tomorrow     ", "Things", 1, ""));
        words.add(new Word("forward", "   1. to go, move on, set out 2. in the future      ", "Things", 1, ""));
        words.add(new Word("fullness", "completely, absolutely, totally", "Things", 1, ""));
        words.add(new Word("funds", "money ", "Things", 1, ""));
        words.add(new Word("crucial", "serious, great, hard, dread  ", "Things", 1, ""));
        words.add(new Word("crucial", "serious, great, hard, dread  ", "Things", 1, ""));
        words.add(new Word("crucial", "serious, great, hard, dread  ", "Things", 1, ""));
        words.add(new Word("crucial", "serious, great, hard, dread  ", "Things", 1, ""));
        words.add(new Word("crucial", "serious, great, hard, dread  ", "Things", 1, ""));
        words.add(new Word("crucial", "serious, great, hard, dread  ", "Things", 1, ""));











        for (Word x : words) {
            db.createWord(x);
        }
    }
}

