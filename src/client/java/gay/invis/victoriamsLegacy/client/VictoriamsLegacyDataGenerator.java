package gay.invis.victoriamsLegacy.client;

import gay.invis.victoriamsLegacy.VictoriamsLegacyAdvancementProvider;
import gay.invis.victoriamsLegacy.VictoriamsLegacyItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class VictoriamsLegacyDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(VictoriamsLegacyAdvancementProvider::new);
    }
}
