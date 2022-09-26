package jdbc;

import java.sql.*;

public class
PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
1.Adim-->Prepared statement query'sini olustur.
2.Adim-->Prepared statement objesini olustur.
3.Adim-->set() meth ile soru isaretleri icin deger gir.
4.Adim-->Execute query
 */


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "12345");
        Statement st = con.createStatement();

//1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //-->1.Adim: Prepared statement query'sini olustur.

        String sql1 = "UPDATE companies SET number_of_employees=? WHERE company=?";

        //-->2.Adim: Prepared statemen objesini olustur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //-->3.Adim: set() meth ile soru isaretleri icin deger gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        // 4.Adim: Execute query

        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi");

        String sql2 = "SELECT*FROM companies";
        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "--" + result1.getString(2) + "--" + result1.getInt(3));

        }
        System.out.println();// bosluk icin

        //Google icin degisiklik

        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");


        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi");

        String sql3 = "SELECT*FROM companies";
        ResultSet result2 = st.executeQuery(sql3);

        while (result2.next()) {

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" + result2.getInt(3));

        }

       /* //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

        String sql4 = "SELECT*FROM ?";

        PreparedStatement pst2 = con.prepareStatement(sql4);

        pst2.setString(1, "companies");

        ResultSet result4 = pst2.executeQuery(sql4);

        while(result4.next()){

            System.out.println(result4.getInt(1) + "--" + result4.getString(2) + "--" + result4.getInt(3));


        }


        */
        System.out.println();
        read_data(con,"companies");
        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
    }

    public static void read_data(Connection con, String tableName) {


        try {
            String query = String.format("SELECT*FROM %s", tableName);// Format() methodu dinamik String olusturmak icin kullanilir.
            Statement statement = con.createStatement();
            //SQL query'i calistir.
            ResultSet rs = statement.executeQuery(query);//Datayi cagirip Resulset konteynirina koyuyoruz

            while(rs.next()){ // Tüm datayi cagiralim.
                System.out.println(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getInt(3));

            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
