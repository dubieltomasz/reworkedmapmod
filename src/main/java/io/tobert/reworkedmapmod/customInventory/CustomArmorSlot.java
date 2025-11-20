package io.tobert.reworkedmapmod.customInventory;

import io.tobert.reworkedmapmod.ReworkedMapMod;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class CustomArmorSlot extends Slot {
    private final LivingEntity entity;
    private final EquipmentSlot equipmentSlot;
    @Nullable
    private final Identifier backgroundSprite;

    public CustomArmorSlot(Inventory inventory, LivingEntity entity, EquipmentSlot equipmentSlot, int index, int x, int y, @Nullable Identifier backgroundSprite) {
        super(inventory, index, x, y);
        this.entity = entity;
        this.equipmentSlot = equipmentSlot;
        this.backgroundSprite = backgroundSprite;
    }

    @Override
    public void setStack(ItemStack stack, ItemStack previousStack) {
        this.entity.onEquipStack(this.equipmentSlot, previousStack, stack);

        if(previousStack != ItemStack.EMPTY) {
            previousStack.applyAttributeModifiers(this.equipmentSlot, (attribute, modifier) -> {
                if(this.entity.getAttributeInstance(attribute) != null) {
                    this.entity.getAttributeInstance(attribute).removeModifier(
                            new EntityAttributeModifier(Identifier.of(ReworkedMapMod.MOD_ID.toLowerCase(Locale.ROOT)
                                    + this.equipmentSlot.getName().toLowerCase(Locale.ENGLISH)),
                                    modifier.value(),
                                    modifier.operation()
                            )
                    );
                }
            });
        }

        if(stack != ItemStack.EMPTY) {
            stack.applyAttributeModifiers(this.equipmentSlot, (attribute, modifier) -> {
                if(this.entity.getAttributeInstance(attribute) != null) {
                    this.entity.getAttributeInstance(attribute).addPersistentModifier(
                            new EntityAttributeModifier(Identifier.of(ReworkedMapMod.MOD_ID.toLowerCase(Locale.ENGLISH)
                                    + this.equipmentSlot.getName().toLowerCase(Locale.ENGLISH)),
                                    modifier.value(),
                                    modifier.operation()
                            )
                    );
                }
            });
        }

        super.setStack(stack, previousStack);
    }

    @Override
    public int getMaxItemCount() {
        return 1;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return this.entity.canEquip(stack, this.equipmentSlot);
    }

    @Override
    public boolean isEnabled() {
        return this.entity.canUseSlot(this.equipmentSlot);
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        ItemStack itemStack = this.getStack();
        return !itemStack.isEmpty()
                && !playerEntity.isCreative()
                && EnchantmentHelper.hasAnyEnchantmentsWith(itemStack, EnchantmentEffectComponentTypes.PREVENT_ARMOR_CHANGE)
                ? false
                : super.canTakeItems(playerEntity);
    }

    @Nullable
    @Override
    public Identifier getBackgroundSprite() {
        return this.backgroundSprite;
    }
}
