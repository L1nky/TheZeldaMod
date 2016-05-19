package linky.mods.thezeldamod.client;

import org.lwjgl.opengl.GL11;

import linky.mods.thezeldamod.common.TheZeldaMod;
import linky.mods.thezeldamod.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TESRInventoryRenderer implements ISimpleBlockRenderingHandler
{
    public static ModelClock model = new ModelClock();
    public static ModelZeldaSuperChest model2 = new ModelZeldaSuperChest();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        if(block == TheZeldaMod.blockClock)
        {
            GL11.glPushMatrix();
            GL11.glRotated(180, 0, 1, 0);
            GL11.glTranslated(0, 1, 0);
            GL11.glRotated(180, 0, 0, 1);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TileEntityClockSpecialRenderer.texture);
            model.render();
            GL11.glPopMatrix();
        }
        else if(block == TheZeldaMod.blockZeldaSuperChest)
        {
            GL11.glPushMatrix();
            GL11.glRotated(180, 0, 1, 0);
            GL11.glTranslated(0, 1, 0);
            GL11.glRotated(180, 0, 0, 1);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TileEntityZeldaSuperChestSpecialRenderer.texture);
            model2.render();
            GL11.glPopMatrix();
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return ClientProxy.tesrID;
    }

}
