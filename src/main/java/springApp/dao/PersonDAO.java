package springApp.dao;

import org.springframework.stereotype.Component;
import springApp.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    public PersonDAO(List<Person> people) {
        this.people = new ArrayList<>();
        this.people.add(new Person(PEOPLE_COUNT++, "nik", 20, "nil@mail.ru"));
        this.people.add(new Person(PEOPLE_COUNT++, "masha", 32, "nil@mail.ru"));
        this.people.add(new Person(PEOPLE_COUNT++, "bodich", 12, "nil@mail.ru"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        for (int i = 0; i < people.size(); i++) {

            if (people.get(i).getId() == id) {
                return people.get(i);
            }
        }
        return null;
    }

    public void save(Person person) {
        person.setId(PEOPLE_COUNT++);
        this.people.add(person);

    }

    public void update(int id, Person editPerson) {
        Person oldPerson = show(id);
        oldPerson.setName(editPerson.getName());
        oldPerson.setAge(editPerson.getAge());
        oldPerson.setEmail(editPerson.getEmail());

    }

    public void delete(int id) {
        for (int i = 0; i < people.size(); i++) {

            if (people.get(i).getId() == id) {
                people.remove(i);
            }
        }

    }
}




