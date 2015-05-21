package database;

import java.util.ArrayList;

import model.Marker;
import model.Word;

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
        //words.add(new Word("Ackee","national Dish","Foods", 1,""));
        words.add(new Word("Bulla","Cake","Foods", 1,""));
        words.add(new Word("Nyam","To eat","Foods", 1,""));
        words.add(new Word("Bammy","Cassava Pancake","Foods", 1,""));

        /**
         * Greetings
         */
        words.add(new Word("Yeh","Yes","Greetings", 1,""));
        words.add(new Word("Wappun","What's happening?","Greetings", 1,""));
        words.add(new Word("Wah","What or Wa mek","Greetings", 1,""));
        words.add(new Word("Tanks","Thank","Greetings", 1,""));
        words.add(new Word("My yute","My youth,Calling a friend.","Greetings", 1,""));
        words.add(new Word("More time","goodbye.","Greetings", 1,""));
        words.add(new Word("Link up","Slang for Hooking up.","Greetings", 1,""));
        words.add(new Word("Likkle more","A saying of goodbye.","Greetings", 1,""));
        words.add(new Word("Jah guide","God shall guide.","Greetings", 1,""));
        words.add(new Word("Inna di lates","To say Tomorrow","Greetings", 1,""));
        words.add(new Word("Irie","everything is alright","Greetings", 1,""));
        words.add(new Word("Agony","Sensations felt during sex.","Greetings", 1,""));
        words.add(new Word("Babylon","the System,Church, State","Greetings", 1,""));
        words.add(new Word("Bad","good, great","Greetings", 1,""));
        words.add(new Word("Badness","hooligan behavior","Greetings", 1,""));
        words.add(new Word("Bafan","clumsy; awkward","Greetings", 1,""));
        words.add(new Word("Baggy","word underpants .","Greetings", 1,""));
        words.add(new Word("Bald Head","one without dreadlocks.","Greetings", 1,""));
        //words.add(new Word("Bandulu","bandit or criminal","Greetings", 1,""));
        words.add(new Word("Bangarang","uproar, disturbance.","Greetings", 1,""));
        words.add(new Word("Bex","vex,or vexed.","Greeting", 1,""));
        words.add(new Word("Bly","chance","Greeting", 1,""));
        words.add(new Word("Bredren","one's fellow male Rastas","Greeting", 1,""));
        words.add(new Word("Brindle","to be angry","Greeting", 1,""));
        words.add(new Word("Bun","To cheat on one's spouse","Greeting", 1,""));
        words.add(new Word("Cease & sekkle","stop everything and relax!","Greeting", 1,""));
        words.add(new Word("Cha & cho","expressing impatience","Greeting", 1,""));
        words.add(new Word("Chakachaka","messy, disorderly.","Greeting", 1,""));
        words.add(new Word("Chalice","A pipe for smoking herb","Greeting", 1,""));

        /**.
         * Things
         */
        words.add(new Word("Monn","represent every person","Things", 1,""));
        words.add(new Word("Mash it up","Expression of doing well","Things", 1,""));
        words.add(new Word("Leggo","To let go","Things", 1,""));
        words.add(new Word("Jamdown","Word for Jamaica.","Things", 1,""));
        words.add(new Word("Higgla","A street vendor.","Things", 1,""));
        words.add(new Word("Fren","Friend","Things", 1,""));
        words.add(new Word("Fimi","Shows possession.","Things", 1,""));
        words.add(new Word("Batty","bottom; backside; anus.","Things", 1,""));
        words.add(new Word("Coil","money","Greeting", 1,""));
        words.add(new Word("Chimmy","chamber pot","Greeting", 1,""));
        words.add(new Word("Cool runnings","Things going smoothly","Things", 1,""));
        words.add(new Word("Coolie","East Indians","Things", 1,""));
        words.add(new Word("Craven","greedy ","Things", 1,""));
        words.add(new Word("Cris","anything brand new","Things", 1,""));
        words.add(new Word("Crosses","problems, misfortunes","Things", 1,""));
        words.add(new Word("Crucial","serious, great, hard, dread","Things", 1,""));

        words.add(new Word("Dada","father","Things", 1,""));
        words.add(new Word("Cuss Cuss","a quarrel .","Things", 1,""));
        words.add(new Word("Dandada","the highest of DON'S","Things", 1,""));
        words.add(new Word("Dawta","woman","Things", 1,""));
        words.add(new Word("Don","one who is respected","Things", 1,""));
        words.add(new Word("Donkya","careless,lacking ambition","Things", 1,""));
        words.add(new Word("Deh","here","Things", 1,""));
        words.add(new Word("Di","the","Things", 1,""));
        words.add(new Word("Dis ya","this","Things", 1,""));
        words.add(new Word("Djew","light rain or drizzle.","Things", 1,""));
        words.add(new Word("Dread","dreadlocks","Things", 1,""));
        words.add(new Word("Duck Ants","white ants, or termites.","Things", 1,""));
        words.add(new Word("Duppy","a ghost","Things", 1,""));
        words.add(new Word("Dutchy","heavy pot.","Things", 1,""));
        words.add(new Word("Ease up","to lighten up","Things", 1,""));
        words.add(new Word("Fassy","Someone has offend you.","Expression", 1,""));
        words.add(new Word("Fayva","look like;","Things", 1,""));
        words.add(new Word("Feel no way","don't worry","Things", 1,""));
        words.add(new Word("Fenky fenky","choosy, proud, stuck up.","Things", 1,""));
        words.add(new Word("Fiesty","rude, out of order.","Things", 1,""));
        words.add(new Word("First light","tomorrow","Things", 1,""));
        words.add(new Word("Forward","to go","Things", 1,""));
        words.add(new Word("Fullness"," absolutely","Things", 1,""));
        words.add(new Word("Ganja","herb, marijuana","Things", 1,""));
        words.add(new Word("Gansey","t-shirt","Things", 1,""));
      // words.add(new Word("general","cool operator","Things", 1,""));
        words.add(new Word("Grindsman","great prowess in bed","Things", 1,""));
        words.add(new Word("Haffi","to have to.","Things", 1,""));
        words.add(new Word("Hail","a greeting","Things", 1,""));
        words.add(new Word("Hard","excellent, proficient","Things", 1,""));
        words.add(new Word("Hiez haad","stubborn or unwilling","Things", 1,""));
        words.add(new Word("Hitey titey"," high tone, stoosh.","Things", 1,""));
        words.add(new Word("Hot stepper","fugitive from jail ","Things", 1,""));
        //words.add(new Word("ignorant","short-tempered","Things", 1,""));
        words.add(new Word("Jammin"," good time","Things", 1,""));
        words.add(new Word("Jah know","lord knows","Things", 1,""));
        words.add(new Word("Jah","god","Things", 1,""));
        words.add(new Word("Jelly","a young coconut.","Things", 1,""));
        words.add(new Word("Janga","shrimp, crayfish.","Things", 1,""));
        words.add(new Word("Jook","to pierce or stick","Things", 1,""));
        words.add(new Word("Judgin","ordinary clothes","Things", 1,""));
        words.add(new Word("Kallaloo","dark leafy vegetable","Things", 1,""));
        words.add(new Word("kiss me neck!"," exclamation of surprise.","Things", 1,""));
        words.add(new Word("Kiss teet","hissing noise","Things", 1,""));
        words.add(new Word("Ku deh!","look at","Things", 1,""));
        words.add(new Word("Ku ya!","look here!","Expression", 1,""));

        words.add(new Word("Ku","look","Expression", 1,""));
        words.add(new Word("Kya","to care","Expression", 1,""));
        words.add(new Word("Kyaan","can't","Expression", 1,""));
        words.add(new Word("Kyai","to carry","Expression", 1,""));
        words.add(new Word("Kyan","can","Expression", 1,""));
        words.add(new Word("Laba laba","to chat,gab;gossip","Expression", 1,""));
        //words.add(new Word("Labrish","gossip,chit-chat","Expression", 1,""));
        words.add(new Word("Large","respected","Expression", 1,""));
      //  words.add(new Word("Leggo beas","wild, disorderly","Expression", 1,""));
        words.add(new Word("Licky licky","flattering,obsequious","Expression", 1,""));
        words.add(new Word("Lilly bit","little bit, tiny","Expression", 1,""));
       // words.add(new Word("Likky likky","look here!","Expression", 1,""));
        words.add(new Word("Maca","thorn, prickle.","Expression", 1,""));
        words.add(new Word("Madda","mother","Expression", 1,""));
        words.add(new Word("Maga dog","mongrel","Expression", 1,""));
        words.add(new Word("Maga","thin","Expression", 1,""));
        words.add(new Word("Marina","Tank-top style shirt","thing", 1,""));
       // words.add(new Word("no true?","isn't it so?","Expression", 1,""));
       // words.add(new Word("Monks","amongst","Expression", 1,""));
       // words.add(new Word("mash up, mash down","destroy","Expression", 1,""));

        words.add(new Word("No kya","no matter,","Expression", 1,""));
        words.add(new Word("Obeah","traditional african science","Expression", 1,""));
        words.add(new Word("Ongle","only","Expression", 1,""));
        words.add(new Word("Patu","owl","Expression", 1,""));
        words.add(new Word("Peenywally","fire fly","Expression", 1,""));
        words.add(new Word("Peer","avocado pear","Expression", 1,""));
        words.add(new Word("Picky","brush haircut","Expression", 1,""));
        //words.add(new Word("picky-picky","finicky or choosy","Expression", 1,""));
        words.add(new Word("Pikny","child","Thing", 1,""));
        words.add(new Word("Pinda","peanut","Expression", 1,""));
        words.add(new Word("Polytricks","politicians","Expression", 1,""));
        words.add(new Word("Poppy show  ","make fun of someone","Expression", 1,""));
        //words.add(new Word("pum-pum  ","a woman's genitals","Expression", 1,""));
       // words.add(new Word("punaani or punni","a woman's genitals","Expression", 1,""));
       // words.add(new Word("puttin' away","except for, or except.","Expression", 1,""));
        //words.add(new Word("pyaa-pyaa   ","sickly, weak;","Expression", 1,""));
        words.add(new Word("Raatid","surprise or vexation","Expression", 1,""));
        words.add(new Word("Ranking","highly respected","Expression", 1,""));
        words.add(new Word("Ras or rass","backside, rump","Expression", 1,""));
        words.add(new Word("To raas   ","really?, damn!","Expression", 1,""));
        words.add(new Word("Rat bat","bat, the night-flying rodent.","Expression", 1,""));

        words.add(new Word("Renk","foul-smelling or rude","Expression", 1,""));
      //  words.add(new Word("rhaatid","A curse-exclamation,","Expression", 1,""));
        words.add(new Word("Rockers","reggae music","Expression", 1,""));
        words.add(new Word("Roots","natural indigenous","Expression", 1,""));
        words.add(new Word("Rude boy","a tough guy .","Expression", 1,""));
        words.add(new Word("Ryal","royal","Expression", 1,""));
        words.add(new Word("Salt","Unlucky","Expression", 1,""));
        words.add(new Word("Samfai man","trickster, conman.","Expression", 1,""));
        words.add(new Word("Satta","sit, rest, meditate relax","Expression", 1,""));
        words.add(new Word("Screechie","to sneak by","Expression", 1,""));
        words.add(new Word("Sheg up","to be messed up, ruined","Expression", 1,""));

        words.add(new Word("Sidung","sit down","Expression", 1,""));
       // words.add(new Word("sight?","do you understand?","Expression", 1,""));
        words.add(new Word("Sinkl bible","the aloevera plant.","Expression", 1,""));
        words.add(new Word("Sistren","a woman, a friend","Expression", 1,""));
        words.add(new Word("Slackness","lewd, vulgarity","Expression", 1,""));
        words.add(new Word("So so","Neither bad or good","Expression", 1,""));
        words.add(new Word("Spliff"," marijuana cigarette","Expression", 1,""));
        words.add(new Word("Step","to depart quickly","Expression", 1,""));

        words.add(new Word("Sufferer","a poor person stuggling","Expression", 1,""));
        //words.add(new Word("tall","long","Expression", 1,""));
        words.add(new Word("Teif","a theif, to steal","Expression", 1,""));
        words.add(new Word("Trace","to curse","Expression", 1,""));
        words.add(new Word("Tumpa","one-foot man.","Expression", 1,""));
        words.add(new Word("Tunti","female organ.","Expression", 1,""));
        words.add(new Word("Unu or uno","you-all.","Expression", 1,""));
        words.add(new Word("Vex","Upset","Expression", 1,""));


        words.add(new Word("Wa day","the other day","Expression", 1,""));
        //words.add(new Word("wa mek?","why?","Expression", 1,""));
        //words.add(new Word("wanga-gut","hungry-belly","Expression", 1,""));
        words.add(new Word("Wheels","vehicle","Expression", 1,""));
        words.add(new Word("Whole heap","a lot","Expression", 1,""));
        words.add(new Word("Winjy","thin and sickly looking","Expression", 1,""));
        //words.add(new Word("wis","vine, liana, from withe.","Expression", 1,""));
        words.add(new Word("Ya","hear, or here.","Expression", 1,""));
        words.add(new Word("Yabba","a big clay pot.","Expression", 1,""));

        words.add(new Word("Yahso","one's tenement.","Expression", 1,""));
        words.add(new Word("Zion","Ethiopia","Expression", 1,""));
        words.add(new Word("Zungu pan"," zinc pan","Expression", 1,""));


        /*Place */
        markers.add(new Marker("discovery bay St.ann",-77.3995230,18.4603030,"Antonet Bar","antonetbar@gmail.com","antonetbar.com","813-1787",1,"Sports bar"));
        markers.add(new Marker("Appleton Estate",-77.7529073,18.1640921,"Appleton Sugar and Rum Factory","","","(876) 963-9215",1,"Agriculture"));
        markers.add(new Marker("Discovery Bay",-77.374478,18.460723,"green grotto caves","","","",1,"Beach"));
        markers.add(new Marker("Ocho Rios",-77.134854,18.414845,"Dunn's River Falls","","","",1,"Beach"));
        markers.add(new Marker("Ocho Rios",-77.13036,18.417266,"Dolphin Cove","","","",1,"Beach"));
        markers.add(new Marker("Falmouth",-77.62835,18.48295,"Glistening Waters","","","",1,"Restaurant"));
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

