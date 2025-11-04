package io.tobert.reworkedmapmod.customInventory;

import com.mojang.serialization.Codec;
import io.tobert.reworkedmapmod.ReworkedMapMod;
import net.minecraft.component.Component;
import net.minecraft.entity.ContainerUser;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class CastomInventory implements Inventory {
    private DefaultedList<ItemStack> stacks;

    public CastomInventory(int size) {

        this.stacks = DefaultedList.ofSize(size, ItemStack.EMPTY);
    }

    @Override
    public int size() {
        return stacks.size();
    }

    @Override
    public boolean isEmpty() {
        return stacks.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return stacks.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack stack = stacks.get(slot);
        if(stack.getCount() <= amount) {
            return stacks.set(slot, ItemStack.EMPTY);
        } else {
            stack.decrement(amount);
            return stack;
        }
    }

    @Override
    public ItemStack removeStack(int slot) {
        return stacks.set(slot, ItemStack.EMPTY);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        stacks.set(slot, stack);
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i < this.size(); ++i) {
            stacks.set(i, ItemStack.EMPTY);
        }
    }
}
