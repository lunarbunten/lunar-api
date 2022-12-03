package net.bunten.lunar.impl.mixin.client;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.bunten.lunar.api.entity.HasTickableSoundInstance;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.entity.Entity;

@Environment(EnvType.CLIENT)
@Mixin(ClientPacketListener.class)
public abstract class AddTickableSoundInstances {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "postAddEntitySoundInstance", at = @At("HEAD"), cancellable = true)
    public void postAddEntitySoundInstance(Entity entity, CallbackInfo info) {
        if (entity instanceof HasTickableSoundInstance tick) {
            minecraft.getSoundManager().queueTickingSound(tick.getTickableSoundInstance());
        }
    }
}