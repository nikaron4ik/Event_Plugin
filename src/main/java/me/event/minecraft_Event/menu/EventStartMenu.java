package me.event.minecraft_Event.menu;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static me.event.minecraft_Event.utils.Utils.color;

public class EventStartMenu {

    public static void MenuOfEvent(Player player) {
        // Создаёт меню в 4x9, в котором можно будет выбрать коня для ставки, а также начать игру
        Inventory menu = Bukkit.createInventory(null, 36, color("&2&lКонные скачки"));

        // Создание блоков для заполнения начального меню
        ItemStack start_star = new ItemStack(Material.NETHER_STAR);
        ItemStack close_barrier = new ItemStack(Material.BARRIER);
        ItemStack magenta_glass = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE);
        ItemStack yellow_glass = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);

        // Создание каждой лошади и покраска её в нужный цвет
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


        // Списки для хранения слотов, в которых должны помещаться нужные нам блоки (жёлтое и фиолетовое стекло)
        // (P.s. Никита: решил поэкспериментировать, забавно, что получилось. Есть ли какой-то более эффективный способ заполнения инвентарей?)
        Integer[] magenta_glass_slots = {0, 1, 7, 8, 9, 10, 16, 17, 18, 19, 25, 26, 27, 28, 34, 35};
        Integer[] yellow_glass_slots = {2, 6, 11, 15, 20, 24, 29, 33};

        // Заполняем соответствующие слоты нужными нам блоками
        for (int slot: magenta_glass_slots) {
            menu.setItem(slot, magenta_glass);
        }

        for (int slot: yellow_glass_slots) {
            menu.setItem(slot, yellow_glass);
        }

        menu.setItem(3, red_horse);
        menu.setItem(12, yellow_horse);
        menu.setItem(21, blue_horse);
        menu.setItem(30, green_horse);

        menu.setItem(14, start_star);
        menu.setItem(23, close_barrier);















        player.openInventory(menu);
    }

}
