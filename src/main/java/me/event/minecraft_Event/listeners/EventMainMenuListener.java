package me.event.minecraft_Event.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static me.event.minecraft_Event.utils.Utils.color;

public class EventMainMenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§4§lКонные Скачки")) {
            event.setCancelled(true);

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.getType() == Material.NETHER_STAR) {
                moveItems(event.getInventory(), (Player) event.getWhoClicked());
            }
        }
    }

    private void moveItems(Inventory inventory, Player player) {
        Random random = new Random();
        int[] positionOfHorses = {0, 9, 18, 27};
        ItemStack[] horses = {
                inventory.getItem(0),
                inventory.getItem(9),
                inventory.getItem(18),
                inventory.getItem(27)
        };
        int winHorse = random.nextInt(positionOfHorses.length);
        int slotEnd = 8;

        // Создаём хеш-таблицу для размещения лошадей (совмещение слотов из EventStartMenuListener и EventMainMenuListener)
        Map<Integer, Integer> startAndMainSlots = new HashMap<>();
        startAndMainSlots.put(3, 0);
        startAndMainSlots.put(12, 9);
        startAndMainSlots.put(21, 18);
        startAndMainSlots.put(30, 27);


        new BukkitRunnable() {
            @Override
            public void run() {
                boolean isRaceFinished = false;

                for (int i = 0; i < positionOfHorses.length; i++) {
                    if (positionOfHorses[i] % 9 == slotEnd) {
                        continue;
                    }
                    inventory.setItem(positionOfHorses[i], new ItemStack(Material.AIR));

                    if (i == winHorse) {
                        positionOfHorses[i]++;
                    } else {
                        positionOfHorses[i] += random.nextInt(2);
                    }

                    if (positionOfHorses[i] % 9 == slotEnd) {
                        isRaceFinished = true;
                        switch (i) {
                            case 0:
                                player.sendMessage(color("&l&fВыиграла &4Красная &fлошадь"));
                                break;
                            case 1:
                                player.sendMessage(color("&l&fВыиграла &eЖёлтая &fлошадь"));
                                break;
                            case 2:
                                player.sendMessage(color("&l&fВыиграла &9Синяя &fлошадь"));
                                break;
                            case 3:
                                player.sendMessage(color("&l&fВыиграла &aЗелёная &fлошадь"));
                                break;
                        }

                        this.cancel();
                    }
                    inventory.setItem(positionOfHorses[i], horses[i]);
                }
                player.updateInventory();

                if (isRaceFinished) {
                    this.cancel();
                    Bukkit.getScheduler().runTaskLater(JavaPlugin.getProvidingPlugin(this.getClass()), () -> {
                        player.closeInventory();
                    }
                     , 60);
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(this.getClass()), 0L, 10L);
    }
}
