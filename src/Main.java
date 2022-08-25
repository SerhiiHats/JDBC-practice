import controller.Handler;
import db.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection()) {
            Handler handler = new Handler(connection);
            handler.showMenu();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
