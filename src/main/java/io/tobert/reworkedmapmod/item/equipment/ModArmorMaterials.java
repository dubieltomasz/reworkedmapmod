package io.tobert.reworkedmapmod.item.equipment;

import io.tobert.reworkedmapmod.registry.ModItemTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public class ModArmorMaterials {

    public static final ArmorMaterial EVIL_DIAMOND = new ArmorMaterial(
            15, // Base durability
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5, // Enchantability
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            0.0f, // Toughness
            0.0f, // Knockback res
            ModItemTags.REPAIRS_EVIL_ARMOR,
            ModEquipmentAssetKeys.EVIL_DIAMOND
    );
}
