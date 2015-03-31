package database;

/**
 * Created by dacorie on 01/03/2015.
 */
public class Marker {
    int id;
    String address;
    double longitude;
    double latitude;
    String Name;
    String email;
    String website;
    String number;
    int isTopRated;
    String type;
    String icon;

    public Marker(int id, String address, double longitude, double latitude, String name, String email, String website, String number, int isTopRated, String type, String icon) {
        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        Name = name;
        this.email = email;
        this.website = website;
        this.number = number;
        this.isTopRated = isTopRated;
        this.type = type;
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int isTopRated() {
        return isTopRated;
    }

    public void setTopRated(int isTopRated) {
        this.isTopRated = isTopRated;
    }



    public Marker(String address, double longitude, double latitude, String name, String email, String website, String number, int isTopRated, String type) {
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.Name = name;
        this.email = email;
        this.website = website;
        this.number = number;
        this.isTopRated = isTopRated;
        this.type = type;
    }

    public Marker(int id, String address, double longitude, double latitude, String name, String email, String website, String number, int isTopRated) {
        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        Name = name;
        this.email = email;
        this.website = website;
        this.number = number;
        this.isTopRated = isTopRated;
    }

    public String getEmail() {
        return email;
    }

    public Marker(int id, String address, double longitude, double latitude, String name, String email, String website, String number) {

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
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Marker(int id, String address, double longitude, double latitude,
                  String name) {
        super();
        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        Name = name;
    }
}