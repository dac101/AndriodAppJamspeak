package database;

/**
 * Created by Dacorie Smith on 10/12/13.
 */
public class Picture {
    int id;
    String picture_Location;
    String file_Name;
	String category;
	String translation;
	
	public Picture(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture_Location() {
		return picture_Location;
	}

	public void setPicture_Location(String picture_Location) {
		this.picture_Location = picture_Location;
	}

	public String getFile_Name() {
		return file_Name;
	}

	public void setFile_Name(String file_Name) {
		this.file_Name = file_Name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public Picture(int id, String picture_Location, String file_Name,
			String category, String translation) {
		super();
		this.id = id;
		this.picture_Location = picture_Location;
		this.file_Name = file_Name;
		this.category = category;
		this.translation = translation;
	}
	
}
