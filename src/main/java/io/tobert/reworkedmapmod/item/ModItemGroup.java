package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(ReworkedMapMod.MOD_ID, "reworked_map_mod"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.reworkedmapmod.reworked_map_mod_group"))
            .icon(() -> new ItemStack(ModItems.REWORKED_MAP))
            .build();

    public static void registerItemGroup() {
        ReworkedMapMod.LOGGER.info("Registering Item Group for " + ReworkedMapMod.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
    }
}
