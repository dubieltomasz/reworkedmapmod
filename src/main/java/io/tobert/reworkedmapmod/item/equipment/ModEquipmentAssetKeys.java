package io.tobert.reworkedmapmod.item.equipment;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;

import static io.tobert.reworkedmapmod.ReworkedMapMod.ofModIdentifier;

/**
 * Something like armor types.
 * Check {@link net.minecraft.item.equipment.EquipmentAssetKeys}
 */
public interface ModEquipmentAssetKeys {
    RegistryKey<EquipmentAsset> EVIL_DIAMOND = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, ofModIdentifier("evil_diamond"));
}
