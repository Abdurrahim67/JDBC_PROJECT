package jdbc;

import java.sql.*;

public class CallableStatement01 {

/*
Java'da methodlar return type sahibi olsa da, void olsa da method olarak adlandırılır.
SQL'de ise data return ediyorsa "function" denir. Return yapmıyorsa "procedure" diye adlandırılır.
 */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "12345");
        Statement st = con.createStatement();

        //1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.

        //1.Adim=Foknsiyon kodunu yaz

        String sql1="CREATE OR REPLACE FUNCTION toplamaF(x NUMERIC, y NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "\n" +
                "BEGIN\n" +
                "RETURN x+y;\n" +
                "END\n" +
                "$$\n";


        //2.Adim: Fonksiyonu calistir.

        st.execute(sql1);

        //3.Adim: Fonksiyonu cagir.

       CallableStatement cst1= con.prepareCall("{?=call toplamaF(?,?)}");

       //4. Adim:Return icin registerOutParameter() methodunu, parametreler icin set() methodlarindan uygun olanlari kullan.
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,15);
        cst1.setInt(3,25);


       //5.Adim: Calistirmak icin execute() methodunu kullan.

        cst1.execute();

        //6.Adim: Sonucu cagirmak icin return data tipini göre"get" methodlarindan uygun olani kullan

        System.out.println(cst1.getBigDecimal(1));



        //2. Örnek: Koninin hacmini hesaplayan bir function yazın

        String sql2 = "CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC, h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "\n" +
                "BEGIN\n" +
                "RETURN 3.14*r*r*h/3;\n" +
                "END\n" +
                "$$\n";


        st.execute(sql2);
        CallableStatement cst2 = con.prepareCall("{?=call koniHacmi(?,?)}");


        cst2.registerOutParameter(1, Types.NUMERIC);
        cst2.setInt(2, 3);
        cst2.setInt(3, 5);


        cst2.execute();

        System.out.println(cst2.getBigDecimal(1));

    }


    }



