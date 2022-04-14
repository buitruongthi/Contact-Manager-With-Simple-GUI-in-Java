/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Truong Thi Bui - 101300750
 */
public class Contact {

    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private Address homeAddress;
    private String email;
    private MyDate birthday;
    private String notes;

    public Contact(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, MyDate birthday, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAddress = homeAddress;
        this.email = email;
        this.birthday = birthday;
        this.notes = notes;
    }

    public Contact(String firstName, String lastName, String homePhone, String workPhone,
            String streetInfo1, String streetInfo2, String city, String postalCode, String province,
            String country, String email, int day, int month, int year, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAddress = new Address(streetInfo1, streetInfo2, city, postalCode, province, country);
        this.email = email;
        this.birthday = new MyDate(day, month, year);
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Full Name: " + firstName + " " + lastName
                + "  |  Home Phone: " + homePhone
                + "  |  Work Phone: " + workPhone
                + "\nHome Address: " + homeAddress.toString()
                + "\nEmail: " + email
                + "\nBirthday: " + birthday.toString()
                + "\nNotes: " + notes;
    }
    
}
