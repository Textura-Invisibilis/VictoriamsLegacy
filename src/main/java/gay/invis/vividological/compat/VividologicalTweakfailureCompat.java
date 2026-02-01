package gay.invis.vividological.compat;

import gay.invis.vividological.Vividological;
import gay.invis.vividological.toolMaterials.ViviniteToolMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static gay.invis.vividological.VividologicalItems.CUSTOM_ITEM_GROUP;
import static gay.invis.vividological.VividologicalItems.CUSTOM_ITEM_GROUP_KEY;

public class VividologicalTweakfailureCompat {
        public static Item register(Item item, String id) {
            // Create the identifier for the item.
            Identifier itemID = Identifier.of(Vividological.MOD_ID, id);

            // Register the item.
            Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

            // Return the registered item!
            return registeredItem;
        }

    public static final Item VIVINITE_CLEAVER = register(new ViviniteCleaver(ViviniteToolMaterial.INSTANCE,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE)
                            .attributeModifiers(SwordItem.createAttributeModifiers(ViviniteToolMaterial.INSTANCE, 0, -2.3f))),
            "vivinite_cleaver"
    );

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(VividologicalTweakfailureCompat.VIVINITE_CLEAVER);
            // ...
        });

    }
}

