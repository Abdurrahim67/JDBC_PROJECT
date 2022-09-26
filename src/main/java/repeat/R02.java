package repeat;

import java.sql.*;

public class R02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // -->1.Adim:Driver'a kaydol.
        // -->2.Adim: Database'e baglan.
        //-->3.Adim:Statement olustur.



        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "12345");
        Statement st = con.createStatement();

        //1. Example:  region id'si 1 olan "country name" değerlerini çağırın.

        String sql = "SELECT country_name from countries WHERE region_id=1";
        boolean r1 = st.execute(sql);
        System.out.println(r1);
        // Reordlari görmek icin excecuteQuery() methodu kullanmaliyiz.
        ResultSet result1 = st.executeQuery(sql);

        while (result1.next()) {
            System.out.println(result1.getString("country_name"));

        }
        //    2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql2 = "SELECT country_id,country_name FROM countries WHERE region_id>2";
       ResultSet result2 = st.executeQuery(sql2);

        while (result2.next()) {
            System.out.println(
                    result2.getString("country_id") + "-->" + result2.getString("country_name"));


        }//3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

        String sql3="SELECT*FROM companies WHERE number_of_employees=(SELECT MIN(number_of_employees) FROM companies)";
        ResultSet result3=st.executeQuery(sql3);
         while(result3.next()){
             System.out.println(result3.getString("company_id") + "-->" + result3.getString("company") + "-->" + result3.getString("number_of_employees"));

         }

        con.close();
        st.close();
    }


}
