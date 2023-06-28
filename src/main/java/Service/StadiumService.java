package Service;

import Dao.StadiumDao;
import db.DBConnection;
import model.Stadium;

import java.sql.Connection;
import java.util.List;

public class StadiumService {

    private StadiumDao stadiumDao;
    private Connection connection;

    public StadiumService(StadiumDao stadiumDao, Connection connection) {
        this.stadiumDao = stadiumDao;
        this.connection = DBConnection.getInstance();
    }



    public List<Stadium> getStadium() {
        List<Stadium> stadiumList = stadiumDao.getStadiumList();

        return stadiumList;
    }

}
