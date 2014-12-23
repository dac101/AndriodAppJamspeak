package database;

/**
 * Created by Dacorie Smith on 10/12/13.
 */
public class Lesson {

    int id;
    String lessonDetail;
    String lessonName;
    float progress;

    public Lesson() {
    }

    public Lesson(int id,String lessonDetail, String lessonName) {

        this.id = id;
        this.lessonDetail = lessonDetail;
        this.lessonName = lessonName;
    }

	public float getProgress() {
		return progress;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonDetail() {
        return lessonDetail;
    }

    public void setLessonDetail(String lessonDetail) {
        this.lessonDetail = lessonDetail;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
