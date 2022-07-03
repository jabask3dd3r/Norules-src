package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketSetExperience implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int level;
    private /* synthetic */ int totalExperience;
    private /* synthetic */ float experienceBar;
    
    public float getExperienceBar() {
        return this.experienceBar;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllIIIlllIIIIIl) throws IOException {
        this.experienceBar = lllIIIlllIIIIIl.readFloat();
        this.level = lllIIIlllIIIIIl.readVarIntFromBuffer();
        this.totalExperience = lllIIIlllIIIIIl.readVarIntFromBuffer();
    }
    
    public int getLevel() {
        return this.level;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllIIIllIllIIll) {
        lllIIIllIllIIll.handleSetExperience(this);
    }
    
    public SPacketSetExperience(final float lllIIIlllIIIlll, final int lllIIIlllIIIllI, final int lllIIIlllIIlIIl) {
        this.experienceBar = lllIIIlllIIIlll;
        this.totalExperience = lllIIIlllIIIllI;
        this.level = lllIIIlllIIlIIl;
    }
    
    public int getTotalExperience() {
        return this.totalExperience;
    }
    
    public SPacketSetExperience() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllIIIllIlllIll) throws IOException {
        lllIIIllIlllIll.writeFloat(this.experienceBar);
        lllIIIllIlllIll.writeVarIntToBuffer(this.level);
        lllIIIllIlllIll.writeVarIntToBuffer(this.totalExperience);
    }
}
