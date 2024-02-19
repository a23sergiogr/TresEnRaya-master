package motor3R;
/**
 * Clase que controla la lógica del juego de 3 en Raya.
 * "X" es la máquina.
 * "O" es el jugador.
 * "_" es una casilla vacía.
 * El tablero se representa con una matriz de 3x3.
 *
 * @author a23SergioGR
 * @version 1.1
 */
public class TresEnRaya {
    private short dificultad;
    private char[][] tablero;


    /**
    * Constructor que crea e inicializa el tablero.
     * Todas las casillas se inicializan como vacías ('_').
    */
    public TresEnRaya() {
        // Crear e Inicializar tablero
        dificultad = 1;
        tablero = new char[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '_';
            }
        }
    }

    /**
     * Compruedba si la casilla está vacía y la rellena con el simbolo
     * 
     * @param fila    Índice de la fila de la casilla.
     * @param columna Índice de la columna de la casilla.
     * @param simbolo Símbolo a colocar en la casilla ('X' o 'O').
     * @return true si la casilla estaba vacía y se llenó correctamente, false si la casilla estaba ocupada.
     */
    public boolean setCasilla(int fila, int columna, char simbolo) {
        if (tablero[fila][columna] != '_') {
            return false;
        }
        tablero[fila][columna] = simbolo;
        return true;
    }

    /**
     * Modifica la dificultad del juego
     * 
     * @param dificultad Nivel de dificultad del juego (1, 2 o 3).
     */
    public void setDificultad(short dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * Obtiene la representación actual del tablero.
     *
     * @return La matriz que representa el tablero.
     */
    public char[][] getTablero() {
        char[][] copiaTablero = new char[tablero.length][tablero[0].length];
        copiaTablero = tablero.clone();
        return copiaTablero;
    }

    /**
     * Realiza el turno de la máquina.
     * Dependiendo de la dificultad, se comportará de una forma u otra.
     * Dificultad 1: Aleatorio.
     * Dificultad 2: Gana si puede, si no, pone al lado de una ficha propia.
     * Dificultad 3: Intenta ganar o bloquear al jugador.
     */
    public void turnoMaquina() {
        if (dificultad == 1) {
            turnoMaquinaFacil();
        }
        else if (dificultad == 2) {
            turnoMaquinaNormal();
        }
        else {
            turnoMaquinaDificil();
        } 
    }

    // Métodos privados para los diferentes niveles de dificultad...
    private void turnoMaquinaFacil() {
        // Poner ficha aleatoria
        int fila, columna;
        do {
            fila = (int) (Math.random() * 3);
            columna = (int) (Math.random() * 3);
        } while (!setCasilla(fila, columna, 'X'));
    }

    private void turnoMaquinaNormal() {
        // Comprobar si puede ganar
        if (posibleVictoria('X')) {
            return;
        }

        // Poner ficha al lado de una ficha propia
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'X') {
                    if (i - 1 >= 0 && tablero[i - 1][j] == '_') {
                        tablero[i - 1][j] = 'X';
                        return;
                    }
                    if (i + 1 < 3 && tablero[i + 1][j] == '_') {
                        tablero[i + 1][j] = 'X';
                        return;
                    }
                    if (j - 1 >= 0 && tablero[i][j - 1] == '_') {
                        tablero[i][j - 1] = 'X';
                        return;
                    }
                    if (j + 1 < 3 && tablero[i][j + 1] == '_') {
                        tablero[i][j + 1] = 'X';
                        return;
                    }
                }
            }
        }

        // Si no hay casilla para ganar ni se pude poner al lado de otra, pone una ficha aleatoria
        turnoMaquinaFacil();
    }

    private void turnoMaquinaDificil() {
        System.out.println("Dificil");
        // Comprobar si puede ganar
        if (posibleVictoria('X')) {
            return;
        }

        // Comprueba si el jugador puede ganar
        if (posibleVictoria('O')) {
            return;
        }

        // Poner ficha en el centro
        if(setCasilla(1, 1, 'X'))
            return;

        if(tablero[1][1] == 'X') {
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    if(setCasilla(0, 1, 'X'))
                        return;
                    break;
                case 1:
                    if(setCasilla(1, 0, 'X'))
                        return;
                    break;
                case 2:
                    if(setCasilla(1, 2, 'X'))
                        return;
                    break;
                case 3:
                    if(setCasilla(2, 1, 'X'))
                        return;
                    break;              
            }
        }

        // Poner ficha en una esquina si al lado contrario no hay ficha del jugador
        if (tablero[0][0] == '_' && tablero[2][2] == '_') {
            tablero[2][2] = 'X';
            return;
        }
        if (tablero[0][2] == '_' && tablero[2][0] == '_') {
            tablero[0][2] = 'X';
            return;
        }

        // Poner ficha al lado de una ficha propia
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'X') {
                    if (i - 1 >= 0 && tablero[i - 1][j] == '_') {
                        tablero[i - 1][j] = 'X';
                        return;
                    }
                    if (i + 1 < 3 && tablero[i + 1][j] == '_') {
                        tablero[i + 1][j] = 'X';
                        return;
                    }
                    if (j - 1 >= 0 && tablero[i][j - 1] == '_') {
                        tablero[i][j - 1] = 'X';
                        return;
                    }
                    if (j + 1 < 3 && tablero[i][j + 1] == '_') {
                        tablero[i][j + 1] = 'X';
                        return;
                    }
                }
            }
        }

        // Agotadas las opciones anteriores, pone una ficha aleatoria
        turnoMaquinaFacil();
    }

    /**
     * Comprueba si es posible lograr la victoria en el próximo movimiento para el símbolo proporcionado.
     *
     * @param c Símbolo ('X' o 'O') para el cual se verifica la posible victoria.
     * @return true si es posible ganar en el próximo movimiento, false de lo contrario.
     */
    private boolean posibleVictoria(char c) {
        // Comprobar si hay una casilla que permita ganar en el siguiente turno
        int n = 2;
        if (c == 'O') {
            n = 1;
        }

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (setCasilla(i, j, c)) {
                    if (comprobarVictoria(c) == n) {
                        tablero[i][j] = 'X';
                        return true;
                    }
                    tablero[i][j] = '_';
                }
            }
        }
        return false;
    }

    /**
     * Comprueba si hay victoria en el tablero.
     *
     * @param c Símbolo a comprobar ('X' o 'O').
     * @return 0 si no hay victoria, 1 si ha ganado el jugador, 2 si ha ganado la máquina, 3 si hay empate.
     */
    public int comprobarVictoria(char c) {
        // Filas
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == c && tablero[i][1] == c && tablero[i][2] == c) {
                //Victoria
                if (c == 'O') {
                    return 1;
                }
                else {
                    return 2;
                }
            }
        }

        // Columnas
        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[0][j] == c && tablero[1][j] == c && tablero[2][j] == c) {
                //Victoria
                if (c == 'O') {
                    return 1;
                }
                else {
                    return 2;
                }
            }
        }

        // Diagonales
        if (tablero[0][0] == c && tablero[1][1] == c && tablero[2][2] == c) {
            //Victoria
            if (c == 'O') {
                return 1;
            }
            else {
                return 2;
            }
        }
        if (tablero[0][2] == c && tablero[1][1] == c && tablero[2][0] == c) {
            //Victoria
            if (c == 'O') {
                return 1;
            }
            else {
                return 2;
            }
        }

        if (tableroLleno()) {
            return 3;
        }

        return 0;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }
}
