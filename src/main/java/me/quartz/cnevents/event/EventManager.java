package me.quartz.cnevents.event;

import me.quartz.cnevents.CNEvents;
import me.quartz.cnevents.event.events.*;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.*;

public class EventManager {

    private Event event;

    public EventManager() {
        this.event = null;
        CNEvents.getInstance().getConfig().getStringList("schedule").forEach(this::runScheduled);
        runEvent();
    }

    public void runScheduled(String time) {
        Timer timer = new Timer();

        TimerTask dailyTask = new TimerTask() {
            @Override
            public void run() {
                runEvent();
            }
        };

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.split(":")[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
        calendar.set(Calendar.SECOND, 0);

        Date scheduledTime = calendar.getTime();
        if (scheduledTime.before(new Date())) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            scheduledTime = calendar.getTime();
        }

        long period = 24 * 60 * 60 * 1000;
        timer.scheduleAtFixedRate(dailyTask, scheduledTime, period);
    }

    public boolean runEvent() {
        if(event == null) {
            //int choice = new Random().nextInt(9);
            //
            //switch (choice) {
            //    case 0:
            //        runEvent(new BattleRoyal());
            //    case 1:
            //        runEvent(new BedWars());
            //    case 2:
            //        runEvent(new KitPvP());
            //    case 3:
            //        runEvent(new OITC());
            //    case 4:
            //        runEvent(new SkyWars());
            //    case 5:
            //        runEvent(new Sumo());
            //    case 6:
            //        runEvent(new SumoFFA());
            //    case 7:
            //        runEvent(new WoolWars());
            //}

            runEvent(new BattleRoyal());
            return true;
        } else return false;
    }

    public boolean runEvent(Event event) {
        if(this.event == null) {
            this.event = event;
            CNEvents.getInstance().getConfig().getStringList("messages.event-announce").forEach(s -> {
                Bukkit.getOnlinePlayers().forEach(player ->
                        {
                            TextComponent textComponent = new TextComponent(ChatColor.translateAlternateColorCodes('&',
                                    s
                                            .replace("%event%", event.getEventType().getCustomFile().getCustomConfig().getString("general.name"))
                                            .replace("%available%", event.getEventType().getCustomFile().getCustomConfig().getString("general.max-players"))
                            ));

                            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.translateAlternateColorCodes('&',
                                    CNEvents.getInstance().getConfig().getString("messages.event-announce-hover")))));
                            textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/cnevent join"));

                            player.spigot().sendMessage(textComponent);
                        }
                );
            });
            return true;
        }
        else return false;
    }

    public Event getEvent() {
        return event;
    }
}
