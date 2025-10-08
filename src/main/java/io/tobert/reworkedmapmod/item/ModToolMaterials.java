package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.registry.ModItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials {
    public static final ToolMaterial EVIL_DIAMOND = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            455, // Durability
            5.0F, // Mining speed
            1.5F, // Additional damage
            22, // Enchantability
            ModItemTags.EVIL_DIAMOND_TOOL_MATERIALS
    );
}
