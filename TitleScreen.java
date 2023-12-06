import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 700, 1); 
        Label titleLabel = new Label("Not So Hungry Elephant", 100);
        Label titleLabel2 = new Label("Press Space to Start", 100);
        addObject(titleLabel, 650, 350);
        addObject(titleLabel2, 650, 450);
        setBackground("background.jpg");
    }
    public void act(){
        if(Greenfoot.isKeyDown("SPACE")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
}
