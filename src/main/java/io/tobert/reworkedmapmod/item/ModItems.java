package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import io.tobert.reworkedmapmod.block.ModBlocks;
import io.tobert.reworkedmapmod.customInventory.CustomEquipmentSlot;
import io.tobert.reworkedmapmod.customInventory.CustomEquipmentType;
import io.tobert.reworkedmapmod.item.equipment.ModArmorMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtString;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Locale;
import java.util.function.Function;

import static io.tobert.reworkedmapmod.ReworkedMapMod.MOD_ID;

/**
 * Class for registering custom items
 */
public class ModItems {

    public static final Item EVIL_DIAMOND = register("evil_diamond", Item::new, new Item.Settings());
    public static final Item EVIL_STICK = register("evil_stick", Item::new, new Item.Settings());
    public static final Item EVIL_DIAMOND_AXE = register("evil_diamond_axe", Item::new, new Item.Settings().axe(ModToolMaterials.EVIL_DIAMOND, 1f, 1f));
    public static final Item REWORKED_MAP = register("reworked_map", ReworkedMap::new, new Item.Settings());

    public static final Item EVIL_DIAMOND_HELMET = register("evil_diamond_helmet", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.HELMET));
    public static final Item EVIL_DIAMOND_CHESTPLATE = register("evil_diamond_chestplate", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.CHESTPLATE));
    public static final Item EVIL_DIAMOND_LEGGINGS = register("evil_diamond_leggings", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.LEGGINGS));
    public static final Item EVIL_DIAMOND_BOOTS = register("evil_diamond_boots", Item::new, new Item.Settings().armor(ModArmorMaterials.EVIL_DIAMOND, EquipmentType.BOOTS));

    public static final Item IRON_GLOVES = register("iron_gloves", Item::new, customArmorSettings(ArmorMaterials.IRON, CustomEquipmentType.GLOVES, 2));
    public static final Item IRON_MASK = register("iron_mask", Item::new, customArmorSettings(ArmorMaterials.IRON, CustomEquipmentType.MASK, 1));
    public static final Item BACKPACK = register("backpack", Item::new, customArmorSettings(ArmorMaterials.LEATHER, CustomEquipmentType.BACKPACK, 0));

    public static final Item EVIL_DIAMOND_BLOCK = register(ModBlocks.EVIL_DIAMOND_BLOCK);

    public static void initialize() {
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

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
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

    private static Item.Settings customArmorSettings(ArmorMaterial material, CustomEquipmentType customEquipmentType, int armor) {
        NbtCompound compound = new NbtCompound();
        compound.putInt("customSlot", customEquipmentType.getEquipmentSlot().getIndex());

        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
        AttributeModifierSlot attributeModifierSlot = AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.CHEST);
        Identifier identifier = Identifier.of(ReworkedMapMod.MOD_ID.toLowerCase(Locale.ROOT) + customEquipmentType.getEquipmentSlot().getName().toLowerCase(Locale.ENGLISH));

        builder.add(
                EntityAttributes.ARMOR,
                new EntityAttributeModifier(identifier, armor, EntityAttributeModifier.Operation.ADD_VALUE),
                attributeModifierSlot
        );
        builder.add(
                EntityAttributes.ARMOR_TOUGHNESS,
                new EntityAttributeModifier(identifier, material.toughness(), EntityAttributeModifier.Operation.ADD_VALUE),
                attributeModifierSlot
        );
        if (material.knockbackResistance() > 0.0F) {
            builder.add(
                    EntityAttributes.KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(identifier, material.knockbackResistance(), EntityAttributeModifier.Operation.ADD_VALUE),
                    attributeModifierSlot
            );
        }

        return new Item.Settings()
                .maxDamage(customEquipmentType.getMaxDamage(material.durability()))
                .attributeModifiers(builder.build())
                .enchantable(material.enchantmentValue())
                //.component(
                //        DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(null).equipSound(material.equipSound()).model(material.assetId()).build()
                //)
                .component(
                        DataComponentTypes.CUSTOM_DATA, NbtComponent.of(compound)
                )
                .repairable(material.repairIngredient());
    }
}
