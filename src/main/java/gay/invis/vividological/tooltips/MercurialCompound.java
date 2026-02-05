package gay.invis.vividological.tooltips;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class MercurialCompound extends Item {
    public MercurialCompound(Settings settings){
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.vividological.mercurial_compound_1").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
    }
    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(0x9da19c));
    }
}
