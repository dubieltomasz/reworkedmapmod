package io.tobert.reworkedmapmod.customInventory;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public enum CustomEquipmentSlot implements StringIdentifiable {
    FACE(EquipmentSlot.Type.HUMANOID_ARMOR, 4, 1, 0, "face"),
    BACK(EquipmentSlot.Type.HUMANOID_ARMOR, 5, 1, 1, "back"),
    HANDS(EquipmentSlot.Type.HUMANOID_ARMOR, 6, 1, 2, "hands");

    public static final int NO_MAX_COUNT = 0;
    public static final List<CustomEquipmentSlot> VALUES = List.of(values());
    public static final IntFunction<CustomEquipmentSlot> FROM_INDEX = ValueLists.createIndexToValueFunction(
            (ToIntFunction<CustomEquipmentSlot>) slot -> slot.index, values(), ValueLists.OutOfBoundsHandling.ZERO
    );
    public static final StringIdentifiable.EnumCodec<CustomEquipmentSlot> CODEC = StringIdentifiable.createCodec(CustomEquipmentSlot::values);
    public static final PacketCodec<ByteBuf, CustomEquipmentSlot> PACKET_CODEC = PacketCodecs.indexed(FROM_INDEX, slot -> slot.index);
    private final EquipmentSlot.Type type;
    private final int entityId;
    private final int maxCount;
    private final int index;
    private final String name;

    private CustomEquipmentSlot(final EquipmentSlot.Type type, final int entityId, final int maxCount, final int index, final String name) {
        this.type = type;
        this.entityId = entityId;
        this.maxCount = maxCount;
        this.index = index;
        this.name = name;
    }

    public EquipmentSlot.Type getType() {
        return this.type;
    }

    public int getEntitySlotId() {
        return this.entityId;
    }

    public int getOffsetEntitySlotId(int offset) {
        return offset + this.entityId;
    }

    public ItemStack split(ItemStack stack) {
        return this.maxCount > 0 ? stack.split(this.maxCount) : stack;
    }

    public int getIndex() {
        return this.index;
    }

    public int getOffsetIndex(int offset) {
        return this.index + offset;
    }

    public String getName() {
        return this.name;
    }

    public boolean isArmorSlot() {
        return this.type == EquipmentSlot.Type.HUMANOID_ARMOR || this.type == EquipmentSlot.Type.ANIMAL_ARMOR;
    }

    @Override
    public String asString() {
        return this.name;
    }

    public boolean increasesDroppedExperience() {
        return this.type != EquipmentSlot.Type.SADDLE;
    }

    public static CustomEquipmentSlot byName(String name) {
        CustomEquipmentSlot customEquipmentSlot = (CustomEquipmentSlot)CODEC.byId(name);
        if (customEquipmentSlot != null) {
            return customEquipmentSlot;
        } else {
            throw new IllegalArgumentException("Invalid slot '" + name + "'");
        }
    }
}
