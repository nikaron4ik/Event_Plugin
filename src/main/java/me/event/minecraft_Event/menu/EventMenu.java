package me.event.minecraft_Event.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EventMenu {

    public static void MenuOfEvent(Player player) {
        Inventory menu = Bukkit.createInventory(null, 45, "Конные скачки");

        player.openInventory(menu);
    }

}
