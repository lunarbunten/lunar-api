package net.bunten.lunar.api.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import net.bunten.lunar.api.hud.HudElement;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class HudElementRegistry {
    
    public static final List<HudElement> ELEMENTS = new ArrayList<>();

    public static void register(HudElement element) {
        Objects.requireNonNull(element);
        ELEMENTS.add(element);
	}
}