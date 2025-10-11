package io.tobert.reworkedmapmod.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModdedCraftingSerializer {
    public static final RecipeSerializer<CraftingReworkedMapRecipe> CRAFTING_REWORKED_MAP = register(
            "reworked-map-mod:crafting_reworked_map", new SpecialCraftingRecipe.SpecialRecipeSerializer<>(CraftingReworkedMapRecipe::new)
    );

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
    }

    public static void initialize() {

    }
}
