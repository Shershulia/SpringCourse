package com.ntnu.lernspringframework.game;

import com.ntnu.lernspringframework.game.GameRunner;
import com.ntnu.lernspringframework.game.MarioGame;
import com.ntnu.lernspringframework.game.PackManGame;
import com.ntnu.lernspringframework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var superContra = new SuperContraGame();
        var packMan = new PackManGame();
        var gameRunner = new GameRunner(packMan);
        gameRunner.run();
    }
}
