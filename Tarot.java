/**
 * The Tarot Class is going to be a system that draws one of the 78 cards in a tarot deck
 */
import java.io.File;
public class Tarot {
    private String name;
    private String effect;
    private String fortune;
    private File imageFile;
    /**
     * Creates a tarot card with an effect of one minute instant profit
     * @param name the name of the Card
     * 
     */
    public Tarot(String name){
        this.name = name;
        this.effect = "Profit60s";
        this.fortune = "The dev isn't Done yet";
    }
    public Tarot(String name, String Fortune){
        this.name = name;
        this.effect = "Profit60s";
        this.fortune = Fortune;
    }
        public Tarot(String name, String Fortune, String image){
        this.name = name;
        this.imageFile = new File(image);
        this.effect = "Profit60s";
        this.fortune = Fortune;
    }
    /**
     * Outputs the name of the Tarot Card
     * @return the name of the Tarot Card
     */
    public String getName(){
        return name;
    }
    /**
     * Changes the name of the card to whatever was placed there.
     * @param name the name to be set.
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Outputs the effect of the Tarot Card
     * @return the effect name of the Tarot Card
     */
    public String getEffect(){
        return effect;
    }
   /**
     * Changes the effect of the card to whatever was placed there.
     * @param effect the effect to be set.
     */
    public void setEffect(String effect){
        this.effect = effect;
    }
    /**
     * Gets the attached fortune that goes with the Tarot card
     * @return the Tarot Card's Fortune
     */
    public String getFortune(){
        return fortune;
    }
    /**
     * Changes the Tarot's fortune to whatever is desired.
     * @param fortune the fortune that is to bet set.
     */
    public void setFortune(String fortune){
        this.fortune = fortune;
    }
    /**
     * Acquires the image file of the Tarot Card
     * @return the file for the Tarot Card Image.
     */
    public File getiFile(){
        return imageFile;
    }
    public String getiString(){
        return imageFile.toString();
    }
    /**
     * 
     */
    public void setiFile(String filename){
        this.imageFile = new File(filename);
    }
}
    

