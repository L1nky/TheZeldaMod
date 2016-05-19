
package linky.mods.thezeldamod.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClock extends ModelBase
{
    ModelRenderer base;
    ModelRenderer left1;
    ModelRenderer right1;
    ModelRenderer right2;
    ModelRenderer left2;
    ModelRenderer mid;
    ModelRenderer minutes;
    ModelRenderer hours;
    ModelRenderer top;
  
  public ModelClock()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      base = new ModelRenderer(this, 0, 0);
      base.addBox(0F, 0F, 0F, 16, 5, 16);
      base.setRotationPoint(-8F, 16F, -8F);
      base.setTextureSize(64, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      left1 = new ModelRenderer(this, 0, 24);
      left1.addBox(0F, 0F, 0F, 1, 6, 16);
      left1.setRotationPoint(-8F, 10F, -8F);
      left1.setTextureSize(64, 64);
      left1.mirror = true;
      setRotation(left1, 0F, 0F, 0F);
      right1 = new ModelRenderer(this, 0, 24);
      right1.addBox(0F, 0F, 0F, 1, 6, 16);
      right1.setRotationPoint(7F, 10F, -8F);
      right1.setTextureSize(64, 64);
      right1.mirror = true;
      setRotation(right1, 0F, 0F, 0F);
      right2 = new ModelRenderer(this, 0, 24);
      right2.addBox(0F, 0F, 0.01F, 1, 6, 16);
      right2.setRotationPoint(8F, 10F, -8F);
      right2.setTextureSize(64, 64);
      right2.mirror = true;
      setRotation(right2, 0F, 0F, 2.426008F);
      left2 = new ModelRenderer(this, 0, 24);
      left2.addBox(-1F, 0F, 0.01F, 1, 6, 16);
      left2.setRotationPoint(-8F, 10F, -8F);
      left2.setTextureSize(64, 64);
      left2.mirror = true;
      setRotation(left2, 0F, 0F, -2.426008F);
      mid = new ModelRenderer(this, 35, 25);
      mid.addBox(0F, 0F, 0F, 8, 8, 1);
      mid.setRotationPoint(-4F, 8F, -8F);
      mid.setTextureSize(64, 64);
      mid.mirror = true;
      setRotation(mid, 0F, 0F, 0F);
      minutes = new ModelRenderer(this, 35, 36);
      minutes.addBox(-0.5F, -0.5F, 0F, 5, 1, 1);
      minutes.setRotationPoint(0F, 12F, -9F);
      minutes.setTextureSize(64, 64);
      minutes.mirror = true;
      setRotation(minutes, 0F, 0F, -1.570796F);
      hours = new ModelRenderer(this, 35, 40);
      hours.addBox(-0.5F, -0.5F, -0.1F, 3, 1, 1);
      hours.setRotationPoint(0F, 12F, -9F);
      hours.setTextureSize(64, 64);
      hours.mirror = true;
      setRotation(hours, 0F, 0F, -3.14485F);
      top = new ModelRenderer(this, 0, 47);
      top.addBox(0F, 0F, 0F, 8, 1, 16);
      top.setRotationPoint(-4F, 5.5F, -8F);
      top.setTextureSize(64, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
  }
  
  public void render()
  {
    base.render(0.0625F);
    left1.render(0.0625F);
    right1.render(0.0625F);
    right2.render(0.0625F);
    left2.render(0.0625F);
    mid.render(0.0625F);
    minutes.render(0.0625F);
    hours.render(0.0625F);
    top.render(0.0625F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
