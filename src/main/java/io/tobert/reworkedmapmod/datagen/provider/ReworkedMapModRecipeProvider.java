package io.tobert.reworkedmapmod.datagen.provider;

import io.tobert.reworkedmapmod.item.ModItems;
import io.tobert.reworkedmapmod.registry.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ReworkedMapModRecipeProvider extends FabricRecipeProvider {
    public ReworkedMapModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShaped(RecipeCategory.TOOLS, ModItems.EVIL_DIAMOND_AXE, 1)
                        .pattern("DD")
                        .pattern("DS")
                        .pattern(" S")
                        .input('D', ModItemTags.EVIL_DIAMOND_TOOL_MATERIALS)
                        .input('S', ModItems.EVIL_STICK)
                        .criterion(hasItem(ModItems.EVIL_DIAMOND_AXE), conditionsFromItem(ModItems.EVIL_DIAMOND_AXE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ReworkedMapModRecipeProvider";
    }
}
