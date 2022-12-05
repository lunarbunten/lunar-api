package net.bunten.lunar.api.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Predicate;

public class SoundTypeModification {
    private final SoundType soundType;
    private final Predicate<BlockState> predicate;

    public SoundTypeModification(SoundType soundType, Predicate<BlockState> predicate) {
        this.soundType = soundType;
        this.predicate = predicate;
    }

    public SoundType getSoundType() {
        return soundType;
    }

    public boolean applies(BlockState block) {
        return predicate.test(block);
    }
}