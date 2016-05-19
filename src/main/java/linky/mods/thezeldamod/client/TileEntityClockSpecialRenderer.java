package linky.mods.thezeldamod.client;

import org.lwjgl.opengl.GL11;

import linky.mods.thezeldamod.common.TheZeldaMod;
import linky.mods.thezeldamod.common.TileEntityClock;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityClockSpecialRenderer extends TileEntitySpecialRenderer
{
    public ModelClock model = new ModelClock();
    public static ResourceLocation texture = new ResourceLocation(TheZeldaMod.modID, "textures/models/blocks/ModelClock.png");

    public TileEntityClockSpecialRenderer()
    {
        this.func_147497_a(TileEntityRendererDispatcher.instance);
    }

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialRenderTick)
    {
        this.renderTileEntityClockAt((TileEntityClock)tile, x, y, z, partialRenderTick);
    }

    private void renderTileEntityClockAt(TileEntityClock tile, double x, double y, double z, float partialRenderTick)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + .5, y + 1.3125, z + .5);
        GL11.glRotated(180, 0, 0, 1);
        GL11.glRotated(90 * tile.direction + 180, 0, 1, 0);
        this.bindTexture(texture);
        this.model.minutes.rotateAngleZ = -(float)Math.PI / 2 + (float)(tile.getWorldObj().getWorldTime()+6000) / 500 * (float)Math.PI;
        this.model.hours.rotateAngleZ = -(float)Math.PI / 2 + (float)(tile.getWorldObj().getWorldTime()+6000) / 6000 * (float)Math.PI;
        this.model.render();
        GL11.glPopMatrix();
    }
}
