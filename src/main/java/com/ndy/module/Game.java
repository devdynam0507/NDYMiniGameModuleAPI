package com.ndy.module;

import com.google.gson.annotations.Expose;
import com.ndy.MiniGameModulePlugin;
import com.ndy.file.GsonUtil;
import com.ndy.file.abstraction.ISaveable;
import com.ndy.file.abstraction.IUseFileIO;
import com.ndy.file.manage.FileManager;
import com.ndy.lobby.GameLobby;

import java.io.File;

public abstract class Game implements ISaveable {

    @Expose private GameLobby lobby;
    @Expose private String name;

    public abstract void start(); /* 게임 시작 함수 */

    public void setLobby(GameLobby lobby) { this.lobby = lobby; }

    @Override
    public void save() {
        File gameFolder = FileManager.mkdir(MiniGameModulePlugin.getInstance().getDataFolder(), "game");
        IUseFileIO<Game> fileIO = new GsonUtil<>(gameFolder, name, this, Game.class);
        fileIO.save();
    }

}
