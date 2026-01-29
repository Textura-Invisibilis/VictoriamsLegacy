package gay.invis.victoriamsLegacy.compat;

import net.kindling.impl.tweakfailure.item.CleaverItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VivalentCleaver extends CleaverItem {
    public VivalentCleaver(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings);
    }
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.vividological.vivalent_cleaver_1").formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.vivalent_cleaver_2").formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
    }
}
