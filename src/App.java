import java.sql.*;
public class App
{
    public static void main(String[] args) {
        {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://lin-8259-5354-mysql-primary.servers.linodedb.net:3306/TestDatenbankLorena","linroot", "ri@Tv6HOegJowUuH");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("Select * From Persons");
                            
                while(rs.next())
                {
                    System.out.println(rs.getString(2));
                }
                

                PreparedStatement preparedStmtInsertInto = con.prepareStatement("Insert into Persons (PersonId, LastName)" + " values (?, ?)");
                preparedStmtInsertInto.setInt(1, 5);
                preparedStmtInsertInto.setString(2, "Musterman");

                preparedStmtInsertInto.executeUpdate();

                System.out.println("\nNach hinzufügen der Daten: \n");

            Statement stmt2=con.createStatement();
               ResultSet rs2=stmt2.executeQuery("Select * From Persons");

                while(rs2.next())
                {
                    System.out.println(rs2.getString(2));
                }
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}