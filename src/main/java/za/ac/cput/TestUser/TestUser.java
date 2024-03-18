package za.ac.cput.TestUser;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import za.ac.cputuserGui.UserGUI;

/**
 *
 * @author User
 */
public class TestUser {

    public static void main(String[] args) {
        
        UserGUI run = new UserGUI();
        
        run.pack();
        run.setSize(400,150);
        run.setVisible(true);
        run.setDefaultCloseOperation(EXIT_ON_CLOSE);
        run.setGUI();
        
    }
    
}
