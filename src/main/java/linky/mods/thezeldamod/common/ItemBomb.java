package linky.mods.thezeldamod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBomb extends Item
{
    public ItemBomb()
    {
        this.setUnlocalizedName("bomb");
        this.setTextureName(TheZeldaMod.modID + ":bomb");
        this.setMaxStackSize(5);
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --itemstack.stackSize;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        // IMPORTANT! Only spawn new entities on the server. If the world is not remote,
        // that means you are on the server:
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityBomb(world, player));
        }

        return itemstack;
    }
}
