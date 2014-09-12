package linky.mods.thezeldamod.common;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSpeSand extends BlockSand
{

    public static String[] subBlock = new String[] {"speSand", "speRedSand"};
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray = new IIcon[subBlock.length];

    protected BlockSpeSand()
    {
        super();
        this.setBlockName("speSand");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
            this.iconArray[i] = iconRegister.registerIcon(TheZeldaMod.modID + ":" + subBlock[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return this.iconArray[metadata];
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        entity.moveEntity(0, 1, 0);
        entity.setVelocity(0, 0, 0);
    }

    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
    
    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntitySpeSand();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
}
