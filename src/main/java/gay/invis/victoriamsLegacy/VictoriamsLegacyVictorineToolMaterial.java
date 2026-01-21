package gay.invis.victoriamsLegacy;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class VictoriamsLegacyVictorineToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2045;
    }
    public float getMiningSpeedMultiplier() {
        return 5.0f;
    }
    public float getAttackDamage() {
        return 2.0f;
    }
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_IRON_TOOL;
    }
    public int getEnchantability() {
        return 25;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(VictoriamsLegacyItems.PROCESSED_VICTORINE);
    }

    public static final VictoriamsLegacyVictorineToolMaterial INSTANCE = new VictoriamsLegacyVictorineToolMaterial();
}
