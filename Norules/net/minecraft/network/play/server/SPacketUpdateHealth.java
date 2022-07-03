package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketUpdateHealth implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float health;
    private /* synthetic */ int foodLevel;
    private /* synthetic */ float saturationLevel;
    
    public int getFoodLevel() {
        return this.foodLevel;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllllIlllIlIlIIllI) throws IOException {
        this.health = llllllllllllllIllllIlllIlIlIIllI.readFloat();
        this.foodLevel = llllllllllllllIllllIlllIlIlIIllI.readVarIntFromBuffer();
        this.saturationLevel = llllllllllllllIllllIlllIlIlIIllI.readFloat();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIllllIlllIlIIlllII) {
        llllllllllllllIllllIlllIlIIlllII.handleUpdateHealth(this);
    }
    
    public SPacketUpdateHealth(final float llllllllllllllIllllIlllIlIlIlllI, final int llllllllllllllIllllIlllIlIllIIIl, final float llllllllllllllIllllIlllIlIlIllII) {
        this.health = llllllllllllllIllllIlllIlIlIlllI;
        this.foodLevel = llllllllllllllIllllIlllIlIllIIIl;
        this.saturationLevel = llllllllllllllIllllIlllIlIlIllII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllllIlllIlIlIIIII) throws IOException {
        llllllllllllllIllllIlllIlIlIIIII.writeFloat(this.health);
        llllllllllllllIllllIlllIlIlIIIII.writeVarIntToBuffer(this.foodLevel);
        llllllllllllllIllllIlllIlIlIIIII.writeFloat(this.saturationLevel);
    }
    
    public float getHealth() {
        return this.health;
    }
    
    public SPacketUpdateHealth() {
    }
    
    public float getSaturationLevel() {
        return this.saturationLevel;
    }
}
