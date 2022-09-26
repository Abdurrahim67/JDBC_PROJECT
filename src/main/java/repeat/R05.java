package repeat;

import java.sql.*;

public class R05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "12345");
        Statement st = con.createStatement();

        //  Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //-->1.Adim: Prepared statement query'sini olustur.
        String sql1 = "UPDATE companies SET number_of_employees=? WHERE company=?";

        //-->2.Adim: Prepared statement objesini olustur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //-->3.Adim: set() meth ile soru isaretleri icin deger gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        // 4.Adim: Execute query

        int updateRowsayisi = pst1.executeUpdate();
        System.out.println(updateRowsayisi + "satir guncellendi");

        String sql2 = "SELECT*FROM companies";
        ResultSet result2 = st.executeQuery(sql2);


        while (result2.next()) {

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" + result2.getInt(3));

        }

        // Google icin degisiklik

        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");

        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi2 + " satir güncellendi");

        String sql3 = "SELECT*FROM companies";
        ResultSet resultSet = st.executeQuery(sql3);
        while (result2.next()) {

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" + result2.getInt(3));


        }
    }

}
/*
1.Adim: Prepared statement query'sini olustur.
2.Adim: Prepared statement objesini olustur.
3.Adim: set() meth ile soru isaretleri icin deger gir.
4.Adim: Execute query
 */