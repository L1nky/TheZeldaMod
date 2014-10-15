package linky.mods.thezeldamod.common;

import net.minecraft.item.Item;

public class ItemMasterSword extends Item
{
    public ItemMasterSword()
    {
        this.setUnlocalizedName("masterSword");
        this.setTextureName(TheZeldaMod.modID + ":mastersword");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
    }
}
