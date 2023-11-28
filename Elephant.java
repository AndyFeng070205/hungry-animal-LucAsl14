import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    int shootTimer = 10;
    Random rand = new Random();
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
            turn(4);
        if(Greenfoot.isKeyDown("a"))
            turn(-4);
        if(Greenfoot.isKeyDown("SPACE")){
            if(shootTimer<=0){
                int adjustment = rand.nextInt(51);
                Spit s = new Spit(6, (getRotation()+adjustment-25+360)%360);
                getWorld().addObject(s, getX(), getY());
                shootTimer = 10;
            }
        }

    }
}
