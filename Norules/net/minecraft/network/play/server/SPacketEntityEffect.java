package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.potion.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketEntityEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int duration;
    private /* synthetic */ int entityId;
    private /* synthetic */ byte effectId;
    private /* synthetic */ byte amplifier;
    private /* synthetic */ byte flags;
    
    public byte getEffectId() {
        return this.effectId;
    }
    
    public byte getAmplifier() {
        return this.amplifier;
    }
    
    public boolean doesShowParticles() {
        return (this.flags & 0x2) == 0x2;
    }
    
    public SPacketEntityEffect(final int lllllllllllllIlIIIlIIlIlIIlIllll, final PotionEffect lllllllllllllIlIIIlIIlIlIIlIlllI) {
        this.entityId = lllllllllllllIlIIIlIIlIlIIlIllll;
        this.effectId = (byte)(Potion.getIdFromPotion(lllllllllllllIlIIIlIIlIlIIlIlllI.getPotion()) & 0xFF);
        this.amplifier = (byte)(lllllllllllllIlIIIlIIlIlIIlIlllI.getAmplifier() & 0xFF);
        if (lllllllllllllIlIIIlIIlIlIIlIlllI.getDuration() > 32767) {
            this.duration = 32767;
        }
        else {
            this.duration = lllllllllllllIlIIIlIIlIlIIlIlllI.getDuration();
        }
        this.flags = 0;
        if (lllllllllllllIlIIIlIIlIlIIlIlllI.getIsAmbient()) {
            this.flags |= 0x1;
        }
        if (lllllllllllllIlIIIlIIlIlIIlIlllI.doesShowParticles()) {
            this.flags |= 0x2;
        }
    }
    
    public boolean getIsAmbient() {
        return (this.flags & 0x1) == 0x1;
    }
    
    public SPacketEntityEffect() {
    }
    
    public boolean isMaxDuration() {
        return this.duration == 32767;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIlIIlIlIIlIlIII) throws IOException {
        this.entityId = lllllllllllllIlIIIlIIlIlIIlIlIII.readVarIntFromBuffer();
        this.effectId = lllllllllllllIlIIIlIIlIlIIlIlIII.readByte();
        this.amplifier = lllllllllllllIlIIIlIIlIlIIlIlIII.readByte();
        this.duration = lllllllllllllIlIIIlIIlIlIIlIlIII.readVarIntFromBuffer();
        this.flags = lllllllllllllIlIIIlIIlIlIIlIlIII.readByte();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIIlIIlIlIIIllIll) {
        lllllllllllllIlIIIlIIlIlIIIllIll.handleEntityEffect(this);
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIlIIlIlIIlIIIlI) throws IOException {
        lllllllllllllIlIIIlIIlIlIIlIIIlI.writeVarIntToBuffer(this.entityId);
        lllllllllllllIlIIIlIIlIlIIlIIIlI.writeByte(this.effectId);
        lllllllllllllIlIIIlIIlIlIIlIIIlI.writeByte(this.amplifier);
        lllllllllllllIlIIIlIIlIlIIlIIIlI.writeVarIntToBuffer(this.duration);
        lllllllllllllIlIIIlIIlIlIIlIIIlI.writeByte(this.flags);
    }
    
    public int getDuration() {
        return this.duration;
    }
}
