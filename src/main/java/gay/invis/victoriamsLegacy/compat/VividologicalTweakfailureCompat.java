package gay.invis.victoriamsLegacy.compat;

import gay.invis.victoriamsLegacy.Vividological;
import gay.invis.victoriamsLegacy.toolMaterials.VivalenticToolMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kindling.impl.tweakfailure.item.CleaverItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static gay.invis.victoriamsLegacy.VividologicalItems.CUSTOM_ITEM_GROUP;
import static gay.invis.victoriamsLegacy.VividologicalItems.CUSTOM_ITEM_GROUP_KEY;

public class VividologicalTweakfailureCompat {
        public static Item register(Item item, String id) {
            // Create the identifier for the item.
            Identifier itemID = Identifier.of(Vividological.MOD_ID, id);

            // Register the item.
            Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

            // Return the registered item!
            return registeredItem;
        }

    public static final Item VIVALENT_CLEAVER = register(new VivalentCleaver(VivalenticToolMaterial.INSTANCE,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE)
                            .attributeModifiers(SwordItem.createAttributeModifiers(VivalenticToolMaterial.INSTANCE, 3, -2.3f))),
            "vivalent_cleaver"
    );

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(VividologicalTweakfailureCompat.VIVALENT_CLEAVER);
            // ...
        });

    }
}

