package io.tobert.reworkedmapmod.block;

import io.tobert.reworkedmapmod.item.ModItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

import static io.tobert.reworkedmapmod.ReworkedMapMod.ofModIdentifier;

public class ModBlocks {

    public static final Block EVIL_DIAMOND_BLOCK = register("evil_diamond_block", Block::new, Blocks.DIAMOND_BLOCK.getSettings());

    public static void initialize(){}

    public static Block register(String name, Function<AbstractBlock.Settings,Block> factory, AbstractBlock.Settings settings){
        Block block = factory.apply(settings);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, ofModIdentifier(name));
        return Registry.register(Registries.BLOCK, blockKey, block);
    }
}
