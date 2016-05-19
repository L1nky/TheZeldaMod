package linky.mods.thezeldamod.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelZeldaSuperChest extends ModelBase
{
    ModelRenderer baseBack;
    ModelRenderer baseFront;
    ModelRenderer baseRight;
    ModelRenderer baseLeft;
    ModelRenderer baseBottom;
    ModelRenderer topBack1;
    ModelRenderer topFront1;
    ModelRenderer topBack2;
    ModelRenderer topFront2;
    ModelRenderer topTop;
    ModelRenderer topRight1;
    ModelRenderer topLeft1;
    ModelRenderer topRight2;
    ModelRenderer topLeft2;
    ModelRenderer lock;
  
  public ModelZeldaSuperChest()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      baseBack = new ModelRenderer(this, 0, 26);
      baseBack.addBox(0F, 0F, 0F, 14, 5, 1);
      baseBack.setRotationPoint(-7F, 19F, 4F);
      baseBack.setTextureSize(64, 32);
      baseBack.mirror = true;
      setRotation(baseBack, 0F, 0F, 0F);
      baseFront = new ModelRenderer(this, 0, 26);
      baseFront.addBox(0F, 0F, 0F, 14, 5, 1);
      baseFront.setRotationPoint(-7F, 19F, -5F);
      baseFront.setTextureSize(64, 32);
      baseFront.mirror = true;
      setRotation(baseFront, 0F, 0F, 0F);
      baseRight = new ModelRenderer(this, 0, 13);
      baseRight.addBox(0F, 0F, 0F, 1, 5, 8);
      baseRight.setRotationPoint(6F, 19F, -4F);
      baseRight.setTextureSize(64, 32);
      baseRight.mirror = true;
      setRotation(baseRight, 0F, 0F, 0F);
      baseLeft = new ModelRenderer(this, 0, 13);
      baseLeft.addBox(0F, 0F, 0F, 1, 5, 8);
      baseLeft.setRotationPoint(-7F, 19F, -4F);
      baseLeft.setTextureSize(64, 32);
      baseLeft.mirror = true;
      setRotation(baseLeft, 0F, 0F, 0F);
      baseBottom = new ModelRenderer(this, 0, 0);
      baseBottom.addBox(0F, 0F, 0F, 12, 1, 8);
      baseBottom.setRotationPoint(-6F, 23F, -4F);
      baseBottom.setTextureSize(64, 32);
      baseBottom.mirror = true;
      setRotation(baseBottom, 0F, 0F, 0F);
      topBack1 = new ModelRenderer(this, 0, 26);
      topBack1.addBox(-7F, -3F, -1.0F, 14, 3, 1);
      topBack1.setRotationPoint(0F, 19F, 5F);
      topBack1.setTextureSize(64, 32);
      topBack1.mirror = true;
      setRotation(topBack1, 0F, 0F, 0F);
      topFront1 = new ModelRenderer(this, 0, 26);
      topFront1.addBox(-7F, -3F, -10F, 14, 3, 1);
      topFront1.setRotationPoint(0F, 19F, 5F);
      topFront1.setTextureSize(64, 32);
      topFront1.mirror = true;
      setRotation(topFront1, 0F, 0F, 0F);
      topBack2 = new ModelRenderer(this, 0, 26);
      topBack2.addBox(-7F, -6.05F, 1.25F, 14, 4, 1);
      topBack2.setRotationPoint(0F, 19F, 5F);
      topBack2.setTextureSize(64, 32);
      topBack2.mirror = true;
      setRotation(topBack2, 0.837758F, 0F, 0F);
      topFront2 = new ModelRenderer(this, 0, 26);
      topFront2.addBox(-7F, 1.35F, -8.95F, 14, 4, 1);
      topFront2.setRotationPoint(0F, 19F, 5F);
      topFront2.setTextureSize(64, 32);
      topFront2.mirror = true;
      setRotation(topFront2, -0.837758F, 0F, 0F);
      topTop = new ModelRenderer(this, 19, 10);
      topTop.addBox(-7F, -5.75F, -7F, 14, 1, 4);
      topTop.setRotationPoint(0F, 19F, 5F);
      topTop.setTextureSize(64, 32);
      topTop.mirror = true;
      setRotation(topTop, 0F, 0F, 0F);
      topRight1 = new ModelRenderer(this, 31, 16);
      topRight1.addBox(6F, -3F, -9F, 1, 3, 8);
      topRight1.setRotationPoint(0F, 19F, 5F);
      topRight1.setTextureSize(64, 32);
      topRight1.mirror = true;
      setRotation(topRight1, 0F, 0F, 0F);
      topLeft1 = new ModelRenderer(this, 31, 16);
      topLeft1.addBox(-7F, -3F, -9F, 1, 3, 8);
      topLeft1.setRotationPoint(0F, 19F, 5F);
      topLeft1.setTextureSize(64, 32);
      topLeft1.mirror = true;
      setRotation(topLeft1, 0F, 0F, 0F);
      topRight2 = new ModelRenderer(this, 41, 0);
      topRight2.addBox(6F, -5F, -7F, 1, 2, 4);
      topRight2.setRotationPoint(0F, 19F, 5F);
      topRight2.setTextureSize(64, 32);
      topRight2.mirror = true;
      setRotation(topRight2, 0F, 0F, 0F);
      topLeft2 = new ModelRenderer(this, 41, 0);
      topLeft2.addBox(-7F, -5F, -7F, 1, 2, 4);
      topLeft2.setRotationPoint(0F, 19F, 5F);
      topLeft2.setTextureSize(64, 32);
      topLeft2.mirror = true;
      setRotation(topLeft2, 0F, 0F, 0F);
      lock = new ModelRenderer(this, 20, 18);
      lock.addBox(-1F, -2F, -11F, 2, 3, 1);
      lock.setRotationPoint(0F, 19F, 5F);
      lock.setTextureSize(64, 32);
      lock.mirror = true;
      setRotation(lock, 0F, 0F, 0F);
  }
  
  public void render()
  {
    baseBack.render(0.0625F);
    baseFront.render(0.0625F);
    baseRight.render(0.0625F);
    baseLeft.render(0.0625F);
    baseBottom.render(0.0625F);
    topBack1.render(0.0625F);
    topFront1.render(0.0625F);
    topBack2.render(0.0625F);
    topFront2.render(0.0625F);
    topTop.render(0.0625F);
    topRight1.render(0.0625F);
    topLeft1.render(0.0625F);
    topRight2.render(0.0625F);
    topLeft2.render(0.0625F);
    lock.render(0.0625F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
