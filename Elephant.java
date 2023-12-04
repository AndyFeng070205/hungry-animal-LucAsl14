import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends SmoothMover
{
    int shootTimer = 0;
    Random rand = new Random();
    int spread = 25;
    int maxCount = 25; 
    public int currentCount = 0;
    GreenfootImage[] images = new GreenfootImage[8];
    public Elephant(){
        for(int i=0; i<8; i++){
            images[i] = new GreenfootImage("elephant_idle/idle"+i+".png");
        }
        aniTimer.mark();
    }
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
                Spit s = new Spit(5, (getRotation()+(int)(adj*spread-spread/2)+360)%360);
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
        
        if(Greenfoot.isKeyDown("q")){
            HomingSpit hs = new HomingSpit(4, getRotation(), 
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
    int aniFrame = 0;
    SimpleTimer aniTimer = new SimpleTimer();
    private void animate(){
        if(aniTimer.millisElapsed()>100){
            aniFrame++; aniFrame%=images.length;
            setImage(images[aniFrame]);
            aniTimer.mark();
        }
    }
    private void debugTest(){
        for (int i=-spread/2; i<=spread/2; i++){
            Spit s = new Spit(6, (getRotation()+i+360)%360);
            getWorld().addObject(s, getX(), getY());            
        }
    }
}
