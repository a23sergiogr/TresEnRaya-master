# Proyecto Tres en Raya

El proyecto "Tres en Raya" es una implementación del clásico juego de tres en raya (o tic-tac-toe) en Java. Este juego permite a un jugador enfrentarse a una inteligencia artificial que actúa como oponente.

## Estructura del proyecto

El proyecto consta de los siguientes archivos:

- `TresEnRaya.java`: Contiene la lógica del juego, incluyendo la representación del tablero, la lógica de la IA para la máquina, y métodos para verificar la victoria y controlar el flujo del juego.
- `InterfazConsola.java`: Contiene la interfaz de usuario basada en consola para interactuar con el juego.
  
## Funcionalidades principales

- **Juego contra la máquina**: El jugador puede enfrentarse a la máquina, que ofrece tres niveles de dificultad.
- **Niveles de dificultad**:
  - **Fácil**: La máquina realiza movimientos aleatorios.
  - **Normal**: La máquina intenta ganar la partida si es posible, de lo contrario, bloquea al jugador o realiza movimientos aleatorios.
  - **Difícil**: La máquina prioriza ganar la partida o bloquear al jugador. También intenta ocupar el centro y las esquinas del tablero.
- **Interfaz de consola**: La interacción con el juego se realiza a través de la consola.
