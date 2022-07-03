package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import java.io.*;
import org.apache.commons.lang3.*;
import net.minecraft.network.*;

public class SPacketSoundEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int posX;
    private /* synthetic */ int posZ;
    private /* synthetic */ SoundEvent sound;
    private /* synthetic */ float soundVolume;
    private /* synthetic */ float soundPitch;
    private /* synthetic */ SoundCategory category;
    private /* synthetic */ int posY;
    
    public SoundCategory getCategory() {
        return this.category;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIlIlllIllIlIIIll) throws IOException {
        this.sound = SoundEvent.REGISTRY.getObjectById(lllllllllllllIllIlIlllIllIlIIIll.readVarIntFromBuffer());
        this.category = lllllllllllllIllIlIlllIllIlIIIll.readEnumValue(SoundCategory.class);
        this.posX = lllllllllllllIllIlIlllIllIlIIIll.readInt();
        this.posY = lllllllllllllIllIlIlllIllIlIIIll.readInt();
        this.posZ = lllllllllllllIllIlIlllIllIlIIIll.readInt();
        this.soundVolume = lllllllllllllIllIlIlllIllIlIIIll.readFloat();
        this.soundPitch = lllllllllllllIllIlIlllIllIlIIIll.readFloat();
    }
    
    public float getVolume() {
        return this.soundVolume;
    }
    
    public double getY() {
        return this.posY / 8.0f;
    }
    
    public double getZ() {
        return this.posZ / 8.0f;
    }
    
    public float getPitch() {
        return this.soundPitch;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllIlIlllIllIIIIlII) {
        lllllllllllllIllIlIlllIllIIIIlII.handleSoundEffect(this);
    }
    
    public double getX() {
        return this.posX / 8.0f;
    }
    
    public SPacketSoundEffect() {
    }
    
    public SPacketSoundEffect(final SoundEvent lllllllllllllIllIlIlllIllIlIllll, final SoundCategory lllllllllllllIllIlIlllIllIllIllI, final double lllllllllllllIllIlIlllIllIlIllIl, final double lllllllllllllIllIlIlllIllIlIllII, final double lllllllllllllIllIlIlllIllIlIlIll, final float lllllllllllllIllIlIlllIllIlIlIlI, final float lllllllllllllIllIlIlllIllIllIIIl) {
        Validate.notNull((Object)lllllllllllllIllIlIlllIllIlIllll, "sound", new Object[0]);
        this.sound = lllllllllllllIllIlIlllIllIlIllll;
        this.category = lllllllllllllIllIlIlllIllIllIllI;
        this.posX = (int)(lllllllllllllIllIlIlllIllIlIllIl * 8.0);
        this.posY = (int)(lllllllllllllIllIlIlllIllIlIllII * 8.0);
        this.posZ = (int)(lllllllllllllIllIlIlllIllIlIlIll * 8.0);
        this.soundVolume = lllllllllllllIllIlIlllIllIlIlIlI;
        this.soundPitch = lllllllllllllIllIlIlllIllIllIIIl;
    }
    
    public SoundEvent getSound() {
        return this.sound;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIlIlllIllIIlllIl) throws IOException {
        lllllllllllllIllIlIlllIllIIlllIl.writeVarIntToBuffer(SoundEvent.REGISTRY.getIDForObject(this.sound));
        lllllllllllllIllIlIlllIllIIlllIl.writeEnumValue(this.category);
        lllllllllllllIllIlIlllIllIIlllIl.writeInt(this.posX);
        lllllllllllllIllIlIlllIllIIlllIl.writeInt(this.posY);
        lllllllllllllIllIlIlllIllIIlllIl.writeInt(this.posZ);
        lllllllllllllIllIlIlllIllIIlllIl.writeFloat(this.soundVolume);
        lllllllllllllIllIlIlllIllIIlllIl.writeFloat(this.soundPitch);
    }
}
