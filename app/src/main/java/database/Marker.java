package database;

/**
 * Created by dacorie on 01/03/2015.
 */
public class Marker {
    int id;
    String address;
    float longitude;
    float latitude;
    String Name;
    String email;
    String website;
    String number;


    public String getEmail() {
        return email;
    }

    public Marker(int id, String address, float longitude, float latitude, String name, String email, String website, String number) {

        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        Name = name;
        this.email = email;
        this.website = website;
        this.number = number;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        number = number;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        website = website;
    }


    @Override
    public String toString() {
        return "Marker [id="
                + id + ", address=" + address + ", longitude="
                + longitude + ", latitude=" + latitude + ", Name=" + Name
                + ", getId()=" + getId() + ", getAddress()=" + getAddress()
                + ", getLongitude()=" + getLongitude() + ", getLatitude()="
                + getLatitude() + ", getName()=" + getName()
                + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }
    public Marker() {
        super();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Marker(int id, String address, float longitude, float latitude,
                  String name) {
        super();
        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        Name = name;
    }
}