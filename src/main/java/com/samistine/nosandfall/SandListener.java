package com.samistine.nosandfall;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.World;
import org.bukkit.Bukkit;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.Listener;

final class SandListener implements Listener {

    private final Set<String> worlds = new HashSet<>();

    SandListener(Configuration config) {
        for (String s : config.getStringList("Whitelist")) {
            World w = Bukkit.getWorld(s);
            if (w == null) {
                System.out.print("[NoSandFall] The world " + s + " was not found?!!?!?!?!?!?!?!");
            } else {
                this.worlds.add(w.getName());
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    void onFall(EntityChangeBlockEvent event) {
        if (event.getEntityType() == EntityType.FALLING_BLOCK && this.worlds.contains(event.getBlock().getWorld().getName())) {
            event.setCancelled(true);
        }
    }
}
