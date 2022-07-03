package net.minecraft.server.integrated;

import net.minecraft.server.management.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import java.net.*;
import com.mojang.authlib.*;

public class IntegratedPlayerList extends PlayerList
{
    private /* synthetic */ NBTTagCompound hostPlayerData;
    
    @Override
    protected void writePlayerData(final EntityPlayerMP lllllllllllllIlIIlIIIIIIllIIllll) {
        if (lllllllllllllIlIIlIIIIIIllIIllll.getName().equals(this.getServerInstance().getServerOwner())) {
            this.hostPlayerData = lllllllllllllIlIIlIIIIIIllIIllll.writeToNBT(new NBTTagCompound());
        }
        super.writePlayerData(lllllllllllllIlIIlIIIIIIllIIllll);
    }
    
    @Override
    public IntegratedServer getServerInstance() {
        return (IntegratedServer)super.getServerInstance();
    }
    
    public IntegratedPlayerList(final IntegratedServer lllllllllllllIlIIlIIIIIIllIlIlIl) {
        super(lllllllllllllIlIIlIIIIIIllIlIlIl);
        this.setViewDistance(10);
    }
    
    @Override
    public NBTTagCompound getHostPlayerData() {
        return this.hostPlayerData;
    }
    
    @Override
    public String allowUserToConnect(final SocketAddress lllllllllllllIlIIlIIIIIIllIIlIII, final GameProfile lllllllllllllIlIIlIIIIIIllIIIlll) {
        return (lllllllllllllIlIIlIIIIIIllIIIlll.getName().equalsIgnoreCase(this.getServerInstance().getServerOwner()) && this.getPlayerByUsername(lllllllllllllIlIIlIIIIIIllIIIlll.getName()) != null) ? "That name is already taken." : super.allowUserToConnect(lllllllllllllIlIIlIIIIIIllIIlIII, lllllllllllllIlIIlIIIIIIllIIIlll);
    }
}
