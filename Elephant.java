import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    int shootTimer = 10;
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shootTimer--;
        if(Greenfoot.isKeyDown("s"))
            move(-3);
        if(Greenfoot.isKeyDown("w"))
            move(4);
        if(Greenfoot.isKeyDown("d"))
            turn(5);
        if(Greenfoot.isKeyDown("a"))
            turn(-5);
        if(Greenfoot.isKeyDown("SPACE")){
            if(shootTimer<=0){
                Spit s = new Spit(6, getRotation());
                getWorld().addObject(s, getX(), getY());
                shootTimer = 10;
            }
        }

    }
}
