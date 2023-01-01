package io.github.sarahgreywolf.redsorcery;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.sarahgreywolf.redsorcery.commands.HelpCommand;
import io.github.sarahgreywolf.redsorcery.interfaces.ICommand;
import io.github.sarahgreywolf.redsorcery.listeners.KillListener;
import net.kyori.adventure.text.Component;

public final class RedSorcery extends JavaPlugin {

    public static RedSorcery plugin;
    public static PluginManager pm;
    public static final String pluginPrefix = "\u00A75[RedSorcery]\u00A7r";

    private Map<String, ICommand> commands = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;
        pm = getServer().getPluginManager();
        pm.registerEvents(new KillListener(), this);
        CommandHandler RedSorceryCommand = new CommandHandler();
        PluginCommand command = this.getCommand("RedSorcery");
        command.setExecutor(RedSorceryCommand);
        command.setTabCompleter(RedSorceryCommand);
        command.permissionMessage(Component.text("\u00A74 You do not have permission to execute this command"));
        registerCommands();
        registerPermissions();
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

    private void registerCommands() {
        this.addCommand(new HelpCommand());
    }

    private void registerPermissions() {
        for (String command : this.getCommands().keySet()) {
            pm.addPermission(new Permission("redsorcery." + this.getCommands().get(command).getPermission()));
        }
        pm.addPermission(new Permission("redsorcery.*"));
        pm.addPermission(new Permission("redsorcery"));
    }

}
