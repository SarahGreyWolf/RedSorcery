package dev.sarahgreywolf.redsorcery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.command.PluginCommand;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;

import dev.sarahgreywolf.redsorcery.commands.HelpCommand;
import dev.sarahgreywolf.redsorcery.interfaces.ICommand;
import dev.sarahgreywolf.redsorcery.interfaces.IRitual;
import dev.sarahgreywolf.redsorcery.listeners.KillListener;
import dev.sarahgreywolf.redsorcery.listeners.RitualListener;
import dev.sarahgreywolf.redsorcery.rituals.ModifyWeather;
import dev.sarahgreywolf.redsorcery.rituals.Enchant;
import dev.sarahgreywolf.redsorcery.rituals.KillServer;

public final class RedSorcery extends JavaPlugin {

    public static RedSorcery plugin;
    public static PluginManager pm;
    public static final String prefix = "\u00A75[RedSorcery]\u00A7r";

    private Map<String, ICommand> commands = new HashMap<>();
    private List<IRitual> rituals = new ArrayList<>();

    @Override
    public void onEnable() {
        plugin = this;
        pm = getServer().getPluginManager();
        pm.registerEvents(new KillListener(), this);
        pm.registerEvents(new RitualListener(), this);
        CommandHandler RedSorceryCommand = new CommandHandler();
        PluginCommand command = getCommand("redsorcery");
        command.setExecutor(RedSorceryCommand);
        command.setTabCompleter(RedSorceryCommand);
        command.permissionMessage(Component.text("\u00A74 You do not have permission to execute this command"));
        registerCommands();
        registerRituals();
        registerPermissions();
    }

    @Override
    public void onDisable() {
        commands.clear();
        rituals.clear();
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
        addCommand(new HelpCommand());
    }

    private void registerPermissions() {
        for (String command : getCommands().keySet()) {
            pm.addPermission(new Permission("redsorcery.commands." + getCommands().get(command).getPermission()));
        }
        pm.addPermission(new Permission("redsorcery.commands.*"));
        pm.addPermission(new Permission("redsorcery.rituals.*"));
        pm.addPermission(new Permission("redsorcery.*"));
        pm.addPermission(new Permission("redsorcery"));
        for (IRitual ritual : getRituals()) {
            pm.addPermission(new Permission("redsorcery.rituals." + ritual.getPermission()));
        }
        pm.addPermission(new Permission("redsorcery.rituals.killserver.head"));
    }

    public List<IRitual> getRituals() {
        return rituals;
    }

    public void addRitual(IRitual ritual) {
        rituals.add(ritual);
    }

    private void registerRituals() {
        addRitual(new ModifyWeather());
        addRitual(new KillServer());
        addRitual(new Enchant());
    }

}
