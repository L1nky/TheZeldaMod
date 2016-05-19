package linky.mods.thezeldamod.proxy;

import net.minecraft.client.renderer.entity.RenderSnowball;
import linky.mods.thezeldamod.client.TESRInventoryRenderer;
import linky.mods.thezeldamod.client.TileEntityClockSpecialRenderer;
import linky.mods.thezeldamod.client.TileEntityZeldaSuperChestSpecialRenderer;
import linky.mods.thezeldamod.common.EntityBomb;
import linky.mods.thezeldamod.common.TheZeldaMod;
import linky.mods.thezeldamod.common.TileEntityClock;
import linky.mods.thezeldamod.common.TileEntityZeldaSuperChest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public static int tesrID;
    
    @Override
    public void registerRenderers()
    {
        tesrID = RenderingRegistry.getNextAvailableRenderId();
        
        RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderSnowball(TheZeldaMod.itemBomb));
        RenderingRegistry.registerBlockHandler(new TESRInventoryRenderer());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClock.class, new TileEntityClockSpecialRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityZeldaSuperChest.class, new TileEntityZeldaSuperChestSpecialRenderer());
    }
}
