package net.skn.sparkprogression.components;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.skn.sparkprogression.SKNsProgression;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<Boolean> TIPPED = // requires diamond
            register("tipped", booleanBuilder -> booleanBuilder.codec(Codec.BOOL));
    public static final ComponentType<Boolean> SHARPENED = // requires quartz
            register("sharpened", booleanBuilder -> booleanBuilder.codec(Codec.BOOL));
    public static final ComponentType<Boolean> SOULBOUND = // requires echo shard
            register("soulbound", booleanBuilder -> booleanBuilder.codec(Codec.BOOL));
    public static final ComponentType<Boolean> EFFICIENT = // requires idk
            register("efficient", booleanBuilder -> booleanBuilder.codec(Codec.BOOL));
    public static final ComponentType<Boolean> PROTECTED = // requires Idk either
            register("protected", booleanBuilder -> booleanBuilder.codec(Codec.BOOL));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(SKNsProgression.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }
    public static void registerDataComponentTypes() {
        SKNsProgression.LOGGER.info("Registering Data Components for " + SKNsProgression.MOD_ID);
    }
}
