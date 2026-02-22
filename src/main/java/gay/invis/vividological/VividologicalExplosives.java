package gay.invis.vividological;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VividologicalExplosives extends FireballEntity {
    public VividologicalExplosives(EntityType<? extends FireballEntity> entityType, World world) {
        super(entityType, world);
    }
    public VividologicalExplosives(World world, LivingEntity owner, Vec3d velocity, int explodePower) {
        super(world, owner, velocity, explodePower);
    }
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onBlockCollision(BlockState state) { // called on collision with a block
        super.onBlockCollision(state);
        if (!this.getWorld().isClient) { // checks if the world is client
            this.getWorld().sendEntityStatus(this, (byte)3); // particle?

            this.kill(); // kills the projectile
        }
    }
}
