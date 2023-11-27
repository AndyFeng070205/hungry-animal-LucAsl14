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
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        //enemy making
        MyWorld world = (MyWorld) getWorld();
        Random rand = new Random();
        int side = rand.nextInt(1, 5);
        int h = world.getHeight();
        int w = world.getWidth();
        int roll = rand.nextInt(3);
        Enemy snake = new Enemy();
        Enemy2 archer = new Enemy2();
        switch(side){
            case 1:{
                world.addObject(snake, 0, rand.nextInt(0, h-1));
                break;
            }
            case 2:{
                world.addObject(snake, rand.nextInt(0, w-1), 0);
                break;
            }
            case 3:{
                world.addObject(snake, w-1, rand.nextInt(0, h-1));
                break;
            }
            case 4:{
                world.addObject(snake, rand.nextInt(0, w-1), h-1);
                break;
            }
        }
        sleepFor(50);
    }
}
