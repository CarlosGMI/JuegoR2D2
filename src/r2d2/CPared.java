package r2d2;
/**
* CPared
* La clase CPared hereda de CCasilla y contiene los constructores correspondientes para luego ser insertados en los
* tableros; cumple con la función de impedir el paso del Arturito.
* 
* @author Maldonado, Carlos. Márquez, Rubén. Raffalli, José.
* @version 1.00, 13/10/2015
* 
*/
public class CPared extends CCasilla 
{
    public CPared()
    {
        
    }
    
    public CPared(int x, int y, char simb)
    {
        super(x,y,simb);
    }
}
