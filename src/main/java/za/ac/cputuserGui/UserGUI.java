package za.ac.cputuserGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import za.ac.cput.UserDAO.UserDAO;

public class UserGUI extends JFrame {

    private JPanel nPanel, sPanel;
    private JLabel lblEmail, lblPass;
    private JTextField txtEmail;
    private JPasswordField txtPass;
    private JButton btnRegister, btnLogin, btnExit;
    private UserDAO dao;

    public UserGUI() {

        nPanel = new JPanel();
        sPanel = new JPanel();

        lblEmail = new JLabel("Email Address: ");
        lblPass = new JLabel("Password: ");

        txtEmail = new JTextField();
        txtPass = new JPasswordField();

        btnRegister = new JButton("Register");
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");

        dao = new UserDAO();

    }

    public void setGUI() {

        nPanel.setLayout(new GridLayout(2, 2));
        nPanel.add(lblEmail);
        nPanel.add(txtEmail);
        nPanel.add(lblPass);
        nPanel.add(txtPass);
        this.add(nPanel, BorderLayout.NORTH);

        sPanel.setLayout(new GridLayout(1, 2));
        sPanel.add(btnLogin);
        sPanel.add(btnRegister);
        sPanel.add(btnExit);
        this.add(sPanel, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = txtEmail.getText();
                String pass = new String(txtPass.getPassword());

                boolean verify = dao.verify(email, pass);

                if (verify) {
                    JOptionPane.showMessageDialog(null, "Successful Login");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Details");
                }

            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dao.closeOperation();
                System.exit(0);

            }
        });

    }

}
