package com.talabat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginPanel extends JFrame{
    private JButton loginButton;
    private JLabel backGround;
    private JButton signupButton;
    private JTextField username;
    private JPasswordField password;
    private Customer customer;

    
    public LoginPanel(Customer c) {
        this.customer = c;
        initComponents();
    }

    private void initComponents() {

        loginButton = new JButton();
        signupButton = new JButton();
        backGround = new JLabel();
        username = new JTextField();
        password = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(85, 85, 406, 656));
        setMaximumSize(new Dimension(321, 571));
        setMinimumSize(new Dimension(321, 571));
        setName("mainFrame");
        setUndecorated(true);
        setPreferredSize(new Dimension(321, 571));
        setResizable(false);
        setSize(new Dimension(321, 571));
        getContentPane().setLayout(null);

        loginButton.setBackground(new Color(255, 90, 0));
        loginButton.setFont(new Font("Microsoft Sans Serif", 1, 14));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setIcon(new ImageIcon(getClass().getResource("assets/images/login/login_btn.png")));
        loginButton.setToolTipText("");
        loginButton.setBorderPainted(false);
        loginButton.setMargin(new Insets(0, 0, 0, 0));
        loginButton.setMaximumSize(new Dimension(116, 31));
        loginButton.setMinimumSize(new Dimension(116, 31));
        loginButton.setPreferredSize(new Dimension(116, 31));

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    loginButtonActionPerformed(evt);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(103, 428, 116, 31);

        signupButton.setBackground(new Color(255, 90, 0));
        signupButton.setFont(new Font("Microsoft Sans Serif", 1, 14));
        signupButton.setForeground(new Color(255, 255, 255));
        signupButton.setIcon(new ImageIcon(getClass().getResource("assets/images/login/signup_btn.png")));
        signupButton.setToolTipText("");
        signupButton.setBorderPainted(false);
        signupButton.setMargin(new Insets(0, 0, 0, 0));
        signupButton.setMaximumSize(new Dimension(116, 31));
        signupButton.setMinimumSize(new Dimension(116, 31));
        signupButton.setPreferredSize(new Dimension(116, 31));

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signupButton);
        signupButton.setBounds(103, 480, 116, 31);

        username.setText("");
        username.setHorizontalAlignment(JTextField.CENTER);
        username.setBackground(new Color(242, 242, 242));
        getContentPane().add(username);
        username.setBounds(43, 251, 237, 26);

        password.setText("");
        password.setHorizontalAlignment(JPasswordField.HORIZONTAL);
        password.setBackground(new Color(242, 242, 242));
        getContentPane().add(password);
        password.setBounds(43, 306, 237, 26);

        backGround.setIcon(new ImageIcon(getClass().getResource("assets/images/login/background.png")));
        backGround.setText("backGround");
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 359, 571);
        backGround.getAccessibleContext().setAccessibleName("background");

        pack();
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/images/login/login_btn_h.png")));
        String uname = username.getText();
        String pword = password.getPassword().toString();

        customer.login(uname, pword);
    }

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("oi cunt");
    }
}
