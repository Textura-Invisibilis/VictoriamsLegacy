package gay.invis.vividological.tooltips;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ShroudedSteelIngot extends Item {
    public ShroudedSteelIngot(Settings settings){
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.vividological.shrouded_steel_1").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.shrouded_steel_2").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
    }
    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(0x3b3b3b));
    }
}
