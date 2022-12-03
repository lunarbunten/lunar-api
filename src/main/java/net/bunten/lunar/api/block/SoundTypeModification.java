package net.bunten.lunar.api.block;

import java.util.function.Predicate;

import net.minecraft.world.level.block.SoundType;

public class SoundTypeModification {
    private final SoundType soundType;
    private final Predicate<SoundType> predicate;

    public SoundTypeModification(SoundType soundType, Predicate<SoundType> predicate) {
        this.soundType = soundType;
        this.predicate = predicate;
    }

    public SoundType getSoundType() {
        return soundType;
    }

    public boolean applies() {
        return predicate.test(soundType);
    }
}