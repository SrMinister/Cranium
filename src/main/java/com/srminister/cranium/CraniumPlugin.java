package com.srminister.cranium;

import com.srminister.cranium.dao.CraniumDAO;
import com.srminister.cranium.registry.DefaultRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class CraniumPlugin extends JavaPlugin {
    private DefaultRegistry defaultRegistry;
    private CraniumDAO craniumDAO;

    @Override
    public void onEnable() {
        defaultRegistry = new DefaultRegistry(this);
        craniumDAO = new CraniumDAO(this);

        commands();
        listeners();
        views();
    }

    public void commands() {
        defaultRegistry.commands();
    }

    public void listeners() {
        defaultRegistry.listeners();
    }

    public void views() {
        defaultRegistry.views();
    }

    public static CraniumPlugin getInstance() {
        return getPlugin(CraniumPlugin.class);
    }
}
