package net.minecraft.network.login.client;

import net.minecraft.network.login.*;
import com.mojang.authlib.*;
import java.io.*;
import java.util.*;
import net.minecraft.network.*;

public class CPacketLoginStart implements Packet<INetHandlerLoginServer>
{
    private /* synthetic */ GameProfile profile;
    
    public CPacketLoginStart(final GameProfile lIIl) {
        this.profile = lIIl;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllllllllllllllllll) throws IOException {
        llllllllllllllllllllllllllllllll.writeString(this.profile.getName());
    }
    
    public GameProfile getProfile() {
        return this.profile;
    }
    
    public CPacketLoginStart() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer ll) throws IOException {
        this.profile = new GameProfile((UUID)null, ll.readStringFromBuffer(16));
    }
    
    @Override
    public void processPacket(final INetHandlerLoginServer lllllllllllllllllllllllllllllIIl) {
        lllllllllllllllllllllllllllllIIl.processLoginStart(this);
    }
}
