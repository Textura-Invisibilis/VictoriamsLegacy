package gay.invis.vividological.effects;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class VividologicalDamageTypes {
    public static final RegistryKey<DamageType> MERCURIC_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("vividological", "mercuric_poison"));

    public static void initialize() {
        // ...
    }
}
