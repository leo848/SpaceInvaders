import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Bullet.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bullet extends Actor
{
    
    Random random = new Random();
    
    Vector pos = new Vector(0,0);
    Vector vel = new Vector(0,-3);
    public Bullet(double ix, double iy){
        pos.x = ix;
        pos.y = iy;
    }
    public void act() 
    {
        if (pos.y < 0){
            getWorld().removeObject(this);
        }
        
        pos.add(vel);
        setLocation((int) pos.x,(int)  pos.y);
        
    }    
}