package homework_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HumanRepository {

    private static final String QUERY_FIND_ALL = "SELECT * FROM HUMAN";

    public List<Human> getAll(){

        List<Human> humanList = new ArrayList<>();

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = preparedStatement.getResultSet()) {
             while (resultSet.next()){

                 Human human = new Human();
                 human.setId(resultSet.getInt("human_id"));
                 human.setFirst_name(resultSet.getString("first_name"));
                 human.setLast_name(resultSet.getString("last_name"));
                 human.setAge(resultSet.getInt("age"));

                 humanList.add(human);

             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return humanList;
    }

}
