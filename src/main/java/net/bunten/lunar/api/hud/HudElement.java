package net.bunten.lunar.api.hud;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;

@Environment(EnvType.CLIENT)
public abstract class HudElement extends GuiComponent {

    public final RenderPhase phase;

    public HudElement(RenderPhase phase) {
        this.phase = phase;
        
        if (phase == RenderPhase.AFTER_HUD) HudRenderCallback.EVENT.register(this::render);
        ClientTickEvents.START_CLIENT_TICK.register(client -> tick());
    }

    protected final Minecraft client = Minecraft.getInstance();
    protected int width;
    protected int height;

    public abstract void render(PoseStack matrix, float delta);

    public void tick() {
        if (client.isPaused()) return;

        width = client.getWindow().getGuiScaledWidth();
        height = client.getWindow().getGuiScaledHeight();
    }
}