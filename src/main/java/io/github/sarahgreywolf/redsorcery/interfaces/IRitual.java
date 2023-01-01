package io.github.sarahgreywolf.redsorcery.interfaces;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import io.github.sarahgreywolf.redsorcery.util.ShapePos;
import net.kyori.adventure.text.Component;

public interface IRitual {

    String getName();

    Map<Character, Material> getShapeIngredients();

    Material getActivationItem();

    char[][][] getShape();

    void execute(Player ritualActivator, World world, Object[] args, Component permissionMessage);

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
