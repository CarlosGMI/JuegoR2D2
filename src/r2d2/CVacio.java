package r2d2;
/**
* CVacio
* La clase CVacio hereda de CCasilla y contiene los constructores correspondientes para luego ser insertados en los
* tableros; cumple con la función de ocupar las casillas que estén vacías.
* 
* @author Maldonado, Carlos. Márquez, Rubén. Raffalli, José.
* @version 1.00, 13/10/2015
* 
*/
public class CVacio extends CCasilla
{
    public CVacio(int x, int y, char simb)
    {
        super(x,y,simb);
    }
    
    public CVacio()
    {
        
    }
}
