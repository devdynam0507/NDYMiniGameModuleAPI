package com.ndy.game.scheduler;

import com.ndy.MiniGameModulePlugin;
import com.ndy.game.abstraction.IGameLogic;
import org.bukkit.Bukkit;

public class GameScheduler {

    private int taskId = -1;
    private long delay;
    private IGameLogic logic;

    public GameScheduler(IGameLogic logic, int delay) {
        this.logic = logic;
        this.delay = delay * 20;
    }

    public void startRepeatingTask() {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(MiniGameModulePlugin.getInstance(), () -> {
            try {
                logic.doExecute();
            }catch (Exception e) {
                logic.dispose();
                cancelTask();
            }
        },0L, delay);
    }

    public void startDelayedTask() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(MiniGameModulePlugin.getInstance(), () -> {
            try {
                logic.doExecute();
            }catch (Exception e) {
                logic.dispose();
            }
        }, delay);
    }

    public boolean isRunning() { return taskId != -1; }

    public void cancelTask() {
        if(taskId != -1) {
            Bukkit.getScheduler().cancelTask(taskId);
            taskId = -1;
        }
    }

}
