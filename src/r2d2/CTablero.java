package r2d2;
/**
* CTablero
* La clase CTablero es la encargada de contener tanto el tablero inicial como el tablero final donde se desplazará el
* Arturito, además en ella se realiza la lectura del archivo de texto para su respectiva inicialización, se comparan
* los dos tableros y se muestran por pantalla.
* 
* @author Maldonado, Carlos. Márquez, Rubén. Raffalli, José.
* @version 1.00, 13/10/2015
* 
*/
import java.io.BufferedReader; //Librería para la lectura del archivo de texto
import java.io.FileNotFoundException; // Librería de la excepción en la lectura del archivo de texto
import java.io.FileReader; //Librería para la lectura del archivo de texto
import java.io.IOException; // Librería de la excepción en la lectura del archivo de texto
import java.util.Arrays; //Librería para comparar las matrices
import java.util.Scanner; // Librería del Scanner

public class CTablero 
{
    private CCasilla tableroI[][] = new CCasilla[8][8];
    private CCasilla tableroF[][] = new CCasilla[8][8];

    public CTablero()
    {
        
    }
    
    /**
    * Inicializar Tableros
    * Este método realiza la lectura del archivo de texto, este archivo de texto contiene las coordenadas de las paredes,
    * las coordenadas iniciales y finales de los beepers y la coordenada final del Arturito; al realizar la lectura 
    * se procede a inicializar los tableros con esas coordenadas.
    * 
    * @param r2d2I es el Arturito inicial que el usuario introduce por teclado dependiendo si escoge colocarlo manualmente
    * o con la coordenada que trae por defecto. Del tipo CRobot.
    */
    public void inicializarTableros(CRobot r2d2I) throws FileNotFoundException, IOException
    {
        FileReader text = new FileReader("mundos.txt");
        BufferedReader read = new BufferedReader(text);
        String texto;
        int aux = 0,x,y;
        CVacio casillaVacia = new CVacio();
        while((texto = read.readLine()) != null)
        {
            String palabras[] = texto.split(" ");
            if(aux < 14)
            {
                palabras[0] = palabras[1];
                palabras[1] = palabras[2];
                x = Integer.parseInt(palabras[0]);
                y = Integer.parseInt(palabras[1]);
                CPared pared = new CPared(x,y,'#');
                tableroI[x][y] = pared;
                tableroF[x][y] = pared;
            }
            else if(aux > 14 && aux < 18)
            {
                palabras[0] = palabras[1];
                palabras[1] = palabras[2];
                x = Integer.parseInt(palabras[0]);
                y = Integer.parseInt(palabras[1]);
                CBeeper beeper = new CBeeper(x,y,'B');
                tableroI[x][y] = beeper;
            }
            else if(aux > 18 && aux < 22)
            {
                palabras[0] = palabras[1];
                palabras[1] = palabras[2];
                x = Integer.parseInt(palabras[0]);
                y = Integer.parseInt(palabras[1]);
                CBeeper beeperf = new CBeeper(x,y,'B');
                tableroF[x][y] = beeperf;
            }
            else if(aux == 22)
            {
                palabras[0] = palabras[1];
                palabras[1] = palabras[2];
                x = Integer.parseInt(palabras[0]);
                y = Integer.parseInt(palabras[1]);
                CRobot r2d2f = new CRobot(x,y,'A');
                tableroF[x][y] = r2d2f;
            }
            aux++;
        }
        read.close();
        if(tableroI[r2d2I.getPosx()][r2d2I.getPosy()] instanceof CPared)
        {
            System.out.println("Error! No puedes ingresar el Arturito en una pared!");
        }
        else
        {
            tableroI[r2d2I.getPosx()][r2d2I.getPosy()] = r2d2I;
        }
        for (int i=0;i<8;i++) 
        {
            for (int j=0;j<8;j++) 
            {
                if(tableroI[i][j] == null)
                {
                    casillaVacia.setSimbolo(' ');
                    tableroI[i][j] = casillaVacia;
                }
                if(tableroF[i][j] == null)
                {
                    casillaVacia.setSimbolo(' ');
                    tableroF[i][j] = casillaVacia;
                }
            }
        }
    }
    
    /**
    * Mostrar Tableros
    * Este método realiza la impresión por pantalla de los tableros donde se desplazará el Arturito.
    */
    
    public void mostrarTableros()
    {
        System.out.println("======================TABLERO INICIAL======================\t\t\t\t=======================TABLERO FINAL=======================");
        for(int i=0;i<8;i++)
        {
            System.out.println("");
            for(int j=0;j<8;j++)
            {
                if(tableroI[i][j].getSimbolo() == 'A')
                {
                    System.out.print("["+tableroI[i][j].getSimbolo()+"]\t");
                }
                else if(tableroI[i][j].getSimbolo() == 'B')
                {
                    System.out.print("["+tableroI[i][j].getSimbolo()+"]\t");
                }
                else
                {
                    System.out.print("["+tableroI[i][j].getSimbolo()+"]\t");
                }
            }
            System.out.print("\t\t\t");
            for(int j=0;j<8;j++)
            {
                if(tableroF[i][j].getSimbolo() == 'A')
                {
                    System.out.print("["+tableroF[i][j].getSimbolo()+"]\t");
                }
                else if(tableroF[i][j].getSimbolo() == 'B')
                {
                    System.out.print("["+tableroF[i][j].getSimbolo()+"]\t");
                }
                else
                {
                    System.out.print("["+tableroF[i][j].getSimbolo()+"]\t");
                }
            }
        }
    }
    
    /**
    * Comparar Mundos
    * Este método realiza la comparación de los dos mundos (tablero inicial y tablero final) para determinar si son
    * iguales o no para mostrar por pantalla si el jugador ganó o no.
    */
    public boolean compararMundos ()
    {
        boolean iguales = true;
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                if(tableroI[i][j].getSimbolo() == tableroF[i][j].getSimbolo())
                {
                    iguales = true;
                }
                else 
                {
                    for(i=0; i<8; i++)
                    {
                        for(j=0; j<8; j++)
                        { 
                            iguales = false;
                        }
                    }
                }
            }
        }
        return iguales;
        /*if (Arrays.equals(tableroI , tableroF))
        System.out.println("Has Ganado la Partida");
        else
        System.out.println("Has perdido... \n "+"Los mundos no son iguales");*/
    }
    
    public CCasilla[][] getTableroI() {
        return tableroI;
    }

    public void setTableroI(CCasilla[][] tableroI) {
        this.tableroI = tableroI;
    }

    public CCasilla[][] getTableroF() {
        return tableroF;
    }

    public void setTableroF(CCasilla[][] tableroF) {
        this.tableroF = tableroF;
    }
}
