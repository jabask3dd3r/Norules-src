package net.minecraft.network.login.server;

import net.minecraft.network.login.*;
import com.mojang.authlib.*;
import java.util.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketLoginSuccess implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ GameProfile profile;
    
    public GameProfile getProfile() {
        return this.profile;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIllIIllllIIlllI) throws IOException {
        final String llllllllllllllIIlIllIIllllIlIIlI = llllllllllllllIIlIllIIllllIIlllI.readStringFromBuffer(36);
        final String llllllllllllllIIlIllIIllllIlIIIl = llllllllllllllIIlIllIIllllIIlllI.readStringFromBuffer(16);
        final UUID llllllllllllllIIlIllIIllllIlIIII = UUID.fromString(llllllllllllllIIlIllIIllllIlIIlI);
        this.profile = new GameProfile(llllllllllllllIIlIllIIllllIlIIII, llllllllllllllIIlIllIIllllIlIIIl);
    }
    
    public SPacketLoginSuccess() {
    }
    
    public SPacketLoginSuccess(final GameProfile llllllllllllllIIlIllIIllllIlllII) {
        this.profile = llllllllllllllIIlIllIIllllIlllII;
    }
    
    @Override
    public void processPacket(final INetHandlerLoginClient llllllllllllllIIlIllIIlllIllllII) {
        llllllllllllllIIlIllIIlllIllllII.handleLoginSuccess(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIllIIllllIIIIll) throws IOException {
        final UUID llllllllllllllIIlIllIIllllIIIlIl = this.profile.getId();
        llllllllllllllIIlIllIIllllIIIIll.writeString((llllllllllllllIIlIllIIllllIIIlIl == null) ? "" : llllllllllllllIIlIllIIllllIIIlIl.toString());
        llllllllllllllIIlIllIIllllIIIIll.writeString(this.profile.getName());
    }
}
