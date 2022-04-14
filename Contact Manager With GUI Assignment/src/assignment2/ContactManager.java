/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Truong Thi Bui - 101300750
 */
public class ContactManager {

    private List<Contact> contactList = new ArrayList<>();

    public boolean add(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, MyDate birthday, String notes) {
        return contactList.add(new Contact(firstName, lastName, homePhone, workPhone, homeAddress, email, birthday, notes));
    }

    public boolean add(String firstName, String lastName, String homePhone, String workPhone,
            String streetInfo1, String streetInfo2, String city, String postalCode, String province,
            String country, String email, int day, int month, int year, String notes) {
        return contactList.add(new Contact(firstName, lastName, homePhone, workPhone,
                streetInfo1, streetInfo2, city, postalCode, province,
                country, email, day, month, year, notes));
    }

    public void remove(int index) {
        contactList.remove(index);
    }

    public void edit(int index, String firstName, String lastName, String homePhone, String workPhone,
            String streetInfo1, String streetInfo2, String city, String postalCode, String province,
            String country, String email, int day, int month, int year, String notes) {

        Contact c = contactList.get(index);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setHomePhone(homePhone);
        c.setWorkPhone(workPhone);
        c.getHomeAddress().streetInfo1 = streetInfo1;
        c.getHomeAddress().streetInfo2 = streetInfo2;
        c.getHomeAddress().city = city;
        c.getHomeAddress().postalCode = postalCode;
        c.getHomeAddress().province = province;
        c.getHomeAddress().country = country;
        c.setEmail(email);
        c.getBirthday().setDay(day);
        c.getBirthday().setMonth(month);
        c.getBirthday().setYear(year);
        c.setNotes(notes);
    }

    public String viewAllContacts() {
        String s = "List of contacts\n";
        for (int i = 0; i < contactList.size(); i++) {
            s += "----------------------------------------------------------------\n" + "Id: " + i
                    + "\n" + contactList.get(i).toString() + "\n";
        }
        return s;
    }

    public String viewContactsInCity(String city) {
        String s = "Contacts in " + city + "\n";
        for (Contact c : contactList) {
            if (c.getHomeAddress().city.equals(city)) {
                s += "----------------------------------------------------------------\n" + c.toString() + "\n";
            }
        }
        return s;
    }

    public String findContact(String firstName, String lastName) {
        String s = "All contacts with name: " + firstName + " " + lastName + "\n";
        for (Contact c : contactList) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                s += "----------------------------------------------------------------\n" + c.toString() + "\n";
            }
        }
        return s;
    }

    public int getNumContact() {
        return contactList.size();
    }

    public Contact getContact(int index) {
        return contactList.get(index);
    }
}
