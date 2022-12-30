package io.github.sarahgreywolf.advengear;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

public class Permissions {
    private AdvenGear plugin = AdvenGear.plugin;

    public Permissions() {
        for (String command : plugin.getCommands().keySet()) {
            AdvenGear.pm
                    .addPermission(new Permission("advengear." + plugin.getCommands().get(command).getPermission()));
        }
        AdvenGear.pm
                .addPermission(new Permission("advengear.*"));
        AdvenGear.pm
                .addPermission(new Permission("advengear"));
    }
}
