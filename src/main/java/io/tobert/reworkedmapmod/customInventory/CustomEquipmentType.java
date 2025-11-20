package io.tobert.reworkedmapmod.customInventory;

import com.mojang.serialization.Codec;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.util.StringIdentifiable;

public enum CustomEquipmentType implements StringIdentifiable {
    MASK(CustomEquipmentSlot.FACE, 10, "mask"),
    BACKPACK(CustomEquipmentSlot.BACK, 14, "backpack"),
    GLOVES(CustomEquipmentSlot.HANDS, 13, "gloves");

    public static final Codec<CustomEquipmentType> CODEC = StringIdentifiable.createBasicCodec(CustomEquipmentType::values);
    private final CustomEquipmentSlot equipmentSlot;
    private final String name;
    private final int baseMaxDamage;

    private CustomEquipmentType(final CustomEquipmentSlot equipmentSlot, final int baseMaxDamage, final String name) {
        this.equipmentSlot = equipmentSlot;
        this.name = name;
        this.baseMaxDamage = baseMaxDamage;
    }

    public int getMaxDamage(int multiplier) {
        return this.baseMaxDamage * multiplier;
    }

    public CustomEquipmentSlot getEquipmentSlot() {
        return this.equipmentSlot;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
