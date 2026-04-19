package src.Main;

import java.awt.*;
import javax.swing.*;

public class UI {

    Panel panel;
    Graphics2D g2;
    Image egg1, egg2, egg3, egg4, egg5, egg6, bg;
    Image rawegg, softegg, cookegg, overcookegg;
    Image leftarrow, rightarrow;
    Image cook, cooking;
    int uiCount = 0, eggCount = 0, eggChoice = 0;
    boolean timerStart = false;
    

    public UI(Panel panel){
        this.panel = panel;

        egg1 = new ImageIcon(getClass().getResource("/res/asset/Smaller egg.png")).getImage();
        egg2 = new ImageIcon(getClass().getResource("/res/asset/Smaller egg cracked 1.png")).getImage();
        egg3 = new ImageIcon(getClass().getResource("/res/asset/Smaller egg cracked 2.png")).getImage();
        egg4 = new ImageIcon(getClass().getResource("/res/asset/Smaller egg cracked 3.png")).getImage();
        egg5 = new ImageIcon(getClass().getResource("/res/asset/Smaller egg cracked 4.png")).getImage();
        egg6 = new ImageIcon(getClass().getResource("/res/asset/Smaller egg cracked 5.png")).getImage();

        rawegg = new ImageIcon(getClass().getResource("/res/asset/runny boiled egg.png")).getImage();
        softegg = new ImageIcon(getClass().getResource("/res/asset/soft boiled egg.png")).getImage();
        cookegg = new ImageIcon(getClass().getResource("/res/asset/boiled egg.png")).getImage();
        overcookegg = new ImageIcon(getClass().getResource("/res/asset/overboiled egg.png")).getImage();

        leftarrow = new ImageIcon(getClass().getResource("/res/asset/leftarrow.png")).getImage();
        rightarrow = new ImageIcon(getClass().getResource("/res/asset/righttarrow.png")).getImage();

        cook = new ImageIcon(getClass().getResource("/res/asset/Cook.png")).getImage();
        cooking = new ImageIcon(getClass().getResource("/res/asset/cooking.png")).getImage();

        bg = new ImageIcon(getClass().getResource("/res/asset/trial.png")).getImage();

    }

    public void draw(Graphics2D g2){

        if(uiCount == 0){
            panel.setBackground(Color.decode("#FFD872"));
            title(g2);
            drawImage(g2);
        }
        else if(uiCount == 1){
            panel.setBackground(Color.decode("#f8da8f"));
            drawImage(g2);
            pickEggScreen(g2);
        }
        else if(uiCount == 2){
            panel.setBackground(Color.decode("#f4124f"));
            drawImage(g2);
        }
    }

    public void drawImage(Graphics2D g2){

        if(uiCount == 0){
            switch(eggCount){

                case 0: g2.drawImage(egg1,200,350,100,100, null); break;
                case 1: g2.drawImage(egg2,200,350,100,100, null); break;
                case 2: g2.drawImage(egg3,200,350,100,100, null); break;
                case 3: g2.drawImage(egg4,200,350,100,100, null); break;
                case 4: g2.drawImage(egg5,200,350,100,100, null); break;
                case 5: g2.drawImage(egg6,200,350,100,100, null); break;
            }       
        }
    
        else if(uiCount == 1){
            g2.drawImage(bg, 0,0,500,650,null);
            g2.drawImage(cook,210,450,100,100,null);

            switch(eggChoice){

                case 0 -> {
                    g2.drawImage(rawegg,105,125,300,300,null);
                    g2.drawImage(rightarrow, 400, 275,75,75,null);
                    g2.drawImage(leftarrow, 40, 275,75,75,null);
                    break;
                }
                case 1 -> {
                    g2.drawImage(softegg,105,125,300,300,null);
                    g2.drawImage(rightarrow, 400, 275,75,75,null);
                    g2.drawImage(leftarrow, 40, 275,75,75,null);
                    break;
                }
                case 2 -> {
                    g2.drawImage(cookegg,105,125,300,300,null);
                    g2.drawImage(rightarrow, 400, 275,75,75,null);
                    g2.drawImage(leftarrow, 40, 275,75,75,null);
                    break;
                }
                case 3 -> {
                    g2.drawImage(overcookegg,105,125,300,300,null);
                    g2.drawImage(rightarrow, 400, 275,75,75,null);
                    g2.drawImage(leftarrow, 40, 275,75,75,null);
                    break;
                }
            }
        }
        else if(uiCount == 2){
            g2.drawImage(cooking,0,0,500,650,null);
            timer(g2);
        }
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

    public void pickEggScreen(Graphics2D g2){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
        String text = "HOW DO YOU WANT YOUR EGGS?";

        int x =  getXforCenteredText(g2, text);
        int y =  panel.screenHeight / 6;

        g2.setColor(Color.white);
        g2.drawString(text, x, y);

    }

    public void timer(Graphics2D g2){

    if(!timerStart){
        switch(eggChoice){
                case 0 -> {panel.min = 3;}
                case 1 -> {panel.min = 7;}
                case 2 -> {panel.min = 11;}
                case 3 -> {panel.min = 15;}
        }
        panel.sec = 59;
        timerStart = true;
    }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 90));
        String text = panel.min + ":" + String.format("%02d", panel.sec);;

        int x =  getXforCenteredText(g2, text);
        int y =  panel.screenHeight / 4;

        g2.setColor(Color.black);
        g2.drawString(text, x, y);

    }
}
