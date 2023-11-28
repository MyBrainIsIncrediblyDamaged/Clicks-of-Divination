/**
 * 
 * @author James Hooson
 */
import javax.swing.*;
public class ClickerGame {
    public static void main(String[] args){
        JFrame frame = new JFrame("Clicks of Divination");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ClickerPanel());
        frame.pack();
        frame.setVisible(true);
        
    }
}