package data;

import model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    private  Connection connection;

    public PersonDao() {
        connection = DbConnector.getDbConnection();
    }

    public boolean addPerson(Person person) throws SQLException {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into " +
                    "info(first,second,third,phone,email) values (?,?,?,?,?)");
            preparedStatement.setString(1, person.getFirst());
            preparedStatement.setString(2, person.getSecond());
            preparedStatement.setString(3, person.getThird());
            preparedStatement.setString(4, person.getPhone());
            preparedStatement.setString(5, person.getEmail());

            boolean rowAdded = preparedStatement.executeUpdate() > 0;
            return rowAdded;
    }

    public boolean deletePerson(Person person) throws SQLException {

            PreparedStatement preparedStatement = connection.prepareStatement("delete from info where " +
                    "id_person =?");
            preparedStatement.setInt(1, person.getId_person());
            boolean rowDeleted = preparedStatement.executeUpdate() > 0;
            return rowDeleted;

    }

    public  boolean updatePerson(Person person) throws SQLException {

            PreparedStatement preparedStatement = connection.prepareStatement("update info set first = ?, " +
                    "second = ?, third = ?, phone = ?, email = ? where id_person = ?");
            preparedStatement.setString(1, person.getFirst());
            preparedStatement.setString(2, person.getSecond());
            preparedStatement.setString(3, person.getThird());
            preparedStatement.setString(4, person.getPhone());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setInt(6, person.getId_person());

            boolean rowUpdated = preparedStatement.executeUpdate() > 0;
            return rowUpdated;
    }

    public Person getPersonById(int personId) {
        Person person = new Person();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from info where id_person = " + personId);

            while (resultSet.next()) {
                person.setId_person(resultSet.getInt("id_person"));
                person.setFirst(resultSet.getString("first"));
                person.setSecond(resultSet.getString("second"));
                person.setThird(resultSet.getString("third"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public List<Person> listAllPerson() throws SQLException {
        ArrayList<Person> listPerson = new ArrayList<Person>();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from info");

            while (resultSet.next()) {
                int id = resultSet.getInt("id_person");
                String first = resultSet.getString("first");
                String second = resultSet.getString("second");
                String third = resultSet.getString("third");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                Person person = new Person(id, first, second, third, email, phone);
                listPerson.add(person);
            }

        return listPerson;
    }

    public static void registerPerson() {
        String sql = "insert into info(first,second,third,email,phone) " +
                "values('example','example','example','example','example') ";

        Connection connection = DbConnector.getDbConnection();
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
