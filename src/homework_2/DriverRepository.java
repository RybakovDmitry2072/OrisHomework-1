package homework_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverRepository {

    private static final String QUERY_FIND_ALL = "SELECT * FROM \"driver\"";

    private static final String QUERY_SAVE = "INSERT INTO \"driver\" (first_name, last_name, age)" +
            "VALUES (?, ?, ?)";

    private static final String QUERY_FIND_BY_AGE = "SELECT * FROM \"driver\" WHERE age > ?";

    public List<Driver> getAllByAge(int minAge){

        List<Driver> driverList = new ArrayList<>();

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_BY_AGE)) {

            preparedStatement.setInt(1, minAge);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Driver driver = new Driver();
                driver.setId(resultSet.getInt("driver_id"));
                driver.setAge(resultSet.getInt("age"));
                driver.setFirstName(resultSet.getString("first_name"));
                driver.setLastName(resultSet.getString("last_name"));

                driverList.add(driver);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return driverList;

    }

    public void save(Driver driver){

        try (Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SAVE)) {

            preparedStatement.setString(1,driver.getFirstName());
            preparedStatement.setString(2,driver.getLastName());
            preparedStatement.setInt(3, driver.getAge());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveSixDriver(List<Driver> driverList){

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SAVE)) {

            for (Driver driver : driverList) {

                preparedStatement.setString(1, driver.getFirstName());
                preparedStatement.setString(2, driver.getLastName());
                preparedStatement.setInt(3, driver.getAge());
                //добавил все в пакет, а потом ОДНИМ запросов отправил в бд.
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Driver> getAll(){

        List<Driver> driverList = new ArrayList<>();

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
             while (resultSet.next()){

                 Driver driver = new Driver();
                 driver.setId(resultSet.getInt("driver_id"));
                 driver.setFirstName(resultSet.getString("first_name"));
                 driver.setLastName(resultSet.getString("last_name"));
                 driver.setAge(resultSet.getInt("age"));

                 driverList.add(driver);

             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return driverList;
    }

}
