package com.srminister.cranium.sortition;

import com.srminister.cranium.enums.Messages;
import org.bukkit.entity.Player;

import java.util.Random;

public class SortitionItems {

    public static void sort(Player player) {
        Random random = new Random();
        int amount = random.nextInt(60) + 1;
        if (amount == 2 || amount == 5 || amount == 8 || amount == 10) {
            Messages.POP.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §a§lYEAH! §aVocê acaba de ganhar uma recompensa no crânio!",
                            ""
                    }
            );
        } else if (amount == 12 || amount == 15 || amount == 18) {
            Messages.POP.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §a§lYEAH! §aVocê acaba de ganhar uma recompensa no crânio!",
                            ""
                    }
            );
        } else if (amount == 22 || amount == 24 || amount == 28) {
            Messages.POP.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §a§lYEAH! §aVocê acaba de ganhar uma recompensa no crânio!",
                            ""
                    }
            );
        } else if (amount == 32 || amount == 35 || amount == 38) {
            Messages.POP.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §a§lYEAH! §aVocê acaba de ganhar uma recompensa no crânio!",
                            ""
                    }
            );
        } else if (amount == 40 || amount == 44 || amount == 48) {
            Messages.POP.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §a§lYEAH! §aVocê acaba de ganhar uma recompensa no crânio!",
                            ""
                    }
            );
        } else if (amount == 52 || amount == 54 || amount == 58) {
            Messages.POP.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §a§lYEAH! §aVocê acaba de ganhar uma recompensa no crânio!",
                            ""
                    }
            );
        } else {
            Messages.NOT_SOUND.sendMessageList(
                    player,
                    new String[]{
                            "",
                            " §c§lOPS! §cParece que você teve azar nesta crânio.",
                            ""
                    }
            );
        }
    }
}
