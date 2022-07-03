package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;

public class SPacketEntityVelocity implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityID;
    private /* synthetic */ int motionX;
    private /* synthetic */ int motionZ;
    private /* synthetic */ int motionY;
    
    public SPacketEntityVelocity(final int lllllllllllllllIllIIIlllIIIIlllI, double lllllllllllllllIllIIIlllIIIIIlll, double lllllllllllllllIllIIIlllIIIIIllI, double lllllllllllllllIllIIIlllIIIIIlIl) {
        this.entityID = lllllllllllllllIllIIIlllIIIIlllI;
        final double lllllllllllllllIllIIIlllIIIIlIlI = 3.9;
        if (lllllllllllllllIllIIIlllIIIIIlll < -3.9) {
            lllllllllllllllIllIIIlllIIIIIlll = -3.9;
        }
        if (lllllllllllllllIllIIIlllIIIIIllI < -3.9) {
            lllllllllllllllIllIIIlllIIIIIllI = -3.9;
        }
        if (lllllllllllllllIllIIIlllIIIIIlIl < -3.9) {
            lllllllllllllllIllIIIlllIIIIIlIl = -3.9;
        }
        if (lllllllllllllllIllIIIlllIIIIIlll > 3.9) {
            lllllllllllllllIllIIIlllIIIIIlll = 3.9;
        }
        if (lllllllllllllllIllIIIlllIIIIIllI > 3.9) {
            lllllllllllllllIllIIIlllIIIIIllI = 3.9;
        }
        if (lllllllllllllllIllIIIlllIIIIIlIl > 3.9) {
            lllllllllllllllIllIIIlllIIIIIlIl = 3.9;
        }
        this.motionX = (int)(lllllllllllllllIllIIIlllIIIIIlll * 8000.0);
        this.motionY = (int)(lllllllllllllllIllIIIlllIIIIIllI * 8000.0);
        this.motionZ = (int)(lllllllllllllllIllIIIlllIIIIIlIl * 8000.0);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIllIIIllIllllIlII) {
        lllllllllllllllIllIIIllIllllIlII.handleEntityVelocity(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIllIIIllIlllllllI) throws IOException {
        this.entityID = lllllllllllllllIllIIIllIlllllllI.readVarIntFromBuffer();
        this.motionX = lllllllllllllllIllIIIllIlllllllI.readShort();
        this.motionY = lllllllllllllllIllIIIllIlllllllI.readShort();
        this.motionZ = lllllllllllllllIllIIIllIlllllllI.readShort();
    }
    
    public SPacketEntityVelocity(final Entity lllllllllllllllIllIIIlllIIIllIII) {
        this(lllllllllllllllIllIIIlllIIIllIII.getEntityId(), lllllllllllllllIllIIIlllIIIllIII.motionX, lllllllllllllllIllIIIlllIIIllIII.motionY, lllllllllllllllIllIIIlllIIIllIII.motionZ);
    }
    
    public int getMotionZ() {
        return this.motionZ;
    }
    
    public SPacketEntityVelocity() {
    }
    
    public int getMotionX() {
        return this.motionX;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIllIIIllIlllllIII) throws IOException {
        lllllllllllllllIllIIIllIlllllIII.writeVarIntToBuffer(this.entityID);
        lllllllllllllllIllIIIllIlllllIII.writeShort(this.motionX);
        lllllllllllllllIllIIIllIlllllIII.writeShort(this.motionY);
        lllllllllllllllIllIIIllIlllllIII.writeShort(this.motionZ);
    }
    
    public int getMotionY() {
        return this.motionY;
    }
    
    public int getEntityID() {
        return this.entityID;
    }
}
