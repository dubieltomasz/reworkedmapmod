package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.block.ModBlocks;
import io.tobert.reworkedmapmod.item.equipment.ModArmorMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static io.tobert.reworkedmapmod.ReworkedMapMod.*;

public class ModItems {

    public static final Item EVIL_DIAMOND = register("evil_diamond", Item::new,new Item.Settings());
    public static final Item EVIL_STICK = register("evil_stick", Item::new, new Item.Settings());
    public static final Item EVIL_DIAMOND_AXE = register("evil_diamond_axe", Item::new, new Item.Settings().axe(ModToolMaterials.EVIL_DIAMOND, 1f, 1f));
    public static final Item REWORKED_MAP = register("reworked_map", ReworkedMap::new, new Item.Settings());

    public static final Item EVIL_DIAMOND_HELMET = register("evil_diamond_helmet", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.HELMET));
    public static final Item EVIL_DIAMOND_CHESTPLATE = register("evil_diamond_chestplate", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.CHESTPLATE));
    public static final Item EVIL_DIAMOND_LEGGINGS = register("evil_diamond_leggings", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.LEGGINGS));
    public static final Item EVIL_DIAMOND_BOOTS = register("evil_diamond_boots", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.BOOTS));

    public static final Item EVIL_DIAMOND_BLOCK = register(ModBlocks.EVIL_DIAMOND_BLOCK);

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, ModItemGroups.CUSTOM_ITEM_GROUP_KEY, ModItemGroups.CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModItems.EVIL_DIAMOND);
            itemGroup.add(ModItems.EVIL_DIAMOND_AXE);
            itemGroup.add(ModItems.EVIL_DIAMOND_HELMET);
            itemGroup.add(ModItems.EVIL_DIAMOND_CHESTPLATE);
            itemGroup.add(ModItems.EVIL_DIAMOND_LEGGINGS);
            itemGroup.add(ModItems.EVIL_DIAMOND_BOOTS);
            itemGroup.add(ModItems.EVIL_STICK);
            itemGroup.add(ModItems.REWORKED_MAP);
            itemGroup.add(ModItems.EVIL_DIAMOND_BLOCK);
        });
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings){
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey)); // settings.registryKey(itemKey) <-- this function assigns settings to an item?
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static Item register(Block block) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, block.getRegistryEntry().registryKey().getValue());
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
        return Registry.register(Registries.ITEM, itemKey, blockItem);
    }
}
