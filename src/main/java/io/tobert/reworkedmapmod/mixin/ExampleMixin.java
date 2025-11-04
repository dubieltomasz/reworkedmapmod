package io.tobert.reworkedmapmod.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gl.RenderPipelines;

@Mixin(InventoryScreen.class)
public abstract class ExampleMixin extends HandledScreen {
	public ExampleMixin(ScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}

	@Inject(method = "drawBackground", at = @At("TAIL"))
	private void onDrawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY, CallbackInfo ci) {
		int offsetX = 8 + 18 + 50; //padding + first slot + player model window
		int offsetY = 7; //padding
		drawSlot(context, this.x + offsetX, this.y + offsetY);
		drawSlot(context, this.x + offsetX, this.y + offsetY + 18);
		drawSlot(context, this.x + offsetX, this.y + offsetY + 18 * 2);
	}

	@Unique
	private void drawSlot(DrawContext context, int x, int y) {
		context.drawTexture(RenderPipelines.GUI_TEXTURED, Identifier.ofVanilla("textures/gui/sprites/container/slot.png"), x, y, 0.0f, 0.0f, 18, 18, 18, 18);
	}
}