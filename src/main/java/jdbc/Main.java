package jdbc;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        //DBWork objesíni olustur.
        DBWork db = new DBWork();

        //Connection fonksiyonunu cagir.
        Connection con = db.connect_to_db("techproed", "postgres", "12345");

        //Yeni table olusturma methodunu cagir.

        db.createTable(con,"employees");

    }
}
