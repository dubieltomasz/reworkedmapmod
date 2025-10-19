package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.CustomScreen;
import io.tobert.reworkedmapmod.component.ModDataComponentTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ReworkedMap extends Item {
    MapColor[][] data;
    public ReworkedMap(Settings settings) {
        super(settings);
        data = new MapColor[5][5];
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
            MinecraftClient.getInstance().setScreen(
                    new CustomScreen(Text.empty(), data)
            );
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if (stack.get(ModDataComponentTypes.HAS_RED_PIN) == null) {
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
            return;
        }

        // Change tooltip if the red pin nbt tag is true
        if (stack.get(ModDataComponentTypes.HAS_RED_PIN)) {
            textConsumer.accept(Text.translatable("Red Pin").formatted(Formatting.DARK_RED));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        int x = entity.getBlockX();
        int z = entity.getBlockZ();
        MapColor[][] a = new MapColor[5][5];

        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                BlockState blockState = world.getBlockState(new BlockPos(x - 2 + i, entity.getBlockY(), z - 2 + j));
                a[i][j] = blockState.getMapColor(world, new BlockPos(x - 2 + i, entity.getBlockY(), z - 2 + j));
            }
        }

        this.data = a;
    }
}
