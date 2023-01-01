package io.github.sarahgreywolf.redsorcery.interfaces;

import java.util.List;

import org.bukkit.command.CommandSender;
import net.kyori.adventure.text.Component;

import io.github.sarahgreywolf.redsorcery.RedSorcery;

public interface ICommand {

    void execute(CommandSender commandSender, String[] args, Component permissionMessage);

    String help();

    String usage();

    String getName();

    String getPermission();

    default boolean isOpOverride() {
        return false;
    };

    default boolean isConsoleUsable() {
        return false;
    };

    List<String> tabComplete(CommandSender commandSender);
}
