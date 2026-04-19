package src.Main;

import java.io.InputStream;
import java.awt.*;
import java.io.IOException;
import src.Assets.Sound;

import javax.swing.*;

public class Panel extends JPanel {

    Graphics2D g2;
    UI ui = new UI(this);
    Sound se = new Sound();
    MouseHandler mouse = new MouseHandler(ui, this);
    
    int sec = 60, min = 0;
    int ticks = 0;
    

    final int screenWidth = 500;
    final int screenHeight = 650;

    Font maruMonica;

    public Panel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        this.setLayout(null);
        this.setDoubleBuffered(true);

        this.addMouseListener(mouse);

        try{
            InputStream is = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);

        }catch(FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(ui.eggCount > 0){
            System.out.print("Clicked!");        
        }

        Timer timer = new Timer(1000/120, e -> {
            if(ui.uiCount == 2){ // only count during timer screen
                ticks++;
                if(ticks % 60 == 0){
                    if(sec > 0){
                        sec--;
                    } else if(min > 0){
                        sec = 59;
                        min--;
                    } else {
                        playSound(0);
                    }
                }
            }
            repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D)g; 
        g2.setFont(maruMonica);
        g2.setColor(Color.white);

        ui.draw(g2);
    }

    public void playSound(int i){
        se.setFile(i);
        se.play();
        }
}
