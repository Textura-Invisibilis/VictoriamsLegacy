package gay.invis.vividological;

import gay.invis.vividological.compat.VividologicalTweakfailureCompat;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vividological implements ModInitializer {
    public static final String MOD_ID = "vividological";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        VividologicalItems.initialize();
        VividologicalBlocks.initialize();
        if (FabricLoader.getInstance().isModLoaded("tweakfailure")) {
            VividologicalTweakfailureCompat.initialize();
            LOGGER.info("Tweakfailure, you've gained a new friend!");
        } else {
            LOGGER.info("<< This mod is incomplete. Maybe try failing to tweak something?");
        }
    }
}
