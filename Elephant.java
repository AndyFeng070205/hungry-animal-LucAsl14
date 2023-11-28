import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    int shootTimer = 0;
    Random rand = new Random();
    int spread = 50;
    int maxCount = 25; 
    public int currentCount = 0;
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shootTimer--;
        if(Greenfoot.isKeyDown("d"))
            turn(4);
        if(Greenfoot.isKeyDown("a"))
            turn(-4);
        if(Greenfoot.isKeyDown("s"))
            move(-3);
        if(Greenfoot.isKeyDown("w"))
            move(4);
        if(Greenfoot.isKeyDown("SPACE")){
            if(shootTimer<=0&&!checkExceed()){
                float adj = rand.nextFloat();
                Spit s = new Spit(6, (getRotation()+(int)(adj*spread-spread/2)+360)%360);
                getWorld().addObject(s, getX(), getY());
                shootTimer = 10;
                currentCount++;
            }
        } else {
            currentCount = 0;
        }
    }
    public boolean checkExceed(){
        if(currentCount > maxCount){
            return true;
        }
        return false;
    }
}
