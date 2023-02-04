package dev.sarahgreywolf.redsorcery.interfaces;

import java.util.Collection;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import dev.sarahgreywolf.redsorcery.util.ShapePos;

public interface IRitual {

    String getName();

    Map<Character, Material> getShapeIngredients();

    // Has to be square
    char[][][] getShape();

    boolean execute(Player ritualActivator, Location pos, World world, Collection<Entity> entities);

    String getPermission();

    String help();

    // Find where the moss block is in the rituals shape
    default ShapePos findMossLocation() {
        char[][][] shape = this.getShape();
        ShapePos shapePos = null;
        search: for (int layer = 0; layer < shape.length; layer++) {
            for (int z = 0; z < shape[layer].length; z++) {
                for (int x = 0; x < shape[layer][z].length; x++) {
                    if (shape[layer][z][x] == 'X' && shape[layer + 1][z][x] == 'Y') {
                        shapePos = new ShapePos(x, z, layer);
                        break search;
                    }
                }
            }
        }
        return shapePos;
    }

}
