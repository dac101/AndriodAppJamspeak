package model;
import java.util.Comparator;

/**
 * Created by Dacorie Smith on 10/9/13.
 */
public class Word implements Comparable<Word> {
    int id;
    String word;
    String translation;
    String category;
    int word_or_phrase;
    String audiofile;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getWord_or_phrase() {
        return word_or_phrase;
    }

    public void setWord_or_phrase(int word_or_phrase) {
        this.word_or_phrase = word_or_phrase;
    }

    public String getAudiofile() {
        return audiofile;
    }

    public void setAudiofile(String audiofile) {
        this.audiofile = audiofile;
    }

    public Word(int id, String word, String translation, String category,
                int word_or_phrase, String audiofile) {
        super();
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.category = category;
        this.word_or_phrase = word_or_phrase;
        this.audiofile = audiofile;
    }


    public Word(String word, String translation, String category,
                int word_or_phrase, String audiofile) {
        super();
        this.word = word;
        this.translation = translation;
        this.category = category;
        this.word_or_phrase = word_or_phrase;
        this.audiofile = audiofile;
    }

    public Word() {

    }

    @Override
    public int compareTo(Word another) {


        if(this.word.toLowerCase().equals(another.word)){
            return 0;
        }else{
            return -1;
        }

    }

    public static Comparator<Word> WordNameComparator  = new Comparator<Word>() {

        public int compare(Word word1, Word word2) {

            String wordName1 = word1.getWord().toUpperCase();
            String wordName2 = word2.getWord().toUpperCase();

            //ascending order
            return wordName1.compareTo(wordName2);

             //descending order
             // return fruitName2.compareTo(fruitName1);
        }

    };
}
