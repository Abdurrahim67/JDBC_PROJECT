package jdbcPractise;

import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1.Adim:Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        // 2.Adim: Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                                                    "postgres",
                                                    "12345");

        //3) Statement olustur
        Statement st=con.createStatement();

        //ResultSet
        ResultSet veri=st.executeQuery("select*from ogrenciler");

        // Sonuclari al

        while(veri.next()){

            //index kullanarak
            System.out.println(veri.getInt(1)+veri.getString(2)+veri.getString(3)+veri.getString(4));


            //sutun ismi kullanarak
            System.out.println(veri.getInt(1)+veri.getString("ogrenci_ismi")+veri.getString("sinif")+veri.getString("cinsiyet"));
        }


        // 6) Kapatma

        con.close();
        st.close();
        veri.close();
    }


}
