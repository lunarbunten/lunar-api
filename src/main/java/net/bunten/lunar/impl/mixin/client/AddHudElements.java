package net.bunten.lunar.impl.mixin.client;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.vertex.PoseStack;

import net.bunten.lunar.api.hud.RenderPhase;
import net.bunten.lunar.api.registry.HudElementRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public abstract class AddHudElements {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V"
        ),
        slice = @Slice(
            from = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Lighting;setupFor3DItems()V"),
            to = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;renderConfusionOverlay(F)V")
        )
    )
    
    public void render(float f, long l, boolean bl, CallbackInfo info) {
        HudElementRegistry.ELEMENTS.stream().filter((element) -> element.phase == RenderPhase.BEFORE_HUD).forEach((element) -> {
            element.render(new PoseStack(), minecraft.getDeltaFrameTime());
        });
    }
}