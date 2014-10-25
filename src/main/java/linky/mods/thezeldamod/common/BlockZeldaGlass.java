package linky.mods.thezeldamod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockZeldaGlass extends Block
{
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray = new IIcon[16];

    public BlockZeldaGlass()
    {
        super(Material.glass);
        this.setBlockName("zeldaGlass");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < 16; i++)
        {
            this.iconArray[i] = iconRegister.registerIcon(TheZeldaMod.modID + ":zeldaGlass" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        int textureNumber = 0;
        boolean[] neighbourType = new boolean[6];
        neighbourType[0] = world.getBlock(x, y - 1, z) == this;
        neighbourType[1] = world.getBlock(x, y + 1, z) == this;
        neighbourType[2] = world.getBlock(x - 1, y, z) == this;
        neighbourType[3] = world.getBlock(x + 1, y, z) == this;
        neighbourType[4] = world.getBlock(x, y, z - 1) == this;
        neighbourType[5] = world.getBlock(x, y, z + 1) == this;
        switch(side)
        {
            case 0:
                if(!neighbourType[2])
                {
                    textureNumber += 1;
                    if(!neighbourType[5])
                    {
                        
                    }
                }
                if(!neighbourType[3])
                {
                    textureNumber += 4;
                }
                if(!neighbourType[4])
                {
                    textureNumber += 8;
                }
                if(!neighbourType[5])
                {
                    textureNumber += 2;
                }
                return this.iconArray[textureNumber];
            case 1:
                if(!neighbourType[2])
                {
                    textureNumber += 1;
                }
                if(!neighbourType[3])
                {
                    textureNumber += 4;
                }
                if(!neighbourType[4])
                {
                    textureNumber += 8;
                }
                if(!neighbourType[5])
                {
                    textureNumber += 2;
                }
                return this.iconArray[textureNumber];
            case 2:
                if(!neighbourType[0])
                {
                    textureNumber += 2;
                }
                if(!neighbourType[1])
                {
                    textureNumber += 8;
                }
                if(!neighbourType[2])
                {
                    textureNumber += 4;
                }
                if(!neighbourType[3])
                {
                    textureNumber += 1;
                }
                return this.iconArray[textureNumber];
            case 3:
                if(!neighbourType[0])
                {
                    textureNumber += 2;
                }
                if(!neighbourType[1])
                {
                    textureNumber += 8;
                }
                if(!neighbourType[2])
                {
                    textureNumber += 1;
                }
                if(!neighbourType[3])
                {
                    textureNumber += 4;
                }
                return this.iconArray[textureNumber];
            case 4:
                if(!neighbourType[0])
                {
                    textureNumber += 2;
                }
                if(!neighbourType[1])
                {
                    textureNumber += 8;
                }
                if(!neighbourType[4])
                {
                    textureNumber += 1;
                }
                if(!neighbourType[5])
                {
                    textureNumber += 4;
                }
                return this.iconArray[textureNumber];
            case 5:
                if(!neighbourType[0])
                {
                    textureNumber += 2;
                }
                if(!neighbourType[1])
                {
                    textureNumber += 8;
                }
                if(!neighbourType[4])
                {
                    textureNumber += 4;
                }
                if(!neighbourType[5])
                {
                    textureNumber += 1;
                }
                return this.iconArray[textureNumber];
            default:
                return this.iconArray[15];
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return this.iconArray[15];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
    {
        if (world.getBlock(x, y, z) == this)
        {
            return false;
        }
        return true;
    }

    public boolean isBlockSolid(IBlockAccess world, int x, int y, int z, int side)
    {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

}
