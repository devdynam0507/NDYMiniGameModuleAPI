package com.ndy.game.abstraction;

public interface IGameLogic {

    public enum LogicType { Repeating, Delayed}

    /**
    * Game 의 Main Logic 을 담당하는 인터페이스
    * */

    public void doExecute() throws Exception;
    public void dispose();
    public int getExecuteDelay();
}
