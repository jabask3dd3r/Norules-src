package com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.data;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viabackwards.*;

public class ShoulderTracker extends StoredObject
{
    private /* synthetic */ int entityId;
    private /* synthetic */ String leftShoulder;
    private /* synthetic */ String rightShoulder;
    
    public String getLeftShoulder() {
        return this.leftShoulder;
    }
    
    private String getName(String lllllllllllllllIlIllllllIlIlIIIl) {
        if (lllllllllllllllIlIllllllIlIlIIIl.startsWith("minecraft:")) {
            lllllllllllllllIlIllllllIlIlIIIl = lllllllllllllllIlIllllllIlIlIIIl.substring(10);
        }
        final String[] lllllllllllllllIlIllllllIlIlIIll = lllllllllllllllIlIllllllIlIlIIIl.split("_");
        final StringBuilder lllllllllllllllIlIllllllIlIlIIlI = new StringBuilder();
        final float lllllllllllllllIlIllllllIlIIlllI = (Object)lllllllllllllllIlIllllllIlIlIIll;
        final String lllllllllllllllIlIllllllIlIIllIl = (String)lllllllllllllllIlIllllllIlIIlllI.length;
        for (byte lllllllllllllllIlIllllllIlIIlIll = 0; lllllllllllllllIlIllllllIlIIlIll < lllllllllllllllIlIllllllIlIIllIl; ++lllllllllllllllIlIllllllIlIIlIll) {
            final String lllllllllllllllIlIllllllIlIlIllI = lllllllllllllllIlIllllllIlIIlllI[lllllllllllllllIlIllllllIlIIlIll];
            lllllllllllllllIlIllllllIlIlIIlI.append(lllllllllllllllIlIllllllIlIlIllI.substring(0, 1).toUpperCase()).append(lllllllllllllllIlIllllllIlIlIllI.substring(1)).append(" ");
        }
        return String.valueOf(lllllllllllllllIlIllllllIlIlIIlI);
    }
    
    public void setEntityId(final int lllllllllllllllIlIllllllIIlllIII) {
        this.entityId = lllllllllllllllIlIllllllIIlllIII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("ShoulderTracker{entityId=").append(this.entityId).append(", leftShoulder='").append(this.leftShoulder).append('\'').append(", rightShoulder='").append(this.rightShoulder).append('\'').append('}'));
    }
    
    public ShoulderTracker(final UserConnection lllllllllllllllIlIlllllllIIIIIIl) {
        super(lllllllllllllllIlIlllllllIIIIIIl);
    }
    
    private String generateString() {
        final StringBuilder lllllllllllllllIlIllllllIllIllII = new StringBuilder();
        lllllllllllllllIlIllllllIllIllII.append("  ");
        if (this.leftShoulder == null) {
            lllllllllllllllIlIllllllIllIllII.append("§4§lNothing");
        }
        else {
            lllllllllllllllIlIllllllIllIllII.append("§2§l").append(this.getName(this.leftShoulder));
        }
        lllllllllllllllIlIllllllIllIllII.append("§8§l <- §7§lShoulders§8§l -> ");
        if (this.rightShoulder == null) {
            lllllllllllllllIlIllllllIllIllII.append("§4§lNothing");
        }
        else {
            lllllllllllllllIlIllllllIllIllII.append("§2§l").append(this.getName(this.rightShoulder));
        }
        return String.valueOf(lllllllllllllllIlIllllllIllIllII);
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public void setRightShoulder(final String lllllllllllllllIlIllllllIIIIllll) {
        this.rightShoulder = lllllllllllllllIlIllllllIIIIllll;
    }
    
    public void setLeftShoulder(final String lllllllllllllllIlIllllllIIlIIlIl) {
        this.leftShoulder = lllllllllllllllIlIllllllIIlIIlIl;
    }
    
    public void update() {
        final PacketWrapper lllllllllllllllIlIllllllIllllIII = PacketWrapper.create(ClientboundPackets1_12.CHAT_MESSAGE, null, this.getUser());
        lllllllllllllllIlIllllllIllllIII.write(Type.COMPONENT, Protocol1_9To1_8.fixJson(this.generateString()));
        lllllllllllllllIlIllllllIllllIII.write(Type.BYTE, (Byte)2);
        try {
            lllllllllllllllIlIllllllIllllIII.scheduleSend(Protocol1_11_1To1_12.class);
        }
        catch (Exception lllllllllllllllIlIllllllIllllIll) {
            ViaBackwards.getPlatform().getLogger().severe("Failed to send the shoulder indication");
            lllllllllllllllIlIllllllIllllIll.printStackTrace();
        }
    }
    
    public String getRightShoulder() {
        return this.rightShoulder;
    }
}
