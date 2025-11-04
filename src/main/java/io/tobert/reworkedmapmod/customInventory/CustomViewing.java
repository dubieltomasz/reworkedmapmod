package io.tobert.reworkedmapmod.customInventory;

import com.mojang.serialization.Codec;
import net.minecraft.item.ItemStack;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Unique;

import java.util.Optional;

public abstract class CustomViewing implements WriteView, ReadView {
    @Unique
    public DefaultedList<ItemStack> stacks = DefaultedList.ofSize(3);

    public void put(String key, Codec<DefaultedList<ItemStack>> codec, DefaultedList<ItemStack> value) {
        if(key.equals("stacks")) {
            stacks = (DefaultedList<ItemStack>) value;
        }
    }

    @Override
    public <T> Optional<T> read(String key, Codec<T> codec) {
        if(key.equals("stacks")) {
            Optional<DefaultedList<ItemStack>> result = mw;
            result.
            return result;
        }
        return Optional.empty();
    }
}
