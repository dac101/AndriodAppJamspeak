package catchmedia.jamaica.dictionary;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import database.DatabaseHandler;

import database.Word;
import utility.ImageInfo;

public class HomeLessonActivity extends Activity {

    private TextView answer;
    DatabaseHandler db = new DatabaseHandler(this);
    String correctAnswer = null;
    ArrayList<ImageInfo> info = new ArrayList<ImageInfo>();
    String imageWord, currentWordToLowerCase, wordType;
    RadioGroup section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lesson);
        Intent i = getIntent();

        answer = (TextView) findViewById(R.id.answer);
        wordType = i.getStringExtra("Type");
        section = (RadioGroup)  findViewById(R.id.selection);

        getImages();
        generateQuestion();

        findViewById(R.id.check).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedid = section.getCheckedRadioButtonId();
                if (selectedid > 0) {
                    questionAnswer();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_lesson, menu);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        return true;
    }

    /**
     * provide the answer
     *
     * @return
     */
    public void questionAnswer() {// answer
        answer = (TextView) findViewById(R.id.answer);
        RadioGroup selection = (RadioGroup) findViewById(R.id.selection);
        RadioButton answer1 = (RadioButton) findViewById(selection
                .getCheckedRadioButtonId());

        //	Log.i(selection.getCheckedRadioButtonId() + "id", "id");
        if (answer1.getText().equals(correctAnswer)) {
            answer.setText("Correct");
          //  saveLesson(correctAnswer);
            generateQuestion();
        } else {
            answer.setText("Answer is:  " + correctAnswer);
        }
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public void generateQuestion() {

        Random generator = new Random(System.currentTimeMillis());

        RadioButton answer1 = (RadioButton) findViewById(R.id.answer1);
        RadioButton answer2 = (RadioButton) findViewById(R.id.answer2);
        RadioButton answer3 = (RadioButton) findViewById(R.id.answer3);
        RadioButton answer4 = (RadioButton) findViewById(R.id.answer4);
        RadioGroup section = (RadioGroup)  findViewById(R.id.selection);
        ImageView imageWord = (ImageView) findViewById(R.id.lessonImageView);

        int selectedId = section.getCheckedRadioButtonId();
        int counter = 0;

        int i = generator.nextInt(info.size());
        int[] selectedWordIds = new int[4] ;


        String[] wrongAnswer = { "ackee", "Bulla", "Nyam", "Yeh ,", "Wappun",
                "Tanks", "My yute", "Inna di Lights", "Leggo", "JamDown",
                "Higga", "fren", "Deh here","Feel no way","A true" ,"Bwoy (b-why)","Cut yeye"
                ,"Zeen","Zed","Yaad","Yahso","Yeyewata","Undastan","Satday","Rhaatid"};

        List<String> answers = new ArrayList<String>();
        List<Integer> answersTempId = new ArrayList<Integer>();
        List<Word> words = db.getAllWords();

        answer.setText("");

        clearSelection(section, selectedId);

        for (Word word : words) {
            counter++;

            this.imageWord = cleanString(info.get(i).getName().toLowerCase(),"_jamaicaword", "_");
            currentWordToLowerCase = word.getWord().toLowerCase();

            if (word.getCategory().contains(wordType)) {
                if (this.imageWord.contains(currentWordToLowerCase) || currentWordToLowerCase.contains(this.imageWord)) {

                    answers.add(wrongAnswer[generator.nextInt(wrongAnswer.length)]);
                    answers.add(wrongAnswer[generator.nextInt(wrongAnswer.length)]);
                    answers.add(wrongAnswer[generator.nextInt(wrongAnswer.length)]);
                    answers.add( word.getWord());


                    answersTempId.add(0);
                    answersTempId.add(1);
                    answersTempId.add(2);
                    answersTempId.add(3);

                    imageWord.setImageResource(info.get(i).getId());

                    selectedWordIds[0]= -1;
                    selectedWordIds[1]= -1;
                    selectedWordIds[2]= -1;
                    selectedWordIds[3]= -1;


                    RandomizeFunction(selectedWordIds, answersTempId);
                    CheckForDuplicates(selectedWordIds, answersTempId);

                    answer1.setText(answers.get(selectedWordIds[0]));
                    answer2.setText(answers.get(selectedWordIds[1]));
                    answer3.setText(answers.get(selectedWordIds[2]));
                    answer4.setText(answers.get(selectedWordIds[3]));

                    correctAnswer = word.getWord();
                    return;
                }
            }

        }
        if(counter == words.size())
        {
            generateQuestion();
        }
    }

    public void clearSelection(RadioGroup section, int selectedId) {
        if (selectedId > 0) {
            section.clearCheck();
        }
    }

    private void CheckForDuplicates(int[] selectedWordIds, List<Integer> answersTempId) {

        int repeatedTime = 0;

        Set<Integer> set = new HashSet<Integer>();
        for(int i : selectedWordIds) {
            if(!set.add(i)) {
                repeatedTime++;
            }
        }
        if (repeatedTime > 1) {
            RandomizeFunction(selectedWordIds, answersTempId);
            CheckForDuplicates(selectedWordIds, answersTempId);
        }

    }

    public void RandomizeFunction(int[] selectedWordIds, List<Integer> answersTempId) {
        int[] selectedWordIdsTemp;
        int currentWordId;
        for(int x = 0 ; x < selectedWordIds.length; x++){
            selectedWordIdsTemp  = Arrays.copyOf(selectedWordIds, selectedWordIds.length) ;
                int findOrNot = 0;
                while (true) {
                    Arrays.sort(selectedWordIdsTemp);
                    currentWordId = randInt(0, answersTempId.size() - 1);
                    findOrNot = Arrays.binarySearch(selectedWordIdsTemp, currentWordId);
                    if(findOrNot <= -1 && findOrNot >= -5)
                    {

                        break;
                    }
            }
            selectedWordIds[x] =answersTempId.get(currentWordId);

        }
    }

    public void getImages() {
        Field[] drawables = R.drawable.class.getFields();
        int[] resArray = new int[drawables.length];

        for (int i = 0; i < drawables.length; i++) {
            try {
                if (drawables[i].getName().contains("jamaicaword")) {
                    resArray[i] = drawables[i].getInt(null);
                    info.add(new ImageInfo(drawables[i].getName(), drawables[i]
                            .getInt(null)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Takes out all the number words, symbol base on the parameter
     *
     * @param str
     * @param word
     * @return
     */
    public String cleanString(String str, String word, String symbol) {
        str = str.replaceAll(word, "");
        str = str.replace(symbol, "");
        str = str.replaceAll("(\\d+[,/%]?\\d*)", "");
        return str;
    }

}
