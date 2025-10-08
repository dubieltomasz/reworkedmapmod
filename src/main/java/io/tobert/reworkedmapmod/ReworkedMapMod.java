package io.tobert.reworkedmapmod;

import io.tobert.reworkedmapmod.item.ModItemGroup;
import io.tobert.reworkedmapmod.item.ModItems;
import io.tobert.reworkedmapmod.recipe.ModdedCraftingSerializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReworkedMapMod implements ModInitializer {
	public static final String MOD_ID = "reworked-map-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModdedCraftingSerializer.initialize();
	}
}