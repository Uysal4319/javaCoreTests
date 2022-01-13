package dbOperations.mysql;

import java.sql.*;
import java.util.List;

public class MysqlTableFetch {

    public static void main(String[] args) throws ClassNotFoundException {
        process();
    }

      public static void process() throws ClassNotFoundException {
        List<Integer> test =null;
        Connection con = null ;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:dbOperations.mysql://127.0.0.1:3306/my_db","root","root");
            String sql = "SELECT user_id FROM user ";
            Statement statement= con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                test.add(userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Integer integer : test) {
            System.out.println(integer);
        }
    }
}
