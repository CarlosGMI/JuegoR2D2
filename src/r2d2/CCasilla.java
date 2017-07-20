package r2d2;
/**
* CCasilla
* La clase CCasilla contiene la casilla que compone a los tableros, es una clase padre puesto que de ellas heredan CRobot,
* CBeeper, CPared y CVacio; Cada casilla tiene una coordenada (posición x - posición y) y un símbolo que la identifica a
* la hora de mostrar los tableros por pantalla.
* 
* @author Maldonado, Carlos. Márquez, Rubén. Raffalli, José.
* @version 1.00, 13/10/2015
* 
*/
public class CCasilla 
{
    // Atributos
    protected int posx;
    protected int posy;
    protected char simbolo;
    
    // Constructores
    public CCasilla() //Vacio por default
    {
        
    }
    
    public CCasilla(int x, int y, char simbolo) // Por parametros
    {
        this.posx = x;
        this.posy = y;
        this.simbolo = simbolo;
    }
    
    // Getters and Setters
    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
