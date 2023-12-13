/**
 * 
 * @author James Hooson
 */
import javax.swing.*;

import java.awt.Color;
import java.text.*;
public class StatsPanel extends JPanel{
    /*
    List of stats
        Divination Energy
        DE per second
        Click profit(Base, Multiplier, Current,)
        Autoclick profit(Base, Multiplier, Current)
        Divine Insight
     */
    DecimalFormat df = new DecimalFormat("0.00");
    double DE = 0;
    //double DE = 400000000;
    long DEl= 0L;
    double DEs = 0;
    double Cp = 1;
    int CpBase = 1;
    double CpMult = 1;
    double ACp = 1;
    long DI = 0;
    double DIm = 1.04;
    double Cpm = 1;
    double ACpm = 1;
    double pMult = 1;
    JButton[][] statsGrid;
    
    //Getters 
    public long getDEL(){
        return DEl;
    }
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

    public long getDI(){
        return DI;
    }

    public double getDIm(){
        return DIm;
    }
    public double getPMult(){
        return pMult;
    }
    public double getCpMult(){
        return CpMult;
    }

    //Setters
    public void updateCp(){
        this.Cp = CpBase * CpMult * DIm;
        updateACp();
    }
    public void addCp(int Cp){
        this.CpBase += Cp;
        updateCp();
    }

    public void addACp(double mult){
        this.ACpm = mult * ACpm;
        this.ACp = Cp * ACpm * DIm;
    }
 public void updateACp(){
        this.ACp = Cp * ACpm;
    }
    public void setDI(long DI){
        this.DI = DI;
    }

    public void setDIm(double DIm){
        this.DIm = DIm;
    }
    public void setPMult(double pMult){
        this.pMult = pMult;
    }
    public void setDEs(double DEs){
        this.DEs = DEs;
    }
    public StatsPanel(){
        statsGrid = new JButton[2][3];
        this.setBackground(Color.darkGray);
        for(int a=0;a<statsGrid.length;a++){
            for(int b=0;b<statsGrid[a].length;b++){
                statsGrid[a][b] = new JButton();
            }
        }
        statsGrid[0][0].setText(String.valueOf(DEl) + String.valueOf(DE));
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
        double DImP = (DIm - 1)*100;
        DecimalFormat i = new DecimalFormat("#");
        updateCp();
        updateACp();
        
        statsGrid[0][0].setText("Divination Energy(DE): "+String.valueOf(df.format(DE)));
        statsGrid[1][0].setText("DE/s: "+String.valueOf(df.format(DEs)));
        statsGrid[0][1].setText("Click Profit: "+String.valueOf(df.format(Cp)));
        statsGrid[1][1].setText("AutoClick Profit: "+String.valueOf(df.format(ACp)));
        statsGrid[0][2].setText("Divine Insight(DI): "+String.valueOf(df.format(DI)));
        statsGrid[1][2].setText("Multiplier for Divine Insight: "+i.format(DImP) + "%");
    }
    public void ClickIncrement(){
        DE += Cp;
        this.Update();
    }
    public void AcIncrement(){
        DE += ACp;
        this.Update();
    }
    public void Sincrement(){
        DE += (DEs / 40);
        DEl = (long) DE;
        this.Update();
    }
    public void subtractDE(double amount){
        DE -= amount;
    }
    public void Reset(){
    DE = 0;
    DEl= 0;
    Cp = 1;
    CpBase = 1;
    CpMult = 1;
    ACp = 1;
    Cpm = 1;
    ACpm = 1;
    pMult = 1;
    Update();
    }
}
