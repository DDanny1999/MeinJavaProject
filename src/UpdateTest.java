import java.sql.*;

/**
 * A Java MySQL UPDATE example.
 * Demonstrates the use of a SQL UPDATE statement against a
 * MySQL database, called from a Java program.
 * 
 * Created by Alvin Alexander, http://devdaily.com
 *
 */
public class UpdateTest {

    public static void main(String[] args) {
        try {
            // create a java mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/kurse";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "DBADMIN");                                    // https://alvinalexander.com/java/java-mysql-update-query-example/

        // create the java mysql update preparedstatement
    /*      String queryUpdate = "update users set first_name = ? where first_name = ?";
            PreparedStatement preparedStmtUpdate = conn.prepareStatement(queryUpdate);
            preparedStmtUpdate.setString(1, "Daniel");
            preparedStmtUpdate.setString(2, "Fred"); */

         //create the java mysql insert into preparedstatement                                                                      // https://stackoverflow.com/questions/59147960/how-to-insert-into-mysql-database-with-java
      /*   String queryInsertInto = "insert into users (first_name, last_name, date_created, is_admin, num_points)"
            + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmtInsertInto = conn.prepareStatement(queryInsertInto);
            preparedStmtInsertInto.setString(1, "Boris");
            preparedStmtInsertInto.setString(2, "Gratchev");
            preparedStmtInsertInto.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));               // https://stackoverflow.com/questions/18614836/using-setdate-in-preparedstatement
            preparedStmtInsertInto.setBoolean(4, true);
            preparedStmtInsertInto.setInt(5, 1500);  */

            // create the java mysql select statement                  
              Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT Vorname, Familienname, Ort from tbPerson;");
            while(rs.next())
            {
                System.out.println(rs.getString(1) + ' ' + rs.getString(2) + ' ' + rs.getString(3));
            }
            conn.close(); 

          //    execute the java preparedstatement

          //  preparedStmtUpdate.executeUpdate();  
         //  preparedStmtInsertInto.executeUpdate(); 
           
           System.out.println("Query hat geklappt!");

           conn.close(); 
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}



/* public void adduser(User s) {
    try {
         sql = "insert into users ('u_fname', 'u_lname', 'u_uname', 'u_pass', 'u_age', 'u_adderess')"
                 + "values('" + s.getFirstname() + "','" + s.getLastname()
                 + "','" + s.getUsername() + "','" + s.getPassword() + "','" + s.getAge() + "','" + s.getAdderss() + "')";
         
     } catch (Exception e) {
         System.out.println(e);
     }
 
 } */