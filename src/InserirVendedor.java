import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InserirVendedor {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection("coursejdbc");
            st = conn.prepareStatement(
                    "INSERT INTO department " + "(Name) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
//                    "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
//                    "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

//            st.setString(1,"José");
//            st.setString(2,"jose@gmail.com");
//            st.setDate(3,new java.sql.Date(sdf.parse("22/04/1985").getTime()));
//            st.setDouble(4, 3000d);
//            st.setInt(5, 4);

            st.setString(1,"D1");

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();

                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }

            }else {
                System.out.println("No rown affected!");
            }

        }catch (SQLException e){
            e.printStackTrace();
//        }catch (ParseException e){
//            e.printStackTrace();
        }finally {
            DB.closeSatement(st);
            DB.closeConnection();
        }
    }
}
