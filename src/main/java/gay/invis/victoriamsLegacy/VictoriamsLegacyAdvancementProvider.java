package gay.invis.victoriamsLegacy;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class VictoriamsLegacyAdvancementProvider extends FabricAdvancementProvider {
    public VictoriamsLegacyAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super (output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getRawVivalent = Advancement.Builder.create()
                .display(
                        VictoriamsLegacyItems.RAW_VIVALENT_CRYSTAL, // The display icon
                        Text.literal("Crystalline Reconstruction"), // The title
                        Text.literal("Use the power of raw electricity to create a new mineral"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_raw_vivalent", InventoryChangedCriterion.Conditions.items(VictoriamsLegacyItems.RAW_VIVALENT_CRYSTAL))
                // Give the advancement an id
                .build(consumer, VictoriamsLegacy.MOD_ID + "/get_raw_vivalent");
        AdvancementEntry processVivalent = Advancement.Builder.create()
                .parent(getRawVivalent)
                .display(
                        VictoriamsLegacyItems.VIVALENT_INGOT, // The display icon
                        Text.literal("An Alternative Metallic Substance for Weaponry Reasons"), // The title
                        Text.literal("Process a Vivalent Crystal into some Vivalentic Alloy!"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_dirt", InventoryChangedCriterion.Conditions.items(Items.DIRT))
                // Give the advancement an id
                .build(consumer, VictoriamsLegacy.MOD_ID + "/get_dirt");
    }

}
