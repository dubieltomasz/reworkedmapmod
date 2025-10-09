package io.tobert.reworkedmapmod.datagen.provider;

import io.tobert.reworkedmapmod.item.ModItemGroups;
import io.tobert.reworkedmapmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * This class provides translations for generating en-us.json. Add any translations here.
 */
public class ReworkedMapModEnglishLangProvider extends FabricLanguageProvider {

    public ReworkedMapModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.EVIL_DIAMOND.getTranslationKey(), "Evil Diamond");
        translationBuilder.add(ModItems.EVIL_DIAMOND_AXE.getTranslationKey(), "Evil Diamond Axe");
        translationBuilder.add(ModItems.EVIL_DIAMOND_HELMET.getTranslationKey(), "Evil Diamond Helmet");
        translationBuilder.add(ModItems.EVIL_DIAMOND_CHESTPLATE.getTranslationKey(), "Evil Diamond Chestplate");
        translationBuilder.add(ModItems.EVIL_DIAMOND_LEGGINGS.getTranslationKey(), "Evil Diamond Leggings");
        translationBuilder.add(ModItems.EVIL_DIAMOND_BOOTS.getTranslationKey(), "Evil Diamond Boots");
        translationBuilder.add(ModItems.EVIL_STICK.getTranslationKey(), "Evil Diamond");
        translationBuilder.add(ModItems.REWORKED_MAP.getTranslationKey(), "Reworked Map");
        translationBuilder.add(ModItems.EVIL_DIAMOND_BLOCK.getTranslationKey(), "Evil Diamond Block");

        translationBuilder.add(ModItemGroups.CUSTOM_ITEM_GROUP.getDisplayName().getString(), "Evil Group");
    }
}
