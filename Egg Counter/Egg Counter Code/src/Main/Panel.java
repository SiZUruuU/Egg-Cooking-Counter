package src.Main;
import java.io.InputStream;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import java.text.DecimalFormat;

public class Panel extends JPanel {

    Graphics2D g2;
    UI ui = new UI(this);
    MouseHandler mouse = new MouseHandler(ui, this);
    

    final int screenWidth = 500;
    final int screenHeight = 650;

    Font maruMonica;

    public Panel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.decode("#FFD872"));
        
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
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); // ✅ Always call this first

        Graphics2D g2 = (Graphics2D)g; // ✅ Cast to Graphics2D here
        g2.setFont(maruMonica);
        g2.setColor(Color.white);

        ui.draw(g2); // ✅ Pass g2 as a parameter
    }

    // public void screen(){

    // }

    // public void title(Graphics2D g2){
        
    //     g2.setFont(g2.getFont().deriveFont(Font.BOLD, 90));
    //     String text = "EGG COUNTER";

    //     int x =  getXforCenteredText(g2, text);
    //     int y =  screenHeight / 3;

    //     g2.setColor(Color.black);
    //     g2.drawString(text, x+6, y+6);

    //     g2.setColor(Color.white);
    //     g2.drawString(text, x, y);

    // }

    //     public int getXforCenteredText(Graphics2D g2, String text){

    //     int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    //     int x = (screenWidth - length) / 2;
    //     return x;

    // }
}
