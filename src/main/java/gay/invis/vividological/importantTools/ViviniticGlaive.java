package gay.invis.vividological.importantTools;

import gay.invis.vividological.toolMaterials.ViviniteToolMaterial;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.util.TypedActionResult.*;

public class ViviniticGlaive extends SwordItem {
    public static final ViviniteToolMaterial INSTANCE = new ViviniteToolMaterial();
    public ViviniticGlaive(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.

		user.getItemCooldownManager().set(this, 45);
        if (world.isClient) {
            return pass(user.getStackInHand(hand));
        }

        BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 5);

        // Spawn the lightning bolt.

        FireballEntity placeholderFireball = new FireballEntity(EntityType.FIREBALL, world);
        placeholderFireball.setPosition(frontOfPlayer.toCenterPos());
        world.spawnEntity(placeholderFireball);

//        LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
//        lightningBolt.setPosition(frontOfPlayer.toCenterPos());
//        world.spawnEntity(lightningBolt);

        // Nothing has changed to the item stack,
        // so we just return it how it was.
        return success(user.getStackInHand(hand));
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.vividological.vivalentic_glaive_1").formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
        tooltip.add(Text.translatable("itemTooltip.vividological.vivalentic_glaive_2").formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
    }
    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(0xc7f069));
    }
}
