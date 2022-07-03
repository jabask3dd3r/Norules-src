package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import javax.annotation.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketCamera implements Packet<INetHandlerPlayClient>
{
    public /* synthetic */ int entityId;
    
    public SPacketCamera(final Entity lllllllllllllllIIIllIlIIIllllllI) {
        this.entityId = lllllllllllllllIIIllIlIIIllllllI.getEntityId();
    }
    
    @Nullable
    public Entity getEntity(final World lllllllllllllllIIIllIlIIIllIIllI) {
        return lllllllllllllllIIIllIlIIIllIIllI.getEntityByID(this.entityId);
    }
    
    public SPacketCamera() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIllIlIIIlllIlII) throws IOException {
        lllllllllllllllIIIllIlIIIlllIlII.writeVarIntToBuffer(this.entityId);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIllIlIIIllllIII) throws IOException {
        this.entityId = lllllllllllllllIIIllIlIIIllllIII.readVarIntFromBuffer();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIIllIlIIIllIllII) {
        lllllllllllllllIIIllIlIIIllIllII.handleCamera(this);
    }
}
