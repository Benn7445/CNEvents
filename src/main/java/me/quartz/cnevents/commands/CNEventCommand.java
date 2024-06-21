package me.quartz.cnevents.commands;

import me.quartz.cnevents.CNEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CNEventCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length > 0) {
            if(strings[0].equalsIgnoreCase("join")) {
                if(commandSender instanceof Player) {
                    Player player = (Player) commandSender;
                    CNEvents.getInstance().getEventManager().getEvent().joinPlayer(player);
                } else commandSender.sendMessage(ChatColor.RED + "Only players can execute this command.");
            } else commandSender.sendMessage(ChatColor.RED + "Unknown Argument.");
        } else commandSender.sendMessage(ChatColor.RED + "Unknown Argument.");
        return true;
    }
}
