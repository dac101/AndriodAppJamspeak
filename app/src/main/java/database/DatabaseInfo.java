package database;

import java.util.ArrayList;

/**
 * Created by dacorie on 19/12/2014.
 */

public class DatabaseInfo {

    public ArrayList<Word> words;
    public ArrayList<Marker> markers;
    public DatabaseHandler db;

    public DatabaseInfo(DatabaseHandler db) {
        this.db = db;
    }

    public void insertWords() {
        words = new ArrayList<Word>();
        markers = new ArrayList<Marker>();
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
        words.add(new Word("bandulu", "bandit or criminal", "Greetings", 1, ""));
        words.add(new Word("bangarang", "uproar, disorder, disturbance. ", "Greetings", 1, ""));
        words.add(new Word("bex", " vex (verb), or vexed (adjective).", "Greeting", 1, ""));
        words.add(new Word("bly", " chance, must get a bly, must get a chance", "Greeting", 1, ""));
        words.add(new Word("bredren", " one's fellow male Rastas ", "Greeting", 1, ""));
        words.add(new Word("brindle", " to be angry ", "Greeting", 1, ""));
        words.add(new Word("bun", "to have one's spouse  cheat on oneself ", "Greeting", 1, ""));
        words.add(new Word("cease & sekkle", "stop everything and relax!", "Greeting", 1, ""));
        words.add(new Word("cha & cho", " expressing impatience, vexation or disappointment", "Greeting", 1, ""));
        words.add(new Word("chakachaka", "messy, disorderly, untidy.", "Greeting", 1, ""));
        words.add(new Word("chalice", " A pipe for smoking herb", "Greeting", 1, ""));

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
        words.add(new Word("bat", "  butterfly or moth", "Things", 1, ""));
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
        words.add(new Word("fassy", "Someone who is irritating or has done something to offend you.", "Expression", 1, ""));
        words.add(new Word("fayva", " to favour, resemble, or look like;", "Things", 1, ""));
        words.add(new Word("feel no way", " don't take offense, don't be sorry, don't worry", "Things", 1, ""));
        words.add(new Word("fenky-fenky", "(from finicky) choosy, proud, stuck-up.", "Things", 1, ""));
        words.add(new Word("fiesty", " impudent, rude, out of order, cheeky.", "Things", 1, ""));
        words.add(new Word("first light", "tomorrow     ", "Things", 1, ""));
        words.add(new Word("forward", "   1. to go, move on, set out 2. in the future      ", "Things", 1, ""));
        words.add(new Word("fullness", "completely, absolutely, totally", "Things", 1, ""));
        words.add(new Word("ganja", "herb, marijuana  ", "Things", 1, ""));
        words.add(new Word("gansey ", "t-shirt, any knit shirt , great, hard, dread  ", "Things", 1, ""));
        words.add(new Word("general ", "cool operator ", "Things", 1, ""));
        words.add(new Word("grindsman ", "one who displays great prowess in bed", "Things", 1, ""));
        words.add(new Word("haffi ", "to have to. ", "Things", 1, ""));
        words.add(new Word("hail ", " a greeting  ", "Things", 1, ""));
        words.add(new Word("hard ", "excellent, proficient, skillful, uncompromising  ", "Things", 1, ""));
        words.add(new Word("hiez-haad   ", " ears-hard, thick skulled, stubborn or unwilling", "Things", 1, ""));
        words.add(new Word("hitey-titey  ", " upper class, high tone, stoosh.", "Things", 1, ""));
        words.add(new Word("hot-stepper", " fugitive from jail or gun court ", "Things", 1, ""));
        words.add(new Word("ignorant ", " short-tempered, easy to vex, irate. ", "Things", 1, ""));
        words.add(new Word("jammin ", "to be having a good time, to be dancing calypso/soca ", "Things", 1, ""));
        words.add(new Word("jah know   ", " lord knows   ", "Things", 1, ""));
        words.add(new Word("jah ", "god", "Things", 1, ""));
        words.add(new Word("jelly ", "  a young coconut, full of jelly.  ", "Things", 1, ""));
        words.add(new Word("janga ", " shrimp, crayfish.", "Things", 1, ""));
        words.add(new Word("jook", "to pierce or stick, as with a thorn or a long pointed sti", "Things", 1, ""));
        words.add(new Word("judgin", "adjective, everyday or ordinary clothes or shoes worn in the yard  ","Things", 1, ""));
        words.add(new Word("kallaloo ", "a dark, green leafy vegetable, very nutritious and cheap.   ", "Things", 1, ""));
        words.add(new Word("kiss me neck!", "common exclamation of surprise.  ", "Things", 1, ""));
        words.add(new Word("Kiss teet", "hissing noise of disappoval, dislike, vexation or disappointment", "Things", 1, ""));
        words.add(new Word("ku deh! ", "look at", "Things", 1, ""));
        words.add(new Word("ku ya!", "look here!  ", "Expression", 1, ""));

        words.add(new Word("ku", "look ", "Expression", 1, ""));
        words.add(new Word("kya ", "to care; donkya, don't care, careless;  ", "Expression", 1, ""));
        words.add(new Word("kyaan", "can't  ", "Expression", 1, ""));
        words.add(new Word("Kyai", "to carry ", "Expression", 1, ""));
        words.add(new Word("kyan ", "can", "Expression", 1, ""));
        words.add(new Word("laba-laba", "to chat,gab;gossip", "Expression", 1, ""));
        words.add(new Word("labrish", "gossip,chit-chat ", "Expression", 1, ""));
        words.add(new Word("large ", "respected ", "Expression", 1, ""));
        words.add(new Word("leggo beas", "wild, disorderly, like a let-go beast ", "Expression", 1, ""));
        words.add(new Word("licky-licky", "fawning,flattering,obsequious", "Expression", 1, ""));
        words.add(new Word("lilly bit ", "little bit, tiny", "Expression", 1, ""));
        words.add(new Word("(too) likky-likky", "look here!  ", "Expression", 1, ""));
        words.add(new Word("maama man", "a gay person, an effeminate man, a weakling   ", "Expression", 1, ""));
        words.add(new Word("maca ", "thorn, prickle.   ", "Expression", 1, ""));
        words.add(new Word("madda ", "mother", "Expression", 1, ""));
        words.add(new Word("maga dog ", "    mongrel  ", "Expression", 1, ""));
        words.add(new Word("maga ", "thin", "Expression", 1, ""));
        words.add(new Word("marina ", "look here!  ", "a man's undershirt, guernsey; a tank-top style", 1, ""));
        words.add(new Word("no true? ", "isn't it so?   ", "Expression", 1, ""));
        words.add(new Word("monks  ", "amongst", "Expression", 1, ""));
        words.add(new Word("mash up, mash down  ", "destroy", "Expression", 1, ""));

        words.add(new Word("no kya  ", " no matter, as in no kya weh im tun, no matter where he turns.   ", "Expression", 1, ""));
        words.add(new Word("obeah   ", " traditional african science", "Expression", 1, ""));
        words.add(new Word("ongle   ", "only", "Expression", 1, ""));
        words.add(new Word("patu   ", "owl", "Expression", 1, ""));
        words.add(new Word("peenywally   ", "a kind of large fire fly, actually a type of flying beetle", "Expression", 1, ""));
        words.add(new Word("peer   ", "avocado pear", "Expression", 1, ""));
        words.add(new Word("picky  ", " brush haircut ", "Expression", 1, ""));
        words.add(new Word("picky-picky  ", "finicky or choosy ", "Expression", 1, ""));
        words.add(new Word("pikny   ", "child", "Thing", 1, ""));
        words.add(new Word("pinda   ", "peanut", "Expression", 1, ""));
        words.add(new Word("polytricks   ", "politicians", "Expression", 1, ""));
        words.add(new Word("poppy-show    ", " make fun of someone", "Expression", 1, ""));
        words.add(new Word("pum-pum    ", "a woman's genitals", "Expression", 1, ""));
        words.add(new Word("punaani or punni   ", "  a woman's genitals ", "Expression", 1, ""));
        words.add(new Word("puttin' away   ", "a preposition, meaning except for, or except.", "Expression", 1, ""));
        words.add(new Word("pyaa-pyaa     ", " sickly, weak; feeble, of no account. ", "Expression", 1, ""));
        words.add(new Word("raatid!   ", "a common mild expletive of surprise or vexation", "Expression", 1, ""));
        words.add(new Word("ranking   ", "  highly respected ", "Expression", 1, ""));
        words.add(new Word("ras or rass  ", " backside, rump", "Expression", 1, ""));
        words.add(new Word("(to) raas     ", "really?, damn!  ", "Expression", 1, ""));
        words.add(new Word("rat-bat  ", "bat, the night-flying rodent.", "Expression", 1, ""));

        words.add(new Word("renk ", " foul-smelling, raw-smelling or out of order", "Expression", 1, ""));
        words.add(new Word("rhaatid   ", "A curse-exclamation, similar to what the hell", "Expression", 1, ""));
        words.add(new Word("rockers  ", " reggae music  reggae music as it is played today, the latest sound", "Expression", 1, ""));
        words.add(new Word("roots", "derived from the experience of the common people, natural indigenous  ", "Expression", 1, ""));
        words.add(new Word("rude boy   ", "a criminal, a hard hearted person, a tough guy .", "Expression", 1, ""));
        words.add(new Word("ryal ", "royal", "Expression", 1, ""));
        words.add(new Word("salt ", " adjective, broke, empty-handed, low on funds or food.", "Expression", 1, ""));
        words.add(new Word("samfai man", " trickster, conman.   ", "Expression", 1, ""));
        words.add(new Word("satta ", "  sit, rest, meditate  relax  ", "Expression", 1, ""));
        words.add(new Word("science ", "    obeah, witchcraft   ", "Expression", 1, ""));
        words.add(new Word("screechie  ", "to sneak by   ", "Expression", 1, ""));
        words.add(new Word("sheg-up   ", " to be messed up, ruined   ", "Expression", 1, ""));

        words.add(new Word("sidung ", "  sit down    ", "Expression", 1, ""));
        words.add(new Word("sight?", "do you understand?   ", "Expression", 1, ""));
        words.add(new Word("sinkl-bible   ", " the aloevera plant.", "Expression", 1, ""));
        words.add(new Word("sister, sistren", "a woman, a friend, woman rastafarians ", "Expression", 1, ""));
        words.add(new Word("slackness ", " lewd, vulgar lyrics popular in dj singing   ", "Expression", 1, ""));
        words.add(new Word("so-so ", " to be messed up, ruined   ", "Expression", 1, ""));
        words.add(new Word("spliff ", " large, cone-shaped marijuana cigarette ", "Expression", 1, ""));
        words.add(new Word("step ", "to leave, to depart  briskly, quickly ", "Expression", 1, ""));

        words.add(new Word("stoosh ", " upper class, high tone, hitey-titey. ", "Expression", 1, ""));
        words.add(new Word("sufferer  ", "a poor person stuggling to survive", "Expression", 1, ""));
        words.add(new Word("tall  ", "long ", "Expression", 1, ""));
        words.add(new Word("teif  ", " a theif, to steal", "Expression", 1, ""));
        words.add(new Word("trace  ", " to curse or speak abusively to someone ", "Expression", 1, ""));
        words.add(new Word("tumpa  ", "from stump, as in tumpa-foot man, a one-foot man. ", "Expression", 1, ""));
        words.add(new Word("tunti  ", " female organ. ", "Expression", 1, ""));
        words.add(new Word("unu ", "  you-all. ", "Expression", 1, ""));
        words.add(new Word("uno ", "you-all.", "Expression", 1, ""));
        words.add(new Word("vex ", "to leave, to depart  briskly, quickly ", "Expression", 1, ""));


        words.add(new Word("wa day ", " the other day ", "Expression", 1, ""));
        words.add(new Word("wa mek?", "why?", "Expression", 1, ""));
        words.add(new Word("wanga-gut   ", " hungry-belly", "Expression", 1, ""));
        words.add(new Word("wheels  ", "vehicle", "Expression", 1, ""));
        words.add(new Word("whole heap  ", "a lot ", "Expression", 1, ""));
        words.add(new Word("winjy   ", "thin and sickly looking ", "Expression", 1, ""));
        words.add(new Word("wis ", " vine, liana, from withe. ", "Expression", 1, ""));
        words.add(new Word("ya no see it?  ", "you know?", "Expression", 1, ""));
        words.add(new Word("ya", "hear, or here.", "Expression", 1, ""));
        words.add(new Word("yabba ", " a big clay pot.", "Expression", 1, ""));


        words.add(new Word("yabba  ", " a big clay pot.", "Expression", 1, ""));
        words.add(new Word("yahso   ", " home, one's gates  tenement.", "Expression", 1, ""));
        words.add(new Word("youth   ", "  a child, a young man, an immature man", "Expression", 1, ""));
        words.add(new Word("zion   ", "  ethiopia, africa, the rastafarian holy land.", "Expression", 1, ""));
        words.add(new Word("zungu pan   ", "   zinc pan", "Expression", 1, ""));


        /*Place */
        markers.add(new Marker("discovery bay St.ann",-77.3995230,18.4603030,"Antonet Bar","antonetbar@gmail.com","antonetbar.com","813-1787",1,"Sports bar"));
        markers.add(new Marker("Appleton Estate",-77.7529073,18.1640921,"Appleton Sugar and Rum Factory","","","(876) 963-9215",1,"Agriculture"));
        markers.add(new Marker("Discovery Bay ",-77.374478,18.460723,"green grotto caves ","","","",1,"Beach"));
        markers.add(new Marker("Ocho Rios",-77.134854,18.414845,"Dunn's River Falls  ","","","",1,"Beach"));
        markers.add(new Marker("Ocho Rios",-77.13036,18.417266,"Dolphin Cove","","","",1,"Beach"));
        markers.add(new Marker("Falmouth",-77.62835,18.48295,"Glistening Waters ","","","",1,"Restaurant"));
        markers.add(new Marker("Ocho Rios",-77.125971,18.414132,"Mystic Mountain","","","",1,"Beach"));
        markers.add(new Marker("Portland",-76.3869172,18.1702993,"Blue Lagoon","","","",1,"Beach"));

        for (Word x : words) {
            db.createWord(x);
        }

        for(Marker x : markers )
        {
            db.createMarker(x);
        }
    }
}

