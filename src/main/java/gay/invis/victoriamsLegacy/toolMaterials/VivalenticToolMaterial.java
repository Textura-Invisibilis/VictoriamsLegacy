package gay.invis.victoriamsLegacy.toolMaterials;

import gay.invis.victoriamsLegacy.VictoriamsLegacyItems;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class VivalenticToolMaterial implements ToolMaterial {
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
        return Ingredient.ofItems(VictoriamsLegacyItems.VIVALENT_INGOT);
    }

    public static final VivalenticToolMaterial INSTANCE = new VivalenticToolMaterial();
}
