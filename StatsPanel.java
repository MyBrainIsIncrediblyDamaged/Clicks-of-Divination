/**
 * 
 * @author James Hooson
 */
import javax.swing.*;
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
    DecimalFormat df = new DecimalFormat("#.###");
    double DE = 0;
    double DEs = 0;
    double Cp = 1;
    int CpBase = 1;
    double CpMult = 1;
    double ACp = 1;
    int DI = 0;
    double DIm = 1.03;
    double Cpm = 1;
    double pMult = 1;
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
    public double getPMult(){
        return pMult;
    }
    
    //Setters
    public void updateCp(double mult){
        if(mult > 1){
        this.Cp *= mult;
        }
        else{
            this.Cp *= (mult + 1);
        }
    }
    public void addCp(int Cp){
        this.CpBase += 1;
    }

    public void setACp(double ACp){
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
        double DImP = (DIm - 1)*100;
        DecimalFormat i = new DecimalFormat("#");
        statsGrid[0][0].setText("Divination Energy(DE): "+String.valueOf(df.format(DE)));
        statsGrid[1][0].setText("DE/s: "+String.valueOf(df.format(DEs)));
        statsGrid[0][1].setText("Click Profit: "+String.valueOf(df.format(Cp)));
        statsGrid[1][1].setText("AutoClick Profit: "+String.valueOf(df.format(ACp)));
        statsGrid[0][2].setText("Divine Insight: "+String.valueOf(df.format(DI)));
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
        DE += DEs;
        this.Update();
    }
    
}
