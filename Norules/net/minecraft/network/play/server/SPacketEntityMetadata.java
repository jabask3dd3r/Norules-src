package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.network.datasync.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketEntityMetadata implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ List<EntityDataManager.DataEntry<?>> dataManagerEntries;
    private /* synthetic */ int entityId;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIIlIlllIIIlllIl) throws IOException {
        lllllllllllllIlIIIIlIlllIIIlllIl.writeVarIntToBuffer(this.entityId);
        EntityDataManager.writeEntries(this.dataManagerEntries, lllllllllllllIlIIIIlIlllIIIlllIl);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIIlIlllIIlIIIIl) throws IOException {
        this.entityId = lllllllllllllIlIIIIlIlllIIlIIIIl.readVarIntFromBuffer();
        this.dataManagerEntries = EntityDataManager.readEntries(lllllllllllllIlIIIIlIlllIIlIIIIl);
    }
    
    public List<EntityDataManager.DataEntry<?>> getDataManagerEntries() {
        return this.dataManagerEntries;
    }
    
    public SPacketEntityMetadata(final int lllllllllllllIlIIIIlIlllIIlIlIIl, final EntityDataManager lllllllllllllIlIIIIlIlllIIlIllII, final boolean lllllllllllllIlIIIIlIlllIIlIIlll) {
        this.entityId = lllllllllllllIlIIIIlIlllIIlIlIIl;
        if (lllllllllllllIlIIIIlIlllIIlIIlll) {
            this.dataManagerEntries = lllllllllllllIlIIIIlIlllIIlIllII.getAll();
            lllllllllllllIlIIIIlIlllIIlIllII.setClean();
        }
        else {
            this.dataManagerEntries = lllllllllllllIlIIIIlIlllIIlIllII.getDirty();
        }
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public SPacketEntityMetadata() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIIIlIlllIIIlIlll) {
        lllllllllllllIlIIIIlIlllIIIlIlll.handleEntityMetadata(this);
    }
}
