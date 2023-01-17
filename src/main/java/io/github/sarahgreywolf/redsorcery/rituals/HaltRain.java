package io.github.sarahgreywolf.redsorcery.rituals;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.sarahgreywolf.redsorcery.interfaces.IRitual;

public class HaltRain implements IRitual {

    @Override
    public String getName() {
        return "Halt Rain";
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
    public void execute(Player ritualActivator, World world, ItemStack[] stacks) {
        if (world.hasStorm())
            world.setWeatherDuration(1);
    }

    @Override
    public String getPermission() {
        return "haltrain";
    }

    @Override
    public String help() {
        return "Can be used to halt the rain";
    }

    @Override
    public ItemStack getActivationItem() {
        return new ItemStack(Material.DIAMOND);
    }

}
