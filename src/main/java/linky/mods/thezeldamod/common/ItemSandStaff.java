package linky.mods.thezeldamod.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemSandStaff extends Item
{
    public ItemSandStaff()
    {
        this.setUnlocalizedName("sandStaff");
        this.setTextureName(TheZeldaMod.modID + ":sandstaff");
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        if(world.getBlock(x, y, z) == Blocks.sand)
        {
            for(int i = 1; i < 3; i++)
            {
                if(world.getBlock(x, y + i, z) == Blocks.air)
                {
                    if(i == 1)
                    {
                        world.setBlock(x, y, z, TheZeldaMod.blockSpeSand, metadata, 3);
                        TileEntity tile = world.getTileEntity(x, y, z);
                        if(tile instanceof TileEntitySpeSand)
                        {
                            TileEntitySpeSand tileSpeSand = (TileEntitySpeSand)tile;
                            tileSpeSand.setH((byte)0);
                        }
                    }
                    world.setBlock(x, y + i, z, TheZeldaMod.blockSpeSand, metadata, 3);
                    TileEntity tile = world.getTileEntity(x, y + i, z);
                    if(tile instanceof TileEntitySpeSand)
                    {
                        TileEntitySpeSand tileSpeSand = (TileEntitySpeSand)tile;
                        tileSpeSand.setH((byte)i);
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        else if(world.getBlock(x, y, z) == TheZeldaMod.blockSpeSand)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if(tile instanceof TileEntitySpeSand)
            {
                TileEntitySpeSand tileSpeSand = (TileEntitySpeSand)tile;
                byte h = tileSpeSand.getH();
                if(h == 0)
                {
                    world.setBlock(x, y, z, Blocks.sand, metadata, 3);
                    for(int i = 1; i < 3; i++)
                    {
                        if(world.getBlock(x, y + i, z) == TheZeldaMod.blockSpeSand)
                        {
                            world.setBlock(x, y + i, z, Blocks.air);
                        }
                    }
                }
                else if(h == 1)
                {
                    world.setBlock(x, y, z, Blocks.air);
                    if(world.getBlock(x, y + 1, z) == TheZeldaMod.blockSpeSand)
                    {
                        world.setBlock(x, y + 1, z, Blocks.air);
                    }
                    if(world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand)
                    {
                        world.setBlock(x, y - 1, z, Blocks.sand, metadata, 3);
                    }
                }
                else if(h==2)
                {
                    world.setBlock(x, y, z, Blocks.air);
                    if(world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand)
                    {
                        world.setBlock(x, y - 1, z, Blocks.air);
                    }
                    if(world.getBlock(x, y - 2, z) == TheZeldaMod.blockSpeSand)
                    {
                        world.setBlock(x, y - 2, z, Blocks.sand, metadata, 3);
                    }
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }
}
