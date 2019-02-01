package com.ndy.module;

import java.util.HashMap;
import java.util.Map;

public class GameModuleManager {

    private static GameModuleManager instance;
    private Map<String, Game> gameMap = new HashMap<>();

    private GameModuleManager() {}

    public static synchronized GameModuleManager getInstance() {
        if(instance == null) instance = new GameModuleManager();

        return instance;
    }

    public void registerGame(Game game) {
        gameMap.put(game.toString(), game);
    }

    public Game getGame(String gameName) { return gameMap.get(gameName); }

}
