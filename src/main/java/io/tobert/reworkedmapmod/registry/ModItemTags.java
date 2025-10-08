package io.tobert.reworkedmapmod.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static io.tobert.reworkedmapmod.ReworkedMapMod.ofModIdentifier;

public final class ModItemTags {

    public static final TagKey<Item> REPAIRS_EVIL_ARMOR = TagKey.of(RegistryKeys.ITEM, ofModIdentifier("repairs_evil_diamond_armor"));
    public static final TagKey<Item> EVIL_DIAMOND_TOOL_MATERIALS = TagKey.of(RegistryKeys.ITEM, ofModIdentifier("repairs_evil_diamond_armor"));
}
