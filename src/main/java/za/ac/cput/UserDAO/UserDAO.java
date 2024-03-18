package za.ac.cput.UserDAO;

import java.sql.*;
import javax.swing.*;
import za.ac.cputuser.User.User;

public class UserDAO {

    private Connection con;
    private PreparedStatement pState;
    private ResultSet rs;

    public UserDAO() {

        try {
            String dCon = "jdbc:derby://localhost:1527/Users";
            String uName = "username";
            String pass = "password";

            this.con = DriverManager.getConnection(dCon, uName, pass);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean verify(String email, String pass) {

        //Method 1
        /*
        boolean found = false;
        String select = "Select * from USERTABLE";

        try {

            pState = this.con.prepareStatement(select);
            rs = pState.executeQuery();

            if (rs != null) {
                while (rs.next() & !found) {
                    if (rs.getString(4).equals(email) & rs.getString(5).equals(pass)) {
                        found = true;
                    }
                }
                rs.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            try {
                if (pState != null) {
                    pState.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
        return found;
*/
        
        // Method 2 (More Efficient)
        String select = "Select * from usertable where user_email = ? and user_password = ?"; // Not case sensitive
        
        try {

            pState = this.con.prepareStatement(select);
            pState.setString(1, email);
            pState.setString(2, pass);
            rs = pState.executeQuery();

            if (rs != null) {
                if(rs.next()){
                    return true;
                }
                rs.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            try {
                if (pState != null) {
                    pState.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
        return false;
    }
    
    public User add(User user){
        
        
        
        return null;
    }
    
    public void closeOperation(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
