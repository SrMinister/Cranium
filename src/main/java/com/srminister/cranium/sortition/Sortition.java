package com.srminister.cranium.sortition;

import com.srminister.cranium.enums.Messages;
import com.srminister.cranium.item.ItemBuilder;
import com.srminister.cranium.utils.HeadsUtil;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Sortition {

    public static void sort(Player player) {
        Random random = new Random();
        int amount = random.nextInt(60) + 1;
        if (amount == 2 || amount == 5 || amount == 8 || amount == 10) {
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
                Messages.POP.sendMessageList(
                        player,
                        new String[]{
                                "",
                                " §a§lYEAH! §aVocê acaba de ganhar uma um crânio de dinossauro!",
                                ""
                        }
                );


            } else if (amount == 12 || amount == 15 || amount == 18) {
                nbtItem.setDouble("cranium", (double) 1);
                if (player.getInventory().addItem(nbtItem.getItem()).isEmpty()) {
                    Messages.POP.sendMessageList(
                            player,
                            new String[]{
                                    "",
                                    " §a§lYEAH! §aVocê acaba de ganhar uma um crânio de dinossauro!",
                                    ""
                            }
                    );
                } else if (amount == 22 || amount == 24 || amount == 28) {
                    nbtItem.setDouble("cranium", (double) 1);
                    if (player.getInventory().addItem(nbtItem.getItem()).isEmpty()) {
                        Messages.POP.sendMessageList(
                                player,
                                new String[]{
                                        "",
                                        " §a§lYEAH! §aVocê acaba de ganhar uma um crânio de dinossauro!",
                                        ""
                                }
                        );
                    } else if (amount == 32 || amount == 35 || amount == 38) {
                        nbtItem.setDouble("cranium", (double) 1);
                        if (player.getInventory().addItem(nbtItem.getItem()).isEmpty()) {
                            Messages.POP.sendMessageList(
                                    player,
                                    new String[]{
                                            "",
                                            " §a§lYEAH! §aVocê acaba de ganhar uma um crânio de dinossauro!",
                                            ""
                                    }
                            );
                        } else if (amount == 40 || amount == 44 || amount == 48) {
                            nbtItem.setDouble("cranium", (double) 1);
                            if (player.getInventory().addItem(nbtItem.getItem()).isEmpty()) {
                                Messages.POP.sendMessageList(
                                        player,
                                        new String[]{
                                                "",
                                                " §a§lYEAH! §aVocê acaba de ganhar uma um crânio de dinossauro!",
                                                ""
                                        }
                                );
                            } else if (amount == 52 || amount == 54 || amount == 58) {
                                Messages.POP.sendMessageList(
                                        player,
                                        new String[]{
                                                "",
                                                " §a§lYEAH! §aVocê acaba de ganhar uma um crânio de dinossauro!",
                                                ""
                                        }
                                );
                            } else {

                            }
                        }
                    }
                }
            }
        }
    }
}
