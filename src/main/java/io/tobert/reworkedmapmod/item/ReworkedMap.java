package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.component.ModDataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class ReworkedMap extends Item {

    public ReworkedMap(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if (stack.get(ModDataComponentTypes.HAS_RED_PIN) == null) {
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
            return;
        }

        // Change tooltip if the red pin nbt tag is true
        if (stack.get(ModDataComponentTypes.HAS_RED_PIN)) {
            textConsumer.accept(Text.translatable("Red Pin").formatted(Formatting.RED));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);

        }
    }
}
