package com.srminister.cranium.utils;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import com.mojang.authlib.*;
import com.mojang.authlib.properties.*;
import org.bukkit.inventory.meta.*;
import java.lang.reflect.*;

public class HeadsUtil {
    public static ItemStack WALLET;

    static {
        WALLET = getSkull("https://textures.minecraft.net/texture/3449559b6f7e24920ecdf3bd2e425f434157c236334f482cf98a1349da168");
    }

    private static ItemStack getSkull(String url) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        skull.setItemMeta(skullMeta);
        return skull;
    }
}