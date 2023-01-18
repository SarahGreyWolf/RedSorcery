package dev.sarahgreywolf.redsorcery.listeners;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillListener implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent evt) {
        LivingEntity entity = evt.getEntity();
        Player killer = entity.getKiller();
        if (killer == null)
            return;
        Location deathLoc = entity.getLocation();

    }
}
