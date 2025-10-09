package io.tobert.reworkedmapmod.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static io.tobert.reworkedmapmod.ReworkedMapMod.ofModIdentifier;

/**
 * Class for registering custom data component types
 */
public class ModDataComponentTypes {

    /** Boolean property that is assigned to {@link io.tobert.reworkedmapmod.item.ReworkedMap}. When set to true the tool tip displays that the red pin is present **/
    public static final ComponentType<Boolean> HAS_RED_PIN = register("red_pin", Codec.BOOL);

    public static <T> ComponentType<T> register(String name, PrimitiveCodec<T> codec){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, ofModIdentifier(name), ComponentType.<T>builder().codec(codec).build());
    }

    public static void initialize(){
    }
}
