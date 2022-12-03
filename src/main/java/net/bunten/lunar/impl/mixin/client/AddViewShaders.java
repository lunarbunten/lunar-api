package net.bunten.lunar.impl.mixin.client;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.bunten.lunar.api.entity.HasViewShader;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public abstract class AddViewShaders {

    @Shadow
    abstract void loadEffect(ResourceLocation location);

    @Inject(method = "checkEntityPostEffect", at = @At("TAIL"), cancellable = true)
    public void checkEntityPostEffect(@Nullable Entity entity, CallbackInfo info) {
        if (entity instanceof HasViewShader has) {
            loadEffect(has.getViewShaderLocation());
        }
    }
}