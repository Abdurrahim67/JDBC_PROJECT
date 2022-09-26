package repeat;

import java.sql.*;

public class R06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1)Driver yukle
        Class.forName("org.postgresql.Driver");
        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "12345");
        //3) Statement--
        Statement st = con.createStatement();
        // 4) ResultSet
        ResultSet veri = st.executeQuery("select*from ogrenciler");

        // 5)Sonuclari al

        while (veri.next()) {
            //index kullanrak

            System.out.println(veri.getInt(1) + veri.getString(2) + veri.getString(3) + veri.getString(3));

            //sutun ismi kulanarak
            System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi") + veri.getString("sinif") + veri.getString("cinsiyet"));

        }
        //6)kapat
        con.close();
        st.close();
        veri.close();

    }
}
