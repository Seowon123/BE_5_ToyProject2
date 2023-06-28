package Dao;

import model.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StadiumDao {

    private Connection connection;

    public StadiumDao(Connection connection) {
        this.connection = connection;
    }

    // 야구장 등록
    public void registerStadium(String name) {

        String query = "insert into stadium (stadium_name) values (?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);

            int result = statement.executeUpdate();
            System.out.println("registerStadium res : " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 전체 야구장 목록 보기

    public List<Stadium> getStadiumList() {

        List<Stadium> stadiumList = new ArrayList<>();

        String query = "select * from stadium_tb";

        try {

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Stadium stadium = new Stadium(
                        rs.getInt("stadium_id"),
                        rs.getString("stadium_name"),
                        rs.getTimestamp("stadium_created_at")
                );
                stadiumList.add(stadium);
            }
            return stadiumList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stadiumList;
    }
}