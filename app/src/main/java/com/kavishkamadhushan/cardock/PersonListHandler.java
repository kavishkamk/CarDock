package com.kavishkamadhushan.cardock;

/*
 * this class for store and do operations related to the users
 * this class use singleton pattern (Only create one instance on this class)
 * to create objet of this class use getPersonListHandler() method
 */

import java.util.ArrayList;

public class PersonListHandler {

    private volatile static PersonListHandler personListHandler; // store the object of this class
    private static ArrayList<Person> personArrayList; // array list for store Person objets

    // private constructor
    private PersonListHandler() {
        personArrayList = new ArrayList<>();
    }

    /*
     * this method for get instance of this class
     * this method is synchronized
     */
    public static PersonListHandler getPersonListHandler() {
        if(personListHandler == null) {
            synchronized (PersonListHandler.class) {
                personListHandler = new PersonListHandler();
            }
        }
        return personListHandler;
    }

    // this method is used to add person to the personArrayList
    public void addPerson(Person person) {
        PersonListHandler.personArrayList.add(person);
    }

    /*
     * this method used to check given userName is already available
     * if already available return ture, else return false
     */
    public boolean isAvailableUserName(String userName) {
        for(Person p : personArrayList) {
            if (p.getUserName().equals(userName)) return true;
        }
        return false;
    }

    /*
     * this method used to check given userName is already available
     * if already available return true, else return false
     */
    public boolean isAvailableEmail(String email) {
        for(Person p : personArrayList) {
            if (p.getEmail().equals(email)) return true;
        }
        return false;
    }

    /*
     * this method used to check username with given password
     * if user name and password is correct return true, else return false
     */
    public boolean isCorrectPassword(String userName, String password) {
        for (Person p : personArrayList) {
            if(p.getUserName().equals(userName) && p.getPwd().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
