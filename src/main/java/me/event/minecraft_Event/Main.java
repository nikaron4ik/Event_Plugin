package me.event.minecraft_Event;

import me.event.minecraft_Event.commands.EventCMD;
import me.event.minecraft_Event.listeners.EventMainMenuListener;
import me.event.minecraft_Event.listeners.EventStartMenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public Main() {
    }

    public void onEnable() {
        this.getCommand("event_start").setExecutor(new EventCMD(this));
        this.getServer().getPluginManager().registerEvents(new EventStartMenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new EventMainMenuListener(), this);
    }

    public void onDisable() {
    }
}
