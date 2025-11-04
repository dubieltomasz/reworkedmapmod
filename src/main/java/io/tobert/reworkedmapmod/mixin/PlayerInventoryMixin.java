package io.tobert.reworkedmapmod.mixin;

import com.mojang.authlib.GameProfile;
import io.tobert.reworkedmapmod.ReworkedMapMod;
import io.tobert.reworkedmapmod.customInventory.CastomInventory;
import io.tobert.reworkedmapmod.customInventory.PlayerCustomArray;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerInventoryMixin implements PlayerCustomArray {
    @Unique
    private CastomInventory extraItems = new CastomInventory(3);

    @Inject(method = "<init>", at = @At("RETURN"))
    public void init(World world, GameProfile profile, CallbackInfo ci) {
        this.extraItems = new CastomInventory(3);
    }

    @Override
    public CastomInventory getExtraItems() {
        return this.extraItems;
    }

    @Override
    public void setExtraItems(CastomInventory array) {
        this.extraItems = array;
    }
}
