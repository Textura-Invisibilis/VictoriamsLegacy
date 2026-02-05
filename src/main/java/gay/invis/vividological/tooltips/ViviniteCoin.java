package gay.invis.vividological.tooltips;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ViviniteCoin extends Item {
    public ViviniteCoin(Settings settings){
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.vividological.vivinite_coin_1").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.vivinite_coin_2").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.vivinite_coin_3").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.vivinite_coin_4").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
    }
    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(0xc7f069));
    }
}
