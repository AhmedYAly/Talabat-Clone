package com.talabat;

import java.awt.*;
import javax.swing.*;

public class login extends JPanel{
    private Image img;

    public login (String img){
        this(new ImageIcon(img).getImage());
    }

    public login (Image img){
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        setLayout(null);
    }

    public void draw(Graphics gphx){
        gphx.drawImage(img, 0, 0, null);
    }
}
