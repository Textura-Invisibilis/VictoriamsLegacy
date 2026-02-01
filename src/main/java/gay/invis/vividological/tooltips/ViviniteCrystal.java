package gay.invis.vividological.tooltips;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ViviniteCrystal extends Item {
    public ViviniteCrystal(Settings settings){
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.vividological.raw_vivinite_crystal_1").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.raw_vivinite_crystal_2").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
    }
}
