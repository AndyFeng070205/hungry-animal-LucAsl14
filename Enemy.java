import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
            if(world.getObjects(Elephant.class).size()!=0){
                int elephX = world.elephant.getX();
                int elephY = world.elephant.getY();
                turnTowards(elephX, elephY);
            }
            move(1);
            if(isTouching(Elephant.class)){
                removeTouching(Elephant.class);
                world.gameOver();
            }
    }
    
}
