package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup REWORKED_MAP_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReworkedMapMod.MOD_ID, "reworked_map_mod"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.REWORKED_MAP))
                    .displayName(Text.translatable("itemgroup.reworkedmapmod.reworked_map_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.REWORKED_MAP);
                    }).build());

    public static void registerItemGroup() {
        ReworkedMapMod.LOGGER.info("Registering Item Group for " + ReworkedMapMod.MOD_ID);
    }
}
