package linky.mods.thezeldamod.common;

import java.util.List;
import java.util.Random;

import scala.collection.script.Location;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockBombBush extends BlockBush
{
    public static String[] subBlock = new String[] {"bombbush0", "bombbush1", "bombbush2", "bombbush3", "bombbush4", "bombbush5", "bombbush6"};
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray = new IIcon[subBlock.length];

    public BlockBombBush()
    {
        super(Material.plants);
        this.setBlockName("bombBush");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
        float f = 0.45F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 1.6F, 0.5F + f);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return null;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float preciseX, float preciseY, float preciseZ)
    {
        if(world.getBlockMetadata(x, y, z) == 6)
        {
            world.setBlock(x, y, z, TheZeldaMod.blockBombBush, 3, 3);
            if(!player.inventory.addItemStackToInventory(new ItemStack(TheZeldaMod.itemBomb)))
            {
                world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(TheZeldaMod.itemBomb)));
            }
            return true;
        }
        return false;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
    {
        if(3 < metadata && metadata < 7)
        {
            world.newExplosion(new EntityBomb(world), (double)x, (double)y, (double)z, metadata - 3, false, true);
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
    {
        world.newExplosion(new EntityBomb(world), (double)x, (double)y, (double)z, 2, false, true);
    }

    public void updateTick(World world, int x, int y, int z, Random random)
    {
        super.updateTick(world, x, y, z, random);
        if(world.getBlockMetadata(x, y, z) == 6 || world.getBlockLightValue(x, y, z) < 9 || random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0)
        {
            return;
        }
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
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
        if(metadata < 0 || metadata >= BlockBombBush.subBlock.length)
        {
            return this.iconArray[0];
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
}
