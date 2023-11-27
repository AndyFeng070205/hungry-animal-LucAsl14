import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Elephant elephant = new Elephant();
    public Spawner spawner = new Spawner();
    public Counter counter = new Counter("score: ");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1300, 700, 1);
        setBackground("background.jpg");
        addObject(elephant, getWidth()/2, getHeight()/2);
        addObject(spawner, -10, -10);
        addObject(counter, 1100, 50);
    }
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
        spawner.sleepFor(999999);
    }
}
