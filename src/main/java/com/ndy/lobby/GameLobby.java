package com.ndy.lobby;

import com.google.gson.annotations.Expose;
import com.ndy.util.LocationWrapper;

public class GameLobby {

    @Expose private LocationWrapper locationWrapper;
    @Expose private String lobbyName;

    public GameLobby(String lobbyName) {
        this.lobbyName = lobbyName;
    }

}
