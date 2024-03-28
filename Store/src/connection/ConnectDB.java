package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection con = null;
    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }

    public void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databasename=QLBH";
        String user = "sa";
        String password = "sapassword";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }

    // Kiểm tra connection

    // public static void main(String[] args) throws SQLException {
    // ConnectDB.getInstance().connect();
    // if (ConnectDB.getConnection() != null) {
    // System.out.println("Kết nối thành công");
    // } else {
    // System.out.println("Kết nối thất bại");
    // }
    // }
}
