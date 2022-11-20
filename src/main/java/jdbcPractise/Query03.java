package jdbcPractise;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "12345");
    //Statement st = con.createStatement();

        PreparedStatement ps=con.prepareStatement("select * from ogrenciler");
        ResultSet rs=ps.executeQuery();

        ResultSetMetaData rsmd=rs.getMetaData();

        System.out.println(rsmd.getColumnCount());
        rsmd.getColumnName(1);
        rsmd.getColumnName(2);
        rsmd.getColumnName(3);
        rsmd.getColumnName(4);

        System.out.println("1.Sutunun Data Tipi"+rsmd.getColumnTypeName(1));
        System.out.println("2.Sutunun Data Tipi"+rsmd.getColumnTypeName(2));
        System.out.println("3.Sutunun Data Tipi"+rsmd.getColumnTypeName(3));
        System.out.println("4.Sutunun Data Tipi"+rsmd.getColumnTypeName(4));

        System.out.println("rsmd.getTableName(2) = " + rsmd.getTableName(2));


        con.close();
        ps.close();
        rs.close();

    }


}
