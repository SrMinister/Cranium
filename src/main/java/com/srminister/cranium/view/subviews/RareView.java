package com.srminister.cranium.view.subviews;

import com.srminister.cranium.item.ItemBuilder;
import com.srminister.cranium.view.LessRareView;
import lombok.val;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class RareView extends View {
    public RareView() {
        super(6, "Recompensas da Sacola");
        setCancelOnClick(true);
        setCancelOnPickup(true);
    }

    @Override
    protected void onRender(ViewContext context) {
        val player = (Player) context.getPlayer();

        slot(10).onRender(slot -> slot.setItem(
                new ItemBuilder(
                        Material.FIREWORK_CHARGE
                ).name(
                        "§aFireWork"
                ).lore(
                        "§7Um simples firework"
                ).build()
        )).onClick((handler) -> {
        });

        slot(40).onRender(slot -> slot.setItem(
                        new me.saiintbrisson.minecraft.utils.ItemBuilder(
                                Material.HOPPER
                        ).name(
                                "§aFiltrar"
                        ).lore(
                                "§7Selecione a categoria",
                                "§7que deseja visualizar.",
                                "",
                                " §7• Menos raros",
                                " §f• Mais raros",
                                "",
                                "§aClique para alterar."
                        ).build()
                )
        ).onClick((handler) -> {
            LessRareView view = new LessRareView();
            view.open(player);
        });

    }
}
