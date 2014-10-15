package linky.mods.thezeldamod.common;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockZeldaChest extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray = new IIcon[4];

    protected BlockZeldaChest(Material p_i45394_1_)
    {
        super(p_i45394_1_);
        this.setBlockName("ZeldaChest");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.iconArray[0] = iconRegister.registerIcon(TheZeldaMod.modID + ":zeldachestfront");
        this.iconArray[1] = iconRegister.registerIcon(TheZeldaMod.modID + ":zeldachestside");
        this.iconArray[2] = iconRegister.registerIcon(TheZeldaMod.modID + ":zeldachesttop");
        this.iconArray[3] = iconRegister.registerIcon(TheZeldaMod.modID + ":zeldachestbottom");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        switch(side)
        {
            case 0:
                return this.iconArray[3];
            case 1:
                return this.iconArray[2];
            case 2:
                return this.iconArray[metadata == 2 ? 0 : 1];
            case 3:
                return this.iconArray[metadata == 0 ? 0 : 1];
            case 4:
                return this.iconArray[metadata == 1 ? 0 : 1];
            case 5:
                return this.iconArray[metadata == 3 ? 0 : 1];
            default:
                return this.iconArray[0];
        }
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        /**if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.getTileEntity(x, y, z);

            if (tileentitydispenser != null)
            {
                player.openGui(new GuiDispenser(player.inventory, tileentitydispenser), 1, world, x, y, z);
            }

            return true;
        }*/
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            player.displayGUIWorkbench(x, y, z);
            return true;
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityDispenser();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return 0;
    }
}
