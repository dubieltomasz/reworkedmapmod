package io.tobert.reworkedmapmod.item;

import io.tobert.reworkedmapmod.registry.ModItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

/**
 * Class for registering custom tool materials
 */
public class ModToolMaterials {
    /** Material used to register an Evil Diamond tool **/
    public static final ToolMaterial EVIL_DIAMOND = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 455, 5.0F, 1.5F, 22, ModItemTags.EVIL_DIAMOND_TOOL_MATERIALS);
}
