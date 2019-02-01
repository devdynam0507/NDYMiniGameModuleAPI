package com.ndy.game;

import com.google.gson.annotations.Expose;
import com.ndy.game.abstraction.IGameLogic;
import com.ndy.game.context.GameContext;
import com.ndy.game.lobby.GameLobby;


public abstract class Game {

    /**
     * Game Module 최상위 클래스
     * */

    @Expose private GameContext context;

    public Game(GameContext context, IGameLogic logic) {
        this.context = context;
        this.context.setGameLogic(logic);
    }

    public abstract void initialize(); /* 게임 준비 함수 */
    public abstract void start(); /* 게임 시작 함수 */

    public void setGameLobby(GameLobby lobby) { this.context.setLobby(lobby); }

    public GameLobby getGameLobby() { return context.getLobby(); }
    public GameContext getContext() { return context; }

}
