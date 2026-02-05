package gay.invis.vividological;

import gay.invis.vividological.compat.VividologicalTweakfailureCompat;
import gay.invis.vividological.effects.VividologicalDamageTypes;
import gay.invis.vividological.effects.VividologicalEffects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vividological implements ModInitializer {
    public static final String MOD_ID = "vividological";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        VividologicalItems.initialize();
        VividologicalBlocks.initialize();
        VividologicalEffects.initialize();
        VividologicalItemGroup.initialize();
        VividologicalPotions.initialize();
        if (FabricLoader.getInstance().isModLoaded("tweakfailure")) {
            VividologicalTweakfailureCompat.initialize();
            LOGGER.info("Tweakfailure, you've gained a new friend!");
        } else {
            LOGGER.info("We succeeded at tweaking some things, but something might've happened if we failed...");
        }
    }
    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
