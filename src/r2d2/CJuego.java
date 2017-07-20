package r2d2;
/**
* CJuego
* La clase CJuego es la encargada de contener todos los métodos principales para llevar a cabo la ejecución del
* programa Arturito.
* 
* @author Maldonado, Carlos. Márquez, Rubén. Raffalli, José.
* @version 1.00, 13/10/2015
* 
*/

// Librerías
import java.io.FileNotFoundException; // Librería de la excepción en la lectura del archivo de texto
import java.io.IOException; // Librería de la excepción en la lectura del archivo de texto
import java.util.Scanner; // Librería de scanner

public class CJuego
{
    //Atributos de la clase CJuego
    private CTablero mundo = new CTablero(); //El mundo del Arturito en donde contiene el tablero
    Scanner sc = new Scanner(System.in); //El Scanner necesario para la lectura de respuestas introducidas por el usuario
    private CRobot r2d2; //El Arturito que integra el programa y se mueve en el mundo

    /**
    * Menú
    * El método menú es el método principal que ejecuta el programa Arturito y en donde se lleva a cabo el juego en si.
    */
    
    public void Menu() throws FileNotFoundException, IOException
    { 
        System.out.println("\n=====================================================\n"+"\t \033[31mBienvenido"+" al mundo de"+"\033[34m Arturito"+"\n=====================================================\n");
        System.out.println("-------------------------------------------------------");
        System.out.println("Para encender el arturito [z]");
        System.out.println("-------------------------------------------------------");
        String rsp = sc.nextLine();
        if (rsp.equalsIgnoreCase("z"))
        {
            System.out.println("Desea posicionar manualmente al Arturito en el tablero para comenzar? \n");
            System.out.println("S = Si");
            System.out.println("N = No");
            String rsp1 = sc.nextLine();
            if (rsp1.equalsIgnoreCase("s"))
            {
                System.out.println("Por favor introduzca la coordenada en x:");
                int x = sc.nextInt();
                System.out.println("Por favor introduzca la coordenada en y");
                int y = sc.nextInt();
                r2d2 = new CRobot(x, y, 'A'); //Inicializa el Arturito con las coordenadas introducidas por el usuario
            } 
            else if (rsp1.equalsIgnoreCase("n"))
            {
                r2d2 = new CRobot(7, 0, 'A');
            }
            //Runtime.getRuntime().exec("clear");
            boolean apagar = false;
            mundo.inicializarTableros(r2d2);
            do
            { 
                mundo.mostrarTableros();
                System.out.println("");
                System.out.println("\n MENU DE JUEGO \n");
                System.out.println("Que desea hacer? : \n");
                System.out.println("1. Para mover arturito");
                System.out.print("2. Para girar al ");
                if(r2d2.getDireccion() == 'N')
                {
                    System.out.println("Este");
                }
                else if(r2d2.getDireccion() == 'E')
                {
                    System.out.println("Sur");
                }
                else if(r2d2.getDireccion() == 'S')
                {
                    System.out.println("Oeste");
                }
                else if(r2d2.getDireccion() == 'W')
                {
                    System.out.println("Norte");
                }
                System.out.print("3. Para girar al ");
                if(r2d2.getDireccion() == 'N')
                {
                    System.out.println("Oeste");
                }
                else if(r2d2.getDireccion() == 'W')
                {
                    System.out.println("Sur");
                }
                else if(r2d2.getDireccion() == 'S')
                {
                    System.out.println("Este");
                }
                else if(r2d2.getDireccion() == 'E')
                {
                    System.out.println("Norte");
                }
                System.out.println("4. Para tomar Beeper");
                System.out.println("5. Para dejar Beeper");
                System.out.println("6. Para apagar el arturito \n");
                System.out.print("\033[32mDireccion actual: ");
                if(r2d2.getDireccion() == 'N')
                {
                    System.out.println("Norte");
                }
                else if(r2d2.getDireccion() == 'E')
                {
                    System.out.println("Este");
                }
                else if(r2d2.getDireccion() == 'S')
                {
                    System.out.println("Sur");
                }
                else if(r2d2.getDireccion() == 'W')
                {
                    System.out.println("Oeste");
                }
                System.out.println("\033[34mBeepers en la bolsa: "+r2d2.getBolsa());
                int rsp2 = sc.nextInt();
                if (rsp2 == 1)
                {
                    System.out.println("Desea establecer la cantidad d movimientos?" + " \n s para si n para no \n");
                    String rsp3 = sc.next();
                    if (rsp3.equalsIgnoreCase("s"))
                    { 
                        System.out.println("Cuantos espacios desea desplazarse? :");
                        int n = sc.nextInt();
                        char d = r2d2.getDireccion();
                        r2d2.mover(n, d,mundo.getTableroI(),r2d2);
                    } 
                    else if (rsp3.equalsIgnoreCase("n"))
                    { 
                        int n = 1;
                        char d = r2d2.getDireccion();
                        r2d2.mover(n, d,mundo.getTableroI(),r2d2);
                    }
                    
                }
                else if (rsp2 == 2)
                {
                    r2d2.setDireccion(r2d2.girarDerecha());
                } 
                else if (rsp2 == 3)
                { 
                    r2d2.setDireccion(r2d2.girarIzquierda());
                } 
                else if (rsp2 == 4)
                {  
                    r2d2.tomarBeeper(mundo.getTableroI());
                } 
                else if (rsp2 == 5)
                {
                    r2d2.dejarBeeper(mundo.getTableroI()); 
                } 
                else if (rsp2 == 6)
                { 
                    apagar = true;
                    if(mundo.compararMundos()==true)
                    {
                        System.out.println("==============================================================================================================");
                        System.out.println("===================================Has ganado el juego! Los mundos son iguales===================================");
                        System.out.println("==============================================================================================================");
                    }
                    else
                    {
                        System.out.println("==============================================================================================================");
                        System.out.println("===================================Has perdido... Los mundos no son iguales===================================");
                        System.out.println("==============================================================================================================");
                    }
                }
            }while (apagar == false);
        }
    }
}
