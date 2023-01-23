import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacao {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;


        try {
            conn = DB.getConnection("coursejdbc");
            conn.setAutoCommit(false ); //transforma em uma transação

            st = conn.createStatement();


            int rowsAffected = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            int x = 1;
//            if(x<2){
//                throw new SQLException("Fake error");
//            }
            int rowsAffected2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("Done! Rows affcted: "+ rowsAffected);
            System.out.println("Done! Rows affcted: "+ rowsAffected2);

        }catch (SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transation rolled back! Cause by: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Cause by: " + e.getMessage());
            }
        }finally {
            DB.closeSatement(st);
            DB.closeConnection();
        }
    }
}
