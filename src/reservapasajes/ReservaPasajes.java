/*
una compania de vuelos cuenta con 6 destinos 
a los que realiza 3 vuelos diarios (manana, mediodia, noche).

Se necesita un programa que permita la carga de los asientos disponibles para cada vuelo.

Permitir al ussuario ingresar numero de destino, numero de horario de vuelo
y cantidad de asientos que quiere reservar.

El programa debe controlar si hay la cantidad de asientos solicitados
y comunicar el exito de la reserva o la no realizacion por falta de asientos disponibles

La compania no puede saber cuantas personas van a reservar pasajes en un dia dado
por lo tanto para salir del programa se ingresa la palabra finish
*/
package reservapasajes;
import java.util.Scanner;

public class ReservaPasajes {

    public static void main(String[] args) {
        String vuelos[][] = {{"Rio de janeiro","","",""},
                                {"Cancun","","",""},
                                {"Madrid","","",""},
                                {"Roma","","",""},
                                {"Milan","","",""},
                                {"Iguazu","","",""}
        };
        
        String destino;
        int horario, asientos, indiceDestino, asientosDisponibles;
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaStr = new Scanner(System.in);
        
        System.out.println("***************************************");
        System.out.println("***    Carga inicial de asientos    ***");
        System.out.println("***************************************\n");
        
        for (int i = 0; i < 6; i++) {
            System.out.println("Vuelo a " + vuelos[i][0]);
            System.out.println("1: manana. 2: tarde. 3: noche");
            for (int j = 1; j < 4; j++) {
                System.out.println("Ingrese asientos disponibles para el turno" + j +":");
                vuelos[i][j] = entradaStr.nextLine();
            }
            System.out.println("***************************************");
        }
        
        System.out.println("***************************************");
        System.out.println("***        Reserva de vuleos        ***");
        System.out.println("***************************************\n");
        
        while (true) {            
            System.out.println("Ingrese destino:");
            for (int i = 0; i < 6; i++) {
                System.out.println(i + " - " + vuelos[i][0]);
            }
            // lo uso String por el uso de finish para salir
            destino = entradaStr.nextLine();
            
            if (destino.equalsIgnoreCase("finish")){
                break;
            }
            
            System.out.println("Seleccione horario:");
            System.out.println("1 - manana");
            System.out.println("2 - tarde");
            System.out.println("3 - noche");
            horario = entradaInt.nextInt();
            
            System.out.println("----------------------------");
            System.out.println("cantidad de asientos a reservar:");
            asientos = entradaInt.nextInt();
            
            // paso String a int para usarlo de indice de la matriz
            indiceDestino = Integer.parseInt(destino);
            
            asientosDisponibles = Integer.parseInt(vuelos[indiceDestino][horario]);
            
            if (asientos <= asientosDisponibles) {
                asientosDisponibles -= asientos;
                vuelos[indiceDestino][horario] = Integer.toString(asientosDisponibles);
                System.out.println("**************************************");
                System.out.println("Su reserva fue realizada con exito.");
                System.out.println("***************************************\n");
            }
            else {
                System.out.println("**************************************");
                System.out.println("Disculpe, no se pudo completar la operacion\n dado que no hay asientos disponibles.");
                System.out.println("***************************************\n");
            }
        }
    
    }
}
