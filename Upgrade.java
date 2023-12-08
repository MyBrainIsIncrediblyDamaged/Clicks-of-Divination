import javax.swing.*;
import java.awt.*;

public class Upgrade extends JButton{
    
    boolean isAvailable;
    boolean isHidden;
    int cost;
    double multiplier;
    int count;
    String target;
    String name;
    String description;
    int index;
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
        this.multiplier = multiplier;
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
    
    public void setHidden(boolean isHidden){
        this.isHidden = isHidden;
    }
    public int getCount(){
        return count;
    }
    public String getName(){
        return this.name;
    }
    public void addCount(){
        this.count++;
    }
    public int getIndex(){
        return index;
    }
    public void setIndex(int i){
        this.index = i;
    }
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

}
