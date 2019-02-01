package com.ndy.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationWrapper {

    private double x, y, z;
    private String worldName;

    public LocationWrapper(Location location) {
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.worldName = location.getWorld().getName();
    }

    public LocationWrapper(World world, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.worldName = world.getName();
    }

    public LocationWrapper(World world, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.worldName = world.getName();
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public int getBlockX() { return (int) x; }
    public int getBlockY() { return (int) y; }
    public int getBlockZ() { return (int) z; }

    public String getWorldName() { return worldName; }
    public World getWolrd() { return Bukkit.getWorld(getWorldName()); }

    @Override
    public String toString() {
        return new LocationCrafter(toLocation()).toString();
    }

    public Location toLocation() {
        return new Location(getWolrd(), getX(), getY(), getZ());
    }
}
