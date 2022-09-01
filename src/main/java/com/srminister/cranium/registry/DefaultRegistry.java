package com.srminister.cranium.registry;

import com.srminister.cranium.CraniumPlugin;
import com.srminister.cranium.commands.CraniumCommand;
import com.srminister.cranium.commands.sub.GiveCommand;
import com.srminister.cranium.dao.CraniumDAO;
import com.srminister.cranium.listeners.player.PlayerBreakListener;
import com.srminister.cranium.listeners.player.PlayerInteractListener;
import com.srminister.cranium.view.LessRareView;
import com.srminister.cranium.view.subviews.RareView;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import me.saiintbrisson.minecraft.ViewFrame;
import me.saiintbrisson.minecraft.command.message.MessageHolder;
import me.saiintbrisson.minecraft.command.message.MessageType;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@RequiredArgsConstructor
public class DefaultRegistry {

    private final CraniumPlugin plugin;
    private CraniumDAO craniumDAO;

    public void commands() {
        BukkitFrame frame = new BukkitFrame(plugin);
        MessageHolder messageHolder = frame.getMessageHolder();
        messageHolder.setMessage(MessageType.INCORRECT_USAGE, "§cUse /{usage}.");
        messageHolder.setMessage(MessageType.NO_PERMISSION, "§cVocê não tem permissão para isso.");
        frame.registerCommands(
                new CraniumCommand(),
                new GiveCommand()
        );
    }

    public void listeners() {
        craniumDAO = new CraniumDAO(plugin);
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(
                new PlayerInteractListener(craniumDAO),
                plugin
        );

        manager.registerEvents(
                new PlayerBreakListener(),
                plugin
        );

    }

    public void views() {
        ViewFrame frame = new ViewFrame(plugin);
        frame.register(
                new LessRareView(),
                new RareView()
        );
    }
}
