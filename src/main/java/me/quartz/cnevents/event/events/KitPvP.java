package me.quartz.cnevents.event.events;

import me.quartz.cnevents.CNEvents;
import me.quartz.cnevents.arena.Arena;
import me.quartz.cnevents.event.Event;
import me.quartz.cnevents.event.EventType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class KitPvP implements Event {

    private final EventType eventType;
    private final List<UUID> players;
    private final Arena arena;

    private final HashMap<UUID, ItemStack[]> inventoryContent;
    private final HashMap<UUID, ItemStack[]> armorContent;

    private boolean cooldownStarted;
    private int cooldown;

    public KitPvP() {
        this.eventType = EventType.KITPVP;
        this.players = new ArrayList<>();
        this.arena = CNEvents.getInstance().getArenaManager().getArena();
        this.inventoryContent = new HashMap<>();
        this.armorContent = new HashMap<>();
        this.cooldownStarted = false;
        this.cooldown = 60;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }

    @Override
    public List<Player> getPlayers() {
        return players.stream().filter(uuid -> Bukkit.getPlayer(uuid) != null).map(Bukkit::getPlayer).collect(Collectors.toList());
    }

    @Override
    public boolean joinPlayer(Player player) {
        return false;
    }

    @Override
    public void leavePlayer(Player player) {
        players.remove(player.getUniqueId());
    }

    @Override
    public void addInventory(Player player) {
        inventoryContent.put(player.getUniqueId(), player.getInventory().getContents());
        armorContent.put(player.getUniqueId(), player.getInventory().getArmorContents());
    }

    @Override
    public void restoreInventory(Player player) {
        if(armorContent.containsKey(player.getUniqueId()) && inventoryContent.containsKey(player.getUniqueId())) {
            player.getInventory().setContents(inventoryContent.get(player.getUniqueId()));
            player.getInventory().setArmorContents(armorContent.get(player.getUniqueId()));
        }
    }

    @Override
    public Arena getArena() {
        return arena;
    }

    @Override
    public void start() {
    }
}
