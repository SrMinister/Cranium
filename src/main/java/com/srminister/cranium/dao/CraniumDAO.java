package com.srminister.cranium.dao;

import com.srminister.cranium.CraniumPlugin;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CraniumDAO {

    private CraniumPlugin plugin;
    private List<String> wallet;

    public CraniumDAO(CraniumPlugin plugin) {
        this.plugin = plugin;
        this.wallet = new ArrayList<>();
    }

    public boolean isWallet(ItemStack item) {
        return new NBTItem(item).hasKey("cranium");
    }

    public double getWallet(ItemStack item) {
        return new NBTItem(item).getDouble("cranium") * item.getAmount();
    }

    public double getAllWallet(Inventory inventory) {
        return Arrays.stream(inventory.getContents()).filter(Objects::nonNull).filter(this::isWallet).mapToDouble(this::getWallet).sum();
    }


    public CraniumPlugin getPlugin() {
        return  this.plugin;
    }

    public List<String> getWallet() {
        return this.wallet;
    }

}
