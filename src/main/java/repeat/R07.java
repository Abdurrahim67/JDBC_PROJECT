package repeat;

import java.sql.*;

public class R07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "12345");

        Statement st = con.createStatement();

        ResultSet data = st.executeQuery("select*from ogrenciler where cinsiyet='E' ");

        // Task--> Ögrenciler tablosundaki erkek ögrencileri listeleyiniz?

       /* while (data.next()) {

            System.out.println(data.getInt(1) + data.getString(2) + data.getString(3) + data.getString(4));


        }

        */
        // Task--> Ögrenciler tablosundaki 9.siniftaki  erkek ögrencileri  listeleyiniz?

        ResultSet data1 = st.executeQuery("select*from ogrenciler where sinif='9' and cinsiyet='E'");

        while(data1.next()){
            System.out.println(data1.getInt(1) + data1.getString(2) + data1.getString(3) + data1.getString(4));


        }

        con.close();
        data1.close();
        st.close();
    }

}
