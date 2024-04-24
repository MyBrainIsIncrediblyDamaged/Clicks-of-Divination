import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This MainPanel is the main graphical source for this game, Utilizing Graphics to create the layouts.
 */
public class TarotPanel extends JPanel{
    private int drawIndex = 0;
    private Random rng = new Random();
    private Tarot[] Deck = new Tarot[78];
    private String[] SUIT = {"Cups","Pentacles","Swords","Wands"};
    private BorderLayout layout = new BorderLayout();
    private String[] CARD = {"Ace", "Two", "Three", "Four", "Five","Six","Seven","Eight","Nine","Ten","Page","Knight","Queen","King"};
    private JButton cardButton = new JButton("Card Image goes here");
    private JButton bottomButton = new JButton("Card name & Fortune");
    public JButton panelButton = new JButton("Clicker Panel");
    static JButton drawButton;
    private ClickerPanel CPanel;
    private int i = 22;
    public TarotPanel(ClickerPanel cPanel){
        this.CPanel = cPanel;
        this.setLayout(layout);
        CreateDeck();
        shuffle();
        drawButton = new JButton("Draw");
        drawButton.addActionListener(new TarotListener());
        this.add(cardButton,BorderLayout.CENTER);
        this.add(bottomButton,BorderLayout.SOUTH);
        this.add(drawButton,BorderLayout.WEST);
        this.add(panelButton,BorderLayout.NORTH);


}
    /**
     * Creates a Tarot Deck with All 22 Major Arcana and 58 Minor Arcana
     */
public void CreateDeck(){
    Deck[0] = new Tarot("0: The Fool","Set out on your Journey and explore","Placeholder_Icons/TheFool.png");
    Deck[1] = new Tarot("I: The Magician","Your Imagination can be realized","Placeholder_Icons/TheMagician.png");
    Deck[2] = new Tarot("II: The High Preistess","Trust your own counsel first.","Placeholder_Icons\\TheHighPriestess.png");
    Deck[3] = new Tarot("III: The Empress","Be Happy with your action's consequences","Placeholder_Icons/TheEmpress.png");
    Deck[4] = new Tarot("IV: The Emperor","Own your space with confidence","Placeholder_Icons/TheEmperor.png");
    Deck[5] = new Tarot("V: The Heirophant","Understand your mind","Placeholder_Icons/TheHeirophant.png");
    Deck[6] = new Tarot("VI: The Lovers","Celebrate your Life's Love","Placeholder_Icons/TheLovers.png");
    Deck[7] = new Tarot("VII: The Chariot","You succeed when faced with difficulty","Placeholder_Icons/TheChariot.png");
    Deck[8] = new Tarot("VIII: The Strength","You don't know your strength until it's tested","Placeholder_Icons/Strength.png");
    Deck[9] = new Tarot("IX: The Hermit","Within you is all life's answers","Placeholder_Icons/TheHermit.png");
    Deck[10] = new Tarot("X: The Wheel of Fortune","You have strength in new beginnings, the cycle restarts.","Placeholder_Icons/WheelofFortune.png");
    Deck[11] = new Tarot("XI: Justice","Utilize your intuition to set your moral compass","Placeholder_Icons/Justice.png");
    Deck[12] = new Tarot("XII: The Hanged Man","Look at the world from a different perspective","Placeholder_Icons/TheHangedMan.png");
    Deck[13] = new Tarot("XIII: Death","Growth always has a cost","Placeholder_Icons/Death.png");
    Deck[14] = new Tarot("XIV: Temperance","Seek balance and create an atmosphere of calm","Placeholder_Icons/Temperance.png");
    Deck[15] = new Tarot("XV: The Devil","You are only limited by your belief","Placeholder_Icons/TheDevil.png");
    Deck[16] = new Tarot("XVI: The Tower","Always expect the unexpected","Placeholder_Icons/TheTower.png");
    Deck[17] = new Tarot("XVII: The Star","All your dreams are coming true","Placeholder_Icons/TheStar.png");
    Deck[18] = new Tarot("XVIII: The Moon","Be careful of seeing things that aren't there","Placeholder_Icons/TheMoon.png");
    Deck[19] = new Tarot("XIX: The Sun","Stay on the path and Success Lies ahead","Placeholder_Icons/TheSun.png");
    Deck[20] = new Tarot("XX: Judgement", "Answering the call to action creates new opportunity","Placeholder_Icons/Judgement.png");
    Deck[21] = new Tarot("XXI: The World","All your efforts are leading to completion","Placeholder_Icons/TheWorld.png");
        for(String s:SUIT){
            for(String c:CARD){
                Deck[i] = new Tarot(c + " of " + s);
                Deck[i].setiFile("Placeholder_Icons/"+s+"/"+c+"of"+s+".png");
                if(i<(Deck.length-1)){i++;}
            }
        }


    //Major Arcana Effects Order 0 to XXI
    Deck[0].setEffect("Fool");
    Deck[1].setEffect("Magician");
    Deck[2].setEffect("HighPreistess");
    Deck[3].setEffect("Empress");
    Deck[4].setEffect("Emperor");
    Deck[5].setEffect("Heirophant");
    Deck[6].setEffect("Lovers");
    Deck[7].setEffect("Chariot");
    Deck[8].setEffect("Strength");
    Deck[9].setEffect("Hermit");
    Deck[10].setEffect("WheelofFortune");
    Deck[11].setEffect("Justice");
    Deck[12].setEffect("HangedMan");
    Deck[13].setEffect("Death");
    Deck[14].setEffect("Temperance");
    Deck[15].setEffect("Devil");
    Deck[16].setEffect("Tower");
    Deck[17].setEffect("Star");
    Deck[18].setEffect("Moon");
    Deck[19].setEffect("Sun");
    Deck[20].setEffect("Judgement");
    Deck[21].setEffect("World");
    
    //Suit of Cups Sets in order of Ace to King
Deck[22].setFortune("Open your heart and recieve the emotions around you.");
Deck[22].setEffect("Cups1");
Deck[23].setFortune("Open your heart & receive love from others.");
Deck[23].setEffect("Cups2");
Deck[24].setFortune("Celebrate your success with those you care about.");
Deck[24].setEffect("Cups3");
Deck[25].setFortune("Don't let your focus close you to new ideas.");
Deck[25].setEffect("Cups4");
Deck[26].setFortune("Feel your greif, but know that things will get better");
Deck[26].setEffect("Cups5");
Deck[27].setFortune("Reach out to others with love and compassion.");
Deck[27].setEffect("Cups5");
Deck[28].setFortune("Step Back from everything and gain perspective");
Deck[28].setEffect("Cups2");
Deck[29].setFortune("Make your decision & take action with confidence");
Deck[29].setEffect("Cups4");
Deck[30].setFortune("Everything has turned out well. Enjoy your Success");
Deck[30].setEffect("Cups3");
Deck[31].setFortune("Everything you have planned for has worked out");
Deck[31].setFortune("Cups1");
Deck[32].setFortune("Don't let emotions get in the way");
Deck[32].setEffect("Cups6");
Deck[33].setFortune("Express your creativity with compassionate emotion");
Deck[33].setFortune("Cups6");
Deck[34].setFortune("Be open to recieve the healing and nurturing you need");
Deck[34].setEffect("Cups7");
Deck[35].setFortune("Support yourself before you can support others");
Deck[35].setEffect("Cups7");

    //Suit of Pentacles Cards in order of Ace to King
Deck[36].setFortune("The time is right to take action on your ideas.");
Deck[36].setEffect("Pents1");
Deck[37].setFortune("Find Balance in you life to build your success.");
Deck[37].setEffect("Pents4");
Deck[38].setFortune("Reach out for the help you need when you need it.");
Deck[38].setEffect("Pents3");
Deck[39].setFortune("Holding on too tight can stop you from moving forward.");
Deck[39].setEffect("Pents6");
Deck[40].setFortune("Life is hard right now. Look around, help is at hand.");
Deck[40].setEffect("Pents2");
Deck[41].setFortune("Sharing your success builds more success.");
Deck[41].setFortune("Pents2");
Deck[42].setFortune("Look back on what you have achieved & set new goals.");
Deck[42].setEffect("Pents1");
Deck[43].setFortune("Find work-life balance to protect your creativity.");
Deck[43].setEffect("Pents5");
Deck[44].setFortune("Enjoy the results of all your hard work.");
Deck[44].setEffect("Pents6");
Deck[45].setFortune("Everything in fruition, and wistom from all stages of life.");
Deck[45].setEffect("Pents7");
Deck[46].setFortune("Focus on your goals to bring great success.");
Deck[46].setEffect("Pents3");
Deck[47].setFortune("Take a methodical approach & you'll achieve your dreams.");
Deck[47].setEffect("Pents4");
Deck[48].setFortune("Focus on your home, family, success & abundance.");
Deck[48].setEffect("Pents7");
Deck[49].setFortune("Continue to solve issues in practical ways.");
Deck[49].setEffect("Pents5");
    //Suit of Swords in order of Ace to King
Deck[50].setFortune("Speak your mind to solve your problems.");
Deck[50].setEffect("Swords6");
Deck[51].setFortune("Listen to your inner voice when making choices.");
Deck[51].setEffect("Swords1");
Deck[52].setFortune("A harsh truth is better than a soft lie.");
Deck[52].setEffect("Swords2");
Deck[53].setFortune("Take time out & the answer will come.");
Deck[53].setEffect("Swords3");
Deck[54].setFortune("Sometimes the victory is not worth the price.");
Deck[54].setEffect("Swords4");
Deck[55].setFortune("Move from problems & be mindful what you take.");
Deck[55].setEffect("Swords5");
Deck[56].setFortune("Guard against deceit & concealment.");
Deck[56].setEffect("Swords1");
Deck[57].setFortune("It seems like you're blocked, but you can still take a step.");
Deck[57].setEffect("Swords2");
Deck[58].setFortune("Worrying changes nothing, decide your next step.");
Deck[58].setEffect("Swords4");
Deck[59].setFortune("It has ended & finished, for better or worse.");
Deck[59].setEffect("Swords7");
Deck[60].setFortune("Take your time to think before your act.");
Deck[60].setEffect("Swords3");
Deck[61].setFortune("You are strong, energetic & ready to take on the world.");
Deck[61].setEffect("Swords6");
Deck[62].setFortune("Your clear communication expresses what's best for all.");
Deck[62].setEffect("Swords5");
Deck[63].setFortune("Think things through from all perspectives.");
Deck[63].setEffect("Swords7");
    //Suit of wands in order of Ace to King
Deck[64].setFortune("Take action on your ideas");
Deck[64].setEffect("Wands4");
Deck[65].setFortune("Believe in your personal power.");
Deck[65].setEffect("Wands2");
Deck[66].setFortune("Find your inspiration to take action.");
Deck[66].setEffect("Wands5");
Deck[67].setFortune("Be ready for the opportunity you've worked for.");
Deck[67].setEffect("Wands3");
Deck[68].setFortune("Learn to take life as it comes, both positive and negative.");
Deck[68].setEffect("Wands6");
Deck[69].setFortune("You have earned every one of your successes.");
Deck[69].setEffect("Wands1");
Deck[70].setFortune("There may be challenges ahead. You can face them.");
Deck[70].setEffect("Wands4");
Deck[71].setFortune("Take action on your ideas; life if moving ahead.");
Deck[71].setEffect("Wands3");
Deck[72].setFortune("Believe in yourself & have courage to continue.");
Deck[72].setEffect("Wands1");
Deck[73].setFortune("There is always another way to do something.");
Deck[73].setEffect("Wands2");
Deck[74].setFortune("Keep your eye on your goals & enjoy every moment.");
Deck[74].setEffect("Wands7");
Deck[75].setFortune("Now is a good time to do what you want to do.");
Deck[75].setEffect("Wands6");
Deck[76].setFortune("You can always count on your natural confidence");
Deck[76].setEffect("Wands5");
Deck[77].setFortune("Use the dynamic energy of a leader.");
Deck[77].setEffect("Wands7");
}
public class TarotListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        ClickerPanel cPanel = CPanel;
        if(drawButton.getText().equals("Shuffle")){
            shuffle();
            drawButton.setText("Draw");
            drawIndex = 0;
        }
        if(drawIndex == 78){
            drawButton.setText("Shuffle");
        }
        
        else{
        Tarot clicked = Deck[drawIndex];
        ImageIcon tarotImage = new ImageIcon(clicked.getiFile().toString(), "");
        System.out.println(clicked.getName()+"\n"+clicked.getFortune()+"\n"+clicked.getEffect());
        cardButton.setIcon(tarotImage);
        cardButton.setText("");
        bottomButton.setText(clicked.getName()+"\n"+clicked.getFortune());

        drawIndex++;
        switch(clicked.getEffect()){
            //multiplies Tarot Card profits by 12 then resets DE
            case "Fool":
                cPanel.getSPanel().getSource()[4].addMult(12);
                cPanel.getStats().setDE(0);
            break;
            //Grants 1 hour of DE gain
            case "Magician":
                cPanel.getStats().addDE(3600);
            break;
            //Multiplies AutoClick profit by 3
            case "HighPreistess":
                cPanel.getStats().addACpm(3);
            break;
            //Multiplies profit by 1.25
            case "Empress":
                cPanel.getStats().addPMult(1.25);
            break;
            //Multiplies Click profit by 4
            case "Emperor":
                cPanel.getStats().addCpm(4);
            break;
            //Multiplies AoaD profit by 3
            case "Heirophant":
                cPanel.getSPanel().getSource()[5].addMult(3);
            break;
            //doubles click profit
            case "Lovers":
                cPanel.getStats().addCpm(2);
            break;
            //quadruples click profit
            case "Chariot":
                cPanel.getStats().addCpm(4);
            break;
            //adds 50000 click profit
            case "Strength":
                cPanel.getStats().addCp(50000);
            break;
            
            case "Hermit":
                for(int i = 0;i <10;i++){
                    cPanel.getSPanel().getSource()[rng.nextInt(6)].add();
                }
            break;

            case "WoF":
            cPanel.getStats().addDE(((rng.nextInt(29)+1)*60));
            break;
            
            case "Justice":
                cPanel.getSPanel().getSource()[2].addMult(3);
            break;

            case "Hanged Man":
                cPanel.getSPanel().getSource()[0].addMult(80);
            break;

            case "Death":
                cPanel.getStats().setDE(0);
                cPanel.getStats().addPMult(10);
            break;

            case "Temperance":
                cPanel.getSPanel().getSource()[3].addMult(5);
            break;

            case "Devil":
                cPanel.getSPanel().getSource()[2].addMult(66);
            break;

            case "Tower":
                cPanel.getStats().setDE(0);
                cPanel.getSPanel().reset();
                cPanel.getStats().addPMult(25);
            break;

            case "Star":
                cPanel.getSPanel().getSource()[5].addMult(4);
            break;

            case "Moon":
                cPanel.getSPanel().getSource()[3].addMult(5);
            break;

            case "Sun":
                cPanel.getSPanel().getSource()[1].addMult(15);
            break;

            case "Judgement":
                cPanel.getSPanel().getSource()[4].addMult(10);
            break;

            case "World":
                cPanel.getStats().addCpm(10);
            break;

            case "Cups1":
                cPanel.getSPanel().getSource()[1].addMult(5);
            break;

            case "Cups2":
                cPanel.getSPanel().getSource()[2].addMult(3);
            break;
            
            case "Cups3":
                cPanel.getSPanel().getSource()[3].addMult(5);
            break;

            case "Cups4":
                cPanel.getSPanel().getSource()[4].addMult(4);
            break;

            case "Cups5":
                cPanel.getSPanel().getSource()[5].addMult(7);
            break;

            case "Cups6":
                cPanel.getSPanel().getSource()[0].addMult(5);
            break;

            case "Cups7":
                cPanel.getStats().addPMult(4);
            break;
            case "Swords1":
                cPanel.getStats().addCp(200);
            break;

            case "Swords2":
                cPanel.getStats().addCpm(8);
            break;
            
            case "Swords3":
                cPanel.getStats().addCpm(4);
            break;

            case "Swords4":
                cPanel.getStats().addCpm(6);
            break;

            case "Swords5":
                cPanel.getStats().addCp(2000);
            break;

            case "Swords6":
                cPanel.getStats().addCpm(10);
            break;

            case "Swords7":
                cPanel.getStats().addCpm(10);
            break;
            case "Wands1":
                cPanel.getStats().addACpm(6);
            break;

            case "Wands2":
                cPanel.getStats().addACpm(10);
            break;
            
            case "Wands3":
            cPanel.getStats().addACpm(8);
            break;

            case "Wands4":
            cPanel.getStats().addACpm(12);
            break;

            case "Wands5":
            cPanel.getStats().addACpm(10);
            break;

            case "Wands6":
            cPanel.getStats().addACpm(6);
            break;

            case "Wands7":
            cPanel.getStats().addACpm(18);
            break;
            case "Pents1":
                cPanel.getStats().addDIm(0.01);
            break;

            case "Pents2":
            cPanel.getStats().addDIm(0.01);
            break;
            
            case "Pents3":
            cPanel.getStats().addDIm(0.015);
            break;

            case "Pents4":
            cPanel.getStats().addDIm(0.015);
            break;

            case "Pents5":
            cPanel.getStats().addDIm(0.015);
            break;

            case "Pents6":
            cPanel.getStats().addDIm(0.015);
            break;

            case "Pents7":
            cPanel.getStats().addDIm(0.05);
            break;

            




        }
    }}
}




/**
 * Randomly swaps cards with each other
 */
public void shuffle(){
    Random rand = new Random();
    for(int i = 0; i < Deck.length; i++){
        int j = rand.nextInt(Deck.length - 1);
        swap(i,j);
    }
    drawIndex = 0;
}
    /**
     * Takes two index values and swaps the values of them.
     * @param i 1st index to be swapped
     * @param j 2nd index to be swapped
    */
private void swap(int i, int j){
    Tarot temp = Deck[j];
    Deck[j] = Deck[i];
    Deck[i] = temp;
}

}
