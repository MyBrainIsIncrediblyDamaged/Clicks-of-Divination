/**
 * 
 * @author James Hooson
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class ClickerPanel extends JPanel{
    DecimalFormat f = new DecimalFormat("#.##");
    Timer sTimer = new Timer(1000, new iListener());
    JPanel upgrades;
    StatsPanel stats;
    sourcePanel sPanel;
    BorderLayout layout;
    JButton orb = new JButton(new ImageIcon("Mirror.png"));

    JLabel center = new JLabel();
        public ClickerPanel(){
        layout = new BorderLayout();
        this.setLayout(layout);
        orb.setBorderPainted(false);
        orb.setContentAreaFilled(false);
        orb.setFocusPainted(false);
        orb.setOpaque(false);
        orb.addActionListener(new buttonListener());
        this.stats = new StatsPanel();
        this.sPanel = new sourcePanel();
        this.upgrades = new UpgradePanel();
        orb.setPreferredSize(new Dimension(648,648));
        this.sPanel.setPreferredSize(new Dimension(600, 20000));
        this.sPanel.setVisible(true);
        this.layout.addLayoutComponent(center, BorderLayout.CENTER);
        this.layout.addLayoutComponent(orb, BorderLayout.SOUTH);
        this.layout.addLayoutComponent(upgrades, BorderLayout.WEST);
        this.layout.addLayoutComponent(stats,BorderLayout.NORTH);
        this.layout.addLayoutComponent(sPanel, BorderLayout.EAST);
        this.add(orb);
        this.add(this.stats);
        this.add(this.sPanel);
        this.add(this.upgrades);
        this.setVisible(true);
        sTimer.start();

    }
    private class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JButton clicked = (JButton) e.getSource();
                stats.ClickIncrement();
            }
        }
    private class iListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            stats.Sincrement();

        }
    }
    /**
     * Opens a  
     */
    public class sourcePanel extends JPanel {
        public void updateDEs(){
        double total = 0;
        for(sourceButton s: sources){
                total += s.getCount()*s.getMult()*s.getProfit();
            }
            total *= stats.getPMult();
        stats.DEs = total;
            System.out.print(stats.DEs);
        }
    public sourceButton[] sources;
        //Creates an array of buttons
    public sourcePanel(){
        sources = new sourceButton[6];
        this.setLayout(new GridLayout(10,0));
        this.getLayout();
        for (int i = 0; i < sources.length; i++){
            sources[i] = new sourceButton();
            sources[i].setBorderPainted(false);
            sources[i].setContentAreaFilled(false);
            sources[i].setFocusPainted(false);
            sources[i].setOpaque(false);
        }
        sources[0].setIcon(new ImageIcon("CrystalBall.png"));
        sources[0].setup(3,"Scrying Orb",0.1,1.10);
        sources[1].setIcon(new ImageIcon("sacredText.jpg"));
        sources[1].setup(40, "Sacred Text", 1,1.12);
        sources[2].setIcon(new ImageIcon("Rune.jpg"));
        sources[2].setup(1500,"Rune Tablet",40,1.14);
        sources[3].setIcon(new ImageIcon("Cauldron.jpg"));
        sources[3].setup(40000,"Cauldron",1400,1.16);
        sources[4].setIcon(new ImageIcon("Card.png"));
        sources[4].setup(200000,"Tarot Card",7300,1.18);
        sources[5].setIcon(new ImageIcon("EoG.jpg"));
        sources[5].setup(3000000,"Attention of a Deity",90000,1.2);
        for(int i = 0; i < sources.length;i++){
            sources[i].setText(sources[i].getName() + f.format(sources[i].getCost()) + "DE");
            sources[i].setPreferredSize(new Dimension(400,200));
            sources[i].addActionListener(new sourceListener());
            sources[i].setVisible(true);
            ImageIcon v = (ImageIcon) sources[i].getIcon();
            v.setImage(v.getImage().getScaledInstance(80,80,1));
            sources[i].setIcon(v);
            this.add(sources[i],i);
        }
        this.setVisible(true);
        
    }}
    private class sourceListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            sourceButton clicked = (sourceButton)(e.getSource());
            for(sourceButton s: sPanel.sources){
                if(clicked.getName().equals(s.getName())){
                    if(stats.DE >= s.getCost()){
                        s.purchase(1);
                            sPanel.updateDEs();
                        
                    }
                }
                stats.Update();

            }
        }
    }
    private class sourceButton extends JButton{
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
            this.cost = cost;
            this.name = name;
            this.profit = profit;
            this.scaling = scaling;
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
        public void setProfit(int profit){
            this.profit = profit;
        }
        public void purchase(int count){
            this.count ++;
            stats.DE-= cost;
            stats.Update();
            this.cost *= scaling;
            this.setText(name +": "+ f.format(cost) + "DE");
        }
    }




}
