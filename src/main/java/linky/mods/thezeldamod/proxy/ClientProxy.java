package linky.mods.thezeldamod.proxy;

import net.minecraft.client.renderer.entity.RenderSnowball;
import linky.mods.thezeldamod.common.EntityBomb;
import linky.mods.thezeldamod.common.TheZeldaMod;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderSnowball(TheZeldaMod.itemBomb));
    }
}
