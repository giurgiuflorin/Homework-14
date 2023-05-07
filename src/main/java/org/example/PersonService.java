package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PersonService {

    private List<Person> list = new ArrayList<>();

    public void addPerson(Person person) {
        if (list.contains(person)) {
            throw new MyException("Person already exists in list");
        }
        for (Person p : list) {
            if (p.getName() == person.getName()) {
                throw new MyException("Person already exists in list");
            }
        }
        list.add(person);

    }

    public void removePerson(Person person) {
        if (!list.contains(person)) {
            throw new MyException("Person not in the list");
        }
        list.remove(person);
    }

    public List<Person> getAllPersons() {
        List<Person> list1 = new ArrayList<>();
        for (Person p : list) {
            list1.add(p);
        }
        return list1;
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age < 0 || age > 120) {
            throw new MyException("Age must be between 1 and 120!");
        }
       List<Person> personList = new ArrayList<>();
        for (Person p : list) {
            if (p.getAge() > age) {
                personList.add(p);
            }
        }
        return personList;
    }

    public List<String> getAllPersonNames() {
        List<String> list1 = new ArrayList<>();

        for (Person p : list) {
            list1.add(p.getName());
        }
        return list1;
    }

    public Person getPerson(String name) {

        if (name == null) {
            throw new MyException("Null value String given!");
        }

        for (Person p : list) {
            if (p.getName() == name) {
                return p;
            }
        }
        return null;
    }

    public Person getPersonById(int id) {


        if (id < 0 ) {
            throw new MyException("ID value must be a positive integer!");
        }

        for (Person p : list) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }


}
