package io.tobert.reworkedmapmod;

import io.tobert.reworkedmapmod.block.ModBlocks;
import io.tobert.reworkedmapmod.item.ModItems;
import io.tobert.reworkedmapmod.recipe.ModRecipes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReworkedMapMod implements ModInitializer {
    public static final String MOD_ID = "reworked_map_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ModRecipes.initialize();
    }

    /**
     * This function will change a given String into an identifier in the namespace of this mod.
     *
     * @param name String to convert
     * @return net.minecraft.util.Identifier
     */
    public static Identifier ofModIdentifier(String name) {
        return Identifier.of(MOD_ID, name);
    }
}