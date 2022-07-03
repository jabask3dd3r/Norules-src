package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.util.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import javax.annotation.*;

public class CPacketSpectate implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ UUID id;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlllIllIlIIIIIIlI) throws IOException {
        llllllllllllllIIlllIllIlIIIIIIlI.writeUuid(this.id);
    }
    
    public CPacketSpectate() {
    }
    
    public CPacketSpectate(final UUID llllllllllllllIIlllIllIlIIIlIIII) {
        this.id = llllllllllllllIIlllIllIlIIIlIIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIlllIllIIlllllllI) {
        llllllllllllllIIlllIllIIlllllllI.handleSpectate(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlllIllIlIIIIlIlI) throws IOException {
        this.id = llllllllllllllIIlllIllIlIIIIlIlI.readUuid();
    }
    
    @Nullable
    public Entity getEntity(final WorldServer llllllllllllllIIlllIllIIlllllIII) {
        return llllllllllllllIIlllIllIIlllllIII.getEntityFromUuid(this.id);
    }
}
