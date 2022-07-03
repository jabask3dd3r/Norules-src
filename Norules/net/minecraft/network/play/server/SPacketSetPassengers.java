package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.entity.*;
import java.util.*;

public class SPacketSetPassengers implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ int[] passengerIds;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllIIIIIlIIlIllIllI) {
        lllllllllllllIllIIIIIlIIlIllIllI.handleSetPassengers(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIIIIIlIIlIlllIlI) throws IOException {
        lllllllllllllIllIIIIIlIIlIlllIlI.writeVarIntToBuffer(this.entityId);
        lllllllllllllIllIIIIIlIIlIlllIlI.writeVarIntArray(this.passengerIds);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIIIIIlIIllIIIIII) throws IOException {
        this.entityId = lllllllllllllIllIIIIIlIIllIIIIII.readVarIntFromBuffer();
        this.passengerIds = lllllllllllllIllIIIIIlIIllIIIIII.readVarIntArray();
    }
    
    public SPacketSetPassengers(final Entity lllllllllllllIllIIIIIlIIllIIlIII) {
        this.entityId = lllllllllllllIllIIIIIlIIllIIlIII.getEntityId();
        final List<Entity> lllllllllllllIllIIIIIlIIllIIlIll = lllllllllllllIllIIIIIlIIllIIlIII.getPassengers();
        this.passengerIds = new int[lllllllllllllIllIIIIIlIIllIIlIll.size()];
        for (int lllllllllllllIllIIIIIlIIllIIlIlI = 0; lllllllllllllIllIIIIIlIIllIIlIlI < lllllllllllllIllIIIIIlIIllIIlIll.size(); ++lllllllllllllIllIIIIIlIIllIIlIlI) {
            this.passengerIds[lllllllllllllIllIIIIIlIIllIIlIlI] = lllllllllllllIllIIIIIlIIllIIlIll.get(lllllllllllllIllIIIIIlIIllIIlIlI).getEntityId();
        }
    }
    
    public SPacketSetPassengers() {
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public int[] getPassengerIds() {
        return this.passengerIds;
    }
}
