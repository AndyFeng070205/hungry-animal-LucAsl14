import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Actor
{
    int target = 400;
    int shootTimer = 150;
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        Elephant elephant = world.elephant;
        if(world.getObjects(Elephant.class).size()!=0){
            double distance = Math.sqrt(Math.pow(elephant.getX()-this.getX(),2)
                                       +Math.pow(elephant.getY()-this.getY(),2));
            int elephX = world.elephant.getX();
            int elephY = world.elephant.getY();
            turnTowards(elephX, elephY);
            if(distance>target+20) move(1);
            else if(distance<target-20) move(-1);
            else{
                shoot();
            }
            
            if(Greenfoot.isKeyDown("p")){
                System.out.println(distance);
            }
        }
    }
    public void shoot(){
        shootTimer--;
        if(shootTimer<=0){
            EnemySpit s = new EnemySpit(3, getRotation());
            getWorld().addObject(s, getX(), getY());
            shootTimer = 150;
        }
    }
}
