package gay.invis.vividological.importantTools;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ViviniteOrb extends ThrownItemEntity {
    public ViviniteOrb(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ViviniteOrb(World world, LivingEntity owner) {
        super(null, owner, world); // null will be changed later
    }

    public ViviniteOrb(World world, double x, double y, double z) {
        super(null, x, y, z, world); // null will be changed later
    }
    @Override
    protected Item getDefaultItem(){
        return null;
    }
}
