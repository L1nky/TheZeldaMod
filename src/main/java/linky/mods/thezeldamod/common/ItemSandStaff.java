package linky.mods.thezeldamod.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSandStaff extends Item
{
    public ItemSandStaff()
    {
        this.setUnlocalizedName("sandStaff");
        this.setTextureName(TheZeldaMod.modID + ":sandstaff");
        this.setMaxStackSize(1);
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float preciseX, float preciseY, float preciseZ)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        if(world.getBlock(x, y, z) == Blocks.sand && metadata < 2)
        {
            if(world.getBlock(x, y + 1, z) == Blocks.air || world.getBlock(x, y + 1, z).getMaterial().isLiquid())
            {
                world.setBlock(x, y, z, TheZeldaMod.blockSpeSand, metadata * 3, 3);
                if((world.getBlock(x, y + 2, z) == Blocks.air || world.getBlock(x, y + 2, z).getMaterial().isLiquid())&& !player.isSneaking())
                {
                    world.setBlock(x, y + 1, z, TheZeldaMod.blockSpeSand, metadata * 3 + 1, 3);
                    world.setBlock(x, y + 2, z, TheZeldaMod.blockSpeSand, metadata * 3 + 2, 3);
                }
                else
                {
                    world.setBlock(x, y + 1, z, TheZeldaMod.blockSpeSand, metadata * 3 + 2, 3);
                }
            }
            else
            {
                return false;
            }
        }
        else if(world.getBlock(x, y, z) == TheZeldaMod.blockSpeSand && metadata < 6)
        {
            if(metadata % 3 == 0)
            {
                if(!player.isSneaking())
                {
                    world.setBlock(x, y, z, Blocks.sand, metadata / 3, 3);
                    if(world.getBlock(x, y + 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y + 1, z) == metadata + 1)
                    {
                        world.setBlock(x, y + 1, z, Blocks.air);
                        if(world.getBlock(x, y + 2, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y + 2, z) == metadata + 2)
                        {
                            world.setBlock(x, y + 2, z, Blocks.air);
                        }
                    }
                    else if(world.getBlock(x, y + 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y + 1, z) == metadata + 2)
                    {
                        world.setBlock(x, y + 1, z, Blocks.air);
                    }
                }
                else
                {
                    if(world.getBlock(x, y + 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y + 1, z) - metadata < 3)
                    {
                        if(world.getBlock(x, y + 2, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y + 2, z) == metadata + 2)
                        {
                            world.setBlock(x, y + 2, z, Blocks.air);
                            world.setBlock(x, y + 1, z, TheZeldaMod.blockSpeSand, metadata + 2, 3);
                        }
                        else
                        {
                            world.setBlock(x, y + 1, z, Blocks.air);
                            world.setBlock(x, y, z, Blocks.sand, metadata / 3, 3);
                        }
                    }
                }
            }
            else if(metadata % 3 == 1)
            {
                if(!player.isSneaking())
                {
                    world.setBlock(x, y, z, Blocks.air);
                    if(world.getBlock(x, y + 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y + 1, z) == metadata + 1)
                    {
                        world.setBlock(x, y + 1, z, Blocks.air);
                    }
                    if(world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y - 1, z) == metadata - 1)
                    {
                        world.setBlock(x, y - 1, z, Blocks.sand, (metadata - 1) / 3, 3);
                    }
                }
                else
                {
                    if(world.getBlock(x, y + 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y + 1, z) == metadata + 1 && world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y - 1, z) == metadata - 1)
                    {
                        world.setBlock(x, y + 1, z, Blocks.air);
                        world.setBlock(x, y, z, TheZeldaMod.blockSpeSand, metadata + 1, 3);
                    }
                }
            }
            else if(metadata % 3 == 2)
            {
                if(!player.isSneaking())
                {
                    world.setBlock(x, y, z, Blocks.air);
                    if(world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y - 1, z) == metadata - 1)
                    {
                        world.setBlock(x, y - 1, z, Blocks.air);
                        if(world.getBlock(x, y - 2, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y - 2, z) == metadata - 2)
                        {
                            world.setBlock(x, y - 2, z, Blocks.sand, (metadata - 2) / 3, 3);
                        }
                    }
                    else if(world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y - 1, z) == metadata - 2)
                    {
                        world.setBlock(x, y - 1, z, Blocks.sand, (metadata - 2) / 3, 3);
                    }
                }
                else
                {
                    if(world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand && metadata - world.getBlockMetadata(x, y - 1, z) < 3)
                    {
                        if(world.getBlock(x, y - 2, z) == TheZeldaMod.blockSpeSand && world.getBlockMetadata(x, y - 2, z) == metadata - 2)
                        {
                            world.setBlock(x, y, z, Blocks.air);
                            world.setBlock(x, y - 1, z, TheZeldaMod.blockSpeSand, metadata, 3);
                        }
                        else
                        {
                            world.setBlock(x, y, z, Blocks.air);
                            world.setBlock(x, y - 1, z, Blocks.sand, metadata / 3, 3);
                        }
                    }
                }
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
        world.playSoundAtEntity(player, "dig.sand", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        return true;
    }
}
