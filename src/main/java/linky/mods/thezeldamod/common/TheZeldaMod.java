package linky.mods.thezeldamod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import linky.mods.thezeldamod.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "thezeldamod", name = "The Zelda Mod", version = "1.0.0")
public class TheZeldaMod
{
    @Instance(TheZeldaMod.modID)
    public static TheZeldaMod instance;

    public static final String modID = "thezeldamod";
    
    public static CreativeTabs TheZeldaModCreativeTab = new TheZeldaModCreativeTab("TheZeldaModCreativeTab");
    
    public static Item itemSandStaff;
    public static Item itemSandStaffCore;
    public static Item itemBomb;
    
    public static Block blockSpeSand;
    
    @SidedProxy(clientSide = "linky.mods.thezeldamod.proxy.ClientProxy", serverSide = "linky.mods.thezeldamod.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        itemSandStaff = new ItemSandStaff();
        itemSandStaffCore = new ItemSandStaffCore();
        itemBomb = new ItemBomb();
        
        blockSpeSand = new BlockSpeSand();
        
        GameRegistry.registerItem(itemSandStaff, "sand_staff");
        GameRegistry.registerItem(itemSandStaffCore, "sand_staff_core");
        GameRegistry.registerItem(itemBomb, "bomb");
        
        GameRegistry.registerBlock(blockSpeSand, ItemBlockSpeSand.class, "spe_sand");
        
        EntityRegistry.registerModEntity(EntityBomb.class, "Throwing Rock", 1, this, 64, 10, true);
        
        proxy.registerRenderers();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.addRecipe(new ItemStack(itemSandStaffCore), new Object[]{" X ", "XYX", " X ", 'X', Blocks.sandstone, 'Y', Items.ender_pearl});
        GameRegistry.addRecipe(new ItemStack(itemSandStaff), new Object[]{"  X",  " Y ", "Y  ", 'X', itemSandStaffCore, 'Y', Items.stick});
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }   
}