package jdbcPractise;

import static jdbcPractise.DatabaseUtilty.*;

public class Query06 {

    public static void main(String[] args) {

        DatabaseUtilty.createConnection();
        String query="select*from ogrenciler";
        System.out.println("Sutun isimleri = " + DatabaseUtilty.getColumnNames(query));
        System.out.println("Okul No = " + DatabaseUtilty.getColumnData(query, "okul_no"));
        System.out.println("Ogrenci Ismi = " + DatabaseUtilty.getColumnData(query, "ogrenci_ismi"));
        System.out.println("Sinif = " + DatabaseUtilty.getColumnData(query, "sinif"));
        System.out.println("Cinsiyet = " + DatabaseUtilty.getColumnData(query, "cinsiyet"));


    }
}
