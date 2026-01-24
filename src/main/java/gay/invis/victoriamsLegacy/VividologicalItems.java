package gay.invis.victoriamsLegacy;

import gay.invis.victoriamsLegacy.toolMaterials.VivalenticToolMaterial;
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
            .saturationModifier(20)
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10 * 20), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 6 * 20), 1.0f)
            .build();

    public static final Item RAW_VIVALENT_CRYSTAL = register(
            new Item(new Item.Settings()),
            "raw_vivalent_crystal"
    );
    public static final Item VIVALENT_DUST = register(
            new Item(new Item.Settings()),
            "vivalent_dust"
    );
    public static final Item CRYSTALLINE_COMPOUND = register(
            new Item(new Item.Settings()),
            "crystalline_compound"
    );
    public static final Item VIVALENT_INGOT = register(
            new Item(new Item.Settings()),
            "vivalent_ingot"
    );
    public static final Item DUSTED_EYE = register(
      new Item(new Item.Settings().food(VIVID_EYE_FOOD_COMPONENT_THING)),
            "dusted_eye"
    );
    public static final Item VIVALENTIC_GLAIVE = register(
            new SwordItem(VivalenticToolMaterial.INSTANCE, new Item.Settings()),
            "vivalentic_glaive"
    );
    public static final Item SHROUDED_STEEL_INGOT = register(
            new Item(new Item.Settings()),
            "shrouded_steel_ingot"
    );

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Vividological.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VividologicalItems.VIVALENT_INGOT))
            .displayName(Text.translatable("itemGroup.vividological"))
            .build();

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(VividologicalItems.VIVALENT_DUST);
            itemGroup.add(VividologicalItems.VIVALENT_INGOT);
            itemGroup.add(VividologicalItems.DUSTED_EYE);
            itemGroup.add(VividologicalItems.RAW_VIVALENT_CRYSTAL);
            itemGroup.add(VividologicalItems.VIVALENTIC_GLAIVE);
            // ...
        });

    }
}

