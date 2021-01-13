package com.talabat;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AddMeal extends JFrame {
    private JLabel backGround;
    private JButton addButton;
    private JButton browseButton;
    private JTextField mealName;
    private JTextField price;
    private JTextArea description;
    private ImagePanel img;
    private Dimension screenSize;
    private String slectedImagepath;

    public AddMeal() {
        initComponents();
    }

    private void initComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        addButton = new JButton();
        browseButton = new JButton();
        mealName = new JTextField();
        price = new JTextField();
        description = new JTextArea();
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
        addButton.setIcon(new ImageIcon(getClass().getResource("assets/images/addmeal/addmeal_btn.png")));
        addButton.setBorderPainted(false);
        addButton.setMargin(new Insets(0, 0, 0, 0));

//        addButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                addButtonActionPerformed(evt);
//            }
//        });
        getContentPane().add(addButton);
        addButton.setBounds(109, 527, 103, 29);

        browseButton.setBackground(new Color(255, 90, 0));
        browseButton.setForeground(new Color(255, 255, 255));
        browseButton.setIcon(new ImageIcon(getClass().getResource("assets/images/addmeal/browseimg_btn.png")));
        browseButton.setBorderPainted(false);
        browseButton.setMargin(new Insets(0, 0, 0, 0));

        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseButtonActionPerformed(evt);
                img = new ImagePanel(slectedImagepath);
                add(img);

                img.setBounds(34, 342, 254, 155);
            }
        });
        getContentPane().add(browseButton);
        browseButton.setBounds(34, 305, 103, 29);

        backGround.setIcon(new ImageIcon(getClass().getResource("assets/images/addmeal/background.png")));
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 359, 571);

        mealName.setText("");
        mealName.setBackground(new Color(235, 235, 235));
        mealName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        getContentPane().add(mealName);
        mealName.setBounds(34, 81, 254, 31);

        price.setText("");
        price.setBackground(new Color(235,235,235));
        price.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        getContentPane().add(price);
        price.setBounds(34,142,64,31);

        description.setText("");
        description.setBackground(new Color(235,235,235));
        description.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        getContentPane().add(description);
        description.setBounds(110,142,178,155);

        pack();
    }

    private void browseButtonActionPerformed(ActionEvent evt) {
        JFileChooser browseimagefile = new JFileChooser();

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseimagefile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseimagefile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseimagefile.getSelectedFile();
            slectedImagepath = selectedImageFile.getAbsolutePath();
        }
    }

    public class ImagePanel extends JPanel{

        private BufferedImage image;
        private String path;

        public ImagePanel(String path) {
            this.path = path;
            try {
                image = ImageIO.read(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public BufferedImage resize(BufferedImage img, int newW, int newH) {
            Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
            BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = dimg.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();

            return dimg;
        }

        ImageIcon img = new ImageIcon(path);
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(this.resize(image, 254, 155), 0, 0, this); // see javadoc for more info on the parameters
        }

    }
}
