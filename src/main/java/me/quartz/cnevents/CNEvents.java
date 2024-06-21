package me.quartz.cnevents;

import me.quartz.cnevents.arena.ArenaManager;
import me.quartz.cnevents.commands.CNEventCommand;
import me.quartz.cnevents.event.EventManager;
import me.quartz.cnevents.files.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CNEvents extends JavaPlugin {

    private static CNEvents instance;
    private FileManager fileManager;
    private ArenaManager arenaManager;
    private EventManager eventManager;

    @Override
    public void onEnable() {
        registerManagers();
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerManagers() {
        instance = this;
        fileManager = new FileManager();
        arenaManager = new ArenaManager();
        eventManager = new EventManager();
    }

    private void registerCommands() {
        getCommand("cnevent").setExecutor(new CNEventCommand());
    }

    public static CNEvents getInstance() {
        return instance;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}
