package me.quartz.cnevents.event;

import me.quartz.cnevents.CNEvents;
import me.quartz.cnevents.files.CustomFile;

public enum EventType {

    BATTLEROYAL(CNEvents.getInstance().getFileManager().getBattleRoyal()),
    BEDWARS(CNEvents.getInstance().getFileManager().getBedWars()),
    KITPVP(CNEvents.getInstance().getFileManager().getKitPvP()),
    OITC(CNEvents.getInstance().getFileManager().getOitc()),
    SKYWARS(CNEvents.getInstance().getFileManager().getSkyWars()),
    SUMO(CNEvents.getInstance().getFileManager().getSumo()),
    SUMOFFA(CNEvents.getInstance().getFileManager().getSumoFFA()),
    WOOLWARS(CNEvents.getInstance().getFileManager().getWoolWars()),;

    private final CustomFile customFile;

    EventType(CustomFile customFile) {
        this.customFile = customFile;
    }

    public CustomFile getCustomFile() {
        return customFile;
    }

}
