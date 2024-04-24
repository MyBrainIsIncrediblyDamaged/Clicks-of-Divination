/**
 * 
 * @author James Hooson
 */
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.io.File;
import java.util.Random;
/**
 * Creates the Clicker Game
 */
public class ClickerPanel extends JPanel{
    //Thresholds for Upgrades
    final int[] STHRESHOLDS = {1,10,25,50,100,200,300,400,500};
    final int[] CTHRESHOLDS = {1,25,50,100,200,300,400,500};
    final int [] ACTHRESHOLDS = {1,10,25,50,100,200,350,500};
    public boolean upgradebought = false;
    //Other Instance stuff
    DecimalFormat f = new DecimalFormat("#.##");
    Timer sTimer = new Timer(25, new iListener());
    Timer cTimer = new Timer(70, new buttonListener());
    int cCount = 0;
    UpgradePanel upgrades;
    StatsPanel stats;
    SourcePanel sPanel;
    BorderLayout layout;
    JButton orb = new JButton(new ImageIcon("Mirror.png"));
    JButton TarotButton = new JButton("Draw Tarot");
    ClickListener clicker = new ClickListener();
    Summon[] summons; 
    SummonsPanel summoner;
        /**
         * Creates the GUI.
         */
        public ClickerPanel(){
        
        this.setBackground(Color.GRAY);
        summoner = new SummonsPanel();
        layout = new BorderLayout();
        this.setLayout(layout);
        orb.setBorderPainted(false);
        orb.setContentAreaFilled(false);
        orb.setFocusPainted(false);
        orb.setOpaque(false);
        orb.addMouseListener(clicker);
        this.stats = new StatsPanel();
        this.sPanel = new SourcePanel();
        this.upgrades = new UpgradePanel();
        orb.setPreferredSize(new Dimension(324,324));
        orb.setBackground(Color.WHITE);
        this.sPanel.setPreferredSize(new Dimension(600, 2000));
        this.sPanel.setVisible(true);       
        this.add(orb, BorderLayout.CENTER);
        this.add(this.stats,BorderLayout.PAGE_START);
        this.add(this.sPanel,BorderLayout.LINE_END);
        this.add(this.upgrades,BorderLayout.LINE_START);
        this.add(this.summoner, BorderLayout.PAGE_END);
        this.add(this.TarotButton, BorderLayout.PAGE_END);
        this.setVisible(true);
        sTimer.start();
        cTimer.start();
    }
    public void setDE(double DE){
        this.stats.setDE(DE);
    }
    /**
     * Checks if the mouse has been clicked and increments the DE value by the Cp value.
     */
    private class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
                if(clicker.hasClicked){
                    stats.ClickIncrement();
                    clicker.hasClicked = false;
                    cCount++;

                    }
                
                
                
            }
            
        }
    /**
     * Sets hasClicked to true if mouse has been released.
     */

    private class ClickListener implements MouseListener{
        boolean hasClicked = false;
        public void mousePressed(MouseEvent e){
        }
        public void mouseReleased(MouseEvent e){
            hasClicked = true;
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){
        }
        public void mouseClicked(MouseEvent e){
            hasClicked = true;
        }
    }
    /*
     * Increments the DE value, attached to sTimer
     */
    private class iListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            sPanel.updateDEs();
            stats.Sincrement();
            
            for(int i = 0; i < sPanel.sources.length;i++){
                sPanel.sources[i].setToolTipText("Profit Per Unit: "+(sPanel.sources[i].getMult()*sPanel.sources[i].getProfit() * stats.getPMult() * stats.getDIm()) +"\n Total Profit:" + (sPanel.sources[i].getCount() * sPanel.sources[i].getMult() * sPanel.sources[i].getProfit() * stats.getPMult() * stats.getDIm()));
            }
            for(int i = 0; i < summons.length;i++){
                summons[i].updateStats(stats);
            }
                    
            if(cCount == 0){
                            upgrades.Upgrades[0].setCost(10);
            upgrades.Upgrades[0].setMultiplier(1);
            upgrades.Upgrades[0].setToolTipText("<html>Add " + upgrades.Upgrades[0].getMultiplier() + " Click Profit "+"<br>"+ "Cost: " + upgrades.Upgrades[0].getCost()+"<html>");
            upgrades.Upgrades[0].setAvailable(true);
            }
                    for(int i = 0; i < CTHRESHOLDS.length;i++){
                    if(upgradebought){
                    if(upgrades.Upgrades[0].getCount() == i){
                    if(cCount >= CTHRESHOLDS[i]){
                        upgrades.Upgrades[0].setAvailable(true);
                        upgrades.Upgrades[0].setHidden(false);
                        upgrades.Upgrades[0].setMultiplier(Math.pow(3,upgrades.Upgrades[0].getCount()));
                        upgrades.Upgrades[0].setCost((int) upgrades.Upgrades[0].getCost() * 7+1);
                        upgrades.Upgrades[0].setToolTipText("<html>Add " + upgrades.Upgrades[0].getMultiplier() + " Click Profit "+"<br>"+ "Cost: " + upgrades.Upgrades[0].getCost()+"<html>");
                        upgradebought = false;
                    }
                    if(summoner.getAutoClicks() >= ACTHRESHOLDS[i]){
                        upgrades.Upgrades[2].setAvailable(true);
                    }
                    }
                    }
                    if(sPanel.sources[0].getCount() >= STHRESHOLDS[i]){
                       upgrades.Upgrades[3].setAvailable(true); 
                    }
                    if(sPanel.sources[1].getCount() >= STHRESHOLDS[i]){
                       upgrades.Upgrades[4].setAvailable(true); 
                    }
                    if(sPanel.sources[2].getCount() >= STHRESHOLDS[i]){
                       upgrades.Upgrades[5].setAvailable(true); 
                    }
                    if(sPanel.sources[3].getCount() >= STHRESHOLDS[i]){
                       upgrades.Upgrades[6].setAvailable(true); 
                    }
                    if(sPanel.sources[4].getCount() >= STHRESHOLDS[i]){
                       upgrades.Upgrades[7].setAvailable(true); 
                    }
                    if(sPanel.sources[5].getCount() >= STHRESHOLDS[i]){
                       upgrades.Upgrades[8].setAvailable(true); 
                    }

                    }
                
        }
    }
    /**
     * Grabs the SourcePanel for grabing stuff
     */

    public StatsPanel getStats(){
        return this.stats;
    }
    public SourcePanel getSPanel(){
        return this.sPanel;
    }
    /*
     * Upgrades certain values based off of Target and Index values.
     */
    public class UpgradeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Upgrade clicked = (Upgrade) e.getSource();
                if(clicked.getAvailable()){
                    if(stats.DE >= (double)clicked.getCost()){
                        clicked.purchase(1);
                        stats.DE -= clicked.getCost();
                        //Cp updates are based on clicks performed
                        if(clicked.getTarget().equals("Cp")){
                        stats.addCp((int)clicked.getMultiplier());
                        upgradebought = true;
                        }
                        if(clicked.getTarget().equals("ACp")){
                        clicked.setMultiplier(1.5 + (0.5*clicked.getCount()));
                        stats.addACp(clicked.getMultiplier());
                        clicked.setCost((int)Math.pow(clicked.getCost(),1.12));
                        clicked.setToolTipText("Multiply Autoclick profit by " + clicked.getMultiplier() + "X | Cost:" + clicked.getCost());

                        }
                        if(clicked.getTarget().equals("Sourceprofit")){
                        clicked.setMultiplier(2+(clicked.getCount()/5));;
                        sPanel.sources[clicked.getIndex()].addMult(clicked.getMultiplier() - 1);
                        clicked.setCost(clicked.getCost() * 20);
                        clicked.setToolTipText("Multiply " + clicked.getName() + " profit by " + clicked.getMultiplier() + "X | Cost:" + clicked.getCost());
                        }
                        if(clicked.getTarget().equals("DEs")){
                        clicked.setMultiplier(2+(clicked.getCount()/2));;
                        stats.setPMult(stats.getPMult() + clicked.getMultiplier() - 1);
                        clicked.setCost(clicked.getCost() * 15);
                        clicked.setToolTipText("Multiply non-click profit by " + clicked.getMultiplier() + "X | Cost:" + clicked.getCost());
                        }
                        stats.Update();
                        sPanel.updateDEs();

            }}}
    }
    /**
     * ActionListener for the Homonculus creation button, Access to the Prestige system
     */
    private class HomonculusListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Homonculus clicked = (Homonculus)(e.getSource());
            if(clicked.getDILevel() == upgrades.ganesha.getDILevel()){
                clicked.Create();
            }
        }}
        /**
         * Summons are the Autoclickers.
         */
    private class SummonsListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Summon clicked = (Summon)(e.getSource());
            if(stats.DE > clicked.getCost()){
                if(!clicked.getSummoned()){
                clicked.activateSummon();
                stats.subtractDE(clicked.getCost());
                clicked.setCost((int)Math.pow(clicked.getCost(),1.05));
                clicked.setToolTipText("Autoclicks " + clicked.getACs() + " times a second | Cost: " + clicked.getCost());
            }}

        }
    }
    
    /**
     * Panel that sets up the upgrade stuff.
     */
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
         Homonculus ganesha = new Homonculus();
        public UpgradePanel(){
           
            ImageIcon ic;
            ic = new ImageIcon("Mirror.png");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            this.Upgrades = new Upgrade[9];
            this.setLayout(new GridLayout(5,3));
            this.setBackground(Color.WHITE);
            String[] Names = {"Add Click Profit","Profit Upgrade","Autoclick Profit Upgrade","Scrying Orb profit multiplier","Sacred Text profit multiplier","Rune Tablet profit multiplier","Cauldron profit multiplier","Tarot Card profit multiplier","Attract deific attention"};
            double[] mults = {1,2,1.5,2,2,2,2,2,2};
            int[] uCosts = {10,100,100,500,1250,5000,18000,300000,40000000};
            for(int i = 0; i < Upgrades.length;i++){
                Upgrades[i] = new Upgrade(Names[i],uCosts[i],mults[i]);
                Upgrades[i].setPreferredSize(new Dimension(150,150));
                Upgrades[i].addActionListener(new UpgradeListener());
                Upgrades[i].setBorderPainted(false);
                Upgrades[i].setContentAreaFilled(false);
                Upgrades[i].setFocusPainted(false);
                Upgrades[i].setOpaque(false);
            }
            ganesha.addActionListener(new HomonculusListener());
            this.add(new JLabel(),0);
            JLabel Title = new JLabel("Upgrades");
            Title.setFont(new Font("Times New Roman",0,30));
            this.add(Title,1);
            this.add(new JLabel(),2);
            ganesha.setToolTipText("Create Homonculus with Divine Insight | " + "+ " + ganesha.getDILevel());
            //Add the First upgrade (Click Profit Upgrade)
            Upgrades[0].setToolTipText("Add 1 Click Profit | Cost: 10" );
            Upgrades[0].setAvailable(true);
            Upgrades[0].setHidden(false);
            Upgrades[0].setIcon(ic);
            Upgrades[0].setTarget("Cp");
            this.add(Upgrades[0],3);
            //Add the Second Upgrade (Profit per second Upgrade)
            ic = new ImageIcon("Upgrade_Icons/ProfMult.png");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[1].setToolTipText("Multiply Profits by 2X | Cost: 100");
            Upgrades[1].setIcon(ic);
            Upgrades[1].setHidden(false);
            Upgrades[1].setAvailable(true);
            Upgrades[1].setTarget("DEs");
            this.add(Upgrades[1],4);
            //Add the Third Upgrade ( Autoclick Profit Upgrade)
            ic = new ImageIcon("Upgrade_Icons/AutoClicker.png");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[2].setToolTipText("Multiply Autoclick Profit by 1.5X | Cost: 100");
            Upgrades[2].setIcon(ic);
            Upgrades[2].setTarget("ACp");
            Upgrades[2].setHidden(false);
            Upgrades[2].setAvailable(true);
            this.add(Upgrades[2],5);
            //Add the Crystal Ball upgrade
            ic = new ImageIcon("Source_Icons/CrystalBall.png");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[3].setToolTipText("Muliply Scrying Orb Profits by 2X | Cost: 500");
            Upgrades[3].setIcon(ic);
            Upgrades[3].setTarget("Sourceprofit");
            Upgrades[3].setHidden(false);
            Upgrades[3].setAvailable(true);
            Upgrades[3].setIndex(0);
            this.add(Upgrades[3],6);
            //Add the Sacred Text upgrade
            ic = new ImageIcon("Upgrade_Icons/Sacred-Text-Upgrade.png");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[4].setToolTipText("Multiply Sacred Text Profits by 2X | Cost: 1250");
            Upgrades[4].setIcon(ic);
            Upgrades[4].setTarget("Sourceprofit");
            Upgrades[4].setHidden(false);
            Upgrades[4].setAvailable(true);
            Upgrades[4].setIndex(1);
            //Add the Rune Tablet upgrade
            this.add(Upgrades[4],7);
            ic = new ImageIcon("Source_Icons/Rune.jpg");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[5].setToolTipText("Multiply Rune Tablet Profits by 2X | Cost: 5000");
            Upgrades[5].setIcon(ic);
            Upgrades[5].setTarget("Sourceprofit");
            Upgrades[5].setHidden(false);
            Upgrades[5].setAvailable(true);
            Upgrades[5].setIndex(2);
            this.add(Upgrades[5],8);
            //Add the Cauldron upgrade
            ic = new ImageIcon("Source_Icons/Cauldron.jpg");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[6].setToolTipText("Multiply Cauldron Profits by 2X | Cost: 18000");
            Upgrades[6].setIcon(ic);
            Upgrades[6].setTarget("Sourceprofit");
            Upgrades[6].setHidden(false);
            Upgrades[6].setAvailable(true);            
            Upgrades[6].setIndex(3);
            this.add(Upgrades[6],9);
            //Add the Tarot Card upgrade
            ic = new ImageIcon("Upgrade_Icons/Strength.png");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[7].setToolTipText("Multiply Tarot Card Profits by 2X | Cost: 300000");
            Upgrades[7].setIcon(ic);
            Upgrades[7].setTarget("Sourceprofit");
            Upgrades[7].setHidden(false);
            Upgrades[7].setAvailable(true);
            Upgrades[7].setIndex(4);
            this.add(Upgrades[7],10);
            //Add the Attention of a Deity upgrade
            ic = new ImageIcon("Upgrade_Icons/Color-OoS2.jpg");
            ic = new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1));
            Upgrades[8].setToolTipText("Multiply Attention of a Deity Profits by 2X | Cost: 40000000");
            Upgrades[8].setIcon(ic);
            Upgrades[8].setTarget("Sourceprofit");
            Upgrades[8].setHidden(false);
            Upgrades[8].setAvailable(true);
            Upgrades[8].setIndex(5);
            this.add(Upgrades[8],11);
            this.add(new JLabel(),12);
            this.add(ganesha,13);
        }
    
    
    
    
    
    
    }
    /**
     * Opens a  
     */
    public class SourcePanel extends JPanel {
        public void updateDEs(){
        double total = 0;
        for(sourceButton s: sources){
                total += s.getCount()*s.getMult()*s.getProfit();
                s.setToolTipText("Profit per Unit: " + (s.getCount()*s.getMult()*s.getProfit()));
            }

            total *= stats.getPMult();
            stats.setDIm(1+(stats.getDI() * .03));
            total *= stats.getDIm();
            stats.setDEs(total);
        }
    public sourceButton[] sources;
    public sourceButton[] getSources(){
        return this.sources;
    }
    JLabel[] sCosts;
        //Creates an array of buttons
    JLabel[] sNames;
    public SourcePanel(){
        sources = new sourceButton[6];
        sNames = new JLabel[6];
        sCosts = new JLabel[6];
        this.setLayout(new GridLayout(6,3));
        this.getLayout();
        this.setPreferredSize(new Dimension(400, 600));
        this.setBackground(Color.WHITE);
        for (int i = 0; i < sources.length; i++){
            sNames[i] = new JLabel();
            sCosts[i] = new JLabel();
            sources[i] = new sourceButton();
            sources[i].setBorderPainted(false);
            sources[i].setContentAreaFilled(false);
            sources[i].setFocusPainted(false);
            sources[i].setOpaque(false);
        }
        
        sources[0].setIcon(new ImageIcon("Source_Icons/CrystalBall.png"));
        sources[0].setup(3,"Scrying Orb",.5,1.16);
        sources[1].setIcon(new ImageIcon("Source_Icons/sacredText.jpg"));
        sources[1].setup(40, "Sacred Text", 5,1.17);
        sources[2].setIcon(new ImageIcon("Source_Icons/Rune.jpg"));
        sources[2].setup(460,"Rune Tablet",18,1.18);
        sources[3].setIcon(new ImageIcon("Source_Icons/Cauldron.jpg"));
        sources[3].setup(7000,"Cauldron",254,1.19);
        sources[4].setIcon(new ImageIcon("Source_Icons/Card.png"));
        sources[4].setup(130000,"Tarot Card",73000,1.2);
        sources[5].setIcon(new ImageIcon("Source_Icons/EoG.jpg"));
        sources[5].setup(28000000,"Attention of a Deity",200000,1.21);
        for(int i = 0; i < sources.length;i++){
            sNames[i].setText(sources[i].getName());
            sCosts[i].setText(sources[i].getCost() + "DE");
            sources[i].setPreferredSize(new Dimension(400,100));
            sources[i].addActionListener(new sourceListener());
            sources[i].setVisible(true);
            ImageIcon v = (ImageIcon) sources[i].getIcon();
            v.setImage(v.getImage().getScaledInstance(100,100,1));
            sources[i].setIcon(v);
            this.add(sources[i],(i*3));
            this.add(sNames[i],(i*3)+1);
            this.add(sCosts[i],(i*3)+2);
        }
        this.setVisible(true);
        
    }
    public sourceButton[] getSource(){
        return this.sources;
    }

    public void reset(){
        for(int i = 0; i < sources.length;i++){
            sources[i].reset();
            sCosts[i].setText(sources[i].getCost() + "DE");
        }
    }
}
    /**
     * Actionlistener for DE sources, allows for purchases.
     */
    private class sourceListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            sourceButton clicked = (sourceButton)(e.getSource());
            for(int i = 0; i < 6;i++){
                sourceButton s = sPanel.sources[i];
                JLabel scost = sPanel.sCosts[i];
                if(clicked.getName().equals(s.getName())){
                    if(stats.DE >= s.getCost()){
                        s.purchase(1);
                        sPanel.updateDEs();
                        scost.setText(f.format(s.getCost())+"DE");

                        
                    }
                }
                stats.Update();

            }
        }
    }
    /**
     * Button for the sources, allows for purchasing, with prices, s
     */
    public class sourceButton extends JButton{
        private double cost;
        private String name;
        private double profit;
        private int base_cost;
        private double initProfit;
        private int count;
        private double mult;
        private double scaling;
        public sourceButton(){
            this.cost = 0;
            this.name = "";
            this.profit = 0;
            this.base_cost = 0;
            this.initProfit = 0;
            this.count = 0;
            this.mult = 1;
            this.scaling = 1;
        }

        public int getCount(){
            return count;
        }
        public double getCost(){
            return cost;
        }
        public String getName(){
            return name;
        }
        public double getProfit(){
            return profit;
        }
        public double getinitProfit(){
            return initProfit;
        }
        public double getBaseCost(){
            return base_cost;
        }
        public double getMult(){
            return mult;
        }
        public void setup(int cost, String name, double profit, double scaling){
            this.initProfit = profit;
            this.base_cost = cost;
            setCost(cost);
            setName(name);
            setProfit(profit);
            this.scaling = scaling;
            this.setToolTipText("Profit per unit: " + getProfit());
        }
        public void reset(){
            setCost(getBaseCost());
            setProfit(getinitProfit());
            this.count = 0;
            this.setText("");
            this.setToolTipText("Profit per unit: " + getProfit());
        }
        public void addMult(double mult){
            this.mult += mult;
        }
        public void setCost(double cost){
            this.cost = cost;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setProfit(double profit){
            this.profit = profit;
        }
        public void add(){
            this.count ++;
            stats.Update();
            this.cost *= scaling;
            this.setText("" +getCount());
            this.setToolTipText("Profit per unit: " + getProfit());
        }
        /**
         * Purchaces a source
         * @param count
         */
        public void purchase(int count){
            this.count ++;
            stats.DE-= cost;
            stats.Update();
            this.cost *= scaling;
            this.setText("" +getCount());
            this.setToolTipText("Profit per unit: " + getProfit());
        }
    }
        /**
     * Your Levelling Mechanic, Resets DE, and Profit stuff
     */
    private class Homonculus extends JButton{
        long DILevel;
        ImageIcon ganesha = new ImageIcon("Upgrade_Icons/Ganesha.jpg");
        public Homonculus(){
            ganesha = new ImageIcon(ganesha.getImage().getScaledInstance(100, 100, 1));
            this.setToolTipText("Create Homonculus with Divine Insight");
            this.setIcon(ganesha);
            this.setBorderPainted(false);
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setOpaque(false);
        }
        public long getDILevel(){
            DILevel = (long)Math.sqrt(stats.DE / Math.pow(10,6));
            return DILevel;
        }
        public void Update(){
            this.setToolTipText("Create Homonculus with Divine Insight" + " | + " + getDILevel() + "DI");
        }
        public void Create(){
            Update();
            for (int i = 0; i < upgrades.Upgrades.length;i++){
                upgrades.Upgrades[i].reset();
                upgrades.Upgrades[i].setAvailable(true);
                upgrades.Upgrades[i].setHidden(false);
            }
            DILevel += stats.getDI();
            cCount = 0;
            summoner.reset();
            
            sPanel.reset();
            stats.Reset();
            sTimer.stop();
            sTimer = new Timer(25, new iListener());
            stats.setDI(DILevel);
            sTimer.start();
            for(int i = 0; i <summoner.getSummons();i++){
                if(summoner.getSummon(i).getSummoned()){
                summoner.getSummon(i).Stop();}
            }
        }
    }
    /**
     * 
     */
    public class SummonsPanel extends JPanel {
        public SummonsPanel(){
        ImageIcon ic;
        this.setLayout(new FlowLayout());
        this.setBackground(Color.white);
        summons = new Summon[3];
        summons[0] = new Summon("Will o the Wisp",5,stats);
        summons[1] = new Summon("The Color Out of Space",10,stats);
        summons[1].setIcon(new ImageIcon("Upgrade_Icons/Color-OoS.jpg"));
        ic = (ImageIcon)summons[1].getIcon();
        summons[1].setIcon(new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1)));
        summons[2] = new Summon("Elder Thing",15,stats);
        ic = new ImageIcon("Upgrade_Icons/Elder-Thing.jpg");
        summons[2].setIcon(new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1)));
        ic = new ImageIcon("Upgrade_Icons/Wotw.png");
        summons[0].setIcon(new ImageIcon(ic.getImage().getScaledInstance(100, 100, 1)));
        for(int i = 0;i<summons.length;i++){
            int x = (int)Math.pow(5,(i+1));
            summons[i].setBorderPainted(false);
            summons[i].setContentAreaFilled(false);
            summons[i].setFocusPainted(false);
            summons[i].setOpaque(false);
            summons[i].setCost(100 * x);
            summons[i].setToolTipText(summons[i].getsName()+" Autoclicks " + summons[i].getACs() + " times a Second | Cost: " + summons[i].getCost());
            summons[i].setPreferredSize(new Dimension(150, 300));
            summons[i].addActionListener(new SummonsListener());
            this.add(summons[i], i);
        }
        }
        public Summon getSummon(int index){
            return summons[index];
        }
        public int getSummons(){
            return summons.length;
        }
        public int getAutoClicks(){
            int output = 0;
            for(int i = 0; i < summons.length; i++){
                output += summons[i].getACCount();
            }
            return output;
        }
        public void reset(){
            for(int i = 0; i < summons.length; i++){
                summons[i].setACCount(0);
            }
        }


}}