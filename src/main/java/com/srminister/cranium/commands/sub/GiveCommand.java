package com.srminister.cranium.commands.sub;

import com.srminister.cranium.enums.Messages;
import com.srminister.cranium.item.ItemBuilder;
import com.srminister.cranium.utils.HeadsUtil;
import de.tr7zw.nbtapi.NBTItem;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GiveCommand {

    @Command(
            name = "cranio.give",
            permission = "hyren.cranium"
    )

    public void handleCraniumGive(
            Context<CommandSender> context,
            Player target
    ) {

        val player = (Player) context.getSender();
        val inventory = (PlayerInventory) target.getInventory();

        ItemStack item = new ItemBuilder(
                HeadsUtil.WALLET.clone()
        ).name(
                "§aCrânio de Dinossauro"
        ).lore(
                "§7Chance de receber itens especiais",
                "§7até mesmo dinheiros e cash",
                "§7no servidor.",
                "",
                " §aOpções:",
                "  §fBotão esquerdo: §7para visualizar.",
                "  §fBotão direito: §7para abrir.",
                "",
                "§eClique direito para abrir!"
        ).build();


        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setDouble("cranium", (double) 1);

        if (player.getInventory().addItem(nbtItem.getItem()).isEmpty()) {
            Messages.ORB_PICKUP.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §a§lYEAH! §aVocê acaba de givar §a§l1 §acrânio§a para o jogador §a"
                                    + target.getName() +
                                    "§a.",
                            ""
                    }
            );
        } else {
            Messages.ERROR.sendMessageList(
                    player,
                    new String[] {
                            "",
                            " §c§lOPS! §cParece que seu invetário está cheio.",
                            ""
                    }
            );

        }
    }
}
