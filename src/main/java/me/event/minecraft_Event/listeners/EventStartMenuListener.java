package me.event.minecraft_Event.listeners;

import me.event.minecraft_Event.menu.EventMainMenu;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static me.event.minecraft_Event.utils.Utils.color;

public class EventStartMenuListener implements Listener {
    // Хэш-таблица со значением Игрок-Слот для сохранения результата выбранной лошади
    private static Map<Player, Integer> selectedHorse = new HashMap<>();

    // Геттер для запоминания выбора игрока (понадобится в EventMainMenuListener для определения, выиграл игрок или нет)
    public static Map<Player, Integer> getSelectedHorse() {
        return selectedHorse;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(color("&2&lКонные скачки"))) {
            // Здесь сразу отменяется действие (P.s Никита: должно ли это реализовываться таким образом, или сделать так, чтобы предметы нельзя было забрать, можно иначе?")
            event.setCancelled(true);

            // Слоты всех кнопок для выполнения тех или иных действий
            List<Integer> horses = Arrays.asList(3, 12, 21, 30);
            Integer next_button = 14;
            Integer exit_button = 23;

            int slot = event.getRawSlot();
            Player player = (Player) event.getWhoClicked();

            // Действия в случае, если выбрана была одна из лошадей
            if (horses.contains(slot)) {
                Integer previousSlot = selectedHorse.put(player, slot);

                if (previousSlot != null) {
                    ItemStack previousItem = event.getInventory().getItem(previousSlot);
                    if (previousItem != null) {
                        previousItem.removeEnchantment(Enchantment.INFINITY);
                    }
                }
                ItemStack currentItem = event.getCurrentItem();
                currentItem.addUnsafeEnchantment(Enchantment.INFINITY, 1);

                player.updateInventory();
            } else if (slot == next_button) {
                player.closeInventory();
                EventMainMenu.openInventory(player);
            } else if (slot == exit_button) {
                player.closeInventory();
            }
        }
    }
}
