package net.bunten.lunar.impl;

import net.bunten.lunar.api.block.SoundTypeModification;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class SoundTypeModificationImpl {

    public static final List<SoundTypeModification> MODIFICATIONS = new ArrayList<>();
    private static final Map<BlockState, SoundType> SOUND_TYPE_CACHE = new IdentityHashMap<>();

    @Nullable
	public static SoundType getSoundType(BlockState state) {
        @Nullable SoundType cached = SOUND_TYPE_CACHE.get(state);
        if (cached != null) return cached;
        for (SoundTypeModification modification : MODIFICATIONS) {
            if (modification.applies(state)) {
                SoundType replaced = modification.getSoundType();
                SOUND_TYPE_CACHE.putIfAbsent(state, replaced);
                return replaced;
            }
        }
		return null;
	}
}