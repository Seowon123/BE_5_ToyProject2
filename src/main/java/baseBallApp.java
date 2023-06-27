import db.DBConnection;

import java.sql.Connection;

public class baseBallApp {
    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();
    }
}
