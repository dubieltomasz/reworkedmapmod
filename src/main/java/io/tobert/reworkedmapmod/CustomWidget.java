package io.tobert.reworkedmapmod;

import net.minecraft.block.MapColor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;

public class CustomWidget extends ClickableWidget {
    MapColor[][] data;

    public CustomWidget(int x, int y, int width, int height, MapColor[][] data) {
        super(x, y, width, height, Text.empty());
        this.data = data;
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        int startColor = 0xFF00FF00; // Green
        int endColor = 0xFF0000FF; // Blue

        //context.fillGradient(getX(), getY(), getX() + this.width, getY() + this.height, startColor, endColor);
        double width = this.width / 5.0;
        double height = this.height / 5.0;

        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                context.fill(getX() + (int) width * i, getY() + (int) height * j, getX() + (int) width * (i + 1), getY() + (int) height * (j + 1), data[i][j].color + 0xFF000000);
            }
        }
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
        return;
    }
}
