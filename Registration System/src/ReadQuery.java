import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int uID = 2;
		String fName="Jack";
		String lName="Johnson";
		String pass="12344";
		String emailAdd="123jack@yahoo.com";
		String pNumber="9872359277";
				
          	// connect with mySQL workbench
          	String url = "jdbc:mysql://localhost:3306/registration"; 
      		String userName = "root"; 
      		String passcode = "273790"; 
      	
      		
          	Connection con = DriverManager.getConnection(url, userName, passcode);
              
          	//execute the query
      		Statement st = con.createStatement();
            String theQuery = "INSERT INTO user " +
              			   "VALUES(" + uID + ",'" + fName + "','" + lName + "','" + pass + "','" + emailAdd + "','" + pNumber + "')";
             st.executeUpdate(theQuery);
             
              
              // close the connection to mySQL
              st.close(); 
              con.close();
              
          	

	}

}
