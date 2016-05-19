package linky.mods.thezeldamod.client;

import linky.mods.thezeldamod.common.TheZeldaMod;
import linky.mods.thezeldamod.common.TileEntityClock;
import linky.mods.thezeldamod.common.TileEntityZeldaSuperChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TileEntityZeldaSuperChestSpecialRenderer extends TileEntitySpecialRenderer
{

    public ModelZeldaSuperChest model = new ModelZeldaSuperChest();
    public static ResourceLocation texture = new ResourceLocation(TheZeldaMod.modID, "textures/models/blocks/ModelZeldaSuperChest.png");
    private float maxAngle = (float)Math.PI/2;

    public TileEntityZeldaSuperChestSpecialRenderer()
    {
        this.func_147497_a(TileEntityRendererDispatcher.instance);
    }

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialRenderTick)
    {
        this.renderTileEntityZeldaSuperChestAt((TileEntityZeldaSuperChest)tile, x, y, z, partialRenderTick);
    }

    private void renderTileEntityZeldaSuperChestAt(TileEntityZeldaSuperChest tile, double x, double y, double z, float partialRenderTick)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + .5, y + 1.5, z + .5);
        GL11.glRotated(180, 0, 0, 1);
        GL11.glRotated(90 * tile.direction + 180, 0, 1, 0);
        this.bindTexture(texture);
        model.topBack1.rotateAngleX = -tile.angle * this.maxAngle;
        model.topBack2.rotateAngleX = 0.837758F - tile.angle * this.maxAngle;
        model.topFront1.rotateAngleX = -tile.angle * this.maxAngle;
        model.topFront2.rotateAngleX = -0.837758F - tile.angle * this.maxAngle;
        model.topTop.rotateAngleX = -tile.angle * this.maxAngle;
        model.topRight1.rotateAngleX = -tile.angle * this.maxAngle;
        model.topRight2.rotateAngleX = -tile.angle * this.maxAngle;
        model.topLeft1.rotateAngleX = -tile.angle * this.maxAngle;
        model.topLeft2.rotateAngleX = -tile.angle * this.maxAngle;
        model.lock.rotateAngleX = -tile.angle * this.maxAngle;
        this.model.render();
        GL11.glPopMatrix();
    }

}
