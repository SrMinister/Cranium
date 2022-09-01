package com.srminister.cranium.listeners.player;

import com.srminister.cranium.sortition.Sortition;
import lombok.val;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakListener implements Listener {

    @EventHandler
    public void on(BlockBreakEvent event) {

        val player = (Player) event.getPlayer();
        val block = (Block) event.getBlock();

        String id = "159:1";
        String[] parts = id.split(":");
        int material = Integer.valueOf(parts[0]);
        int data = Integer.valueOf(parts[1]);

        if (player.getWorld().getName().equalsIgnoreCase("mines")) {
            if (block.getType() == Material.getMaterial( 159) || block.getType() == Material.getMaterial(data)) {
                Sortition.sort(player);
                event.setCancelled(true);
            }
        }
    }

}
