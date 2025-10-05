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
import java.util.function.Function;

public class ModItems {
    public static final Item REWORKED_MAP = registerHelper("reworked_map", Item::new, new Item.Settings());

    public static Item registerHelper(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ReworkedMapMod.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        ReworkedMapMod.LOGGER.info("Register mod items for " + ReworkedMapMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CUSTOM_ITEM_GROUP_KEY).register(entries -> {
            entries.add(REWORKED_MAP);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(REWORKED_MAP);
        });
    }
}
