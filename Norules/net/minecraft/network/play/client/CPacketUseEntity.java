package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import java.io.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.network.*;

public class CPacketUseEntity implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ Action action;
    private /* synthetic */ EnumHand hand;
    private /* synthetic */ int entityId;
    private /* synthetic */ Vec3d hitVec;
    
    public CPacketUseEntity(final Entity lllllllllllllIIlIllIIIlIlIllllll, final EnumHand lllllllllllllIIlIllIIIlIllIIIIIl) {
        this.entityId = lllllllllllllIIlIllIIIlIlIllllll.getEntityId();
        this.action = Action.INTERACT;
        this.hand = lllllllllllllIIlIllIIIlIllIIIIIl;
    }
    
    public Vec3d getHitVec() {
        return this.hitVec;
    }
    
    public CPacketUseEntity(final Entity lllllllllllllIIlIllIIIlIllIIIlll) {
        this.entityId = lllllllllllllIIlIllIIIlIllIIIlll.getEntityId();
        this.action = Action.ATTACK;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIlIllIIIlIlIlIIllI) throws IOException {
        lllllllllllllIIlIllIIIlIlIlIIllI.writeVarIntToBuffer(this.entityId);
        lllllllllllllIIlIllIIIlIlIlIIllI.writeEnumValue(this.action);
        if (this.action == Action.INTERACT_AT) {
            lllllllllllllIIlIllIIIlIlIlIIllI.writeFloat((float)this.hitVec.xCoord);
            lllllllllllllIIlIllIIIlIlIlIIllI.writeFloat((float)this.hitVec.yCoord);
            lllllllllllllIIlIllIIIlIlIlIIllI.writeFloat((float)this.hitVec.zCoord);
        }
        if (this.action == Action.INTERACT || this.action == Action.INTERACT_AT) {
            lllllllllllllIIlIllIIIlIlIlIIllI.writeEnumValue(this.hand);
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIIlIllIIIlIlIlIIIlI) {
        lllllllllllllIIlIllIIIlIlIlIIIlI.processUseEntity(this);
    }
    
    @Nullable
    public Entity getEntityFromWorld(final World lllllllllllllIIlIllIIIlIlIIlllII) {
        return lllllllllllllIIlIllIIIlIlIIlllII.getEntityByID(this.entityId);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIlIllIIIlIlIlIllII) throws IOException {
        this.entityId = lllllllllllllIIlIllIIIlIlIlIllII.readVarIntFromBuffer();
        this.action = lllllllllllllIIlIllIIIlIlIlIllII.readEnumValue(Action.class);
        if (this.action == Action.INTERACT_AT) {
            this.hitVec = new Vec3d(lllllllllllllIIlIllIIIlIlIlIllII.readFloat(), lllllllllllllIIlIllIIIlIlIlIllII.readFloat(), lllllllllllllIIlIllIIIlIlIlIllII.readFloat());
        }
        if (this.action == Action.INTERACT || this.action == Action.INTERACT_AT) {
            this.hand = lllllllllllllIIlIllIIIlIlIlIllII.readEnumValue(EnumHand.class);
        }
    }
    
    public EnumHand getHand() {
        return this.hand;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    public CPacketUseEntity() {
    }
    
    public CPacketUseEntity(final Entity lllllllllllllIIlIllIIIlIlIllIlII, final EnumHand lllllllllllllIIlIllIIIlIlIllIIll, final Vec3d lllllllllllllIIlIllIIIlIlIllIllI) {
        this.entityId = lllllllllllllIIlIllIIIlIlIllIlII.getEntityId();
        this.action = Action.INTERACT_AT;
        this.hand = lllllllllllllIIlIllIIIlIlIllIIll;
        this.hitVec = lllllllllllllIIlIllIIIlIlIllIllI;
    }
    
    public enum Action
    {
        ATTACK("ATTACK", 1), 
        INTERACT_AT("INTERACT_AT", 2), 
        INTERACT("INTERACT", 0);
        
        private Action(final String llllllllllllllIIlllIIlllIlIIllll, final int llllllllllllllIIlllIIlllIlIIlllI) {
        }
    }
}
