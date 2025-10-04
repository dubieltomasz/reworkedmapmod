package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item REWORKED_MAP = registerItem("reworked_map", new Item(
            new Item.Settings().registryKey(RegistryKey.of(
                    RegistryKeys.ITEM, Identifier.of(ReworkedMapMod.MOD_ID,"reworked_map")
            ))
    ));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ReworkedMapMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ReworkedMapMod.LOGGER.info("Register mod items for " + ReworkedMapMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(REWORKED_MAP);
        });
    }
}
