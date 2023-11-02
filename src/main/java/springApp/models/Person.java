package springApp.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "2 to 20")
    private String name;
    @Min(value = 0, message = "Are you birth?")
    private int age;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email don't work")
    private String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
