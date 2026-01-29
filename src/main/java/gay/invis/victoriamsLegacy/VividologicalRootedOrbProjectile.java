package gay.invis.victoriamsLegacy;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.item.BowItem;
import net.minecraft.item.EggItem;

public class VividologicalRootedOrbProjectile extends ThrownItemEntity {
    public VividologicalRootedOrbProjectile(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public VividologicalRootedOrbProjectile(World world, LivingEntity owner) {
        super(null, owner, world);
    }
    public VividologicalRootedOrbProjectile(World world, double x, double y, double z) {
        super(null, x, y, z, world);
    }
    protected Item getDefaultItem() {
        return null;
    }
}
