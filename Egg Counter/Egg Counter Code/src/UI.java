package src;

import java.io.InputStream;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import java.text.DecimalFormat;

public class UI {

    Panel panel;
    Graphics2D g2;
    Font maruMonica;

    public UI(Panel panel){
        this.panel = panel;

        try{
            InputStream is = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);

        }catch(FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        title(g2);
    }

    public void screen(){}
    

    public void title(Graphics2D g2){
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 90));
        String text = "EGG COUNTER";

        int x =  getXforCenteredText(g2, text);
        int y =  panel.screenHeight / 3;

        g2.setColor(Color.black);
        g2.drawString(text, x+6, y+6);

        g2.setColor(Color.white);
        g2.drawString(text, x, y);

    }

        public int getXforCenteredText(Graphics2D g2, String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = (panel.screenWidth - length) / 2;
        return x;

    }
}
