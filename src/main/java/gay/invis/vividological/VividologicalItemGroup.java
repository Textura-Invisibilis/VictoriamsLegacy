package gay.invis.vividological;

import de.dafuqs.fractal.api.ItemSubGroup;
import de.dafuqs.fractal.interfaces.ItemGroupParent;
import gay.invis.vividological.compat.VividologicalTweakfailureCompat;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class VividologicalItemGroup {
    public static final Identifier GROUP_ID = Identifier.of("vividological", "main");

    public static final ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VividologicalItems.VIVINITE_INGOT))
            .entries((displayContext, entries) -> {
                entries.add(Items.APPLE, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
                for (ItemSubGroup subGroup : VividologicalItemGroup.MAIN.fractal$getChildren()) {
                    entries.addAll(subGroup.getSearchTabStacks(), ItemGroup.StackVisibility.SEARCH_TAB_ONLY);
                }
            })
            .displayName(Text.translatable("itemGroup.vividological"))
            .noRenderedName()
            .build();

    public static final Identifier ITEM_GROUP_BACKGROUND_TEXTURE_IDENTIFIER = Identifier.of("vividological", "textures/custom_item_group.png");

    public static final ItemGroup EQUIPMENT = new ItemSubGroup.Builder(MAIN, Identifier.of("vividological", "equipment"), Text.translatable("itemGroup.vividological.equipment")).entries(
            (displayContext, entries) -> {
                entries.add(VividologicalItems.VIVINITIC_GLAIVE);
                entries.add(VividologicalTweakfailureCompat.VIVINITE_CLEAVER);
            }).build();
    public static final ItemGroup CUISINE = new ItemSubGroup.Builder(MAIN, Identifier.of("vividological", "cuisine"), Text.translatable("itemGroup.vividological.cuisine")).entries(
            (displayContext, entries) -> {
                entries.add(VividologicalItems.DUSTED_EYE);
            }).build();
    public static final ItemGroup RESOURCES = new ItemSubGroup.Builder(MAIN, Identifier.of("vividological", "resources"), Text.translatable("itemGroup.vividological.resources")).entries(
            (displayContext, entries) -> {
                entries.add(VividologicalItems.RAW_VIVINITE_CRYSTAL);
                entries.add(VividologicalItems.VIVINITE_INGOT);
                entries.add(VividologicalBlocks.COMPACTED_VIVINITE);
                entries.add(VividologicalItems.MERCURIAL_COMPOUND);
                entries.add(VividologicalItems.SHROUDED_STEEL_INGOT);
                entries.add(VividologicalItems.VIVINITE_DUST);
            }).build();
    public static final ItemGroup MISCELLANEOUS = new ItemSubGroup.Builder(MAIN, Identifier.of("vividological", "miscellaneous"), Text.translatable("itemGroup.vividological.miscellaneous")).entries(
            (displayContext, entries) -> {
                entries.add(VividologicalItems.VIVINITE_COIN);
            }).build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, GROUP_ID, MAIN);
    }
}
