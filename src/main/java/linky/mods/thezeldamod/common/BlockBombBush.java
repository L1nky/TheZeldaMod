package linky.mods.thezeldamod.common;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBombBush extends BlockBush
{
    public BlockBombBush()
    {
        super(Material.plants);
        this.setBlockName("bombBush");
        this.setBlockTextureName(TheZeldaMod.modID + ":bombbush");
        this.setCreativeTab(TheZeldaMod.TheZeldaModCreativeTab);
        float f = 0.45F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 1.6F, 0.5F + f);
    }
    

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return TheZeldaMod.itemBomb;
    }
}
