package gay.invis.victoriamsLegacy;

import gay.invis.victoriamsLegacy.compat.VividologicalTweakfailureCompat;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vividological implements ModInitializer {
    public static final String MOD_ID = "vividological";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("The nation of New Victoriam rides high with the power of new things to tinker with!");
        VividologicalItems.initialize();
        VividologicalBlocks.initialize();
        if (FabricLoader.getInstance().isModLoaded("tweakfailure")) {
            VividologicalTweakfailureCompat.initialize();
        }
    }
}
