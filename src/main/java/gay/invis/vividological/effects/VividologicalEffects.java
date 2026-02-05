package gay.invis.vividological.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class VividologicalEffects {
    public static final RegistryEntry<StatusEffect> MERCURIC_TOXICITY;

    static {
        MERCURIC_TOXICITY = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("vividological","mercuric_poison"), new MercuricPoisonEffect());
    }
    public static void initialize() {
        // ...
    }
}
