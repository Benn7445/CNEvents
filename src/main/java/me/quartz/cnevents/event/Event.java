package me.quartz.cnevents.event;

import me.quartz.cnevents.arena.Arena;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.UUID;

public interface Event {

    public EventType getEventType();
    public List<Player> getPlayers();
    public boolean joinPlayer(Player player);
    public void leavePlayer(Player player);
    public void addInventory(Player player);
    public void restoreInventory(Player player);
    public Arena getArena();
    public void start();

}
