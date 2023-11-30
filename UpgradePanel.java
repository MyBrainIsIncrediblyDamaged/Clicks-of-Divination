/**
 * 
 * @author James Hooson
 */
import javax.swing.*;
import java.awt.*;
public class UpgradePanel extends JPanel{
    /**
     * Upgrade sets
     * Scrying
     * Tarot cards(minor and major)
     * Runes
     * Palm reading
     * Clear sense stuff
     * Click Profit upgrades (**Required**)
     */
    Upgrade[] Upgrades;



    public UpgradePanel(){
        this.Upgrades = new Upgrade[9];
        for(int i = 0; i < Upgrades.length;i++){
            Upgrades[i] = new Upgrade();
        }
        Upgrades[0].setName("Click Profit Upgrade");
    }






}
