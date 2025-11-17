package io.tobert.reworkedmapmod.mixin;

import io.tobert.reworkedmapmod.customInventory.CustomInventoryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackWithSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements CustomInventoryHandler {
    @Unique
    DefaultedList<ItemStack> customInventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    @Override
    public void setCustomSlot(int slot, ItemStack stack) {
        this.customInventory.set(slot, stack);
    }

    @Override
    public DefaultedList<ItemStack> getCustomInventory() {
        return this.customInventory;
    }

    @Inject(method = "readCustomData", at = @At("TAIL"))
    void customReadCustomData(ReadView view, CallbackInfo ci) {
        this.customInventory.clear();
        ReadView.TypedListReadView<StackWithSlot> list = view.getTypedListView("CustomInventory", StackWithSlot.CODEC);

        for (StackWithSlot stackWithSlot : list) {
            if (stackWithSlot.isValidSlot(this.customInventory.size())) {
                this.customInventory.set(stackWithSlot.slot(), stackWithSlot.stack());
            }
        }
    }

    @Inject(method = "writeCustomData", at = @At("TAIL"))
    void customWriteCustomData(WriteView view, CallbackInfo ci) {
        WriteView.ListAppender<StackWithSlot> list = view.getListAppender("CustomInventory", StackWithSlot.CODEC);

        for (int i = 0; i < this.customInventory.size(); i++) {
            ItemStack itemStack = this.customInventory.get(i);

            if (!itemStack.isEmpty()) {
                list.add(new StackWithSlot(i, itemStack));
            }
        }
    }
}