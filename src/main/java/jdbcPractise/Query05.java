package jdbcPractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "12345");
        Statement st = con.createStatement();

        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K')

    //   int s1= st.executeUpdate("insert into ogrenciler values(303, 'Sena Can', 12, 'K')");

    //    System.out.println(s1+" satir eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

/*
        //1.yol
        String [] veri={"insert into ogrenciler values(400, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(402, 'Sena Can', 12, 'K')"};

        // foreach ile arraydeki her bir query'i sırayla calistirip calisma sayisini count'a atiyoruz

        int count=0;
        for(String each:veri){

          count= count+ st.executeUpdate(each);
        }
        System.out.println(count+" Datalar eklendi");

 */
        // 2.yol
        String [] veri2={"insert into ogrenciler values(500, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(501, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(502, 'Sena Can', 12, 'K')"};

        for (String each:veri2) {
            st.addBatch(each); //Yukaridaki datalarin hepsisini birlestiriyor


        }st.executeBatch();   // Datalari tek seferde gönderiyor


    }
}
