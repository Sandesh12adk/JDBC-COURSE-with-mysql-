import java.sql.*;

public class Main {
    static   Connection  conn = null;
    static Statement stmt = null;
    static ResultSet data = null;

    static String url = "jdbc:mysql://localhost:3306/workers";
    static String password = "root";
    static String user = "root";
    static String query = "insert into demo_table(name, age, email) values " +
            "('sandesh', 21, 'sandesh1@example.com'), " +
            "('keshab', 18, 'keshab@example.com'), " +
            "('anu', 23, 'anu@example.com')";

    public static void main(String[] args) {

        try {
            // Establishing the connection with the database
           conn = DriverManager.getConnection(url, user, password);
            // Creating the statement
            stmt = conn.createStatement();
            // Uncomment below line to execute the Delete query

          // stmt.executeUpdate("DELETE FROM demo_table");

            // Uncomment below line to Insert the values to the table
           // stmt.executeUpdate(query);

            // Executing the select query
            data = stmt.executeQuery("select * from demo_table");

            // Moving to the first row
            if (data.next()) {
                // Retrieving data from the second column (age)
                int age = data.getInt(3);
                System.out.println("Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (data != null) {    //NOte that every time you run the app for first time the cursor is
                // always at the top what ever was its position during the last run
                try {
                    data.close();
                } catch (Exception e) {
                    System.out.println("Error closing Resultset " + e.getMessage());
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    System.out.println("Error closing Statement " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Error closing connection " + e.getMessage());
                }
               getallData();
            }
        }
    }
    // Above we talk about how to extablish the connection, run the queries and how to retrive the data
// using the Resultset interface now what we gonna do is to retrive the whole data forn the database
// and display it into the console in tabular form.
    static void getallData(){
        System.out.println();
        System.out.println();
       try{
           conn = DriverManager.getConnection(url, user, password);
           stmt= conn.createStatement();
           ResultSet data = stmt.executeQuery("select * from demo_table");
           while(data.next()){
               int id= data.getInt(1);
               String name= data.getString(2);
               int age= data.getInt(3);
               String email= data.getString(4);
               System.out.println("ID= "+ id);
               System.out.println("Name= "+ name);
               System.out.println("Age= "+ age);
               System.out.println("Email= "+ email);
               System.out.println();
           }
       } catch (Exception e){
           System.out.println("Error " + e.getMessage());
    }finally {
           if (data != null) {    //Note that every time you run the app for first time the cursor is
               // always at the top what ever was its poition during the last run
               try {
                   data.close();
               } catch (Exception e) {
                   System.out.println("Error closing Resultset " + e.getMessage());
               }
           }
           if (stmt != null) {
               try {
                   stmt.close();
               } catch (Exception e) {
                   System.out.println("Error closing Statement " + e.getMessage());
               }
           }
           if (conn != null) {
               try {
                   conn.close();
               } catch (Exception e) {
                   System.out.println("Error closing connection " + e.getMessage());
               }
           }
       }
}
}


