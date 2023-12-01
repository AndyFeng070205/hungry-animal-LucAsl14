import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpecialLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialLabel extends Label
{
    /**
     * Create a new label, initialise it with the int value to be shown and the font size 
     */
    public SpecialLabel(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
    }
    
    /**
     * Create a new label, initialise it with the needed text and the font size 
     */
    public SpecialLabel(String value, int fontSize)
    {
        super(value, fontSize);
    }
    /**
     * Act - do whatever the SpecialLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int actedTimes = 0;
    public void act()
    {
        sleepFor(200);
        if(actedTimes == 1){
            TitleScreen world = new TitleScreen();
            Greenfoot.setWorld(world);
        } else {
            actedTimes++;
        }
    }
}
