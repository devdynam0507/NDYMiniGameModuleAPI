package com.ndy.module;

import com.ndy.MiniGameModulePlugin;
import com.ndy.file.GsonUtil;
import com.ndy.file.manage.FileManager;
import com.ndy.game.Game;
import com.ndy.game.context.GameContext;

import java.io.File;
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

    /**
     * 모듈 플러그인에서 게임을 등록합니다.
     * */
    public void registerGame(Game game) {
        game.getContext().save();

        gameMap.put(game.toString(), game);
    }

    /**
     * GameContext 를 로드시켜줌으로써 게임객체의 정보를 얻어옵니다.
     *
     * @return GameContext
     * */
    public GameContext loadGame(String gameName) {
        File gameFolder = FileManager.mkdir(MiniGameModulePlugin.getInstance().getDataFolder(), "game");

        GsonUtil<GameContext> gsonUtil = new GsonUtil<>(gameFolder, gameName, null, GameContext.class);

        return gsonUtil.load();
    }

    public Game getGame(String gameName) { return gameMap.get(gameName); }

}
