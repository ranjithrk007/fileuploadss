package com.example.demo.bean;
public class file {
    private String Name;
    private String Phone;
    private String Email;
    private String StreetName;
    private String City;
    private String postalCode;
    public file(String name, String phone, String email, String streetName, String city, String post) {
        this.Name = name;
        this.Phone=phone;
        this.Email = email;
        this.StreetName = streetName;
        this.City = city;
        this.postalCode=post;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getStreetName() {
        return StreetName;
    }
    public void setStreetName(String streetName) {
        StreetName = streetName;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
}
