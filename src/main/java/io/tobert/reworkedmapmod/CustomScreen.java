package io.tobert.reworkedmapmod;

import net.minecraft.block.MapColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class CustomScreen extends Screen {
    MapColor[][] data;
    public CustomScreen(Text title, MapColor[][] data) {
        super(title);
        this.data = data;
    }

    @Override
    protected void init() {
        ButtonWidget buttonWidget = ButtonWidget.builder(Text.of("Close"), (btn) -> {
            MinecraftClient.getInstance().setScreen(null);
        }).dimensions(340, 220, 100, 20).build();
        this.addDrawableChild(buttonWidget);

        CustomWidget customWidget = new CustomWidget(40, 40, 280, 200, this.data);
        this.addDrawableChild(customWidget);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }
}
