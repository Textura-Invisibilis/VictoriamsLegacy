package gay.invis.vividological.compat;

import net.kindling.impl.tweakfailure.item.CleaverItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ViviniteCleaver extends CleaverItem {
    public ViviniteCleaver(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings);
    }
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.vividological.vivinite_cleaver_1").formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.vivinite_cleaver_2").formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
    }
    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(0xc7f069));
    }
}
