package com.talabat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterCustomer extends JFrame {
    private JLabel backGround;
    private JButton signupButton;
    private JButton backButton;
    private JTextField username;
    private JTextField address;
    private JTextField mobileNumber;
    private JPasswordField password;
    private Dimension screenSize;
    private Customer customer;

    public RegisterCustomer(Customer c) {
        customer = c;
        initComponents();
    }

    private void initComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        signupButton = new JButton();
        backButton = new JButton();
        backGround = new JLabel();
        username = new JTextField();
        password = new JPasswordField();
        address = new JTextField();
        mobileNumber = new JTextField();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle((int)width * 38 / 100, (int)height / 10, 406, 656));
        setMinimumSize(new Dimension(336, 571));
        setTitle("Customer");
        setResizable(false);
        setSize(new Dimension(336, 571));
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

        backButton.setBackground(new Color(255, 90, 0));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setIcon(new ImageIcon(getClass().getResource("assets/images/common/back_btn.png")));
        backButton.setBorderPainted(false);
        backButton.setMargin(new Insets(0, 0, 0, 0));
        backButton.setMaximumSize(new Dimension(116, 31));
        backButton.setMinimumSize(new Dimension(116, 31));
        backButton.setPreferredSize(new Dimension(116, 31));

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(3, 5, 43, 24);

        username.setBackground(new Color(242, 242, 242));
        getContentPane().add(username);
        username.setBounds(43, 232, 237, 26);

        password.setText("");
        password.setBackground(new Color(242, 242, 242));
        getContentPane().add(password);
        password.setBounds(43, 287, 237, 26);

        address.setText("");
        address.setBackground(new Color(242, 242, 242));
        getContentPane().add(address);
        address.setBounds(43, 342, 237, 26);

        mobileNumber.setText("");
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

        if(validation(uname))
            new Customer(uname, pword, addrs, phone);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt){
        this.setVisible(false);
        new LoginPanel(customer).setVisible(true);
    }

    private boolean validation(String uname) throws SQLException {
        boolean valid = false;
        if(username.getText().isEmpty()){
            System.out.println("please enter a username");
        } else {
            Statement select = Main.conn.createStatement();
            String query = "select CUSTOMER_USERNAME from CUSTOMER";
            ResultSet usernameSet = select.executeQuery(query);

            while(usernameSet.next()){
                if(usernameSet.getString(1).equals(uname)) {
                    System.out.println("Username already used");
                    valid = false;
                    break;
                } else valid = true;
            }
        }
        return valid;
    }
}
