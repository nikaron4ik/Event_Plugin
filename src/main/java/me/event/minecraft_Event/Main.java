package me.event.minecraft_Event;

import me.event.minecraft_Event.commands.EventCMD;
import me.event.minecraft_Event.listeners.EventStartMenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("event_start").setExecutor(new EventCMD(this));

        getServer().getPluginManager().registerEvents(new EventStartMenuListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
