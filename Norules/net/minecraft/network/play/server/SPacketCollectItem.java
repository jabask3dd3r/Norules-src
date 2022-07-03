package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketCollectItem implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int collectedItemEntityId;
    private /* synthetic */ int field_191209_c;
    private /* synthetic */ int entityId;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIlIIIlllllIIIlIll) throws IOException {
        this.collectedItemEntityId = lllllllllllllIIIlIIIlllllIIIlIll.readVarIntFromBuffer();
        this.entityId = lllllllllllllIIIlIIIlllllIIIlIll.readVarIntFromBuffer();
        this.field_191209_c = lllllllllllllIIIlIIIlllllIIIlIll.readVarIntFromBuffer();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIlIIIlllllIIIIlIl) throws IOException {
        lllllllllllllIIIlIIIlllllIIIIlIl.writeVarIntToBuffer(this.collectedItemEntityId);
        lllllllllllllIIIlIIIlllllIIIIlIl.writeVarIntToBuffer(this.entityId);
        lllllllllllllIIIlIIIlllllIIIIlIl.writeVarIntToBuffer(this.field_191209_c);
    }
    
    public int getCollectedItemEntityID() {
        return this.collectedItemEntityId;
    }
    
    public SPacketCollectItem(final int lllllllllllllIIIlIIIlllllIIlIlIl, final int lllllllllllllIIIlIIIlllllIIlIlII, final int lllllllllllllIIIlIIIlllllIIlIIll) {
        this.collectedItemEntityId = lllllllllllllIIIlIIIlllllIIlIlIl;
        this.entityId = lllllllllllllIIIlIIIlllllIIlIlII;
        this.field_191209_c = lllllllllllllIIIlIIIlllllIIlIIll;
    }
    
    public SPacketCollectItem() {
    }
    
    public int func_191208_c() {
        return this.field_191209_c;
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIlIIIllllIlllllIl) {
        lllllllllllllIIIlIIIllllIlllllIl.handleCollectItem(this);
    }
}
