package io.tobert.reworkedmapmod.recipe;

import io.tobert.reworkedmapmod.item.ModItems;
import net.minecraft.block.entity.Sherds;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
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
    public RecipeSerializer<CraftingReworkedMapRecipe> getSerializer() {
        return ModdedCraftingSerializer.CRAFTING_REWORKED_MAP;
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        return input.getStackCount() == 2
                && (input.getStackInSlot(0, 0).isOf(ModItems.REWORKED_MAP)
                || input.getStackInSlot(1, 0).isOf(ModItems.REWORKED_MAP));
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        Sherds sherds = new Sherds(
                input.getStackInSlot(0, 0).getItem(),
                input.getStackInSlot(1, 0).getItem(),
                input.getStackInSlot(0, 0).getItem(),
                input.getStackInSlot(1, 0).getItem()
        );
        ItemStack stack = ModItems.REWORKED_MAP.getDefaultStack();
        stack.set(DataComponentTypes.POT_DECORATIONS, sherds);

        return stack;
    }
}
