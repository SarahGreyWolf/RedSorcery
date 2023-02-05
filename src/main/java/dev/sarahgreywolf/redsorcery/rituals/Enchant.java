package dev.sarahgreywolf.redsorcery.rituals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.enchantments.Enchantment;
import net.kyori.adventure.text.Component;

import dev.sarahgreywolf.redsorcery.RedSorcery;
import dev.sarahgreywolf.redsorcery.interfaces.IRitual;
import dev.sarahgreywolf.redsorcery.util.ShapePos;

public class Enchant implements IRitual {

    private final List<Material> ENCHANTABLE_ITEMS = new ArrayList<Material>(Arrays.asList(
            Material.WOODEN_SWORD,
            Material.STONE_SWORD,
            Material.IRON_SWORD,
            Material.GOLDEN_SWORD,
            Material.DIAMOND_SWORD,
            Material.NETHERITE_SWORD,
            Material.WOODEN_AXE,
            Material.STONE_AXE,
            Material.IRON_AXE,
            Material.GOLDEN_AXE,
            Material.DIAMOND_AXE,
            Material.NETHERITE_AXE,
            Material.WOODEN_PICKAXE,
            Material.STONE_PICKAXE,
            Material.IRON_PICKAXE,
            Material.GOLDEN_PICKAXE,
            Material.DIAMOND_PICKAXE,
            Material.NETHERITE_PICKAXE,
            Material.WOODEN_SHOVEL,
            Material.STONE_SHOVEL,
            Material.IRON_SHOVEL,
            Material.GOLDEN_SHOVEL,
            Material.DIAMOND_SHOVEL,
            Material.NETHERITE_SHOVEL,
            Material.WOODEN_HOE,
            Material.STONE_HOE,
            Material.IRON_HOE,
            Material.GOLDEN_HOE,
            Material.DIAMOND_HOE,
            Material.NETHERITE_HOE,
            Material.IRON_HELMET,
            Material.GOLDEN_HELMET,
            Material.DIAMOND_HELMET,
            Material.NETHERITE_HELMET,
            Material.IRON_CHESTPLATE,
            Material.GOLDEN_CHESTPLATE,
            Material.DIAMOND_CHESTPLATE,
            Material.NETHERITE_CHESTPLATE,
            Material.IRON_LEGGINGS,
            Material.GOLDEN_LEGGINGS,
            Material.DIAMOND_LEGGINGS,
            Material.NETHERITE_LEGGINGS,
            Material.IRON_BOOTS,
            Material.GOLDEN_BOOTS,
            Material.DIAMOND_BOOTS,
            Material.NETHERITE_BOOTS,
            Material.TURTLE_HELMET,
            Material.BOW,
            Material.CROSSBOW,
            Material.TRIDENT,
            Material.FISHING_ROD,
            Material.SHEARS,
            Material.SHIELD,
            Material.ELYTRA,
            Material.FLINT_AND_STEEL,
            Material.CARROT_ON_A_STICK,
            Material.WARPED_FUNGUS_ON_A_STICK));

    private final Map<Enchantment, Integer> MULTIPLIERS = Map.ofEntries(
            Map.entry(Enchantment.PROTECTION_ENVIRONMENTAL, 1),
            Map.entry(Enchantment.PROTECTION_FIRE, 1),
            Map.entry(Enchantment.PROTECTION_FALL, 1),
            Map.entry(Enchantment.PROTECTION_EXPLOSIONS, 2),
            Map.entry(Enchantment.PROTECTION_PROJECTILE, 1),
            Map.entry(Enchantment.THORNS, 4),
            Map.entry(Enchantment.OXYGEN, 2),
            Map.entry(Enchantment.DEPTH_STRIDER, 2),
            Map.entry(Enchantment.WATER_WORKER, 2),
            Map.entry(Enchantment.DAMAGE_ALL, 1),
            Map.entry(Enchantment.DAMAGE_UNDEAD, 1),
            Map.entry(Enchantment.DAMAGE_ARTHROPODS, 1),
            Map.entry(Enchantment.KNOCKBACK, 1),
            Map.entry(Enchantment.FIRE_ASPECT, 2),
            Map.entry(Enchantment.LOOT_BONUS_MOBS, 2),
            Map.entry(Enchantment.DIG_SPEED, 1),
            Map.entry(Enchantment.SILK_TOUCH, 4),
            Map.entry(Enchantment.DURABILITY, 1),
            Map.entry(Enchantment.LOOT_BONUS_BLOCKS, 2),
            Map.entry(Enchantment.ARROW_DAMAGE, 1),
            Map.entry(Enchantment.ARROW_KNOCKBACK, 2),
            Map.entry(Enchantment.ARROW_FIRE, 2),
            Map.entry(Enchantment.ARROW_INFINITE, 4),
            Map.entry(Enchantment.LUCK, 2),
            Map.entry(Enchantment.LURE, 2),
            Map.entry(Enchantment.FROST_WALKER, 2),
            Map.entry(Enchantment.MENDING, 2),
            Map.entry(Enchantment.BINDING_CURSE, 4),
            Map.entry(Enchantment.VANISHING_CURSE, 4),
            Map.entry(Enchantment.IMPALING, 2),
            Map.entry(Enchantment.RIPTIDE, 2),
            Map.entry(Enchantment.LOYALTY, 1),
            Map.entry(Enchantment.CHANNELING, 4),
            Map.entry(Enchantment.MULTISHOT, 2),
            Map.entry(Enchantment.PIERCING, 1),
            Map.entry(Enchantment.QUICK_CHARGE, 1),
            Map.entry(Enchantment.SOUL_SPEED, 4),
            Map.entry(Enchantment.SWIFT_SNEAK, 4),
            Map.entry(Enchantment.SWEEPING_EDGE, 2));

    @Override
    public String getName() {
        return "Enchant";
    }

    @Override
    public Map<Character, Material> getShapeIngredients() {
        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('S', Material.STONE_BRICKS);
        ingredients.put('P', Material.QUARTZ_PILLAR);
        ingredients.put('T', Material.ENCHANTING_TABLE);
        ingredients.put('D', Material.DEEPSLATE_TILES);
        ingredients.put('A', Material.POLISHED_BLACKSTONE_BRICK_STAIRS);
        ingredients.put('Q', Material.QUARTZ_STAIRS);
        ingredients.put('B', Material.BEACON);
        ingredients.put('C', Material.AMETHYST_CLUSTER);
        ingredients.put('E', Material.CHISELED_QUARTZ_BLOCK);
        ingredients.put('N', Material.NETHERITE_BLOCK);
        return ingredients;
    }

    @Override
    public char[][][] getShape() {
        char[][][] shape = {
                // First Layer (say ground level)
                {
                        // Z from top to bottom
                        { ' ', ' ', ' ', 'S', 'S', 'S', 'S', 'S', ' ', ' ', ' ' },
                        { ' ', ' ', 'S', ' ', ' ', ' ', ' ', ' ', 'S', ' ', ' ' },
                        { ' ', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'S', ' ' },
                        { 'S', ' ', ' ', 'D', 'D', 'D', 'D', 'D', ' ', ' ', 'S' },
                        { 'S', ' ', ' ', 'D', 'A', 'A', 'A', 'D', ' ', ' ', 'S' },
                        { 'S', ' ', ' ', 'D', 'A', 'X', 'A', 'D', ' ', ' ', 'S' },
                        { 'S', ' ', ' ', 'D', 'A', 'A', 'A', 'D', ' ', ' ', 'S' },
                        { 'S', ' ', ' ', 'D', 'D', 'D', 'D', 'D', ' ', ' ', 'S' },
                        { ' ', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'S', ' ' },
                        { ' ', ' ', 'S', ' ', ' ', ' ', ' ', ' ', 'S', ' ', ' ' },
                        { ' ', ' ', ' ', 'S', 'S', 'S', 'S', 'S', ' ', ' ', ' ' }
                },
                // Second Layer (1 block above last)
                {
                        { ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', 'T', ' ', ' ', ' ', ' ', ' ', 'T', ' ', ' ' },
                        { 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', 'Y', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' },
                        { ' ', ' ', 'T', ' ', ' ', ' ', ' ', ' ', 'T', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
                },
                {
                        { ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }
                },
                {
                        { ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { 'P', 'Q', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'Q', 'P' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { 'P', 'Q', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'Q', 'P' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'P', ' ', ' ', ' ', 'P', ' ', ' ', ' ' }

                },
                {
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { 'Q', 'E', 'Q', ' ', ' ', ' ', ' ', ' ', 'Q', 'E', 'Q' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { 'Q', 'E', 'Q', ' ', ' ', ' ', ' ', ' ', 'Q', 'E', 'Q' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' }

                },
                {
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' },
                        { ' ', 'Q', 'E', 'C', ' ', ' ', ' ', 'C', 'E', 'Q', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', 'Q', 'E', 'C', ' ', ' ', ' ', 'C', 'E', 'Q', ' ' },
                        { ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'E', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }

                },
                {
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', 'Q', 'N', ' ', ' ', ' ', 'N', 'Q', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', 'Q', 'N', ' ', ' ', ' ', 'N', 'Q', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', ' ', ' ', ' ', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }

                },
                {
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', 'Q', 'Q', 'Q', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', 'N', 'N', 'N', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', 'N', 'N', 'N', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', 'N', 'N', 'N', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', 'Q', 'Q', 'Q', 'Q', 'Q', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }

                },
                {
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', 'B', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }

                }
        };
        return shape;
    }

    @Override
    public boolean execute(Player ritualActivator, Location pos, World world, Collection<Entity> entities) {
        ShapePos beaconPos = new ShapePos(this.findMossLocation().getX() - 5, this.findMossLocation().getZ() - 5,
                this.findMossLocation().getLayer() + 7);
        // RedSorcery.plugin.getLogger().info();
        Location beaconLocation = pos.offset(beaconPos.getX(), beaconPos.getLayer(), beaconPos.getZ())
                .toLocation(world);
        Block beaconBlock = world
                .getBlockAt(beaconLocation);
        Beacon beacon = (Beacon) beaconBlock.getState();
        if (beacon.getPrimaryEffect() == null) {
            ritualActivator.sendMessage(
                    Component.text(RedSorcery.prefix + " The Beacon must be active with an effect"));
            return false;
        }
        List<Item> enchants = new ArrayList<>();
        List<Item> enchantables = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity.getType() != EntityType.DROPPED_ITEM)
                continue;
            Item item = (Item) entity;
            if (item.getItemStack().getType() == Material.ENCHANTED_BOOK) {
                enchants.add(item);
            }
            if (ENCHANTABLE_ITEMS.contains(item.getItemStack().getType())) {
                if (!item.getItemStack().getItemMeta().hasEnchants())
                    enchantables.add(item);
            }
        }
        int levelCost = 0;
        for (Item item : enchantables) {
            for (Item book : enchants) {
                EnchantmentStorageMeta enchant = (EnchantmentStorageMeta) book.getItemStack().getItemMeta();
                levelCost += calculateCost(item, enchant);
            }
        }
        if (ritualActivator.getLevel() < levelCost) {
            ritualActivator.sendMessage(
                    Component.text(RedSorcery.prefix + " " + levelCost + " Levels are required for this enchant."));
            return false;
        }
        for (Item item : enchantables) {
            ItemStack stack = item.getItemStack();
            for (Item book : enchants) {
                EnchantmentStorageMeta enchant = (EnchantmentStorageMeta) book.getItemStack().getItemMeta();
                enchant.getStoredEnchants().forEach((e, level) -> {
                    if (e.canEnchantItem(stack)) {
                        stack.addEnchantment(e, level);
                    }
                });
            }
        }
        ritualActivator.setLevel(ritualActivator.getLevel() - levelCost);
        for (Location loc : getAmethystLocations(beaconLocation)) {
            world.getBlockAt(loc).setType(Material.AIR);
        }

        return true;
    }

    @Override
    public String getPermission() {
        return "enchant";
    }

    @Override
    public String help() {
        return "Enchant items without using up the enchanted books";
    }

    int calculateCost(Item item, EnchantmentStorageMeta enchantedBook) {
        AtomicInteger cost = new AtomicInteger(0);
        enchantedBook.getStoredEnchants().forEach((enchant, level) -> {
            if (enchant.canEnchantItem(item.getItemStack())) {
                cost.addAndGet(level * MULTIPLIERS.get(enchant));
            }
        });
        cost.addAndGet(enchantedBook.getStoredEnchants().size() - 1);
        return cost.get();
    }

    Location[] getAmethystLocations(Location beaconLocation) {
        RedSorcery.plugin.getLogger().info(beaconLocation.toString());
        Location[] locations = {
                beaconLocation.clone().add(-2.0, -3.0, -2.0),
                beaconLocation.clone().add(2.0, -3.0, -2.0),
                beaconLocation.clone().add(2.0, -3.0, 2.0),
                beaconLocation.clone().add(-2.0, -3.0, 2.0)
        };
        return locations;
    }
}