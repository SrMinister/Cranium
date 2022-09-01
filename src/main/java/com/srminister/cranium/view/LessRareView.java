package com.srminister.cranium.view;

import com.srminister.cranium.view.subviews.RareView;
import lombok.val;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LessRareView extends View {
    public LessRareView() {
        super(6, "Recompensas da Sacola");
        setCancelOnClick(true);
        setCancelOnPickup(true);
    }

    @Override
    protected void onRender(ViewContext context) {
        val player = (Player) context.getPlayer();

        slot(10).onRender(slot -> slot.setItem(
                        new ItemBuilder(
                                Material.NETHER_STAR
                        ).name(
                                "§aUma ESTRELA"
                        ).lore(
                                "§7Somente teste"
                        ).build()
                )
        ).onClick((handler) -> {

        });

        slot(40).onRender(slot -> slot.setItem(
                        new ItemBuilder(
                                Material.HOPPER
                        ).name(
                                "§aFiltrar"
                        ).lore(
                                "§7Selecione a categoria",
                                "§7que deseja visualizar.",
                                "",
                                " §f• Menos raros",
                                " §7• Mais raros",
                                "",
                                "§aClique para alterar."
                        ).build()
                )
        ).onClick((handler) -> {
            RareView view = new RareView();
            view.open(player);
        });
    }
}
