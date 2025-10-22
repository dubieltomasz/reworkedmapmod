package io.tobert.reworkedmapmod.mixin;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ExampleMixin {
	@Inject(method = "setScreen(Lnet/minecraft/client/gui/screen/Screen;)V", at = @At("TAIL"))
	private void aSetScreen(Screen screen, CallbackInfo ci) {
		if (screen instanceof InventoryScreen) {
			ReworkedMapMod.LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		}
	}
}