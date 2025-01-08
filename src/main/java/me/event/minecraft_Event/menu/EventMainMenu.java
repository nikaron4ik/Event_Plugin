package me.event.minecraft_Event.menu;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class EventMainMenu {

    private static Inventory createInventory() {
        Inventory inventory = Bukkit.createInventory(null, 54, "§4§lКонные Скачки");

        ItemStack red_horse = new ItemStack(Material.LEATHER_HORSE_ARMOR);
        LeatherArmorMeta red_horse_meta = (LeatherArmorMeta) red_horse.getItemMeta();
        red_horse_meta.setColor(Color.fromRGB(176, 46, 38));
        red_horse.setItemMeta(red_horse_meta);

        ItemStack yellow_horse = new ItemStack(Material.LEATHER_HORSE_ARMOR);
        LeatherArmorMeta yellow_horse_meta = (LeatherArmorMeta) yellow_horse.getItemMeta();
        yellow_horse_meta.setColor(Color.fromRGB(254, 216, 61));
        yellow_horse.setItemMeta(yellow_horse_meta);

        ItemStack blue_horse = new ItemStack(Material.LEATHER_HORSE_ARMOR);
        LeatherArmorMeta blue_horse_meta = (LeatherArmorMeta) blue_horse.getItemMeta();
        blue_horse_meta.setColor(Color.fromRGB(60, 68, 170));
        blue_horse.setItemMeta(blue_horse_meta);

        ItemStack green_horse = new ItemStack(Material.LEATHER_HORSE_ARMOR);
        LeatherArmorMeta green_horse_meta = (LeatherArmorMeta) green_horse.getItemMeta();
        green_horse_meta.setColor(Color.fromRGB(94, 124, 22));
        green_horse.setItemMeta(green_horse_meta);

        inventory.setItem(0, red_horse);
        inventory.setItem(9, yellow_horse);
        inventory.setItem(18, blue_horse);
        inventory.setItem(27, green_horse);

        ItemStack enderStar = new ItemStack(Material.NETHER_STAR);
        inventory.setItem(40, enderStar);
        fillSpecificSlots(inventory);

        return inventory;
    }

    public static void openInventory(Player player) {
        Inventory inventory = createInventory();
        player.openInventory(inventory);
    }

    private static void fillSpecificSlots(Inventory inventory) {
        ItemStack itemToFill = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        int[] excludedSlots = {40};
        for (int i = 36; i <= 53; i++) {
            boolean shouldSkip = false;
            for (int excludedSlot : excludedSlots) {
                if (i == excludedSlot) {
                    shouldSkip = true;
                    break;
                }
            }
            if (!shouldSkip) {
                inventory.setItem(i, itemToFill);
            }
        }
    }
}
