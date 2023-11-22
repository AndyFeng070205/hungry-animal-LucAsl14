import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Elephant e = new Elephant();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1400, 800, 1);
        makeElephant(getWidth()/2, getHeight()/2);
    }
    private void makeElephant(int x, int y){
        addObject(e, x, y);
    }
    // public int getElephantLocation(boolean isX){
        // if(isX)
            // return e.getX();
        // else 
            // return e.getY();
    // }
}
