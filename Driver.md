import javax.swing.*;
import java.awt.Dimension;

/**
 * This class is the Driver Class for Clicks of Divination, it creates a Frame and 
 */
public class Driver {
    static JFrame frame = new JFrame("Tarot Draw Tester");
    public static void main(String args[]){
        TarotPanel tPanel = new TarotPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(tPanel);
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.pack();
        frame.setVisible(true);
    }
}