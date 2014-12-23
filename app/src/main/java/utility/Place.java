package utility;

public class Place {
	double latitude = 17.385044;
	double longitude = 78.486671;
	String name = "";
	String address = "";
	int map_i;
	
	public Place(double latitude, double longitude, String name,
			String address, int map_i) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.address = address;
		this.map_i = map_i;
	}
	public int getMap_i() {
		return map_i;
	}
	public void setMap_i(int map_i) {
		this.map_i = map_i;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Place(double latitude, double longitude, String name, String address) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.address = address;
	}
	
	

}
