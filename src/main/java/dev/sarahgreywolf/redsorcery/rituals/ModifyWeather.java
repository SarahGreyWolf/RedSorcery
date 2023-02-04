package dev.sarahgreywolf.redsorcery.rituals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import dev.sarahgreywolf.redsorcery.interfaces.IRitual;

public class ModifyWeather implements IRitual {

    @Override
    public String getName() {
        return "Modify Weather";
    }

    @Override
    public Map<Character, Material> getShapeIngredients() {
        Map<Character, Material> ingredients = new HashMap<>();
        // by Default ANYTHING marked as the character ' ' can be any Material
        // Additionally anything marked with an X is a moss block, this should be where
        // you want your tree to be positioned
        // and Y is always where the sapling will go (above the moss block)
        ingredients.put('A', Material.AIR);
        ingredients.put('C', Material.STONE_BRICKS);
        ingredients.put('R', Material.REDSTONE_WIRE);

        return ingredients;
    }

    @Override
    public char[][][] getShape() {
        char[][][] shape = {
                // First Layer (say ground level)
                {
                        // Z from top to bottom
                        { ' ', 'C', 'C', 'C', ' ' },
                        { 'C', 'C', ' ', 'C', 'C' },
                        { 'C', ' ', 'X', ' ', 'C' },
                        { 'C', 'C', ' ', 'C', 'C' },
                        { ' ', 'C', 'C', 'C', ' ' }
                },
                // Second Layer (1 block above last)
                {
                        { ' ', 'R', 'R', 'R', ' ' },
                        { 'R', 'R', 'A', 'R', 'R' },
                        { 'R', 'A', 'Y', 'A', 'R' },
                        { 'R', 'R', 'A', 'R', 'R' },
                        { ' ', 'R', 'R', 'R', ' ' }
                }
        };
        return shape;
    }

    @Override
    public boolean execute(Player ritualActivator, Location pos, World world, Collection<Entity> entities) {
        for (Entity entity : entities) {
            if (entity.getType() != EntityType.DROPPED_ITEM)
                continue;
            Item item = (Item) entity;
            if (item.getItemStack().getType() == Material.WATER_BUCKET && !world.hasStorm()) {
                world.setStorm(true);
                world.setThundering(false);
                item.setItemStack(new ItemStack(Material.BUCKET));
                return false;
            }
        }
        if (world.hasStorm())
            world.setWeatherDuration(1);

        return true;
    }

    @Override
    public String getPermission() {
        return "modweather";
    }

    @Override
    public String help() {
        return "Can be used to halt or start the rain";
    }

}
