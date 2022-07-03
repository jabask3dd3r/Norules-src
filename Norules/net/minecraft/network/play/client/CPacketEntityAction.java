package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.entity.*;

public class CPacketEntityAction implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ Action action;
    private /* synthetic */ int auxData;
    private /* synthetic */ int entityID;
    
    public CPacketEntityAction() {
    }
    
    public Action getAction() {
        return this.action;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lIllllIIllIlIll) throws IOException {
        this.entityID = lIllllIIllIlIll.readVarIntFromBuffer();
        this.action = lIllllIIllIlIll.readEnumValue(Action.class);
        this.auxData = lIllllIIllIlIll.readVarIntFromBuffer();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lIllllIIlIlllll) {
        lIllllIIlIlllll.processEntityAction(this);
    }
    
    public int getAuxData() {
        return this.auxData;
    }
    
    public CPacketEntityAction(final Entity lIllllIlIIIIIIl, final Action lIllllIlIIIIIII) {
        this(lIllllIlIIIIIIl, lIllllIlIIIIIII, 0);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lIllllIIllIIlll) throws IOException {
        lIllllIIllIIlll.writeVarIntToBuffer(this.entityID);
        lIllllIIllIIlll.writeEnumValue(this.action);
        lIllllIIllIIlll.writeVarIntToBuffer(this.auxData);
    }
    
    public CPacketEntityAction(final Entity lIllllIIlllIIll, final Action lIllllIIlllIllI, final int lIllllIIlllIlIl) {
        this.entityID = lIllllIIlllIIll.getEntityId();
        this.action = lIllllIIlllIllI;
        this.auxData = lIllllIIlllIlIl;
    }
    
    public enum Action
    {
        STOP_RIDING_JUMP("STOP_RIDING_JUMP", 6), 
        START_FALL_FLYING("START_FALL_FLYING", 8), 
        STOP_SNEAKING("STOP_SNEAKING", 1), 
        STOP_SPRINTING("STOP_SPRINTING", 4), 
        OPEN_INVENTORY("OPEN_INVENTORY", 7), 
        START_SPRINTING("START_SPRINTING", 3), 
        START_RIDING_JUMP("START_RIDING_JUMP", 5), 
        START_SNEAKING("START_SNEAKING", 0), 
        STOP_SLEEPING("STOP_SLEEPING", 2);
        
        private Action(final String llllllllllllllIlllllIIllIllIlIlI, final int llllllllllllllIlllllIIllIllIlIIl) {
        }
    }
}
