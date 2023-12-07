import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    int spawnDelay = 500;
    //spawn chances for {archer,  snake}
    int[] chances = {0,      20,     80};
    int[] prefixSum = new int[chances.length+1];
    SimpleTimer timer = new SimpleTimer();
    public Spawner(){
        timer.mark();
        for(int i=1; i<chances.length; i++){
            prefixSum[i] = chances[i]+prefixSum[i-1];
        }
    }
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(timer.millisElapsed()<spawnDelay){
            return;
        } else {
            timer.mark();
        }
        //enemy making
        MyWorld world = (MyWorld) getWorld();
        Random rand = new Random();
        int side = rand.nextInt(4)+1;
        int h = world.getHeight();
        int w = world.getWidth();
        Enemy snake = new Enemy();
        Enemy2 archer = new Enemy2();
        int roll = rand.nextInt(100);
        Actor[] choices = {null, snake, archer};
        Actor toAdd = snake;
        for(int i=1; i<chances.length; i++){
            if(roll<=prefixSum[i]) toAdd = choices[i];
            if(roll>prefixSum[i]) break;
        }
        switch(side){
            case 1:{
                world.addObject(toAdd, 0, rand.nextInt(h-1));
                break;
            }
            case 2:{
                world.addObject(toAdd, rand.nextInt(w-1), 0);
                break;
            }
            case 3:{
                world.addObject(toAdd, w-1, rand.nextInt(h-1));
                break;
            }
            case 4:{
                world.addObject(toAdd, rand.nextInt(w-1), h-1);
                break;
            }
        }
        // sleepFor(spawnDelay);
    }
}
