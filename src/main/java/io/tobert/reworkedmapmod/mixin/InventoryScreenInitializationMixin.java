package io.tobert.reworkedmapmod.mixin;

import io.tobert.reworkedmapmod.customInventory.CustomArmorSlot;
import io.tobert.reworkedmapmod.customInventory.CustomEquipmentSlot;
import io.tobert.reworkedmapmod.customInventory.CustomInventory;
import io.tobert.reworkedmapmod.customInventory.CustomInventoryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.AbstractCraftingScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerScreenHandler.class)
public abstract class InventoryScreenInitializationMixin extends AbstractCraftingScreenHandler {
    public InventoryScreenInitializationMixin(ScreenHandlerType<?> type, int syncId, int width, int height) {
        super(type, syncId, width, height);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(PlayerInventory inventory, boolean onServer, PlayerEntity owner, CallbackInfo ci) {
        int offsetX = 8 + 18 + 50 + 1;
        int offsetY = 7 + 1;

        CustomInventory extraInventory = new CustomInventory();
        extraInventory.owner = (CustomInventoryHandler) owner;

        addSlot(new CustomArmorSlot(extraInventory, owner, CustomEquipmentSlot.FACE, 0, offsetX, offsetY, null));
        addSlot(new CustomArmorSlot(extraInventory, owner, CustomEquipmentSlot.BACK, 1, offsetX, offsetY + 18, null));
        addSlot(new CustomArmorSlot(extraInventory, owner, CustomEquipmentSlot.HANDS, 2, offsetX, offsetY + 18 * 2, null));
    }
}
