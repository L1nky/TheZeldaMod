package linky.mods.thezeldamod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSelen extends Block
{

    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray = new IIcon[5];

    public BlockSelen()
    {
        super(Material.rock);
        this.setBlockName("selen");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < 5; i++)
        {
            this.iconArray[i] = iconRegister.registerIcon(TheZeldaMod.modID + ":selen" + i);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(side == 0 || side == 1)
        {
            return this.iconArray[4];
        }
        return this.iconArray[(side + metadata) % 4];
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }
}
