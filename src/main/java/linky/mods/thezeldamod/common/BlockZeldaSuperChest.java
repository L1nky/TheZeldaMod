package linky.mods.thezeldamod.common;

import linky.mods.thezeldamod.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockZeldaSuperChest extends Block
{

    protected BlockZeldaSuperChest()
    {
        super(Material.wood);
        this.setBlockName("zeldaSuperChest");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
        this.setBlockTextureName(TheZeldaMod.modID + ":zeldasuperchest");
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityZeldaSuperChest)
        {
            int direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
            ((TileEntityZeldaSuperChest)tile).setDirection((byte)direction);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float preciseX, float preciseY, float preciseZ)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityZeldaSuperChest)
        {
            TileEntityZeldaSuperChest tileChest = (TileEntityZeldaSuperChest)tile;
            tileChest.inverse();
            return true;
        }
        return false;
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntityZeldaSuperChest();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return ClientProxy.tesrID;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

}
