package com.srminister.cranium.enums;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public enum Messages {

    NOT_SOUND(null),
    ERROR(Sound.VILLAGER_NO),
    HORSE_ARMOR(Sound.HORSE_ARMOR),
    ZOMBIE_DEATH(Sound.ZOMBIE_DEATH),
    EXPLODE(Sound.EXPLODE),
    CLICK(Sound.CLICK),
    POP(Sound.CHICKEN_EGG_POP),
    ORB_PICKUP(Sound.ORB_PICKUP),
    ITEM_PICKUP(Sound.ITEM_PICKUP),
    SLIME_WALK(Sound.SLIME_WALK),
    FLYING(Sound.ENDERDRAGON_WINGS),
    TELEPORT(Sound.ENDERMAN_TELEPORT);

    private Sound sound;

    Messages(
            Sound sound
    ) {
        this.sound = sound;
    }

    public void sendMessage(
            Player player,
            String message
    ) {
        player.sendMessage(message);
        player.playSound(player.getLocation(), this.sound, 1.0F, 1.0F);
    }

    public void sendMessageList(
            Player player,
            String[] message
    ) {
        player.sendMessage(message);
        player.playSound(player.getLocation(), this.sound, 1.0F, 1.0F);
    }

}
