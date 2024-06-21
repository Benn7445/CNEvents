package me.quartz.cnevents.arena;

import org.bukkit.Location;

import java.util.List;
import java.util.UUID;

public class Arena {

    private final UUID uuid;
    private final List<Location> locations;

    public Arena(UUID uuid, List<Location> locations) {
        this.uuid = uuid;
        this.locations = locations;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void addLocations(Location location) {
        this.locations.add(location);
    }
}
