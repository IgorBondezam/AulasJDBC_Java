import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection("coursejdbc");
            st = conn.prepareStatement("" +
                    "DELETE FROM department "
                    + "WHERE Id = ?");

            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affcted: "+ rowsAffected);

        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }finally {
            DB.closeSatement(st);
            DB.closeConnection();
        }
    }
}
