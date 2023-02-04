package dev.sarahgreywolf.redsorcery.rituals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import net.kyori.adventure.text.Component;

import dev.sarahgreywolf.redsorcery.RedSorcery;
import dev.sarahgreywolf.redsorcery.interfaces.IRitual;

public class KillServer implements IRitual {

    public final RedSorcery plugin = RedSorcery.plugin;

    @Override
    public String getName() {
        return "Kill Server";
    }

    @Override
    public Map<Character, Material> getShapeIngredients() {
        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('A', Material.AIR);
        ingredients.put('C', Material.NETHERITE_BLOCK);
        ingredients.put('B', Material.ANCIENT_DEBRIS);
        ingredients.put('R', Material.DIAMOND_BLOCK);

        return ingredients;
    }

    @Override
    public char[][][] getShape() {
        char[][][] shape = {
                // First Layer (say ground level)
                {
                        // Z from top to bottom
                        { ' ', 'C', 'C', 'C', 'C', 'C', ' ', },
                        { 'C', ' ', ' ', 'R', ' ', ' ', 'C', },
                        { 'C', ' ', 'R', 'R', 'R', ' ', 'C', },
                        { 'C', ' ', ' ', 'X', ' ', ' ', 'C', },
                        { 'C', ' ', ' ', 'R', ' ', ' ', 'C', },
                        { 'C', ' ', ' ', 'R', ' ', ' ', 'C', },
                        { ' ', 'C', 'C', 'C', 'C', 'C', ' ', }
                },
                // Second Layer (1 block above last)
                {
                        { ' ', 'R', 'R', 'R', 'R', 'R', ' ' },
                        { 'R', ' ', 'B', 'A', 'B', ' ', 'R' },
                        { 'R', ' ', 'A', 'A', 'A', ' ', 'R' },
                        { 'R', ' ', 'B', 'Y', 'B', ' ', 'R' },
                        { 'R', ' ', 'B', 'A', 'B', ' ', 'R' },
                        { 'R', ' ', 'B', 'A', 'B', ' ', 'R' },
                        { ' ', 'R', 'R', 'R', 'R', 'R', ' ' }
                }
        };
        return shape;
    }

    @Override
    public boolean execute(Player ritualActivator, Location pos, World world, Collection<Entity> entities) {
        Item headItem = null;
        ItemStack head = null;
        for (Entity entity : entities) {
            if (entity.getType() != EntityType.DROPPED_ITEM)
                continue;
            headItem = (Item) entity;
            if (headItem.getItemStack().getType() != Material.PLAYER_HEAD)
                continue;
            head = headItem.getItemStack();
        }
        if (headItem == null || head == null) {
            ritualActivator.sendMessage(Component.text(RedSorcery.prefix + " No player head was found"));
            return false;
        }
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        // The permission required by the owner of the head in order for this ritual to
        // work
        OfflinePlayer player = meta.getOwningPlayer();
        if (player == null || player.getPlayer() == null) {
            ritualActivator
                    .sendMessage(Component.text(RedSorcery.prefix + " The owner of the head does not have permission"));
            return false;
        }
        if (player.getPlayer().hasPermission("redsorcery.rituals.killserver.head")) {
            headItem.remove();
            RedSorcery.plugin.getServer().savePlayers();
            for (World world_s : RedSorcery.plugin.getServer().getWorlds()) {
                world_s.save();
            }
            RedSorcery.plugin.getServer().shutdown();
        } else
            ritualActivator
                    .sendMessage(Component.text(RedSorcery.prefix + " The owner of the head does not have permission"));
        return true;
    }

    @Override
    public String getPermission() {
        return "killserver";
    }

    @Override
    public String help() {
        return "Kills the server";
    }

}
