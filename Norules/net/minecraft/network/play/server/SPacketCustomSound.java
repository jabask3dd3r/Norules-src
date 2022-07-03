package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketCustomSound implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float pitch;
    private /* synthetic */ String soundName;
    private /* synthetic */ SoundCategory category;
    private /* synthetic */ int y;
    private /* synthetic */ float volume;
    private /* synthetic */ int z;
    private /* synthetic */ int x;
    
    public SPacketCustomSound() {
        this.y = Integer.MAX_VALUE;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public SPacketCustomSound(final String llllllllllllllIIllIIIlllllIIIllI, final SoundCategory llllllllllllllIIllIIIlllllIIIlIl, final double llllllllllllllIIllIIIlllllIIllII, final double llllllllllllllIIllIIIlllllIIIIll, final double llllllllllllllIIllIIIlllllIIlIlI, final float llllllllllllllIIllIIIlllllIIIIIl, final float llllllllllllllIIllIIIlllllIIIIII) {
        this.y = Integer.MAX_VALUE;
        Validate.notNull((Object)llllllllllllllIIllIIIlllllIIIllI, "name", new Object[0]);
        this.soundName = llllllllllllllIIllIIIlllllIIIllI;
        this.category = llllllllllllllIIllIIIlllllIIIlIl;
        this.x = (int)(llllllllllllllIIllIIIlllllIIllII * 8.0);
        this.y = (int)(llllllllllllllIIllIIIlllllIIIIll * 8.0);
        this.z = (int)(llllllllllllllIIllIIIlllllIIlIlI * 8.0);
        this.volume = llllllllllllllIIllIIIlllllIIIIIl;
        this.pitch = llllllllllllllIIllIIIlllllIIIIII;
    }
    
    public float getVolume() {
        return this.volume;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIllIIIllllIllIlII) throws IOException {
        llllllllllllllIIllIIIllllIllIlII.writeString(this.soundName);
        llllllllllllllIIllIIIllllIllIlII.writeEnumValue(this.category);
        llllllllllllllIIllIIIllllIllIlII.writeInt(this.x);
        llllllllllllllIIllIIIllllIllIlII.writeInt(this.y);
        llllllllllllllIIllIIIllllIllIlII.writeInt(this.z);
        llllllllllllllIIllIIIllllIllIlII.writeFloat(this.volume);
        llllllllllllllIIllIIIllllIllIlII.writeFloat(this.pitch);
    }
    
    public double getY() {
        return this.y / 8.0f;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIllIIIllllIllllII) throws IOException {
        this.soundName = llllllllllllllIIllIIIllllIllllII.readStringFromBuffer(256);
        this.category = llllllllllllllIIllIIIllllIllllII.readEnumValue(SoundCategory.class);
        this.x = llllllllllllllIIllIIIllllIllllII.readInt();
        this.y = llllllllllllllIIllIIIllllIllllII.readInt();
        this.z = llllllllllllllIIllIIIllllIllllII.readInt();
        this.volume = llllllllllllllIIllIIIllllIllllII.readFloat();
        this.pitch = llllllllllllllIIllIIIllllIllllII.readFloat();
    }
    
    public double getZ() {
        return this.z / 8.0f;
    }
    
    public SoundCategory getCategory() {
        return this.category;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIllIIIllllIIllIll) {
        llllllllllllllIIllIIIllllIIllIll.handleCustomSound(this);
    }
    
    public String getSoundName() {
        return this.soundName;
    }
    
    public double getX() {
        return this.x / 8.0f;
    }
}
