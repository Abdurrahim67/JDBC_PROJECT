package repeat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class R01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1.Adim:Driver'a kaydol

        Class.forName("org.postgresql.Driver");

        // 2.Adim: Database'e baglan
      Connection con=  DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","12345");

        //3.Adim:Statement olustur.
        Statement st= con.createStatement();


        //4.Adim:Query calistir.

        //1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
       String sql="CREATE TABLE workers(workers_id VARCHAR(50),worker_name VARCHAR(50),worker_salary INT)";
       boolean result=st.execute(sql);
       System.out.println(result);




        //2.Örnek: Alter table by adding worker_address column into the workers table

        String sql1="ALTER TABLE workers ADD workers_adress VARCHAR(80)";
        st.execute(sql1);


        //2.Örnek: Table'a worker_address sütunu ekleyerel alter yapın.



        //3.Example: Drop workers table
        String sql2="DROP TABLE workers";
        st.execute(sql2);


        // 5.Adim: Baglanti ve Statement 'i kapat
        con.close();
        st.close();




    }

}

