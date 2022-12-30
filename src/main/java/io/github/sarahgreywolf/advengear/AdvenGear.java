package io.github.sarahgreywolf.advengear;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.sarahgreywolf.advengear.commands.HelpCommand;
import io.github.sarahgreywolf.advengear.interfaces.ICommand;
import io.github.sarahgreywolf.advengear.listeners.KillListener;
import net.kyori.adventure.text.Component;

public final class AdvenGear extends JavaPlugin {

    public static AdvenGear plugin;
    public static PluginManager pm;
    public static String pluginPrefix = "\u00A75[AdvenGear]\u00A7r";

    private Map<String, ICommand> commands = new HashMap<>();

    private Permissions permissions;

    @Override
    public void onEnable() {
        plugin = this;
        pm = getServer().getPluginManager();
        pm.registerEvents(new KillListener(), this);
        CommandHandler advenGearCommand = new CommandHandler();
        PluginCommand command = this.getCommand("advengear");
        command.setExecutor(advenGearCommand);
        command.setTabCompleter(advenGearCommand);
        command.permissionMessage(Component.text("\u00A74 You do not have permission to execute this command"));
        registerCommands();
        permissions = new Permissions();
    }

    @Override
    public void onDisable() {
        commands.clear();
        pm = null;
        plugin = null;
    }

    public Map<String, ICommand> getCommands() {
        return commands;
    }

    public void addCommand(ICommand command) {
        commands.put(command.getName(), command);
    }

    public void registerCommands() {
        this.addCommand(new HelpCommand());
    }

    public Permissions getPermissions() {
        return permissions;
    }

}
