package PACKAGE1;

public class Adress {

    public String street;
    public String city;
    public String state;
    public String country;

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() { return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return getStreet() + ", "+getCity()+", "+getState()+", "+getCountry();
    }


}
