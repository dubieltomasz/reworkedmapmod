package io.tobert.reworkedmapmod;

import io.tobert.reworkedmapmod.component.ModDataComponentTypes;
import io.tobert.reworkedmapmod.item.ModItems;
import io.tobert.reworkedmapmod.recipe.ModRecipes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReworkedMapMod implements ModInitializer {
	public static final String MOD_ID = "reworked_map_mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModRecipes.initialize();
		ModDataComponentTypes.initialize();
	}

	public static Identifier ofModIdentifier(String name){
		return Identifier.of(MOD_ID, name);
	}
}