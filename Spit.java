import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spit extends Actor
{
    int vel, dir;
    public Spit(int velocity, int direction){
        vel = velocity;
        dir = direction;
    }
    /**
     * Act - do whatever the Spit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        while(getRotation()!=dir){
            turn(dir-getRotation());
        }
        move(vel);
        if(getX()>=getWorld().getWidth()-1
         ||getX()<=0
         ||getY()>=getWorld().getHeight()-1
         ||getY()<=0){
             getWorld().removeObject(this);
        }
    }
}
