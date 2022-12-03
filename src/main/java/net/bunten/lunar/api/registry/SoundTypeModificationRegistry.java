package net.bunten.lunar.api.registry;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;

import net.bunten.lunar.api.block.SoundTypeModification;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class SoundTypeModificationRegistry {

    public static final Map<ResourceLocation, SoundTypeModification> MODIFICATIONS = new IdentityHashMap<>();

    public static void register(ResourceLocation location, SoundTypeModification modification) {
        Objects.requireNonNull(location);
		Objects.requireNonNull(modification);
        MODIFICATIONS.putIfAbsent(location, modification);
	}

    @Nullable
	public static SoundType getSoundType(Block block) {
        ResourceLocation location = Registry.BLOCK.getKey(block);
        SoundTypeModification modification = MODIFICATIONS.get(location);
        if (modification != null && modification.applies()) {
            return modification.getSoundType();
        }
		return null;
	}
}