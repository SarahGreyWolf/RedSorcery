package io.github.sarahgreywolf.redsorcery.rituals;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;

import io.github.sarahgreywolf.redsorcery.interfaces.IRitual;

public class HaltRain implements IRitual {

    @Override
    public String getName() {
        return "Halt Rain";
    }

    @Override
    public Map<Character, Material> getShapeIngredients() {
        Map<Character, Material> ingredients = new HashMap<>();
        // by Default ANYTHING marked as the character Z can be any Material
        // Additionally anything marked with an X is a moss block, this should be where
        // you want your tree to be positioned
        // and Y is always where the sapling will go (above the moss block)
        ingredients.put('A', Material.AIR);
        ingredients.put('C', Material.STONE_BRICKS);
        ingredients.put('R', Material.REDSTONE);

        return ingredients;
    }

    @Override
    public char[][][] getShape() {
        char[][][] shape = {
                // First Layer (say ground level)
                {
                        // Z from top to bottom
                        { 'Z', 'C', 'C', 'C', 'Z' },
                        { 'C', 'C', 'Z', 'C', 'C' },
                        { 'C', 'Z', 'X', 'Z', 'C' },
                        { 'C', 'C', 'Z', 'C', 'C' },
                        { 'Z', 'C', 'C', 'C', 'Z' }
                },
                // Second Layer (1 block above last)
                {
                        { 'Z', 'R', 'R', 'R', 'Z' },
                        { 'R', 'R', 'A', 'R', 'R' },
                        { 'R', 'A', 'Y', 'A', 'R' },
                        { 'R', 'R', 'A', 'R', 'R' },
                        { 'Z', 'R', 'R', 'R', 'Z' }
                }
        };
        return shape;
    }

    @Override
    public void execute(Player ritualActivator, World world, Object[] args, Component permissionMessage) {
        world.setWeatherDuration(0);
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
    public Material getActivationItem() {
        return Material.DIAMOND;
    }

}
