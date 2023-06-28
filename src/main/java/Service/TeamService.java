package Service;

import Dao.StadiumDao;
import Dao.TeamDao;
import db.DBConnection;

import java.sql.Connection;

public class TeamService {
    private StadiumDao stadiumDao;
    private TeamDao teamDAO;
    private Connection connection;

    public TeamService(StadiumDao stadiumDao, TeamDao teamDAO, Connection connection) {
        this.stadiumDao = stadiumDao;
        this.teamDAO = teamDAO;
        this.connection = DBConnection.getInstance();
    }

}

