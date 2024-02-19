import motor3R.TresEnRaya;

import java.util.Scanner;

public class InterfaceConsola {

    TresEnRaya tresRaya;
    Scanner sc = new Scanner(System.in);

    public InterfaceConsola() {
        tresRaya = new TresEnRaya();
        inicio();
        jugar();
    }

    public static void main(String[] args) {
        new InterfaceConsola();
    }
        
    public void inicio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escoge el nivel de dificultad: 1. Fácil 2. Medio 3. Difícil");
        int nivel = scanner.nextInt();
        tresRaya.setDificultad((short) nivel);
        System.out.println("Nueva Partida, Tablero vacío");
        mostrarTablero(tresRaya.getTablero());

    }

    public void jugar() {
        while (true) {
            partida();
            System.out.println("¿Quieres jugar otra partida? (s/n)");
            String respuesta = sc.next();
            if (respuesta.equals("n")) {
                break;
            }
            tresRaya = new TresEnRaya();
            inicio();
        }
    }

    public void partida() {
        int fila, columna, resultado = 0;
        boolean casillaVacia;

        while (resultado == 0) {
            //Turno del jugador
            do{
                System.out.println("Introduce fila: ");
                fila = sc.nextInt();
                System.out.println("Introduce columna: ");
                columna = sc.nextInt();
                casillaVacia = tresRaya.setCasilla(fila, columna, 'O');
                if (!casillaVacia) {
                    System.out.println("Casilla ocupada, elige otra");
                }
            } while(!casillaVacia);

            System.out.println("Tablero después de tu jugada");
            mostrarTablero(tresRaya.getTablero());

            //Condicion de Victoria
            resultado = tresRaya.comprobarVictoria('O');

            if (resultado == 0) {
                //Turno de la máquina
                tresRaya.turnoMaquina();
                System.out.println("Tablero después de la jugada de la máquina");
                mostrarTablero(tresRaya.getTablero());

                //Condicion de Victoria
                resultado = tresRaya.comprobarVictoria('X');
            }
        }
        finalPartida(resultado);
    }

    public void finalPartida(int resultado) {
        if (resultado == 1) {
            System.out.println("Has ganado");
        } else if (resultado == 2) {
            System.out.println("Has perdido");
        } else {
            System.out.println("Empate");
        }
    }
    
    public void mostrarTablero(char[][] tablero) {
        // Mostrar tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (j == 2)
                    System.out.print(tablero[i][j]);
                else 
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
        }
    }
}

