package linky.mods.thezeldamod.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBomb extends EntityThrowable
{
    private static final String __OBFID = "CL_00001722";
    private boolean impacted;
    private long tick;

    public EntityBomb(World world)
    {
        super(world);
        this.impacted = false;
        this.tick = 0;
    }

    public EntityBomb(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
        this.impacted = false;
        this.tick = 0;
    }

    public EntityBomb(World world, double double1, double double2, double double3)
    {
        super(world, double1, double2, double3);
        this.impacted = false;
        this.tick = 0;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition)
    {
        if(!impacted)
        {
            if(movingObjectPosition.entityHit != null)
            {
                float bombDamage = 2;
                movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), bombDamage);
            }
            for(int i = 0; i < 8; ++i)
            {
                this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
        this.impacted = true;
    }

    @Override
    public void onUpdate()
    {
        if(!impacted)
            super.onUpdate();
        else
        {
            tick++;
        }
        if(tick > 40 && !this.worldObj.isRemote)
        {
            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 3, true, true);
            this.setDead();
        }
    }
}
