package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import java.util.*;

public class SPacketPlayerPosLook implements Packet<INetHandlerPlayClient>
{
    public /* synthetic */ double x;
    private /* synthetic */ int teleportId;
    public /* synthetic */ double z;
    public /* synthetic */ double y;
    public /* synthetic */ float pitch;
    public /* synthetic */ float yaw;
    private /* synthetic */ Set<EnumFlags> flags;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIllIllIllllllll) throws IOException {
        this.x = llllllllllllllIlIIllIllIllllllll.readDouble();
        this.y = llllllllllllllIlIIllIllIllllllll.readDouble();
        this.z = llllllllllllllIlIIllIllIllllllll.readDouble();
        this.yaw = llllllllllllllIlIIllIllIllllllll.readFloat();
        this.pitch = llllllllllllllIlIIllIllIllllllll.readFloat();
        this.flags = EnumFlags.unpack(llllllllllllllIlIIllIllIllllllll.readUnsignedByte());
        this.teleportId = llllllllllllllIlIIllIllIllllllll.readVarIntFromBuffer();
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public SPacketPlayerPosLook() {
    }
    
    public int getTeleportId() {
        return this.teleportId;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getX() {
        return this.x;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIllIllIllllIIIl) {
        llllllllllllllIlIIllIllIllllIIIl.handlePlayerPosLook(this);
    }
    
    public SPacketPlayerPosLook(final double llllllllllllllIlIIllIlllIIIlIIIl, final double llllllllllllllIlIIllIlllIIIlIIII, final double llllllllllllllIlIIllIlllIIIIIlll, final float llllllllllllllIlIIllIlllIIIIlllI, final float llllllllllllllIlIIllIlllIIIIIlIl, final Set<EnumFlags> llllllllllllllIlIIllIlllIIIIllII, final int llllllllllllllIlIIllIlllIIIIIIll) {
        this.x = llllllllllllllIlIIllIlllIIIlIIIl;
        this.y = llllllllllllllIlIIllIlllIIIlIIII;
        this.z = llllllllllllllIlIIllIlllIIIIIlll;
        this.yaw = llllllllllllllIlIIllIlllIIIIlllI;
        this.pitch = llllllllllllllIlIIllIlllIIIIIlIl;
        this.flags = llllllllllllllIlIIllIlllIIIIllII;
        this.teleportId = llllllllllllllIlIIllIlllIIIIIIll;
    }
    
    public Set<EnumFlags> getFlags() {
        return this.flags;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIllIllIlllllIIl) throws IOException {
        llllllllllllllIlIIllIllIlllllIIl.writeDouble(this.x);
        llllllllllllllIlIIllIllIlllllIIl.writeDouble(this.y);
        llllllllllllllIlIIllIllIlllllIIl.writeDouble(this.z);
        llllllllllllllIlIIllIllIlllllIIl.writeFloat(this.yaw);
        llllllllllllllIlIIllIllIlllllIIl.writeFloat(this.pitch);
        llllllllllllllIlIIllIllIlllllIIl.writeByte(EnumFlags.pack(this.flags));
        llllllllllllllIlIIllIllIlllllIIl.writeVarIntToBuffer(this.teleportId);
    }
    
    public double getZ() {
        return this.z;
    }
    
    public enum EnumFlags
    {
        Y("Y", 1, 1), 
        X("X", 0, 0), 
        X_ROT("X_ROT", 4, 4);
        
        private final /* synthetic */ int bit;
        
        Y_ROT("Y_ROT", 3, 3), 
        Z("Z", 2, 2);
        
        private boolean isSet(final int lllllllllllllIlIIlllllIIlllIllll) {
            return (lllllllllllllIlIIlllllIIlllIllll & this.getMask()) == this.getMask();
        }
        
        public static int pack(final Set<EnumFlags> lllllllllllllIlIIlllllIIllIllIIl) {
            int lllllllllllllIlIIlllllIIllIllIII = 0;
            for (final EnumFlags lllllllllllllIlIIlllllIIllIlIlll : lllllllllllllIlIIlllllIIllIllIIl) {
                lllllllllllllIlIIlllllIIllIllIII |= lllllllllllllIlIIlllllIIllIlIlll.getMask();
            }
            return lllllllllllllIlIIlllllIIllIllIII;
        }
        
        private EnumFlags(final String lllllllllllllIlIIlllllIIlllllIII, final int lllllllllllllIlIIlllllIIllllIlll, final int lllllllllllllIlIIlllllIIlllllIlI) {
            this.bit = lllllllllllllIlIIlllllIIlllllIlI;
        }
        
        private int getMask() {
            return 1 << this.bit;
        }
        
        public static Set<EnumFlags> unpack(final int lllllllllllllIlIIlllllIIlllIIllI) {
            final Set<EnumFlags> lllllllllllllIlIIlllllIIlllIIlIl = EnumSet.noneOf(EnumFlags.class);
            final boolean lllllllllllllIlIIlllllIIllIllllI;
            final long lllllllllllllIlIIlllllIIllIlllll = ((EnumFlags[])(Object)(lllllllllllllIlIIlllllIIllIllllI = (boolean)(Object)values())).length;
            for (short lllllllllllllIlIIlllllIIlllIIIII = 0; lllllllllllllIlIIlllllIIlllIIIII < lllllllllllllIlIIlllllIIllIlllll; ++lllllllllllllIlIIlllllIIlllIIIII) {
                final EnumFlags lllllllllllllIlIIlllllIIlllIIlII = lllllllllllllIlIIlllllIIllIllllI[lllllllllllllIlIIlllllIIlllIIIII];
                if (lllllllllllllIlIIlllllIIlllIIlII.isSet(lllllllllllllIlIIlllllIIlllIIllI)) {
                    lllllllllllllIlIIlllllIIlllIIlIl.add(lllllllllllllIlIIlllllIIlllIIlII);
                }
            }
            return lllllllllllllIlIIlllllIIlllIIlIl;
        }
    }
}
