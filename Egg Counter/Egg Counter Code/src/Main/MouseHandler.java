package src.Main;

import java.awt.event.*;

public class MouseHandler implements MouseListener {

    UI ui;
    Panel panel;

    public MouseHandler(UI ui, Panel panel){
        this.ui = ui;
        this.panel = panel;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.print("Clicked at (" + x + "," + y + ")");

        if(ui.eggCount == 0){
            if(x > 100 && x < 350 && y > 350 && y < 450){
                ui.eggCount++;
                panel.repaint(); 
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
