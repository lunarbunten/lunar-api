package net.bunten.lunar.api.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;

public interface HasTickableSoundInstance {
    
    @Environment(value=EnvType.CLIENT)
    public AbstractTickableSoundInstance getTickableSoundInstance();
}