package linky.mods.thezeldamod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSandStaffCore extends Item
{
    public ItemSandStaffCore()
    {
        this.setUnlocalizedName("sandStaffCore");
        this.setTextureName(TheZeldaMod.modID + ":sandstaffcore");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
        return true;
    }
}
