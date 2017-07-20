package r2d2;
/**
* CRobot
* La clase CRobot hereda de CCasilla y es la encargada de tener todos los métodos relacionados con el movimiento del
* Arturito dentro de su mundo inicial (tablero inicial); El robot (Arturito) tiene una bolsa donde él puede guardar 
* los beepers que vaya recogiendo en el juego y una dirección de movimiento.
* 
* @author Maldonado, Carlos. Márquez, Rubén. Raffalli, José.
* @version 1.00, 13/10/2015
* 
*/
import java.util.Scanner; //Librería del Scanner
import java.awt.*; //Librería que nos permite usar la función de Java que hace un "beep"

public class CRobot extends CCasilla 
{
    //Atributos 
    Scanner sc = new Scanner(System.in);
    private int bolsa = 0;
    private char direccion = 'N';

    //Getters and Setters
    public int getBolsa() 
    {
        return bolsa;
    }

    public void setBolsa(int bolsa) 
    {
        this.bolsa = bolsa;
    }

    public char getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(char direccion) 
    {
        this.direccion = direccion;
    }
    
    // Constructores
    public CRobot() //Constructor por default
    {

    }

    public CRobot(int x, int y, char simb, char direccion, int bolsa) //Constructor con parámetros
    {
        super(x, y, simb);
        this.direccion = direccion;
        this.bolsa = bolsa;
    }

    public CRobot(int x, int y, char simb)
    {
        super(x, y, simb);
    }
    /**
    * Mover
    * Este método es el encargado de realizar el movimiento del Arturito en el tablero inicial realizando las diversas
    * validaciones para ver si choca con alguna pared, llega algún beeper o se salió del tablero.
    * 
    * @param n es el número de pasos que el usuario ingresa para que el Arturito se mueva.
    * @param d es la dirección actual en la que el Arturito se está moviendo.
    * @param tablero es el tablero en el cual el Arturito se esta moviendo.
    * @param r2d2 se refiere al Arturito que se desplaza en el tablero.
    */
    public void mover(int n, char d, CCasilla[][] tablero, CRobot r2d2) 
    {
        if (d == 'N') 
        {
            if (this.getPosx() - n >= 0) // Validación si sale del tablero
            {
                if (this.choque(n, d, tablero) == false) // Validación si choca con una pared en el movimiento
                {
                    if (tablero[this.getPosx()][this.getPosy()] instanceof CBeeper) 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CBeeper(this.getPosx(), this.getPosy(), 'B');
                        tablero[this.getPosx() - n][this.getPosy()] = r2d2;
                        r2d2.setPosx(this.getPosx() - n);
                        r2d2.setPosy(this.getPosy());
                    }
                    else if (tablero[this.getPosx()-n][this.getPosy()] instanceof CBeeper) 
                    {
                        System.out.println("\033[31mTe has parado sobre un beeper!\n");
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx()-n][this.getPosy()] = new CBeeper(this.getPosx(), this.getPosy(), 'A');
                        r2d2.setPosx(this.getPosx() - n);
                        r2d2.setPosy(this.getPosy());
                    }
                    else 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx() - n][this.getPosy()] = r2d2;
                        r2d2.setPosx(this.getPosx() - n);
                        r2d2.setPosy(this.getPosy());
                    }
                } 
                else 
                {
                    System.out.println("\033[31mNo se pudo completar el movimiento, pues chocas con una pared");
                }
            } 
            else 
            {
                System.out.println("\033[31mERROR!!! TE SALES DEL TABLERO!!! \n");
            }
        }
        if (d == 'E') 
        {
            if (this.getPosy() + n <= 7) 
            {
                if (this.choque(n, d, tablero) == false)
                {
                    if (tablero[this.getPosx()][this.getPosy()] instanceof CBeeper) 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CBeeper(this.getPosx(), this.getPosy(), 'B');
                        tablero[this.getPosx()][this.getPosy() + n] = r2d2;
                        r2d2.setPosx(this.getPosx());
                        r2d2.setPosy(this.getPosy()+n);
                    }
                    else if (tablero[this.getPosx()][this.getPosy()+n] instanceof CBeeper) 
                    {
                        System.out.println("\033[31mTe has parado sobre un beeper!\n");
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx()][this.getPosy()+n] = new CBeeper(this.getPosx(), this.getPosy(), 'A');
                        r2d2.setPosx(this.getPosx());
                        r2d2.setPosy(this.getPosy()+n); 
                    }
                    else 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx()][this.getPosy()+ n] = r2d2;
                        r2d2.setPosy(this.getPosy() + n);
                        r2d2.setPosx(this.getPosx());
                    }

                } 
                else 
                {
                    System.out.println("\033[31mNo se pudo completar el movimiento, pues chocas con una pared");
                }
            } 
            else 
            {
                System.out.println("\033[31mERROR!!! TE SALES DEL TABLERO!!! \n");
            }
        }
        if (d == 'S') 
        {
            if (this.getPosx() + n <=7)
            {
                if (this.choque(n, d, tablero)==false)
                {
                    if (tablero[this.getPosx()][this.getPosy()] instanceof CBeeper) 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CBeeper(this.getPosx(), this.getPosy(), 'B');
                        tablero[this.getPosx()+n][this.getPosy()] = r2d2;
                        r2d2.setPosx(this.getPosx()+n);
                        r2d2.setPosy(this.getPosy());
                    }
                    else if (tablero[this.getPosx()+n][this.getPosy()] instanceof CBeeper) 
                    {
                        System.out.println("\033[31mTe has parado sobre un beeper!\n");
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx()+n][this.getPosy()] = new CBeeper(this.getPosx(), this.getPosy(), 'A');
                        r2d2.setPosx(this.getPosx()+n);
                        r2d2.setPosy(this.getPosy()); 
                    } 
                    else 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx() + n][this.getPosy()] = r2d2;
                        r2d2.setPosx(this.getPosx() + n);
                        r2d2.setPosy(this.getPosy());
                    }
                } 
                else 
                {
                    System.out.println("\033[31mNo se pudo completar el movimiento, pues chocas con una pared");
                }
            } 
            else 
            {
                System.out.println("\033[31mERROR!!! TE SALES DEL TABLERO!!! \n");
            }
        }
        if (d == 'W') 
        {
            if (this.getPosy() - n >= 0)
            {
                if (this.choque(n, d, tablero)==false)
                {
                    if (tablero[this.getPosx()][this.getPosy()] instanceof CBeeper) 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CBeeper(this.getPosx(), this.getPosy(), 'B');
                        tablero[this.getPosx()][this.getPosy() - n] = r2d2;
                        r2d2.setPosx(this.getPosx());
                        r2d2.setPosy(this.getPosy()-n);
                    }
                    else if (tablero[this.getPosx()][this.getPosy()-n] instanceof CBeeper) 
                    {
                        System.out.println("\033[31mTe has parado sobre un beeper!\n");
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx()][this.getPosy()-n] = new CBeeper(this.getPosx(), this.getPosy(), 'A');
                        r2d2.setPosx(this.getPosx());
                        r2d2.setPosy(this.getPosy()-n); 
                    }
                    else 
                    {
                        tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(), this.getPosy(), ' ');
                        tablero[this.getPosx()][this.getPosy()- n] = r2d2;
                        r2d2.setPosy(this.getPosy() - n);
                        r2d2.setPosx(this.getPosx());
                    }
                } 
                else 
                {
                    System.out.println("\033[31mNo se pudo completar el movimiento, pues chocas con una pared");
                }
            } 
            else 
            {
                System.out.println("\033[31mERROR!!! TE SALES DEL TABLERO!!! \n");
            }
        }
    }
    /**
    * Girar a la Derecha
    * Este método es el encargado de girar el Arturito a la derecha de su posición.
    * 
    * @return la dirección a la cual se moverá el Arturito.
    */
    public char girarDerecha() 
    {
        if (direccion == 'N') 
        {
            return direccion = 'E';
        } 
        else if (direccion == 'E') 
        {
            return direccion = 'S';
        } 
        else if (direccion == 'S') 
        {
            return direccion = 'W';
        } 
        else if (direccion == 'W') 
        {
            return direccion = 'N';
        }
        return direccion = 'N';
    }
    /**
    * Girar a la Izquierda
    * Este método es el encargado de girar el Arturito a la izquierda de su posición.
    * 
    * @return la dirección a la cual se moverá el Arturito.
    */
    public char girarIzquierda() 
    {
        if (direccion == 'N') 
        {
            return direccion = 'W';
        } 
        else if (direccion == 'W') 
        {
            return direccion = 'S';
        } 
        else if (direccion == 'S') 
        {
            return direccion = 'E';
        } 
        else if (direccion == 'E') 
        {
            return direccion = 'N';
        }
        return direccion = 'N';
    }
    /**
    * Dejar Beeper
    * Este método es el encargado de dejar el beeper en alguna casilla elegida por el usuario, además de restarle un
    * beeper a la bolsa que tiene el Arturito apenas al comenzar el juego.
    * 
    * @param tablero se refiere al tablero en el cual el Arturito está realizando sus movimientos.
    */
    public void dejarBeeper(CCasilla[][] tablero)
    {
        if(bolsa > 0)
        {
            if(tablero[this.getPosx()][this.getPosy()] instanceof CBeeper)
            {
                System.out.println("\033[31mNo puedes dejar un beeper! Ya existe uno en esta casilla");
            }
            else
            {
                tablero[this.getPosx()][this.getPosy()] = new CBeeper(this.getPosx(),this.getPosy(),'A');
                System.out.println("\033[31mHas dejado el beeper!");
                bolsa--;
            }
        }
        else
        {
            System.out.println("\033[31mNo puedes dejar Beeper, la bolsa está vacía!");
        }
    }
    /**
    * Tomar Beeper
    * Este método es el encargado de tomar el beeper en alguna casilla donde haya uno, además de sumarle un
    * beeper a la bolsa que tiene el Arturito apenas al comenzar el juego.
    * 
    * @param tablero se refiere al tablero en el cual el Arturito está realizando sus movimientos.
    */
       public void tomarBeeper (CCasilla[][] tablero)
       {
           if(tablero[this.getPosx()][this.getPosy()] instanceof CBeeper)
           {
               tablero[this.getPosx()][this.getPosy()] = new CVacio(this.getPosx(),this.getPosy(),'A');
               Toolkit.getDefaultToolkit().beep();
               System.out.println("\033[31mHas tomado un beeper!");
               bolsa++;
           }
           else
           {
               System.out.println("\033[31mERROR! No hay beeper en esta posicion");
           }
       }
    /**
    * Choque
    * Este método es el encargado de validar si el Arturito al moverse un número de pasos ingresado por el usuario se 
    * encontrará con una pared debido a lo cual él no podrá pasar.
    * 
    * @param n es el número de pasos que el usuario ingresa para que el Arturito se mueva.
    * @param d es la dirección actual en la que el Arturito se está moviendo.
    * @param tablero es el tablero en el cual el Arturito se esta moviendo.
    * 
    * @return true en caso de que si exista una pared en su camino, false en el caso contrario.
    */
    public boolean choque(int n, char d, CCasilla[][] tablero) 
    {
        int cont = 0;
        int aux = 1;
        do 
        {
            if(d == 'N') 
            {
                if (tablero[this.getPosx() - aux][this.getPosy()] instanceof CPared) 
                {
                    return true;
                } 
                else 
                {
                    cont++;
                    aux++;
                }
            } 
            else if(d == 'E') 
            {
                if (tablero[this.getPosx()][this.getPosy()+aux] instanceof CPared) 
                {
                    return true;
                } 
                else 
                {
                    cont++;
                    aux++;
                }
            }
            else if (d == 'S')
            {
                if (tablero[this.getPosx() + aux][this.getPosy()] instanceof CPared) 
                {
                    return true;
                } 
                else 
                {
                    aux++;
                    cont++;
                }
            }
            else if (d == 'W')
            {
                if (tablero[this.getPosx()][this.getPosy()-aux] instanceof CPared) 
                {
                    return true;
                } 
                else 
                {
                    aux++;
                    cont++;
                }
            }
        } while (cont < n);
        return false;
    }
}