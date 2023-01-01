package io.github.sarahgreywolf.redsorcery.interfaces;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import net.kyori.adventure.text.Component;

public interface IRitual {

    String getName();

    Map<Character, Material> getShapeIngredients();

    Material getActivationItem();

    char[][][] getShape();

    void execute(Player ritualActivator, World world, Object[] args, Component permissionMessage);

    String getPermission();

    String help();

}
