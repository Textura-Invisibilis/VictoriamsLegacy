package gay.invis.victoriamsLegacy;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VictoriamsLegacy implements ModInitializer {
    public static final String MOD_ID = "victoriams-legacy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("The nation of New Victoriam rides high with the power of new things to tinker with!");
        VictoriamsLegacyItems.initialize();
    }
}
