package me.event.minecraft_Event.commands;

import me.event.minecraft_Event.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.event.minecraft_Event.menu.EventMenu;

public class EventCMD implements CommandExecutor {

    private final Main plugin;

    public EventCMD(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            EventMenu.MenuOfEvent(player);
            return true;
        } else {
            commandSender.sendMessage("Данная команда может быть отправлена только игроком.");
            return false;
        }
    }
}