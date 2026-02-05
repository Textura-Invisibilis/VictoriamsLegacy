package gay.invis.vividological;

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

public class VividologicalAdvancementProvider extends FabricAdvancementProvider {
    public VividologicalAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super (output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry treeBeginner = Advancement.Builder.create()
                .display(
                        Items.QUARTZ, // The display icon
                        Text.literal("Vividological"), // The title
                        Text.literal("Serving you deadly weapons and modest amounts of materials since 2025"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("vividological_advancement_tree", InventoryChangedCriterion.Conditions.items(Items.QUARTZ))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/vividological_advancement_starter");
        AdvancementEntry getRawVivinite = Advancement.Builder.create()
                .parent(treeBeginner)
                .display(
                        VividologicalItems.RAW_VIVINITE_CRYSTAL, // The display icon
                        Text.literal("Crystalline Reconstruction"), // The title
                        Text.literal("Do some chemical experiments and manufacture a new mineral"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_raw_vivinite", InventoryChangedCriterion.Conditions.items(VividologicalItems.RAW_VIVINITE_CRYSTAL))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_raw_vivinite");
        AdvancementEntry getShroudedSteel = Advancement.Builder.create()
                .parent(treeBeginner)
                .display(
                        VividologicalItems.SHROUDED_STEEL_INGOT, // The display icon
                        Text.literal("Forged Material of a Quiet Variety"), // The title
                        Text.literal("Create a material of stealth"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_shrouded_steel", InventoryChangedCriterion.Conditions.items(VividologicalItems.SHROUDED_STEEL_INGOT))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_shrouded_steel");
        AdvancementEntry processVivinite = Advancement.Builder.create()
                .parent(getRawVivinite)
                .display(
                        VividologicalItems.VIVINITE_INGOT, // The display icon
                        Text.literal("An Alternative Metallic Substance for Weaponry Reasons"), // The title
                        Text.literal("Process Vivinite into a brand new alloy!"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.GOAL, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_vivinite_ingot", InventoryChangedCriterion.Conditions.items(VividologicalItems.VIVINITE_INGOT))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_vivinite_ingot");
        AdvancementEntry crushedVivinite = Advancement.Builder.create()
                .parent(getRawVivinite)
                .display(
                        VividologicalItems.VIVINITE_DUST, // The display icon
                        Text.literal("Powdered Crystals"), // The title
                        Text.literal("You shouldn't eat these"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_vivinite_dust", InventoryChangedCriterion.Conditions.items(VividologicalItems.VIVINITE_DUST))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_vivinite_dust");
        AdvancementEntry getViviniticGlaive = Advancement.Builder.create()
                .parent(processVivinite)
                .display(
                        VividologicalItems.VIVINITIC_GLAIVE, // The display icon
                        Text.literal("Naturally Dangerous"), // The title
                        Text.literal("Craft a Vivinitic Glaive"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_vivinitic_glaive", InventoryChangedCriterion.Conditions.items(VividologicalItems.VIVINITIC_GLAIVE))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_vivinitic_glaive");
        AdvancementEntry getMercury = Advancement.Builder.create()
                .parent(treeBeginner)
                .display(
                        VividologicalItems.MERCURIAL_COMPOUND, // The display icon
                        Text.literal("Toxic Situation"), // The title
                        Text.literal("Create an unknown compound"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_mercury", InventoryChangedCriterion.Conditions.items(VividologicalItems.MERCURIAL_COMPOUND))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_mercury");
    }

}
