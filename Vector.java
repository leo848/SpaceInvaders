import java.lang.Math;

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Vector.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Vector  
{
    // Attribute -  ersetzen Sie das Beispiel hier mit ihren eigenen Attributen
    public double x;
    public double y;

    /**
     * Konstruktor für Objekte der Klasse Vector
     */
    public Vector(double ix, double iy)
    {
        x = ix;
        y = iy;
    }

    Vector add(Vector vector)
    {
        // Ergänzen Sie Ihren Quelltext hier...
        x +=  vector.x;
        y +=  vector.y;
        return this;
    } 
    
    Vector mult(double num){
        x *= num;
        y *= num;
        return this;
    }
    
    Vector div(double num){
        x /=(double) num;
        y /=(double) num;
        return this;
    }
    
    double magSq(){
        return x * x + y * y;
    }
    
    Vector limit(double max){
        double mSq = magSq();
        if (mSq > max * max) {
              this.div(Math.sqrt(mSq)) //normalize it
                .mult(max);
            }
        return this;
    }
    
    
    Vector copy(){
        return new Vector(x, y);
    }
    
    
}