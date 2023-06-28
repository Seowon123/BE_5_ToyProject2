package Dao;

import model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {
    // 팀 등록

    private Connection connection;

    public TeamDao(Connection connection) {
        this.connection = connection;
    }
    public void registerTeam(String name) {
        String query = "insert into team (stadium_id, team_name) values (?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNull(1, Types.INTEGER);
            statement.setString(2, name);

            int result = statement.executeUpdate();
            System.out.println("registerTeam res : " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 전체 팀 목록
    public List<Team> getTeamList() {

        List<Team> teamList = new ArrayList<>();
        String query = "select * from team_tb";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Team team = new Team(
                        rs.getInt("team_id"),
                        rs.getInt("stadium_id"),
                        rs.getString("team_name"),
                        rs.getTimestamp("team_created_at")
                );
                teamList.add(team);
            }
            return teamList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamList;
    }
}