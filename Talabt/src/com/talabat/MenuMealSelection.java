package com.talabat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMealSelection extends JFrame{
    private JButton backButton;
    private JButton infoButton;
    private JComboBox rstName;
    private JComboBox mealName;
    private JLabel rstNamelbl;
    private JLabel mealNamelbl;
    private JLabel backGround;
    private Dimension screenSize;

    public MenuMealSelection(){
        initComponents();
    }

    private void initComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        getContentPane().setBackground(new Color(255, 255, 255));

        infoButton = new JButton();
        backButton = new JButton();
        backGround = new JLabel();
        rstName = new JComboBox();
        rstNamelbl = new JLabel();
        mealNamelbl = new JLabel();
        mealName = new JComboBox();

        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle((int) width * 38 / 100, (int) height / 10, 406, 686));
        setMinimumSize(new Dimension(336, 601));
        setTitle("Register");
        setResizable(false);
        setSize(new Dimension(336, 601));
        getContentPane().setLayout(null);

        infoButton.setBackground(new Color(255, 90, 0));
        infoButton.setForeground(new Color(255, 255, 255));
        infoButton.setIcon(new ImageIcon(getClass().getResource("assets/images/mealinf/inf_button.png")));
        infoButton.setBorderPainted(false);
        infoButton.setMargin(new Insets(0, 0, 0, 0));

//        infoButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                infoButtonActionPerformed(evt);
//            }
//        });
        getContentPane().add(infoButton);
        infoButton.setBounds(96, 468, 129, 36);

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

        backGround.setIcon(new ImageIcon(getClass().getResource("assets/images/mealinf/background.png")));
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 359, 571);

        rstName.setBounds(58,167,206,39);
        rstName.setFont(new java.awt.Font("Myraid Pro", 0, 18));
        getContentPane().add(rstName);
        rstName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None"}));

        mealName.setBounds(58,274,206,39);
        mealName.setFont(new java.awt.Font("Myraid Pro", 0, 18));
        getContentPane().add(mealName);
        mealName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None"}));

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt){
        this.setVisible(false);
        new CusHome().setVisible(true);
    }
}
