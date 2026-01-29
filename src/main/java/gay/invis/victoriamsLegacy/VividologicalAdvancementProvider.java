package gay.invis.victoriamsLegacy;

import gay.invis.victoriamsLegacy.compat.VividologicalTweakfailureCompat;
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
        AdvancementEntry getRawVivalent = Advancement.Builder.create()
                .parent(treeBeginner)
                .display(
                        VividologicalItems.RAW_VIVALENT_CRYSTAL, // The display icon
                        Text.literal("Crystalline Reconstruction"), // The title
                        Text.literal("Do some chemical experiments and manufacture a new mineral"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_raw_vivalent", InventoryChangedCriterion.Conditions.items(VividologicalItems.RAW_VIVALENT_CRYSTAL))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_raw_vivalent");
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
        AdvancementEntry processVivalent = Advancement.Builder.create()
                .parent(getRawVivalent)
                .display(
                        VividologicalItems.VIVALENT_INGOT, // The display icon
                        Text.literal("An Alternative Metallic Substance for Weaponry Reasons"), // The title
                        Text.literal("Process Vivalent into a brand new alloy!"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.GOAL, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_vivalent_ingot", InventoryChangedCriterion.Conditions.items(VividologicalItems.VIVALENT_INGOT))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_vivalent_ingot");
        AdvancementEntry crushedVivalent = Advancement.Builder.create()
                .parent(getRawVivalent)
                .display(
                        VividologicalItems.VIVALENT_DUST, // The display icon
                        Text.literal("Powdered Crystals"), // The title
                        Text.literal("You shouldn't eat these"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_vivalent_dust", InventoryChangedCriterion.Conditions.items(VividologicalItems.VIVALENT_DUST))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_vivalent_dust");
        AdvancementEntry getVivalenticGlaive = Advancement.Builder.create()
                .parent(processVivalent)
                .display(
                        VividologicalItems.VIVALENTIC_GLAIVE, // The display icon
                        Text.literal("Naturally Dangerous"), // The title
                        Text.literal("Craft a Vivalentic Glaive"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_vivalentic_glaive", InventoryChangedCriterion.Conditions.items(VividologicalItems.VIVALENTIC_GLAIVE))
                // Give the advancement an id
                .build(consumer, Vividological.MOD_ID + "/get_vivalentic_glaive");
//        AdvancementEntry getVivalentCleaver = Advancement.Builder.create()
//                .parent(processVivalent)
//                .display(
//                        VividologicalTweakfailureCompat.VIVALENT_CLEAVER, // The display icon
//                        Text.literal("Seemingly Useless"), // The title
//                        Text.literal("Craft a Vivalent Cleaver...is this just for decorative purposes?"), // The description
//                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
//                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
//                        true, // Show the toast when completing it
//                        true, // Announce it to chat
//                        true // Hide it in the advancement tab until it's achieved
//                )
//                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
//                .criterion("got_vivalent_cleaver", InventoryChangedCriterion.Conditions.items(VividologicalItems.VIVALENTIC_GLAIVE))
//                // Give the advancement an id
//                .build(consumer, Vividological.MOD_ID + "/get_vivalent_cleaver");
    }

}
