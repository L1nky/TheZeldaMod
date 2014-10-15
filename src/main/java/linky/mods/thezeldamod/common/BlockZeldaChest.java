package linky.mods.thezeldamod.common;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockZeldaChest extends BlockContainer
{
    private final Random random = new Random();
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray = new IIcon[4];

    public BlockZeldaChest()
    {
        super(Material.wood);
        this.setBlockName("zeldaChest");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }
    
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float preciseX, float preciseY, float preciseZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            IInventory iinventory = this.getIInventory(world, x, y, z);

            if (iinventory != null)
            {
                player.displayGUIChest(iinventory);
            }

            return true;
        }
    }

    public IInventory getIInventory(World world, int x, int y, int z)
    {
        Object object = (TileEntityZeldaChest)world.getTileEntity(x, y, z);

        if (object == null)
        {
            return null;
        }
        else if (world.isSideSolid(x, y + 1, z, DOWN))
        {
            return null;
        }
        else
        {
            return (IInventory)object;
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_)
    {
        TileEntityZeldaChest tileentityzeldachest = (TileEntityZeldaChest)world.getTileEntity(x, y, z);

        if (tileentityzeldachest != null)
        {
            for (int i1 = 0; i1 < tileentityzeldachest.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = tileentityzeldachest.getStackInSlot(i1);

                if (itemstack != null)
                {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = this.random.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, p_149749_6_);
    }
    
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        TileEntityZeldaChest tileentityzeldachest = new TileEntityZeldaChest();
        return tileentityzeldachest;
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
