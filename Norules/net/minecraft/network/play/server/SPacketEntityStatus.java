package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class SPacketEntityStatus implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ byte logicOpcode;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIlllIlllIlllIIIlI) {
        lllllllllllllllIlllIlllIlllIIIlI.handleEntityStatus(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlllIlllIllllIlll) throws IOException {
        this.entityId = lllllllllllllllIlllIlllIllllIlll.readInt();
        this.logicOpcode = lllllllllllllllIlllIlllIllllIlll.readByte();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlllIlllIlllIlIll) throws IOException {
        lllllllllllllllIlllIlllIlllIlIll.writeInt(this.entityId);
        lllllllllllllllIlllIlllIlllIlIll.writeByte(this.logicOpcode);
    }
    
    public SPacketEntityStatus() {
    }
    
    public byte getOpCode() {
        return this.logicOpcode;
    }
    
    public Entity getEntity(final World lllllllllllllllIlllIlllIllIlIlIl) {
        return lllllllllllllllIlllIlllIllIlIlIl.getEntityByID(this.entityId);
    }
    
    public SPacketEntityStatus(final Entity lllllllllllllllIlllIlllIlllllllI, final byte lllllllllllllllIlllIlllIllllllIl) {
        this.entityId = lllllllllllllllIlllIlllIlllllllI.getEntityId();
        this.logicOpcode = lllllllllllllllIlllIlllIllllllIl;
    }
}
