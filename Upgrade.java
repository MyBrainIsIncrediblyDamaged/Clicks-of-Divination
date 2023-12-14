import javax.swing.*;
import java.awt.*;

public class Upgrade extends JButton{
    
    boolean isAvailable;
    boolean isHidden;
    int cost;
    double multiplier;
    double init_mult;
    int count;
    String target;
    String name;
    String description;
    int index;
    int base_cost;
    public Upgrade(){
        this.isAvailable = false;
        this.isHidden = true;
        this.cost = 0;
        this.multiplier = 1;
    }
    
    public Upgrade(String name, int cost, double multiplier){
        this.isAvailable = false;
        this.isHidden = true;
        this.cost = cost;
        this.base_cost = cost;
        this.multiplier = multiplier;
        this.init_mult = multiplier;
        this.name = name;
        this.count = 0;
        this.target = "";
        this.description = "";
        this.index = 0;
    }

    //Getters and Setters
    public boolean getAvailable(){
        return isAvailable;
    }
    /**
     * sets the availability of the Upgrade.
     * @param isAvailable
     */
    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
    /*
     * Tells you if the upgrade is hidden 
     */
    public boolean getHidden(){
        return isHidden;
    }
    /*
     * Sets whether the upgrade is hidden or not.
     */
    public void setHidden(boolean isHidden){
        this.isHidden = isHidden;
    }
    /**
     * outputs the quantity of the upgrade.
     * @return quantity of the count.
     */
    public int getCount(){
        return count;
    }
    /**
     * outputs the name of the upgrade
     * @return name for the upgrade.
     */
    public String getName(){
        return this.name;
    }
    /**
     * increment the quantity of the upgrade
     */
    public void addCount(){
        this.count++;
    }
    /**
     * outputs the Index
     * @return Index for source upgrades
     */
    public int getIndex(){
        return index;
    }
    /**
     * sets the index
     * @param i index to set to
     */
    public void setIndex(int i){
        this.index = i;
    }
    /**
     * outputs upgrade cost
     * @return
     */
    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public double getMultiplier(){
        return multiplier;
    }

    public void setMultiplier(double multiplier){
        this.multiplier = multiplier;
    }
    public String getTarget(){
        return target;
    }
    public void setTarget(String target){
        this.target = target;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String desc){
        this.description = desc;
    }
    //Purchase a listed quantity of said upgrade.
    public void purchase(int count){
        this.count += count;
        this.isAvailable = false;
    }
    public void reset(){
        this.isAvailable = false;
        this.isHidden = true;
        this.count = 0;
        this.cost = base_cost;
        this.multiplier = init_mult;
    }

}
