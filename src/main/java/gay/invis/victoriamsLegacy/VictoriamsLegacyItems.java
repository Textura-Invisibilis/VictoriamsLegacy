package gay.invis.victoriamsLegacy;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class VictoriamsLegacyItems {
        public static Item register(Item item, String id) {
            // Create the identifier for the item.
            Identifier itemID = Identifier.of(VictoriamsLegacy.MOD_ID, id);

            // Register the item.
            Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

            // Return the registered item!
            return registeredItem;
        }

    public static final FoodComponent GLOW_EYE_FOOD_COMPONENT_THING = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(20)
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10 * 20), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 6 * 20), 1.0f)
            .build();

    public static final Item RAW_VICTORINE_CRYSTAL = register(
            new Item(new Item.Settings()),
            "raw_victorine_crystal"
    );
    public static final Item POWDERED_VICTORINE = register(
            new Item(new Item.Settings()),
            "powdered_victorine"
    );
    public static final Item PROCESSED_VICTORINE = register(
            new Item(new Item.Settings()),
            "processed_victorine"
    );
    public static final Item DUSTED_EYE = register(
      new Item(new Item.Settings().food(GLOW_EYE_FOOD_COMPONENT_THING)),
            "dusted_eye"
    );
    public static final Item VICTORINE_DAGGER = register(
            new SwordItem(VictoriamsLegacyVictorineToolMaterial.INSTANCE, new Item.Settings()),
            "victorine_dagger"
    );

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries ->{
                            entries.add(VictoriamsLegacyItems.RAW_VICTORINE_CRYSTAL);
                            entries.add(VictoriamsLegacyItems.PROCESSED_VICTORINE);
                            entries.add(VictoriamsLegacyItems.DUSTED_EYE);
                            entries.add(VictoriamsLegacyItems.POWDERED_VICTORINE);
                        }
                        );
        };

}
