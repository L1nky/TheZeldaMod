package linky.mods.thezeldamod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TheZeldaModCreativeTab extends CreativeTabs
{

    public TheZeldaModCreativeTab(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(TheZeldaMod.itemBomb);
    }

    @Override
    public Item getTabIconItem()
    {
        return null;
    }

}
