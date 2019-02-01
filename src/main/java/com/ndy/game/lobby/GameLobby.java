package com.ndy.game.lobby;

import com.google.gson.annotations.Expose;
import com.ndy.util.LocationWrapper;
import org.bukkit.Location;

public class GameLobby {

    @Expose private LocationWrapper lobbyLocation; /** 게임 대기실 입장시 tp 될 위치 */
    @Expose private String lobbyName;

    public GameLobby(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public void setLobbyLocation(Location location) { this.lobbyLocation = new LocationWrapper(location); }

    public LocationWrapper getLobbyLocation() { return lobbyLocation; }
}
