package com.talabat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerHome extends JFrame{
    private JLabel backGround;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton browseButton;
    private Dimension screenSize;

    public OwnerHome() {
        initComponents();
    }

    private void initComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        addButton = new JButton();
        editButton = new JButton();
        removeButton = new JButton();
        browseButton = new JButton();
        backGround = new JLabel();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle((int)width * 38 / 100, (int)height / 10, 406, 686));
        setMinimumSize(new Dimension(336, 601));
        setTitle("Register");
        setResizable(false);
        setSize(new Dimension(336, 601));
        getContentPane().setLayout(null);

        addButton.setBackground(new Color(255, 90, 0));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/addmeal_btn.png")));
        addButton.setBorderPainted(false);
        addButton.setMargin(new Insets(0, 0, 0, 0));
        addButton.setMaximumSize(new Dimension(116, 31));
        addButton.setMinimumSize(new Dimension(116, 31));
        addButton.setPreferredSize(new Dimension(116, 31));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(92, 270, 137, 39);

        editButton.setBackground(new Color(255, 90, 0));
        editButton.setForeground(new Color(255, 255, 255));
        editButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/editmeal_btn.png")));
        editButton.setBorderPainted(false);
        editButton.setMargin(new Insets(0, 0, 0, 0));
        editButton.setMaximumSize(new Dimension(116, 31));
        editButton.setMinimumSize(new Dimension(116, 31));
        editButton.setPreferredSize(new Dimension(116, 31));


        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton);
        editButton.setBounds(92, 332, 137, 39);

        removeButton.setBackground(new Color(255, 90, 0));
        removeButton.setForeground(new Color(255, 255, 255));
        removeButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/rmvmeal_btn.png")));
        removeButton.setBorderPainted(false);
        removeButton.setMargin(new Insets(0, 0, 0, 0));
        removeButton.setMaximumSize(new Dimension(116, 31));
        removeButton.setMinimumSize(new Dimension(116, 31));
        removeButton.setPreferredSize(new Dimension(116, 31));

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeButton);
        removeButton.setBounds(92, 394, 137, 39);

        browseButton.setBackground(new Color(255, 90, 0));
        browseButton.setForeground(new Color(255, 255, 255));
        browseButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/browseord_btn.png")));
        browseButton.setBorderPainted(false);
        browseButton.setMargin(new Insets(0, 0, 0, 0));
        browseButton.setMaximumSize(new Dimension(116, 31));
        browseButton.setMinimumSize(new Dimension(116, 31));
        browseButton.setPreferredSize(new Dimension(116, 31));

        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(browseButton);
        browseButton.setBounds(92, 456, 137, 39);

        backGround.setIcon(new ImageIcon(getClass().getResource("assets/images/common/background.png")));
        backGround.setText("backGround");
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 359, 571);

        pack();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt){
        addButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/addmeal_btn_h.png")));
        this.setVisible(false);
        new AddMeal().setVisible(true);
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("aa");
        editButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/editmeal_btn_h.png")));
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("aaa");
        removeButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/rmvmeal_btn_h.png")));
    }

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("aaaa");
        browseButton.setIcon(new ImageIcon(getClass().getResource("assets/images/rstown/browseord_btn_h.png")));
    }
}
