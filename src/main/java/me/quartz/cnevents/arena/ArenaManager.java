package me.quartz.cnevents.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ArenaManager {

    private final List<Arena> arenas;

    public ArenaManager() {
        this.arenas = new ArrayList<>();
    }

    public Arena getArena(UUID uuid) {
        return getArenas().stream().filter(arena -> arena.getUuid().toString().equals(uuid.toString())).findAny().orElse(null);
    }

    public Arena getArena() {
        if (getArenas() == null || getArenas().isEmpty()) return null;
        return getArenas().get(new Random().nextInt(getArenas().size()));
    }

    public List<Arena> getArenas() {
        return arenas;
    }
}
