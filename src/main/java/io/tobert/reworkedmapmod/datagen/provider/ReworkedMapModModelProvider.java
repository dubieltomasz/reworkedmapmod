package io.tobert.reworkedmapmod.datagen.provider;

import io.tobert.reworkedmapmod.block.ModBlocks;
import io.tobert.reworkedmapmod.item.ModItems;
import io.tobert.reworkedmapmod.item.equipment.ModEquipmentAssetKeys;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

/**
 * This class provides models for generating .json files. Add generic/ simple models here.
 */
public class ReworkedMapModModelProvider extends FabricModelProvider {
    public ReworkedMapModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EVIL_DIAMOND_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.EVIL_DIAMOND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EVIL_DIAMOND_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EVIL_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REWORKED_MAP, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.EVIL_DIAMOND_HELMET, ModEquipmentAssetKeys.EVIL_DIAMOND, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.EVIL_DIAMOND_CHESTPLATE, ModEquipmentAssetKeys.EVIL_DIAMOND, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.EVIL_DIAMOND_LEGGINGS, ModEquipmentAssetKeys.EVIL_DIAMOND, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.EVIL_DIAMOND_BOOTS, ModEquipmentAssetKeys.EVIL_DIAMOND, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
