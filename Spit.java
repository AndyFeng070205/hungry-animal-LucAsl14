import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spit extends SmoothMover
{
    int vel, dir;
    boolean isNew = true;
    public Spit(int velocity, int direction){
        vel = velocity;
        dir = direction;
        setRotation(dir);
    }
    public Spit(int velocity, int direction, boolean isNew){
        vel = velocity;
        dir = direction;
        setRotation(dir);
        this.isNew = isNew;
    }
    /**
     * Act - do whatever the Spit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld)getWorld();
        if(isTouching(Enemy.class)
         ||isTouching(Enemy2.class)){
           removeTouching(Enemy.class);
           removeTouching(Enemy2.class);
           world.counter.add(1);
           getWorld().removeObject(this);
           return;
        }
        if(Greenfoot.isKeyDown("SPACE")&&isNew){
            if(world.elephant.checkExceed()){
                HomingSpit hs = new HomingSpit(vel-2, dir, world.elephant);
                world.addObject(hs, getX(), getY());
                world.removeObject(this);
                return;
            }
            return;
        }
        isNew = false;
        move(vel);
        if(isAtEdge()){
             getWorld().removeObject(this);
        }
    }
    
    protected void homeToDirection(int angle, int speed){
        if(getRotation()!=angle){
            int turnSpeed;
            int rotationDiff = getRotation()-angle;
            if(rotationDiff>180
             ||(rotationDiff<0 && rotationDiff>-180)){
                 turnSpeed = -speed;
             } else {
                 turnSpeed = speed;
             }
              
            turn(turnSpeed);
        }        
    }
}
