package linky.mods.thezeldamod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemBombBushSeed extends ItemSeeds implements IPlantable
{
    public ItemBombBushSeed()
    {
        super(TheZeldaMod.blockBombBush, Blocks.farmland);
        this.setUnlocalizedName("bombBushSeed");
        this.setTextureName(TheZeldaMod.modID + ":bombbushseed");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }
    
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float preciseX, float preciseY, float preciseZ)
    {
        if (side != 1)
        {
            return false;
        }
        else if (player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y + 1, z, side, itemStack))
        {
            if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z))
            {
                world.setBlock(x, y + 1, z, TheZeldaMod.blockBombBush);
                --itemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
