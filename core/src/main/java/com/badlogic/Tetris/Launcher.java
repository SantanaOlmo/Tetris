package com.badlogic.Tetris;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Launcher extends Game {
 TetrisGame tetrisGame= new TetrisGame();
    @Override
   public void create() {
        tetrisGame.iniciarJuego();
        //setScreen sería para iniciar la pantalla de juego, pero creo que lo mejor sería hacer primero la lógica por consolag
        //setScreen(new FirstScreen());
    }
}
