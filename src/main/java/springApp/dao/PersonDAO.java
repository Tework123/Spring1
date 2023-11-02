package springApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import springApp.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/java_spring1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "ksflkOkas23fl9saflKdl349sLfsk1";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public List<Person> index() throws SQLException {
        List<Person> people = new ArrayList<>();
        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM Person";
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName((resultSet.getString("name")));
            person.setEmail((resultSet.getString("email")));
            person.setAge((resultSet.getInt("age")));
            people.add(person);
        }
        System.out.println(people);
        return people;
    }

    public Person show(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }

    public void save(Person person) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person VALUES(1, ?,?,?)");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setInt(2, person.getAge());
        preparedStatement.setString(3, person.getEmail());
        preparedStatement.executeUpdate();
    }

    public void update(int id, Person editPerson) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");
        preparedStatement.setString(1, editPerson.getName());
        preparedStatement.setInt(2, editPerson.getAge());
        preparedStatement.setString(3, editPerson.getEmail());
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}




