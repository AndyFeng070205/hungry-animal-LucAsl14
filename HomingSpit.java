import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomingSpit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomingSpit extends Spit
{
    double homedX, homedY, distance = 500; // 500
    SmoothMover owner;

    public HomingSpit(int vel, int dir, SmoothMover owner){
        super(vel, dir);    
        this.owner = owner;
        getImage().scale(40, 40);
        updateHoming(owner);
    }
    public void updateHoming(SmoothMover owner){
        double radians = Math.toRadians(owner.getRotation());
        double dx = Math.cos(radians) * distance;
        double dy = Math.sin(radians) * distance;
        homedX = owner.getExactX() + dx;
        homedY = owner.getExactY() + dy;  
    }
    /**
     * Act - do whatever the HomingSpit wants to do. This method is called whenever
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
           world.removeObject(this);
           return;
        }
        if(Greenfoot.isKeyDown("SPACE")&&isNew){
            updateHoming(owner);
            return;
        }
        isNew = false;
        turnTowards(homedX, homedY);
        move(vel);
        // if(Greenfoot.isKeyDown("Q")){
            // TestMarker test = new TestMarker();
            // world.addObject(test, (int)homedX, (int)homedY);
        // }
        double dx = getExactX()-homedX;
        double dy = getExactY()-homedY;
        if(Math.abs(dx)<2&&Math.abs(dy)<2){
            Spit s = new Spit(vel+2, getRotation());
            world.addObject(s, getX(), getY());
            world.removeObject(this);
            return;
        } 
        if(isAtEdge()){
             getWorld().removeObject(this);
        }        
    }
    public void turnTowards(int x, int y){
        turnTowards((double)x, (double)y);
    }
    public void turnTowards(double x, double y){
        double dx = getExactX()-x;
        double dy = getExactY()-y;
        MyWorld world = (MyWorld) getWorld();
        int intendedAngle = (int)(Math.toDegrees(Math.atan(dy/dx)));
        if(dx<0) intendedAngle = 180+intendedAngle;
        if(dx>=0&&dy<0) intendedAngle = 360+intendedAngle;
        homeToDirection(intendedAngle, 1);
    }
}
