package service;

import Dao.OutPlayerDao;
import Dao.PlayerDao;
import db.DBConnection;
import model.OutPlayer;

import java.sql.Connection;
import java.sql.SQLException;

public class OutPlayerService {
    private final OutPlayerDao outPlayerDao;
    private final PlayerDao playerDao;

    public OutPlayerService() {
        Connection connection = DBConnection.getInstance();
        this.outPlayerDao = new OutPlayerDao(connection);
        this.playerDao = new PlayerDao(connection);
    }

    public void registerOutPlayer(int playerId, String reason) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance();
            connection.setAutoCommit(false); // 트랜잭션 시작

            // 퇴출 선수 등록
            OutPlayer outPlayer = new OutPlayer(playerId, reason);
            outPlayerDao.registerOutPlayer(outPlayer);

            // 선수의 team_id를 null로 변경
            playerDao.updateTeamIdToNull(playerId);

            connection.commit(); // 트랜잭션 커밋
            System.out.println("퇴출 선수 등록 및 팀 ID 업데이트가 성공적으로 수행되었습니다.");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // 트랜잭션 롤백
                } catch (SQLException rollbackEx) {
                    System.err.println("트랜잭션 롤백 중 오류가 발생했습니다.");
                    rollbackEx.printStackTrace();
                }
            }
            System.err.println("퇴출 선수 등록 또는 팀 ID 업데이트 중 오류가 발생했습니다.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException closeEx) {
                    System.err.println("데이터베이스 연결을 닫는 중 오류가 발생했습니다.");
                    closeEx.printStackTrace();
                }
            }
        }
    }
}