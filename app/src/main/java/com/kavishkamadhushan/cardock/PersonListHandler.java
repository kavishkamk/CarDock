package com.kavishkamadhushan.cardock;

import java.util.ArrayList;

public class PersonListHandler {

    private ArrayList<Person> personArrayList;

    public PersonListHandler() {
        this.personArrayList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.personArrayList.add(person);
    }

    public boolean isAvailableUserName(String userName) {
        for(Person p : personArrayList) {
            if (p.getUserName().equals(userName)) return true;
        }
        return false;
    }

    public boolean isAvailableEmail(String email) {
        for(Person p : personArrayList) {
            if (p.getEmail().equals(email)) return true;
        }
        return false;
    }

    public boolean isCorrectPassword(String password) {
        for (Person p : personArrayList) {
            if (p.getPwd().equals(password)) return true;
        }
        return false;
    }

}
