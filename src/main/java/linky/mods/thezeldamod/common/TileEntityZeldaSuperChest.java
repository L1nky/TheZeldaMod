package linky.mods.thezeldamod.common;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityZeldaSuperChest extends TileEntity
{
    public byte direction;
    private boolean state = false;
    public float angle = 0;

    @Override
    public void updateEntity()
    {
        if(state)
        {
            if(angle < 1)
            {
                angle += 0.1;
            }
        }
        else
        {
            if(angle > 0)
            {
                angle -= 0.1;
            }
        }
        if(angle < 0)
        {
            angle = 0;
        }
        else if(angle > 1)
        {
            angle = 1;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        this.direction = tag.getByte("direction");
        this.state = tag.getBoolean("state");
        this.angle = tag.getFloat("angle");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setByte("direction", this.direction);
        tag.setBoolean("state", this.state);
        tag.setFloat("angle", this.angle);
    }

    public void setDirection(byte direction)
    {
        this.direction = direction;
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        this.readFromNBT(pkt.func_148857_g());
    }

    public void inverse()
    {
        state = !state;
        if(state)
        {
            this.worldObj.playSoundEffect((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }
        else
        {
            this.worldObj.playSoundEffect((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }
    }
}
