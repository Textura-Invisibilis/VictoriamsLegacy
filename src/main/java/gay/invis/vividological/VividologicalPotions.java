package gay.invis.vividological;

import gay.invis.vividological.effects.VividologicalEffects;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class VividologicalPotions {
    public static final Potion MERCURY_POTION =
            Registry.register(
                    Registries.POTION,
                    Identifier.of("vividological", "mercuric_poison"),
                    new Potion(
                            new StatusEffectInstance(
                                    VividologicalEffects.MERCURIC_TOXICITY,
                                    3600,
                                    0)));

    public static void initialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    // Input potion.
                    Potions.AWKWARD,
                    // Ingredient
                    VividologicalItems.MERCURIAL_COMPOUND,
                    // Output potion.
                    Registries.POTION.getEntry(MERCURY_POTION)
            );
        });
    }
}
