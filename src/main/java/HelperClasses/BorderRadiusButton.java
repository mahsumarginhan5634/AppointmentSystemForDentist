package HelperClasses;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class BorderRadiusButton extends JButton 
{

    public BorderRadiusButton(String text) 
    {
        setBorder(new RoundedBorder(20)); // Yumusaklik icin yaricap degerini degistirebilirsiniz
    }
    
    public BorderRadiusButton(ImageIcon icon)
    {
    	super(icon);
    	setBorder(new RoundedBorder(30));
    }

    private static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}