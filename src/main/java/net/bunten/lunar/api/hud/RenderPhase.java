package net.bunten.lunar.api.hud;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public enum RenderPhase {
    BEFORE_HUD,
    AFTER_HUD
}