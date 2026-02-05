package gay.invis.vividological.effects;

import gay.invis.vividological.Vividological;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class VividologicalDamageSources {
    static RegistryKey<DamageType> MERCURIC_POISON = of("mercuric_poison");

    static DamageSource mercuricPoison(LivingEntity entity) {
        return entity.getDamageSources().create(MERCURIC_POISON);
    }

    private static RegistryKey<DamageType> of(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Vividological.id(name));
    }
}
