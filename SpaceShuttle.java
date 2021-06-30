import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse SpaceShuttle.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SpaceShuttle extends Actor
{
    int ammo;
    
    Random random = new Random();
    
    Vector pos = new Vector(200,500);
    Vector vel = new Vector(0,0);
    Vector acc = new Vector(0,0);
    
    int frameCount = 0;
    
    
    public SpaceShuttle()
    {
        
    }
    
    public void act() 
    {
        frameCount++;
        
        
        if (random.nextInt(5) == 0 && frameCount % 50 == 0){
            getWorld().addObject(new Enemy(), random.nextInt(385), 100);
        }
        
        
        if(Greenfoot.isKeyDown("left")){
        acc.x = -.25;
        } else if (Greenfoot.isKeyDown("right")){
        acc.x = .25;
        } 
        
        if (Greenfoot.getKey()=="space"){
            getWorld().addObject(new Bullet(pos.x,pos.y), (int)pos.x, (int)pos.y);
            
        }
        
        
        
        vel.limit(4);
        vel.mult(.98);
        
        if (pos.x < 15){
            pos.x=16;
            vel.mult(-0.9);
        }
        
        if (pos.x > 385){
            pos.x=384;
            vel.mult(-0.75);
        }
        
        vel.add(acc);
        pos.add(vel);
        
        acc = new Vector(0,0);
        
        setLocation((int) pos.x,(int)  pos.y);
    }    
}