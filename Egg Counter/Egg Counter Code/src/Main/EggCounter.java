package src.Main;
import javax.swing.JFrame;

public class EggCounter {
    public static void main(String[] args){
        //An app that helps you cook eggs! Inspired by Nasha 

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Egg Counter");

        Panel panel = new Panel();
        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }  
}
