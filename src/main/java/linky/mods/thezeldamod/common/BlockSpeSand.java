package linky.mods.thezeldamod.common;

import java.util.List;
import java.util.Random;

import scala.Console;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSpeSand extends BlockSand
{

    public static String[] subBlock = new String[] {"speSandBase", "speSandMiddle", "speSandTop", "speRedSandBase", "speRedSandMiddle", "speRedSandTop"};
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray = new IIcon[subBlock.length];
    @SideOnly(Side.CLIENT)
    public IIcon speSand, speRedSand;

    protected BlockSpeSand()
    {
        super();
        this.setBlockName("speSand");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
            this.iconArray[i] = iconRegister.registerIcon(TheZeldaMod.modID + ":" + subBlock[i]);
        }
        speSand = iconRegister.registerIcon(TheZeldaMod.modID + ":speSand");
        speRedSand = iconRegister.registerIcon(TheZeldaMod.modID + ":speRedSand");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata < 0 || metadata >= BlockSpeSand.subBlock.length)
        {
            return this.iconArray[0];
        }
        if(side == 0 || side == 1)
        {
            if(0 <= metadata && metadata < 3)
            {
                return this.speSand;
            }
            else if(3 <= metadata && metadata < 6)
            {
                return this.speRedSand;
            }
        }
        return this.iconArray[metadata];

    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    /*
     * @Override public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) { entity.moveEntity(0, 1, 0); entity.setVelocity(0, 0, 0); }*
     */

    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
    {
        if(metadata % 3 == 2)
        {
            if(world.getBlock(x, y - 1, z) == TheZeldaMod.blockSpeSand)
            {
                if(world.getBlockMetadata(x, y - 1, z) - metadata == -1)
                {
                    world.setBlock(x, y - 1, z, TheZeldaMod.blockSpeSand, metadata, 3);
                }
                else if(world.getBlockMetadata(x, y - 1, z) - metadata == -2)
                {
                    world.setBlock(x, y - 1, z, Blocks.sand);
                }
            }
        }
        else if(metadata % 3 == 0)
        {
            if(world.getBlock(x, y + 1, z) == TheZeldaMod.blockSpeSand)
            {
                if(world.getBlockMetadata(x, y + 1, z) - metadata == 1)
                {
                    world.setBlock(x, y + 1, z, TheZeldaMod.blockSpeSand, metadata, 3);
                }
                else if(world.getBlockMetadata(x, y + 1, z) - metadata == 2)
                {
                    world.setBlock(x, y + 1, z, Blocks.sand);
                }
            }
        }
    }
}
