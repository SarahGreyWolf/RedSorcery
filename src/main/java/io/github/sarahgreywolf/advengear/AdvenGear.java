package io.github.sarahgreywolf.advengear;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.sarahgreywolf.advengear.listeners.KillListener;

public final class AdvenGear extends JavaPlugin {

    public static AdvenGear plugin;

    @Override
    public void onEnable() {
        plugin = this;
        PluginManager manager = getServer().getPluginManager();
    }

}
