/**
 * 
 * @author James Hooson
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClickerPanel extends JPanel{
    JPanel upgrades;
    StatsPanel stats = new StatsPanel();
    sourcePanel sPanel;
    JButton orb = new JButton(new ImageIcon("Mirror.png"));
    JButton[] sources = new JButton[6];
        public ClickerPanel(){
        orb.setBorderPainted(false);
        orb.setContentAreaFilled(false);
        orb.setFocusPainted(false);
        orb.setOpaque(false);
        orb.addActionListener(clickListener);
        this.add(orb);
        

    }
    

    /**
     * Opens a 
     */
    private class sourcePanel extends JPanel {{
        //Creates an array of buttons
        for (int i = 0; i < sources.length; i++){
            sources[i] = new JButton();
        }
        sources[0].setIcon(new ImageIcon("CrystalBall.png"));
    }
    public class clickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton clicked = (JButton) e.getSource();
            if(clicked.equals(orb)){
                stats.ClickIncrement();
            };
            else{};
        }
    }




}}
