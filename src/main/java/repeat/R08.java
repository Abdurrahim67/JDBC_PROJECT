package repeat;

import java.sql.*;

public class R08 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","12345");

       // Statement st=con.createStatement();
        PreparedStatement ps= con.prepareStatement("select*from ogrenciler");

        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();

        System.out.println("rsmd.getColumnCount() = " + rsmd.getColumnCount());

        System.out.println("rsmd.getColumnName(1) = " + rsmd.getColumnName(1));

        System.out.println("rsmd.getColumnLabel(2) = " + rsmd.getColumnLabel(2));

        System.out.println("rsmd.getColumnTypeName(1) = " + rsmd.getColumnTypeName(1));
        System.out.println("rsmd.getColumnTypeName(2) = " + rsmd.getColumnTypeName(2));
        System.out.println("rsmd.getColumnTypeName(3) = " + rsmd.getColumnTypeName(3));
        System.out.println("rsmd.getColumnTypeName(4) = " + rsmd.getColumnTypeName(4));

        System.out.println("rsmd.getSchemaName(2) = " + rsmd.getTableName(2));

        con.close();
        ps.close();
    }

}
