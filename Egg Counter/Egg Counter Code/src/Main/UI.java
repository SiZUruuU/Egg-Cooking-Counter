package src.Main;

import java.io.InputStream;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class UI {

    Panel panel;
    Graphics2D g2;
    Font maruMonica, purisa;
    Image egg;
    int eggCount;

    public UI(Panel panel){
        this.panel = panel;

        try{
            InputStream is = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);

            is = getClass().getResourceAsStream("/res/font/Purisa Bold.ttf");
            purisa = Font.createFont(Font.TRUETYPE_FONT, is);

        }catch(FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        egg = new ImageIcon(getClass().getResource("/res/asset/Smaller egg.png")).getImage();

    }

    public void draw(Graphics2D g2){
        title(g2);
        drawImage(g2);
    }

    public void drawImage(Graphics2D g2){

        g2.drawImage(egg,200,350,100,100, null);
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

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25));
        text = "> > >Press Egg to Start< < <";

        x =  getXforCenteredText(g2, text);
        y =  panel.screenHeight - 180;

        g2.setColor(Color.white);
        g2.drawString(text, x, y);
    }

        public int getXforCenteredText(Graphics2D g2, String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = (panel.screenWidth - length) / 2;
        return x;

    }
}
