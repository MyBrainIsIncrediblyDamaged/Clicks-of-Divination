import javax.swing.*;
import java.awt.*;
public class Upgrade extends JButton{
    boolean isAvailable;
    boolean isHidden;
    int cost;
    double multiplier;
    String name;
    public Upgrade(){
        this.isAvailable = false;
        this.isHidden = true;
        this.cost = 0;
        this.multiplier = 0;
        this.name = "Unnamed Upgrade";
    }
    public Upgrade(String name, int cost, double multiplier){
        this.isAvailable = false;
        this.isHidden = true;
        this.cost = cost;
        this.multiplier = multiplier;
        this.name = name;
    }

    //Getters and Setters
    public boolean getAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public boolean getHidden(){
        return isHidden;
    }

    public void setHidden(boolean isHidden){
        this.isHidden = isHidden;
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

}
