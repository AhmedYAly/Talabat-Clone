package com.talabat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterPanel extends JFrame {
    private JLabel backGround;
    private JButton signupButton;
    private JTextField username;
    private JTextField address;
    private JTextField mobileNumber;
    private JPasswordField password;

    public RegisterPanel() {
        initComponents();
    }

    private void initComponents() {

        signupButton = new JButton();
        backGround = new JLabel();
        username = new JTextField();
        password = new JPasswordField();
        address = new JTextField();
        mobileNumber = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(85, 85, 406, 656));
        setMinimumSize(new Dimension(321, 571));
        setTitle("Customer  ");
        setName("mainFrame");
        setResizable(false);
        setSize(new Dimension(321, 571));
        getContentPane().setLayout(null);

        signupButton.setBackground(new Color(255, 90, 0));
        signupButton.setFont(new Font("Microsoft Sans Serif", 1, 14));
        signupButton.setForeground(new Color(255, 255, 255));
        signupButton.setIcon(new ImageIcon(getClass().getResource("assets/images/signup/signup_btn.png")));
        signupButton.setToolTipText("");
        signupButton.setBorderPainted(false);
        signupButton.setMargin(new Insets(0, 0, 0, 0));
        signupButton.setMaximumSize(new Dimension(116, 31));
        signupButton.setMinimumSize(new Dimension(116, 31));
        signupButton.setPreferredSize(new Dimension(116, 31));

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    signupButtonActionPerformed(evt);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });
        getContentPane().add(signupButton);
        signupButton.setBounds(103, 480, 116, 31);

        username.setText("");
        username.setHorizontalAlignment(JTextField.CENTER);
        username.setBackground(new Color(242, 242, 242));
        getContentPane().add(username);
        username.setBounds(43, 232, 237, 26);

        password.setText("");
        password.setHorizontalAlignment(JPasswordField.HORIZONTAL);
        password.setBackground(new Color(242, 242, 242));
        getContentPane().add(password);
        password.setBounds(43, 287, 237, 26);

        address.setText("");
        address.setHorizontalAlignment(JTextField.CENTER);
        address.setBackground(new Color(242, 242, 242));
        getContentPane().add(address);
        address.setBounds(43, 342, 237, 26);

        mobileNumber.setText("");
        mobileNumber.setHorizontalAlignment(JTextField.CENTER);
        mobileNumber.setBackground(new Color(242, 242, 242));
        getContentPane().add(mobileNumber);
        mobileNumber.setBounds(43, 397, 237, 26);

        backGround.setIcon(new ImageIcon(getClass().getResource("assets/images/signup/background.png")));
        backGround.setText("backGround");
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 359, 571);
        backGround.getAccessibleContext().setAccessibleName("background");

        pack();
    }

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        signupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/images/signup/signup_btn_h.png")));
        String uname = username.getText();
        String pword = new String(password.getPassword());
        String addrs = address.getText();
        String phone = mobileNumber.getText();

        new Customer(uname, pword, addrs, phone);
    }
}
