import db.DB;

import java.sql.*;

public class PegarDados {
    public static void main(String[] args) {

        Connection conn = null;

        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DB.getConnection("coursejdbc");

            st = conn.createStatement();
            rs= st.executeQuery("SELECT  * FROM department");

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));

            }

        }catch (SQLException e){
            e.getMessage();
        }finally {
            DB.closeSatementResultSet(st, rs);
            DB.closeConnection();
        }





    }
}