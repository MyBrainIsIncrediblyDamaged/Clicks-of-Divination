/**
 * 
 * @author James Hooson
 */
import java.awt.Dimension;

import javax.swing.*;
public class ClickerGame {
    static JFrame frame = new JFrame("Clicker game related to divination");
    
    public static void main(String[] args){
         ClickerPanel cPanel = new ClickerPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(cPanel);
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.pack();
        frame.setVisible(true);
        
    }
}