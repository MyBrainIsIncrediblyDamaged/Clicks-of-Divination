/**
 * 
 * @author James Hooson
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StatsPanel extends JPanel{
    /*
    List of stats
        Divination Energy
        DE per second
        Click profit
        Autoclick profit
        Divine Insight
     */
    double DE = 0;
    double DEs = 0;
    double Cp = 1;
    double ACp = 1;
    int DI = 0;
    double DIm = 1.03;
    double Cpm = 1;
    JButton[][] statsGrid;
    
    //Getters 
    public double getDE(){
        return DE;
    }
    public double getDEs(){
        return DEs;
    }
    public double getCp(){
        return Cp;
    }
    public double getACp(){
        return ACp;
    }
    public int getDI(){
        return DI;
    }
    public double getDIm(){
        return DIm;
    }
    
    //Setters
    public void setCp(double Cp){
        this.Cp = Cp;
    }
    public void setACp(){
        this.ACp = Cp * Cpm;
    }
    public void setDI(int DI){
        this.DI = DI;
    }
    public void setDIm(double DIm){
        this.DIm = DIm;
    }
    public StatsPanel(){
        statsGrid = new JButton[2][3];
        for(int a=0;a<statsGrid.length;a++){
            for(int b=0;b<statsGrid[a].length;b++){
                statsGrid[a][b] = new JButton();
            }
        }
        statsGrid[0][0].setText(String.valueOf(DE));
        statsGrid[1][0].setText(String.valueOf(DEs));
        statsGrid[0][1].setText(String.valueOf(Cp));
        statsGrid[1][1].setText(String.valueOf(ACp));
        statsGrid[0][2].setText(String.valueOf(DI));
        statsGrid[1][2].setText(String.valueOf(DIm));
        for(int a=0;a<statsGrid.length;a++){
            for(int b=0;b<statsGrid[a].length;b++){
                this.add(statsGrid[a][b]);
            }
        }
        
    }
    public void Update(){
        statsGrid[0][0].setText(String.valueOf(DE));
        statsGrid[1][0].setText(String.valueOf(DEs));
        statsGrid[0][1].setText(String.valueOf(Cp));
        statsGrid[1][1].setText(String.valueOf(ACp));
        statsGrid[0][2].setText(String.valueOf(DI));
        statsGrid[1][2].setText(String.valueOf(DIm));
    }
    public void ClickIncrement(){
        DE += Cp;
    }
    public void AcIncrement(){
        DE += ACp;
    }
    public void Sincrement(double i){
        DE += DEs;
    }
    
}
