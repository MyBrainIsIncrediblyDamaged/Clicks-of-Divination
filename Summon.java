import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.*;
public class Summon extends JButton{
    String sName;
    int cost;
    int autoclicks;
    boolean isSummoned;
    int duration;
    Timer summon;
    Timer stopper = new Timer(1000, new StopListener());
    int time;
    int ACs;
    StatsPanel stats;
    public Summon(String name,int ACs,StatsPanel stats){
        this.sName = name;
        this.autoclicks = 0;
        this.isSummoned = false;
        this.duration = 60;
        this.stats = stats;
        this.time = this.duration;
        this.ACs = ACs;
        }
    //Getters and Setters
    public String getsName(){
        return this.sName;
    }
    public int getACs(){
        return this.ACs;
    }
    public int getACCount(){
        return this.autoclicks;
    }
    public int getduration(){
        return this.duration;
    }
    public int getCost(){
        return this.cost;
    }
    public void setName(String name){
        this.sName = name;
    }
    public void setACs(int ACs){
        this.ACs = ACs;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setACCount(int count){
        this.autoclicks = count;
    }
    /**
     * Triggers the Summon.
     */
    public void activateSummon(){
        this.isSummoned = true;
        summon = new Timer((int) 1000/ACs,new AutoClicker());
        summon.start();
        stopper.start();
    }

    public class AutoClicker implements ActionListener{
        public void actionPerformed(ActionEvent e){
            stats.AcIncrement();
            autoclicks++;
        }
    }

    private class StopListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(time > 0){
                time--;
            }
            else if(time==0){
                Stop();
            }
        }
    }
    public void updateStats(StatsPanel stats){
        this.stats = stats;
    }
    public boolean getSummoned(){
        return isSummoned;
    }
    public void setSummoned(boolean isSummoned){
        this.isSummoned = isSummoned;
    }
    public void Stop(){
        summon.stop();
        stopper.stop();
        setSummoned(false);
    }
}
