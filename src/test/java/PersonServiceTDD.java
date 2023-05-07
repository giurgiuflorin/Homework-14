import org.example.MyException;
import org.example.Person;
import org.example.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PersonServiceTDD {

    Person person1 = new Person(12, "Nandor", 31);
    Person person2 = new Person(12, "Nandor", 31);
    Person person3 = new Person(5, "Sanda", 44);
    Person person4 = new Person(4, "Maria", 33);

    @Test
    @DisplayName("Class existence")
    public void classInstance() {
        PersonService personService = new PersonService();
    }

    @Test
    @DisplayName("Object PersonService has an ArrayList of Person objects")
    public void classArray() {
        PersonService personService = new PersonService();
        personService.getList();
    }

    @Test
    @DisplayName("addPerson() method")
    public void addPerson1() {
        PersonService personService = new PersonService();
        personService.addPerson(new Person(1, "Test", 22));
    }

    @Test
    @DisplayName("addPerson() method - Person already exists")
    public void addPerson2() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);

        //WHEN - THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            personService.addPerson(person1);
            personService.addPerson(person2);
        });

    }

    @Test
    @DisplayName("removePerson() method")
    public void removePerson1() {

        PersonService personService = new PersonService();
        personService.addPerson(person1);

        personService.removePerson(person1);
    }

    @Test
    @DisplayName("removePerson() method = person is not in the list")
    public void removePerson2() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);

        //WHEN - THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            personService.removePerson(person2);
        });

    }

    @Test
    @DisplayName("getAllPersons() method")
    public void getAllPersons() {
        PersonService personService = new PersonService();
        personService.getAllPersons();
    }

    @Test
    @DisplayName("getPersonsOlderThan() method")
    public void getPersonsOlderThan() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN
        List<Person> personsOlderThan = personService.getPersonsOlderThan(30);
        int size = personsOlderThan.size();

        //THEN
        org.assertj.core.api.Assertions.assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("getPersonsOlderThan() method - negative age")
    public void getPersonsOlderThan2() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN - THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            personService.getPersonsOlderThan(-10);
            personService.getPersonsOlderThan(123);
        });

    }

    @Test
    @DisplayName("getAllPersonNames() method")
    public void getAllPersonNames() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN
        List<String> listOfAllPersonNames = personService.getAllPersonNames();

        //THEN
        org.assertj.core.api.Assertions.assertThat(listOfAllPersonNames).hasSize(3);
        org.assertj.core.api.Assertions.assertThat(listOfAllPersonNames).containsAll(Arrays.asList("Nandor", "Sanda", "Maria"));
    }

    @Test
    @DisplayName("getPerson() method")
    public void getPerson1() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN
        Person nandor = personService.getPerson("Nandor");

        //THEN
        org.assertj.core.api.Assertions.assertThat(nandor).isEqualTo(person1);
    }

    @Test
    @DisplayName("getPerson() - null value String")
    public void getPerson2() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN - THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            personService.getPerson(null);
        });
    }

    @Test
    @DisplayName(("getPerson() - return null if Person not in the list"))
    public void getPerson3() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN
        Person freud = personService.getPerson("Freud");
        Person hdhd223 = personService.getPerson("hdhd223");

        //THEN
        org.assertj.core.api.Assertions.assertThat(freud).isEqualTo(null);
        org.assertj.core.api.Assertions.assertThat(hdhd223).isEqualTo(null);

    }

    @Test
    @DisplayName("getPersonById() method")
    public void getPersonById1() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN
        Person nandor = personService.getPersonById(12);

        //THEN
        org.assertj.core.api.Assertions.assertThat(nandor).isEqualTo(person1);

    }

    @Test
    @DisplayName("getPersonById() - negative number not allowed")
    public void getPersonById2() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN - THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            personService.getPersonById(-12);
        });

    }

    @Test
    @DisplayName("getPersonById() - return null if not found")
    public void getPersonById3() {

        //GIVEN
        PersonService personService = new PersonService();
        personService.addPerson(person1);
        personService.addPerson(person3);
        personService.addPerson(person4);

        //WHEN
        Person nullPerson = personService.getPersonById(1334);

        //THEN
        org.assertj.core.api.Assertions.assertThat(nullPerson).isEqualTo(null);

    }
}
