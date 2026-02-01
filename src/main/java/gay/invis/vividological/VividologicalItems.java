package gay.invis.vividological;

import gay.invis.vividological.importantTools.ViviniticGlaive;
import gay.invis.vividological.toolMaterials.ViviniteToolMaterial;
import gay.invis.vividological.tooltips.ViviniteCrystal;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class VividologicalItems {
        public static Item register(Item item, String id) {
            // Create the identifier for the item.
            Identifier itemID = Identifier.of(Vividological.MOD_ID, id);

            // Register the item.
            Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

            // Return the registered item!
            return registeredItem;
        }

    public static final FoodComponent VIVID_EYE_FOOD_COMPONENT_THING = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(14)
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10 * 20), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 6 * 20), 1.0f)
            .build();

    public static final Item RAW_VIVINITE_CRYSTAL = register(
            new Item(new Item.Settings()),
            "raw_vivinite_crystal"
    );
    public static final Item VIVINITE_DUST = register(
            new Item(new Item.Settings()),
            "vivinite_dust"
    );
    public static final Item CRYSTALLINE_COMPOUND = register(
            new Item(new Item.Settings()),
            "crystalline_compound"
    );
    public static final Item VIVINITE_INGOT = register(
            new ViviniteCrystal(new Item.Settings()),
            "vivinite_ingot"
    );
    public static final Item DUSTED_EYE = register(
      new Item(new Item.Settings().food(VIVID_EYE_FOOD_COMPONENT_THING)),
            "dusted_eye"
    );
    public static final Item SHROUDED_STEEL_INGOT = register(
            new Item(new Item.Settings()),
            "shrouded_steel_ingot"
    );
    public static final Item VIVINITIC_GLAIVE = register(new ViviniticGlaive(ViviniteToolMaterial.INSTANCE,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE)
                            .attributeModifiers(SwordItem.createAttributeModifiers(ViviniteToolMaterial.INSTANCE, 4, -2.7f))),
            "vivinitic_glaive"
            );

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Vividological.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VividologicalItems.VIVINITE_INGOT))
            .displayName(Text.translatable("itemGroup.vividological"))
            .build();

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(VividologicalItems.VIVINITE_DUST);
            itemGroup.add(VividologicalItems.VIVINITE_INGOT);
            itemGroup.add(VividologicalItems.DUSTED_EYE);
            itemGroup.add(VividologicalItems.RAW_VIVINITE_CRYSTAL);
            // ...
        });

    }
}

