package linky.mods.thezeldamod.common;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySpeSand extends TileEntity
{
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.h = compound.getByte("H");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setByte("H", this.h);
    }

    public byte getH()
    {
        return this.h;
    }
    
    public void setH(byte h)
    {
        this.h = h;
    }
    
    private byte h;
}
