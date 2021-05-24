import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Registration implements ActionListener
{
    private static JTextField userID;
    private static JTextField firstName;
    private static JTextField lastName;
    private static JTextField password;
    private static JTextField email;
    private static JTextField phoneNum;
    private static JButton button;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
    	JPanel panel = new JPanel();
    	JFrame f = new JFrame();
  
    	f.setBounds(500, 300, 600, 500); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setBorder(new EmptyBorder(5, 5, 5, 5)); // need changes
        f.setContentPane(panel);
        panel.setLayout(null);

        // heading
        JLabel theUser = new JLabel("User Registration");
        theUser.setFont(new Font("Normal", Font.PLAIN, 35));
        theUser.setBounds(180, 10, 350, 60);
        panel.add(theUser);
        
        // user id 
        JLabel lfid = new JLabel("User ID:");
        lfid.setFont(new Font("Normal", Font.PLAIN, 20));
        lfid.setBounds(40, 100, 150, 30);
        panel.add(lfid);
        userID = new JTextField();
        userID.setFont(new Font("Normal", Font.PLAIN, 20));
        userID.setBounds(180, 100, 250, 30);
        panel.add(userID);
        userID.setColumns(10);
        
        // first name
        JLabel fn = new JLabel("First name:");
        fn.setFont(new Font("Normal", Font.PLAIN, 20));
        fn.setBounds(40, 150, 150, 30);
        panel.add(fn);
        firstName = new JTextField();
        firstName.setFont(new Font("Normal", Font.PLAIN, 20));
        firstName.setBounds(180, 150, 250, 30);
        panel.add(firstName);
        firstName.setColumns(10);
        
        // last name
        JLabel ln = new JLabel("Last name:");
        ln.setFont(new Font("Normal", Font.PLAIN, 20));
        ln.setBounds(40, 200, 150, 30);
        panel.add(ln);
        lastName = new JTextField();
        lastName.setFont(new Font("Normal", Font.PLAIN, 20));
        lastName.setBounds(180, 200, 250, 30);
        panel.add(lastName);
        lastName.setColumns(10);

        // password
        JLabel p = new JLabel("Password:");
        p.setFont(new Font("Normal", Font.PLAIN, 20));
        p.setBounds(40, 250, 150, 30);
        panel.add(p);
        password = new JPasswordField();
        password.setFont(new Font("Normal", Font.PLAIN, 20));
        password.setBounds(180, 250, 250, 30);
        panel.add(password);
        
        // email
        JLabel e = new JLabel("Email:");
        e.setFont(new Font("Normal", Font.PLAIN, 20));
        e.setBounds(40, 300, 150, 30);
        panel.add(e);
        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBounds(180, 300, 250, 30);
        panel.add(email);
        email.setColumns(10);

        // phone number
        JLabel pn = new JLabel("Phone number:");
        pn.setFont(new Font("Normal", Font.PLAIN, 20));
        pn.setBounds(40, 350, 150, 30);
        panel.add(pn);
        phoneNum = new JTextField();
        phoneNum.setFont(new Font("Normal", Font.PLAIN, 20));
        phoneNum.setBounds(180, 350, 250, 30);
        panel.add(phoneNum);
        phoneNum.setColumns(10);

        // button to enter fields
        button = new JButton("Enter");
        button.setFont(new Font("Normal", Font.PLAIN, 20));
        button.setBounds(180, 420, 150, 30);  
        button.addActionListener(new Registration());
        panel.add(button);
        
        f.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
        int uID = Integer.parseInt(userID.getText());
        String fName = firstName.getText();
        String lName = lastName.getText();
        String pass = password.getText();
        String emailAdd = email.getText();
        String pNumber = phoneNum.getText();
              
              try {
              	// connect with mySQL workbench
              	String url = "jdbc:mysql://localhost:3306/registration"; 
          		String userName = "root"; 
          		String passcode = "273790"; 
              	Connection con = DriverManager.getConnection(url, userName, passcode);
                  
              	//execute the query
          		Statement st = con.createStatement();
                String theQuery = "INSERT INTO user " +
                  			   "VALUES(" + uID + ",'" + fName + "','" + lName + "','" + pass + "','" + emailAdd + "','" + pNumber + "')";
                  int num = st.executeUpdate(theQuery);
          		       

                  // display error if the query exits in the database
                  if (num == 0) {
                      JOptionPane.showMessageDialog(button, "User is aready in the databse.");
                  } else {
                      JOptionPane.showMessageDialog(button, "User account of " + fName + " is registered successfully!");
                  }
                  
                  // close the connection to mySQL
                  st.close(); 
                  con.close();
                  
              	} catch (Exception ex) {
              		ex.printStackTrace();
              		System.out.println("Could not execute the given query.");
              }
	}
}
