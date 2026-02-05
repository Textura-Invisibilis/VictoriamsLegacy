package gay.invis.vividological.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import static gay.invis.vividological.effects.VividologicalDamageSources.mercuricPoison;

public class MercuricPoisonEffect extends StatusEffect {

    protected MercuricPoisonEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.HARMFUL, 0x626b60);
    }
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(mercuricPoison(entity), 1.0f);

        return super.applyUpdateEffect(entity, amplifier);
    }
    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the effect every tick
        int i = 20;
        return duration % i == 0;
    }

    // Called when the effect is applied.

}
