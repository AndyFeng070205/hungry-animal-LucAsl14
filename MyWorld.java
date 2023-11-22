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
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1400, 800, 1);
        addObject(elephant, getWidth()/2, getHeight()/2);
        addObject(spawner, 0, 0);
    }
}
