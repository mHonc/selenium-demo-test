package pl.seleniumdemo.Model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Customer {
    private String firstName;
    private String lastName;
    private String country;
    private String adress1;
    private String postcode;
    private String city;
    private String phone;
    private String email;
    private String companyName;
    private String adress2;
    private String comments;

    public Customer(String firstName, String lastName, String country, String adress1, String postcode, String city, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.adress1 = adress1;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.companyName = "";
        this.adress2 = "";
        this.comments = "";
    }

    public Customer(String firstName, String lastName, String country, String adress1, String postcode, String city, String phone, String email, String companyName, String adress2, String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.adress1 = adress1;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.companyName = companyName;
        this.adress2 = adress2;
        this.comments = comments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getAdress1() {
        return adress1;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAdress2() {
        return adress2;
    }

    public String getComments() {
        return comments;
    }
}
