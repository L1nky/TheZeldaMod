package linky.mods.thezeldamod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TheZeldaModCreativeTab extends CreativeTabs
{

    public TheZeldaModCreativeTab(String lable)
    {
        super(lable);
    }

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(TheZeldaMod.itemSandStaff);
    }

    @Override
    public Item getTabIconItem()
    {
        return null;
    }

}
