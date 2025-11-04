package io.tobert.reworkedmapmod.mixin;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import io.tobert.reworkedmapmod.customInventory.CastomInventory;
import io.tobert.reworkedmapmod.customInventory.PlayerCustomArray;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.AbstractCraftingScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerScreenHandler.class)
public abstract class AdditionalSlotsMixin extends AbstractCraftingScreenHandler {
    public AdditionalSlotsMixin(ScreenHandlerType<?> type, int syncId, int width, int height) {
        super(type, syncId, width, height);
    }

    @Inject(method = "<init>(Lnet/minecraft/entity/player/PlayerInventory;ZLnet/minecraft/entity/player/PlayerEntity;)V", at = @At("TAIL"))
    public void init(PlayerInventory inventory, boolean onServer, PlayerEntity owner, CallbackInfo ci) {
        int offsetX = 8 + 18 + 50 + 1;
        int offsetY = 7 + 1;

        if(owner instanceof PlayerCustomArray pca) {
            CastomInventory extraInventory = pca.getExtraItems();
            addSlot(new Slot(extraInventory, 0, offsetX, offsetY));
            addSlot(new Slot(extraInventory, 1, offsetX, offsetY + 18));
            addSlot(new Slot(extraInventory, 2, offsetX, offsetY + 18 * 2));
        }
    }
}
