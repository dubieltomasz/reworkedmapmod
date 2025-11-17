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
        if(input.getStackCount() == 2){
            boolean bl1 = false;
            boolean bl2 = false;

            for(ItemStack itemStack : input.getStacks()) {
                if(itemStack.isOf(ModItems.REWORKED_MAP)) {
                    if(bl1) {
                        return false;
                    }

                    bl1 = true;
                } else if(itemStack.isOf(Items.RED_DYE)) {
                    if(bl2) {
                        return false;
                    }

                    bl2 = true;
                }
            }

            return bl1 && bl2;
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
