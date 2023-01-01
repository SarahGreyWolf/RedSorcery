package io.github.sarahgreywolf.redsorcery;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandHandler
        implements CommandExecutor, TabCompleter {

    private static final RedSorcery plugin = RedSorcery.plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label,
            String[] originalArgs) {
        String commandName = originalArgs[0];
        String[] args = new String[originalArgs.length - 1];
        for (int i = 1; i < originalArgs.length; i++) {
            args[i - 1] = originalArgs[i];
        }
        if (commandName == null) {
            if (!sender.hasPermission("RedSorcery")) {
                sender.sendMessage(command.permissionMessage());
                return true;
            }
            StringBuilder sb = new StringBuilder();
            // 54 Characters
            if (sender.getName() == "CONSOLE")
                sb.append("\n");
            sb.append("\u00A76----------------------").append("RedSorcery").append("----------------------\n");
            sb.append("\u00A74Author: ").append("\u00A75SarahGreyWolf").append("\n");
            sb.append("\u00A74Version: ").append("\u00A75").append(plugin.getDescription().getVersion())
                    .append("\n");
            sb.append("\u00A76-----------------------------------------------------");
            sender.sendMessage(sb.toString());
            return true;
        }

        if (!plugin.getCommands().containsKey(commandName)) {
            sender.sendMessage(RedSorcery.pluginPrefix + "That command does not exist.");
            sender.sendMessage(RedSorcery.pluginPrefix + "Usage: /redsorcery help");
        }
        if (sender.hasPermission(plugin.getCommands().get(commandName).getPermission()))
            plugin.getCommands().get(commandName).execute(sender, args, command.permissionMessage());
        else
            sender.sendMessage(command.permissionMessage());

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        String currentCommand = strings[0];
        if (strings.length == 1) {
            List<String> commands = new ArrayList<>();
            for (String commandName : plugin.getCommands().keySet()) {
                commands.add(commandName);
            }
            return commands;
        } else {
            if (plugin.getCommands().containsKey(currentCommand)) {
                List<String> list = plugin.getCommands().get(currentCommand).tabComplete(commandSender);
                if (list != null) {
                    if (!list.isEmpty()) {
                        return list;
                    }
                }
            }
            return null;
        }
    }
}
