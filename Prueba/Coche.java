
/**
 * Write a description of class Coche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coche
{
    // instance variables - replace the example below with your own
    private int numeroDeRuedas;
    private int velocidad;

    /**
     * Constructor for objects of class Coche
     */
    public Coche(int numRuedas)
    {
        // initialise instance variables
        numeroDeRuedas = numRuedas;
        velocidad = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getNumRuedas()
    {
        // put your code here
        return numeroDeRuedas;
    }
    
    public int getVelocidad(){
        return velocidad;
    }
    
    public void acelerar(){
        velocidad = velocidad + 5;
    }
}
