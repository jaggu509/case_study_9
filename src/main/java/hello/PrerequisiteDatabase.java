package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PrerequisiteDatabase {

    public static void main(String[] args) {
        try {
            // Load the Derby JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/firstdb;create=true");

            Statement stmt = con.createStatement();
            String qry;
            boolean already_exists = false;
            String table_name = "EMPLOYEE";

            if (already_exists) {
                qry = "DROP TABLE " + table_name;
                stmt.execute(qry);
            }

            qry = "CREATE TABLE " + table_name
                    + " (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY ( START WITH 1, INCREMENT BY 1 ) PRIMARY KEY,"
                    + " NAME VARCHAR(25),"
                    + " SALARY INT,"
                    + " LOCATION VARCHAR(25))";  // Fix the missing closing parenthesis

            stmt.execute(qry);
            already_exists = true;
            System.out.println("Table Created");

            qry = "INSERT INTO " + table_name + " (NAME, SALARY, LOCATION) VALUES"
                    + "('Amit', 100000, 'Hyderabad'),"
                    + "('Rahul', 90000, 'Bangalore'),"
                    + "('Shree', 75000, 'Vizag'),"
                    + "('Nicky', 68000, 'Bangalore'),"
                    + "('Vinay', 96000, 'Hyderabad')";

            stmt.execute(qry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
