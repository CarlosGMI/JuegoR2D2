package r2d2;
/**
* CBeeper
* La clase CBeeper hereda de CCasilla y contiene los constructores correspondientes para luego ser insertados en los
* tableros; cumple con la función de ser un objeto el cual Arturito puede manipular, tomándolo o dejándolo de acuerdo
* a la conveniencia del usuario.
* 
* @author Maldonado, Carlos. Márquez, Rubén. Raffalli, José.
* @version 1.00, 13/10/2015
* 
*/
public class CBeeper extends CCasilla
{
    public CBeeper()
    {
        
    }
    
    public CBeeper(int x, int y, char simb)
    {
        super(x,y,simb);
    }
}
