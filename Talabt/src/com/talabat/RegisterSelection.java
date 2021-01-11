package com.talabat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterSelection extends JFrame {
    private JButton customerButton;
    private JLabel backGround;
    private JButton restaurantButton;
    private JButton backButton;
    Dimension screenSize;

    public RegisterSelection() {
        initComponents();
    }

    private void initComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        customerButton = new JButton();
        restaurantButton = new JButton();
        backButton = new JButton();
        backGround = new JLabel();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle((int)width * 38 / 100, (int)height / 10, 406, 686));
        setMinimumSize(new Dimension(321, 601));
        setTitle("Register");
        setResizable(false);
        setSize(new Dimension(321, 601));
        getContentPane().setLayout(null);

        customerButton.setBackground(new Color(255, 90, 0));
        customerButton.setForeground(new Color(255, 255, 255));
        customerButton.setIcon(new ImageIcon(getClass().getResource("assets/images/signup/customer.png")));
        customerButton.setBorderPainted(false);
        customerButton.setMargin(new Insets(0, 0, 0, 0));
        customerButton.setMaximumSize(new Dimension(116, 31));
        customerButton.setMinimumSize(new Dimension(116, 31));
        customerButton.setPreferredSize(new Dimension(116, 31));

        customerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(customerButton);
        customerButton.setBounds(59, 317, 203, 31);

        restaurantButton.setBackground(new Color(255, 90, 0));
        restaurantButton.setForeground(new Color(255, 255, 255));
        restaurantButton.setIcon(new ImageIcon(getClass().getResource("assets/images/signup/restaurant.png")));
        restaurantButton.setBorderPainted(false);
        restaurantButton.setMargin(new Insets(0, 0, 0, 0));
        restaurantButton.setMaximumSize(new Dimension(116, 31));
        restaurantButton.setMinimumSize(new Dimension(116, 31));
        restaurantButton.setPreferredSize(new Dimension(116, 31));


        restaurantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                restaurantButtonActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantButton);
        restaurantButton.setBounds(59, 375, 203, 31);

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

        backGround.setIcon(new ImageIcon(getClass().getResource("assets/images/login/background.png")));
        backGround.setText("backGround");
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 359, 571);
        backGround.getAccessibleContext().setAccessibleName("background");

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt){
        this.setVisible(false);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPanel().setVisible(true);
            }
        });
    }

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt){
        customerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/images/signup/customer_h.png")));
        this.setVisible(false);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterCustomer().setVisible(true);
            }
        });
    }

    private void restaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {
        restaurantButton.setIcon(new ImageIcon(getClass().getResource("assets/images/signup/restaurant_h.png")));
//        this.setVisible(false);
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterPanel().setVisible(true);
//            }
//        });
        System.out.println("boob");
    }
}
