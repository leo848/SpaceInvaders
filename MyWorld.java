import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse MyWorld.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MyWorld extends World
{
    public int gamesLost = 0;
    
    
    /**
     * Konstruktor für Objekte der Klasse MyWorld
     * 
     */
    public MyWorld()
    {    
        super(400, 600, 1);
        setPaintOrder(Enemy.class, SpaceShuttle.class, Bullet.class);
        
        addShuttle();
        
        Heart heart1 = new Heart();
        Heart heart2 = new Heart();
        Heart heart3 = new Heart();
        
        heart3.alive = false;
        
        addObject(heart1, 25,25);
        addObject(heart2, 65,25);
        addObject(heart3, 105,25);
        
    }
    
    void addShuttle(){
        SpaceShuttle shuttle = new SpaceShuttle();
        addObject(shuttle, 200, 500);
    }
    
    void checkLoseHeart(){
        gamesLost++;
            if (gamesLost > 2){showText("game over", 200,100);
            Greenfoot.stop();}
            
    }
}