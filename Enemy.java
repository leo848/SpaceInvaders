import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Enemy.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Enemy extends Actor
{
    Random random = new Random();
    
    Boolean left = random.nextBoolean();
    
    Vector pos = new Vector(random.nextInt(400),100);
    Vector vel = new Vector(0,0.5);
    
    
    int hitCounter = 0;
    int totalHealth = 6;
    /**
     * Act - tut, was auch immer Enemy tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
    public void act() 
    {
        checkForBullet();
        
        if (pos.x < 15){
            pos.x=16;
            vel.x *= -1;
        }
        
        if (pos.x > 385){
            pos.x=384;
            vel.x *= -1;
        }
        
        if (pos.y > 600){
            Greenfoot.stop();
        }
        
        pos.add(vel);
        setLocation((int) pos.x,(int)  pos.y);
    }
    
    public  void checkForBullet()
    {
        Actor a = getOneIntersectingObject(Bullet.class);
                
        if(a != null)
        {
            hitCounter++;
            getWorld().removeObject(a);
        }
        
        if (hitCounter >= totalHealth){
            getWorld().removeObject(this);
        }
        
        else if (hitCounter >= totalHealth*2/3){
        setImage("enemy-critical.png");
    vel.mult(1.01);}
        
        
        else if (hitCounter >= totalHealth/3){
        setImage("enemy-low.png");vel.mult(1.002);
    
        if (!left){
            vel.x+= 0.01;
        } else {vel.x -=0.01;}
    }
        
        
        
        
    }
}