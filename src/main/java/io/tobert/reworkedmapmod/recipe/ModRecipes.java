package io.tobert.reworkedmapmod.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static io.tobert.reworkedmapmod.ReworkedMapMod.ofModIdentifier;

public class ModRecipes {

    public static final RecipeSerializer<CraftingEvilAxeRecipe> CRAFTING_EVIL_AXE = register("crafting_evil_axe", new SpecialCraftingRecipe.SpecialRecipeSerializer<>(CraftingEvilAxeRecipe::new));
    public static final RecipeSerializer<CraftingReworkedMapRecipe> CRAFTING_REWORKED_MAP = register("crafting_reworked_map", new SpecialCraftingRecipe.SpecialRecipeSerializer<>(CraftingReworkedMapRecipe::new));

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, ofModIdentifier(name), serializer);
    }

    public static void initialize(){

    }
}
