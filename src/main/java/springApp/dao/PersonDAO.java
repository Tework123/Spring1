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
        this.people.add(new Person(PEOPLE_COUNT++, "nik"));
        this.people.add(new Person(PEOPLE_COUNT++, "masha"));
        this.people.add(new Person(PEOPLE_COUNT++, "bodich"));

    }

    public List<Person> index() {
        return people;
    }
/ сломанный цикл, не может достать id, так как i не доходит, при удалении людей
    public Person show(int id) {
        for (int i = 0; i < people.size(); i++) {

            if (people.get(i).getId() == id) {
                return people.get(id);
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

    }

    public void delete(int id){
        for (int i = 0; i < people.size(); i++) {

            if (people.get(i).getId() == id) {
                people.remove(i);
            }
        }

    }
}




