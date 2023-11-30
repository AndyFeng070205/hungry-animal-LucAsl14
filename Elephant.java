import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends SmoothMover
{
    int aniFrame = 0;
    int shootTimer = 0;
    Random rand = new Random();
    int spread = 25;
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
            if(currentCount == 0)setImage("elephant.png");
            if(shootTimer<=0&&!checkExceed()){
                float adj = rand.nextFloat();
                Spit s = new Spit(6, (getRotation()+(int)(adj*spread-spread/2)+360)%360);
                getWorld().addObject(s, getX(), getY());
                shootTimer = 10;
                currentCount++;
                getImage().scale((int)(getImage().getWidth()*(1+currentCount/300.0)),
                                 (int)(getImage().getHeight()*(1+currentCount/300.0)));
            } else if(checkExceed()){
                getImage().setTransparency(50);
            }
        } else {
            currentCount = 0;
            animate();
        }
    }
    public boolean checkExceed(){
        if(currentCount > maxCount){
            GreenfootSound sound = new GreenfootSound("elephantcub.mp3");
            sound.play();
            return true;
        }
        return false;
    }
    private void animate(){
        int delay = 10;
        if(aniFrame==delay*0) setImage("elephant_idle/idle0.png");
        if(aniFrame==delay*1) setImage("elephant_idle/idle1.png");
        if(aniFrame==delay*2) setImage("elephant_idle/idle2.png");
        if(aniFrame==delay*3) setImage("elephant_idle/idle3.png");
        if(aniFrame==delay*4) setImage("elephant_idle/idle4.png");
        if(aniFrame==delay*5) setImage("elephant_idle/idle5.png");
        if(aniFrame==delay*6) setImage("elephant_idle/idle6.png");
        if(aniFrame==delay*7) setImage("elephant_idle/idle7.png");
        aniFrame++;
        if(aniFrame==delay*8) aniFrame = 0;
    }
    private void debugTest(){
        for (int i=-spread/2; i<=spread/2; i++){
            Spit s = new Spit(6, (getRotation()+i+360)%360);
            getWorld().addObject(s, getX(), getY());            
        }
    }
}
