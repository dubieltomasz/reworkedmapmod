package io.tobert.reworkedmapmod.recipe;

import io.tobert.reworkedmapmod.item.ModItems;
import io.tobert.reworkedmapmod.registry.ModItemTags;
import net.minecraft.command.argument.ArgumentTypes;
import net.minecraft.command.argument.NbtCompoundArgumentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtInt;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class CraftingEvilAxeRecipe extends SpecialCraftingRecipe {
    public CraftingEvilAxeRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        if(input.getWidth() == 1 && input.getHeight() == 3 && input.getStackCount() == 3){
            return input.getStackInSlot(0,0).isIn(ModItemTags.EVIL_DIAMOND_TOOL_MATERIALS) && input.getStackInSlot(0,1).isOf(ModItems.EVIL_STICK) && input.getStackInSlot(0,2).isOf(ModItems.EVIL_STICK);
        }
        return false;
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        ItemStack is = ModItems.EVIL_DIAMOND_AXE.getDefaultStack();
        //is.set(DataComponentTypes.CUSTOM_NAME, Text.literal("sperma"));
        is.set(DataComponentTypes.CUSTOM_NAME, Text.of("pep"));
        return is;
    }

    @Override
    public RecipeSerializer<? extends SpecialCraftingRecipe> getSerializer() {
        return ModRecipes.CRAFTING_EVIL_AXE;
    }
}
