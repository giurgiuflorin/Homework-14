import org.example.MyException;
import org.example.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTDD {

    @Test
    @DisplayName("Class was created")
    public void classInitiate() {
        Person person = null;
    }

    @Test
    @DisplayName("Create Person object with all three parameters")
    public void personObject() {
        Person person = new Person(1, "Florin", 26);

    }

    @Test
    @DisplayName("Invalid age when creating Person object")
    public void invalidData1() {
        //GIVEN
        Integer id = 12;
        String name = "Nandor";
        Integer age = -4;

        //WHEN - THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            Person person = new Person(id, name, age);
        });

    }

    @Test
    @DisplayName("String name containing numbers or symbols when creating Person object")
    public void invalidData2() {
        //GIVEN
        Integer id = 3;
        String name = "Na44$@ndor((";
        Integer age = 44;

        //WHEN
        Person person = new Person(id, name, age);
        String name1 = person.getName();

        //THEN
        org.assertj.core.api.Assertions.assertThat(name1).isEqualTo("Nandor");
    }


    @Test
    @DisplayName("Invalid id when creating Person object")
    public void invalidData3() {
        //GIVEN
        Integer id = -2;
        String name = "Nandor";
        Integer age = 31;

        //WHEN - THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            Person person = new Person(id, name, age);
        });
    }

    @Test
    @DisplayName("String name has blank value")
    public void invalidData4() {
        //GIVEN
        Integer id = 3;
        String name = "44$@((";
        Integer age = 44;

        //WHEN-THEN
        Assertions.assertThrows(MyException.class, () ->
        {
            Person person = new Person(id, name, age);
            String name1 = person.getName();

        });

    }
}
