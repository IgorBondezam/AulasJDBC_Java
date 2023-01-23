import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection("coursejdbc");
            st = conn.prepareStatement("" +
                    "UPDATE seller SET " +
                    "BaseSalary = BaseSalary + ? "
                    + "WHERE (DepartmentId = ?)");

            st.setDouble(1, 200d);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affcted: "+ rowsAffected);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DB.closeSatement(st);
            DB.closeConnection();
        }
    }
}
