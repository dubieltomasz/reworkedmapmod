package io.tobert.reworkedmapmod.customInventory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.world.PersistentState;

public class PlayerInventoryState extends PersistentState {
    private NbtCompound data = new NbtCompound();

    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.copyFrom(data);
        return nbt;
    }

    public void readNbt(NbtCompound nbt) {
        data.copyFrom(nbt);
    }

    public void saveInventory(ServerPlayerEntity player, ItemStack[] stacks) {
        NbtList list = new NbtList();
        for (ItemStack stack : stacks) {
            NbtCompound itemNbt = new NbtCompound();
            // Replace the next line with your version’s method:
            stack.METHOD_SERIALIZE_TO_NBT(itemNbt);  // e.g. stack.toNbt(itemNbt) or stack.getNbt().copyTo(itemNbt)
            list.add(itemNbt);
        }
        String key = player.METHOD_GET_UUID_STRING();  // e.g. player.getUuid().toString()
        data.put(key, list);
        markDirty();
    }

    public ItemStack[] loadInventory(ServerPlayerEntity player, int slotCount) {
        String key = player.METHOD_GET_UUID_STRING();
        if (!data.contains(key)) return null;
        NbtList list = data.getList(key, /* compound tag type id */ 10);
        ItemStack[] stacks = new ItemStack[slotCount];
        for (int i = 0; i < Math.min(list.size(), slotCount); i++) {
            if(list.getCompound(i).isPresent()) {
            NbtCompound itemNbt = list.getCompound(i).get();
            }
            // Replace with your version’s deserialize method:
            stacks[i] = ItemStack.METHOD_DESERIALIZE_FROM_NBT(itemNbt);
        }
        return stacks;
    }
}
