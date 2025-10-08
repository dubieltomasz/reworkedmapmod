package io.tobert.reworkedmapmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.tobert.reworkedmapmod.ReworkedMapMod.MOD_ID;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "custom_item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(()->new ItemStack(ModItems.EVIL_DIAMOND))
            .displayName(Text.translatable("itemgroup.reworkedmapmod.custom_item_group"))
            .build();
}
