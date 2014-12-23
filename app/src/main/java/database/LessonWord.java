package database;


/**
 * Created by Dacorie Smith on 10/12/13.
 */
public class LessonWord {
	
    int lesson_id;
    int completed;
    int word_id;
    
	
	
    
    
    
	public LessonWord(int lesson_id, int completed, int word_id) {
		super();
		this.lesson_id = lesson_id;
		this.completed = completed;
		this.word_id = word_id;
	}

	public LessonWord() {
		super();
	}

	public LessonWord(int lesson_id, int completed, int word_id, int picture_id) {
		super();
		this.lesson_id = lesson_id;
		this.completed = completed;
		this.word_id = word_id;

	}

	public int getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}

	public int getWord_id() {
		return word_id;
	}

	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

    
}
