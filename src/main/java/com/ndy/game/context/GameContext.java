package com.ndy.game.context;

import com.google.gson.annotations.Expose;
import com.ndy.MiniGameModulePlugin;
import com.ndy.file.GsonUtil;
import com.ndy.file.abstraction.ISaveable;
import com.ndy.file.abstraction.IUseFileIO;
import com.ndy.file.manage.FileManager;
import com.ndy.game.abstraction.IGameLogic;
import com.ndy.game.attribute.GameAttribute;
import com.ndy.game.attribute.GameAttributeContext;
import com.ndy.game.lobby.GameLobby;
import com.ndy.game.scheduler.GameScheduler;

import java.io.File;

public class GameContext implements ISaveable {

    @Expose private GameLobby lobby; /** 게임 대기실 */
    @Expose private GameAttributeContext attributeContext; /** 게임 속성 Context */
    @Expose(serialize = false) private GameScheduler scheduler;

    public GameContext(String name) {
        this.lobby = new GameLobby(name);
        this.attributeContext = new GameAttributeContext();

        this.attributeContext.registerAttribute("name", new GameAttribute<>(name));
    }

    public void setLobby(GameLobby lobby) { this.lobby = lobby; }
    public void setGameLogic(IGameLogic logic) { this.scheduler = new GameScheduler(logic, logic.getExecuteDelay()); }

    public GameLobby getLobby() { return lobby; }
    public GameScheduler getScheduler() { return scheduler; }

    @Override
    public void save() {
        File gameFolder = FileManager.mkdir(MiniGameModulePlugin.getInstance().getDataFolder(), "game");
        GameAttribute<String> name = attributeContext.getAttribute("name");
        IUseFileIO<GameContext> fileIO = new GsonUtil<>(gameFolder, name.getValue(), this, GameContext.class);

        if(fileIO.exists()) fileIO.delete();

        fileIO.save();
    }
}
