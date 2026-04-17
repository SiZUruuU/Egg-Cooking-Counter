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

        if(ui.uiCount == 0){
            if(x > 100 && x <= 350 && y >= 350 && y <= 450){
                ui.eggCount++;
                System.out.print("Egg Count: " + ui.eggCount);
                    if(ui.eggCount == 6){
                        ui.uiCount++;
                    }
                panel.repaint(); 
            }
        }

        if(ui.uiCount == 1){
            if(x >= 400 && x <= 475 && y >= 275 && y <= 355){
                if(ui.eggChoice < 3){
                    ui.eggChoice++;
                    panel.repaint();
                    System.out.println("\n\nEgg Choice: " + ui.eggChoice);
                }
                else if(ui.eggChoice == 3){
                    ui.eggChoice = 0;
                    panel.repaint();
                    System.out.println("\n\nEgg Choice: " + ui.eggChoice);
                }
            }
            else if(x >= 40 && x <= 115 && y >= 275 && y <= 355){
                if(ui.eggChoice > 0){
                    ui.eggChoice--;
                    panel.repaint();
                    System.out.println("\n\nEgg Choice: " + ui.eggChoice);
                }
                else if(ui.eggChoice == 0){
                    ui.eggChoice = 3;
                    panel.repaint();
                    System.out.println("\n\nEgg Choice: " + ui.eggChoice);
                }
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
