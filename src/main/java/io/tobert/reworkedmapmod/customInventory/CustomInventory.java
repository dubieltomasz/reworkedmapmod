package io.tobert.reworkedmapmod.customInventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Unique;

public class CustomInventory implements Inventory {
    @Unique
    public CustomInventoryHandler owner;

    @Override
    public int size() {
        return 3;
    }

    @Override
    public boolean isEmpty() {
        return  this.owner.getCustomInventory().get(0) == ItemStack.EMPTY &&
                this.owner.getCustomInventory().get(1) == ItemStack.EMPTY &&
                this.owner.getCustomInventory().get(2) == ItemStack.EMPTY;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.owner.getCustomInventory().get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack returnStack = this.owner.getCustomInventory().get(slot);
        if(returnStack != ItemStack.EMPTY && returnStack.getCount() > amount) {
            returnStack.setCount(returnStack.getCount() - amount);
            this.owner.setCustomSlot(slot, returnStack);
            returnStack.setCount(amount);
        } else {
            this.owner.setCustomSlot(slot, ItemStack.EMPTY);
        }

        this.markDirty();
        return returnStack;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack returnStack = this.owner.getCustomInventory().get(slot);
        this.owner.setCustomSlot(slot, ItemStack.EMPTY);

        this.markDirty();
        return returnStack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.owner.setCustomSlot(slot, stack);
        this.markDirty();
    }

    @Override
    public void markDirty() {
        //Yo
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i < 3; ++i) {
            this.owner.setCustomSlot(i, ItemStack.EMPTY);
        }
        this.markDirty();
    }
}
