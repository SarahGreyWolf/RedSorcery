package io.github.sarahgreywolf.redsorcery.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.kyori.adventure.text.Component;

import io.github.sarahgreywolf.redsorcery.interfaces.ICommand;
import io.github.sarahgreywolf.redsorcery.RedSorcery;

public class HelpCommand implements ICommand {
    private String commandHead = "redsorcery";
    private static final RedSorcery plugin = RedSorcery.plugin;

    @Override
    public void execute(CommandSender commandSender, String[] args, Component permissionMessage) {
        Player player = null;
        if (commandSender instanceof Player) {
            player = (Player) commandSender;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\u00A76-------------------").append("RedSorcery Help").append("--------------------\n");

        for (String command : plugin.getCommands().keySet()) {
            if (command.equalsIgnoreCase("help"))
                continue;
            if (plugin.getCommands().get(command).help() != null)
                continue;
            if (player != null) {
                sb.append("\u00A7d").append(plugin.getCommands().get(command).help()).append("\n");
                sb.append("    ").append("\u00A73").append("Usage: ").append("\u00A79")
                        .append(plugin.getCommands().get(command).usage()).append("\n");
            } else if (plugin.getCommands().get(command).isConsoleUsable()) {
                sb.append("\u00A7d").append(plugin.getCommands().get(command).help()).append("\n");
                sb.append("    ").append("\u00A73").append("Usage: ").append("\u00A79")
                        .append(plugin.getCommands().get(command).usage()).append("\n");
            }
        }
        sb.append("\u00A76-----------------------------------------------------");
        commandSender.sendMessage(sb.toString());

    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String usage() {
        return null;
    }

    @Override
    public String getPermission() {
        return "help";
    }

    @Override
    public boolean isOpOverride() {
        return false;
    }

    @Override
    public boolean isConsoleUsable() {
        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender commandSender) {
        return null;
    }

    @Override
    public String getName() {
        return "help";
    }

}
