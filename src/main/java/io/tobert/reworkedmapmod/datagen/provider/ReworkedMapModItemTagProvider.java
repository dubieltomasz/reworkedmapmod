package io.tobert.reworkedmapmod.datagen.provider;

import io.tobert.reworkedmapmod.item.ModItems;
import io.tobert.reworkedmapmod.registry.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * This class provides data for generating item tags. Item tags assign items to their respective groups and give them unique properties. Assign any item tags here.
 */
public class ReworkedMapModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ReworkedMapModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.EVIL_DIAMOND_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.EVIL_DIAMOND_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.EVIL_DIAMOND_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.EVIL_DIAMOND_BOOTS);

        valueLookupBuilder(ItemTags.AXES).add(ModItems.EVIL_DIAMOND_AXE);
        valueLookupBuilder(ModItemTags.REPAIRS_EVIL_ARMOR).add(ModItems.EVIL_DIAMOND);
        valueLookupBuilder(ModItemTags.EVIL_DIAMOND_TOOL_MATERIALS).add(ModItems.EVIL_DIAMOND);
    }
}
