package Dao;

import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
    private final Connection connection;

    public PlayerDao(Connection connection) {
        this.connection = connection;
    }

    //선수 등록

    // 팀별 선수 목록
    public List<Player> getPlayers(int teamId) {
        List<Player> players = new ArrayList<>();
        String query = "select * from player_tb where team_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, teamId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Player player = new Player(
                        rs.getInt("id"),
                        rs.getInt("team_id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getTimestamp("created_at")
                );
                players.add(player);
            }
            return players;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
