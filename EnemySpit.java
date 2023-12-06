import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemySpit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySpit extends SmoothMover
{
    MyWorld world = (MyWorld) getWorld();
    int vel, dir;
    public EnemySpit(int velocity, int direction){
        vel = velocity;
        dir = direction;
    }
    /**
     * Act - do whatever the Spit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Elephant.class)){
           removeTouching(Elephant.class);
           world.gameOver();
           world.removeObject(this);
           return;
        }
        while(getRotation()!=dir){
            turn(dir-getRotation());
        }
        move(vel);
        if(isAtEdge()){
             world.removeObject(this);
        }
    }
}
