package me.event.minecraft_Event.utils;

import org.bukkit.ChatColor;

public class Utils {
    public Utils() {
    }

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
