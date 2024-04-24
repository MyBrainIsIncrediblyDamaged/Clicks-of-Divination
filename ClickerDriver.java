/**
 * 
 * @author James Hooson
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.CardLayout;
import javax.swing.*;
public class ClickerDriver {
    static CardLayout layout = new CardLayout();
    static JFrame frame;
    static Container contentPane;
   
    
    public static void main(String[] args){
         frame = new JFrame("Clicks of Divination");
        contentPane = frame.getContentPane();
        
        
        
        contentPane.setLayout(layout);
        ClickerPanel cPanel = new ClickerPanel();
        TarotPanel tPanel = new TarotPanel(cPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cPanel.TarotButton.addActionListener(new cpanelListener());
        tPanel.panelButton.addActionListener(new tpanelListener());
        contentPane.add(cPanel,0);
        contentPane.add(tPanel,1);
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.pack();
        frame.setVisible(true);
        
        
    }
    public static class cpanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            layout.last(contentPane);


        }
    }
    public static class tpanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            layout.first(ClickerDriver.frame.getContentPane());

        }
    }
}