package repeat;

import java.sql.*;

public class R03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "12345");
        Statement st = con.createStatement();

        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
        // 1.yol OFFSET ve FETCH NEXT kullanarak

        String sql1="SELECT company,number_of_employees\n" +
                "FROM companies\n" +
                "ORDER BY number_of_employees DESC\n" +
                "OFFSET 1 ROW\n" +
                "FETCH NEXT 1 ROW ONLY";

                ResultSet result1=st.executeQuery(sql1);
                while(result1.next()){
                    System.out.println(result1.getString(1) + "-->" + result1.getString(2));


                }




    }
}
