package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item REWORKED_MAP = registerItem("reworked_map", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ReworkedMapMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ReworkedMapMod.LOGGER.info("Registering Mod Items for " + ReworkedMapMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(REWORKED_MAP);
        });
    }
}
