package com.srminister.cranium.listeners.player;

import com.srminister.cranium.dao.CraniumDAO;
import com.srminister.cranium.sortition.SortitionItems;
import com.srminister.cranium.view.LessRareView;
import lombok.val;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class PlayerInteractListener implements Listener {

    private CraniumDAO craniumDAO;

    @EventHandler
    public void on(
            PlayerInteractEvent event
    ) {

        val player = event.getPlayer();
        val action = event.getAction();
        val item = event.getItem();

        if (item == null) return;
        if (item.getType() == Material.AIR) return;
        if (!item.hasItemMeta()) return;

        if (craniumDAO.isWallet(item)) {
            event.setCancelled(true);
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                ItemStack itemInHand = player.getItemInHand();
                int amount = player.isSneaking() ? itemInHand.getAmount() : 1;
                for (int i = 0; i < amount; ++i) {
                    SortitionItems.sort(player);
                }
                if (player.getItemInHand().getAmount() > amount) {
                    player.getItemInHand().setAmount(player.getItemInHand().getAmount() - amount);
                } else {
                    player.setItemInHand(null);
                }
                player.updateInventory();
            }
            if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
                LessRareView view = new LessRareView();
                view.open(player);
            }
        }
    }

    public PlayerInteractListener(CraniumDAO craniumDAO) {
        this.craniumDAO = craniumDAO;
    }
}
