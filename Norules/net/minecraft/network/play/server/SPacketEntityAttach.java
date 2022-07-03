package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.entity.*;
import javax.annotation.*;

public class SPacketEntityAttach implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ int vehicleEntityId;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIIIllllllIllIIIll) {
        lllllllllllllIIIIIllllllIllIIIll.handleEntityAttach(this);
    }
    
    public int getVehicleEntityId() {
        return this.vehicleEntityId;
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIIIllllllIllIlIIl) throws IOException {
        lllllllllllllIIIIIllllllIllIlIIl.writeInt(this.entityId);
        lllllllllllllIIIIIllllllIllIlIIl.writeInt(this.vehicleEntityId);
    }
    
    public SPacketEntityAttach() {
    }
    
    public SPacketEntityAttach(final Entity lllllllllllllIIIIIllllllIlllIlll, @Nullable final Entity lllllllllllllIIIIIllllllIlllIllI) {
        this.entityId = lllllllllllllIIIIIllllllIlllIlll.getEntityId();
        this.vehicleEntityId = ((lllllllllllllIIIIIllllllIlllIllI != null) ? lllllllllllllIIIIIllllllIlllIllI.getEntityId() : -1);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIIIllllllIllIllIl) throws IOException {
        this.entityId = lllllllllllllIIIIIllllllIllIllIl.readInt();
        this.vehicleEntityId = lllllllllllllIIIIIllllllIllIllIl.readInt();
    }
}
