package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" LA RULETA RUSA");

        int num_jugadores;
        do {
            System.out.print("INGRESE EL NUMERO DE JUGADORES DEL 1-6");
            num_jugadores = scanner.nextInt();
        } while (num_jugadores < 1 || num_jugadores > 6);


        scanner.nextLine();
        List<String> nombres = new ArrayList<>();
        for (int i = 0; i < num_jugadores; i++) {
            System.out.print("INGRESE EL NOMBRE DEL JUGADOR " + (i + 1) + ": ");
            nombres.add(scanner.nextLine());
        }

        ruletaRusa juego = new ruletaRusa(num_jugadores, nombres);


        while (true) {
            System.out.println("TURNO DE " + juego.getJugador_actual());
            juego.mostrar_informacion();
            System.out.println("1. DISPARAR");
            System.out.println("2. SALIR POR COBARDE");
            System.out.print("SELECCIONE UNA OPCION: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 2) {
                System.out.println(  juego.getJugador_actual() + " COBARDEEEEE ");
                break;
            } else if (opcion == 1) {
                if (juego.disparar()) {
                    System.out.println("BOOM " + juego.getJugador_actual() + " ESTAS MUERTO.");
                    break;
                } else {
                    System.out.println( juego.getJugador_actual() + " SIGUES CON VIDA");
                    juego.siguiente_turno();
                }
            } else {
                System.out.println(" OPCION NO VALIDA");
            }
        }
        scanner.close();
    }
}