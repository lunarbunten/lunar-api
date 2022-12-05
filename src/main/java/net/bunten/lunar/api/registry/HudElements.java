package net.bunten.lunar.api.registry;

import java.util.Objects;

import net.bunten.lunar.api.hud.HudElement;
import net.bunten.lunar.impl.HudElementImpl;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class HudElements {

    public static void register(HudElement element) {
        Objects.requireNonNull(element);
        HudElementImpl.ELEMENTS.add(element);
	}
}