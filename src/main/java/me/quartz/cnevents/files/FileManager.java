package me.quartz.cnevents.files;

import me.quartz.cnevents.CNEvents;

public class FileManager {

    private final CustomFile battleRoyal;
    private final CustomFile bedWars;
    private final CustomFile kitPvP;
    private final CustomFile oitc;
    private final CustomFile skyWars;
    private final CustomFile sumo;
    private final CustomFile sumoFFA;
    private final CustomFile woolWars;

    public FileManager() {
        CNEvents.getInstance().saveDefaultConfig();
        this.battleRoyal = new CustomFile("events/battleroyal");
        this.bedWars = new CustomFile("events/bedwars");
        this.kitPvP = new CustomFile("events/kitpvp");
        this.oitc = new CustomFile("events/oitc");
        this.skyWars = new CustomFile("events/skywars");
        this.sumo = new CustomFile("events/sumo");
        this.sumoFFA = new CustomFile("events/sumoffa");
        this.woolWars = new CustomFile("events/woolwars");
    }

    public CustomFile getBattleRoyal() {
        return battleRoyal;
    }

    public CustomFile getBedWars() {
        return bedWars;
    }

    public CustomFile getKitPvP() {
        return kitPvP;
    }

    public CustomFile getOitc() {
        return oitc;
    }

    public CustomFile getSkyWars() {
        return skyWars;
    }

    public CustomFile getSumo() {
        return sumo;
    }

    public CustomFile getSumoFFA() {
        return sumoFFA;
    }

    public CustomFile getWoolWars() {
        return woolWars;
    }
}
