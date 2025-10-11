package io.tobert.reworkedmapmod.datagen;

import io.tobert.reworkedmapmod.datagen.provider.ReworkedMapModEnglishLangProvider;
import io.tobert.reworkedmapmod.datagen.provider.ReworkedMapModItemTagProvider;
import io.tobert.reworkedmapmod.datagen.provider.ReworkedMapModModelProvider;
import io.tobert.reworkedmapmod.datagen.provider.ReworkedMapModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ReworkedMapModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ReworkedMapModEnglishLangProvider::new);
		pack.addProvider(ReworkedMapModModelProvider::new);
		pack.addProvider(ReworkedMapModItemTagProvider::new);
		pack.addProvider(ReworkedMapModRecipeProvider::new);
	}
}
