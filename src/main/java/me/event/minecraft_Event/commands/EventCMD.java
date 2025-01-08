
package me.event.minecraft_Event.commands;

import me.event.minecraft_Event.Main;
import me.event.minecraft_Event.menu.EventStartMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EventCMD implements CommandExecutor {
    private final Main plugin;

    public EventCMD(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            EventStartMenu.MenuOfEvent(player);
            return true;
        } else {
            commandSender.sendMessage("Данная команда может быть отправлена только игроком.");
            return false;
        }
    }
}
