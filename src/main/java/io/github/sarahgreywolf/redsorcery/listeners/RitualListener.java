package io.github.sarahgreywolf.redsorcery.listeners;

import java.util.Collection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Sapling;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import io.github.sarahgreywolf.redsorcery.RedSorcery;
import io.github.sarahgreywolf.redsorcery.interfaces.IRitual;
import io.github.sarahgreywolf.redsorcery.util.ShapePos;

public class RitualListener implements Listener {

    private static final RedSorcery plugin = RedSorcery.plugin;

    @EventHandler(priority = EventPriority.MONITOR)
    public void onTreeGrow(StructureGrowEvent evt) {
        Player activator = evt.getPlayer();
        Block block = evt.getBlocks().get(0).getBlock();
        // Check if the block beneath the sapling is a Moss Block
        Block moss = block.getRelative(0, -1, 0);
        if (moss.getType() != Material.MOSS_BLOCK)
            return;
        // Make sure it was a sapling that grew
        if (!(block.getBlockData() instanceof Sapling))
            return;

        // Try to find the correct ritual
        ritual: for (IRitual ritual : plugin.getRituals()) {
            // No point checking for that ritual if they don't have permission to use it
            // anyway, this may get moved so we can give permission errors
            if (!activator.hasPermission("redsorcery.rituals." + ritual.getPermission()))
                continue;

            char[][][] shape = ritual.getShape();
            ShapePos shapePos = ritual.findMossLocation();
            if (shapePos == null)
                continue;

            // Check if the blocks on the x and z axis with the moss block align
            // (Quick exit to avoid checking the whole ritual if these parts aren't correct)
            int lineLengthX = shape[shapePos.getLayer()][shapePos.getZ()].length;
            for (int x = 0 - (lineLengthX / 2); x < (lineLengthX / 2) + 1; x++) {
                char letter = shape[shapePos.getLayer()][shapePos.getZ()][x + (lineLengthX / 2)];
                if (letter == ' ' || x == 0)
                    continue;
                Material mat = ritual.getShapeIngredients()
                        .get(letter);
                if (moss.getRelative(x, 0, 0).getType() != mat)
                    continue ritual;
            }
            int lineLengthZ = shape[shapePos.getLayer()].length;
            for (int z = 0 - (lineLengthZ / 2); z < (lineLengthZ / 2) + 1; z++) {
                char letter = shape[shapePos.getLayer()][z + (lineLengthZ / 2)][shapePos.getX()];
                if (letter == ' ' || z == 0)
                    continue;
                Material mat = ritual.getShapeIngredients()
                        .get(letter);
                if (moss.getRelative(0, 0, z).getType() != mat)
                    continue ritual;
            }
            int bottomLayerRelative = -shapePos.getLayer();
            for (int layer = 0; layer < shape.length; layer++) {
                for (int x = 0 - (lineLengthX / 2); x < (lineLengthX / 2) + 1; x++) {
                    for (int z = 0 - (lineLengthZ / 2); z < (lineLengthZ / 2) + 1; z++) {
                        char letter = shape[layer][z + (lineLengthZ / 2)][x + (lineLengthX / 2)];
                        if (letter == ' '
                                || (x + (lineLengthX / 2) == shapePos.getX() && z + (lineLengthZ / 2) == shapePos.getZ()
                                        && layer >= shapePos.getLayer()))
                            continue;
                        Material mat = ritual.getShapeIngredients()
                                .get(letter);
                        if (moss.getRelative(x, layer + bottomLayerRelative, z).getType() != mat)
                            continue ritual;
                    }
                }
            }

            Collection<Entity> entities = evt.getLocation().getNearbyEntities((lineLengthX / 2) + 1,
                    (shape.length / 2) + 1,
                    (lineLengthZ / 2) + 1);

            ritual.execute(activator, evt.getWorld(), entities);
        }
    }

}