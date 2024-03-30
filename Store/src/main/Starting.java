package main;

import java.sql.SQLException;

import connection.ConnectDB;

public class Starting {
    public static void main(String[] args) throws SQLException {
        int count = 2;
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ConnectDB.getInstance().connect();
        // ScreenLogin frm_Login = new ScreenLogin();
        // frm_TrangChu.setVisible(true);
        // frm_TrangChu.setLocationRelativeTo(null);

    }
}