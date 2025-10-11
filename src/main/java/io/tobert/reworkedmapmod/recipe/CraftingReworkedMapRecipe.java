package io.tobert.reworkedmapmod.recipe;

import io.tobert.reworkedmapmod.component.ModDataComponentTypes;
import io.tobert.reworkedmapmod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class CraftingReworkedMapRecipe extends SpecialCraftingRecipe {
    public CraftingReworkedMapRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        if(input.getWidth()==2 && input.getHeight() == 1 && input.getStackCount()==2){
            return input.getStackInSlot(0,0).isOf(Items.RED_DYE) && input.getStackInSlot(1,0).isOf(ModItems.REWORKED_MAP);
        }
        return false;
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        ItemStack stack = ModItems.REWORKED_MAP.getDefaultStack();
        stack.set(ModDataComponentTypes.HAS_RED_PIN, true);
        return stack;
    }

    @Override
    public RecipeSerializer<? extends SpecialCraftingRecipe> getSerializer() {
        return ModRecipes.CRAFTING_REWORKED_MAP;
    }
}
