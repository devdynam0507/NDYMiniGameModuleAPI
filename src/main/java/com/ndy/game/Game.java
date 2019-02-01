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

    /**
     * @param context 게임의 정보를 담고있는 객체입니다.
     * @param logic Game Loop 가 도는동안 반복해서 실행할 로직을 등록합니다.
     * */
    public Game(GameContext context, IGameLogic logic) {
        this.context = context;
        this.context.setGameLogic(logic);
    }

    abstract void initialize(); /* 게임 준비 메소드 */

    /**
     * 게임 시작 메소드
     * */
    public void start(IGameLogic.LogicType type) {
        initialize();

        context.getScheduler().startScheduler(type);
    }

    public void setGameLobby(GameLobby lobby) { this.context.setLobby(lobby); }

    public GameLobby getGameLobby() { return context.getLobby(); }
    public GameContext getContext() { return context; }

}
