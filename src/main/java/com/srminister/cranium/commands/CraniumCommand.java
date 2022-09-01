package com.srminister.cranium.commands;

import com.srminister.cranium.enums.Messages;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraniumCommand {

    @Command(
            name = "cranio",
            permission = "hyren.cranium"
    )
    public void handleCranium(
            Context<CommandSender> context
    ) {

        val player = (Player) context.getSender();

        Messages.CLICK.sendMessageList(
                player,
                new String[]{
                        "",
                        "§a§lCRANIUM §8▶ §fHelp Commands",
                        "",
                        "§8 ▪ §f/cranio §7· §fcommand list",
                        "§8 ▪ §f/cranio give <player> §7· §fget a wallet",
                        ""
                }
        );
    }
}
