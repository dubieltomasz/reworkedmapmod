package io.tobert.reworkedmapmod.customInventory;

import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

//Adds a way to access custom values added with mixin
public interface CustomInventoryHandler {
    public void setCustomSlot(int slot, ItemStack stack);
    public DefaultedList<ItemStack> getCustomInventory();
}
