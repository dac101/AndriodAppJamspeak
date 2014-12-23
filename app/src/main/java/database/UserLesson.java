package database;

public class UserLesson {
	int user_id;
	int lesson_id;
	int completed;
	
	
	public UserLesson() {
		super();
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}
	public int isCompleted() {
		return completed;
	}
	public void setCompleted(int i) {
		this.completed = i;
	}
	public UserLesson(int user_id, int lesson_id, int completed) {
		super();
		this.user_id = user_id;
		this.lesson_id = lesson_id;
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "UserLesson [user_id=" + user_id + ", lesson_id=" + lesson_id
				+ ", completed=" + completed + "]";
	}
	
	
}
