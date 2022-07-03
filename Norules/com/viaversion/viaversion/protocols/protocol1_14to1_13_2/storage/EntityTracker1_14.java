package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.storage;

import com.viaversion.viaversion.data.entity.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.concurrent.*;

public class EntityTracker1_14 extends EntityTrackerBase
{
    private /* synthetic */ int chunkCenterZ;
    private /* synthetic */ int latestTradeWindowId;
    private final /* synthetic */ Map<Integer, Byte> sleepingAndRiptideData;
    private /* synthetic */ boolean forceSendCenterChunk;
    private /* synthetic */ int chunkCenterX;
    private final /* synthetic */ Map<Integer, Byte> insentientData;
    private final /* synthetic */ Map<Integer, Byte> playerEntityFlags;
    
    @Override
    public void removeEntity(final int lllllllllllllIlIlIlIIIIlIlIIIIll) {
        super.removeEntity(lllllllllllllIlIlIlIIIIlIlIIIIll);
        this.insentientData.remove(lllllllllllllIlIlIlIIIIlIlIIIIll);
        this.sleepingAndRiptideData.remove(lllllllllllllIlIlIlIIIIlIlIIIIll);
        this.playerEntityFlags.remove(lllllllllllllIlIlIlIIIIlIlIIIIll);
    }
    
    public boolean isForceSendCenterChunk() {
        return this.forceSendCenterChunk;
    }
    
    public void setRiptide(final int lllllllllllllIlIlIlIIIIlIIIIllII, final boolean lllllllllllllIlIlIlIIIIlIIIIllll) {
        final byte lllllllllllllIlIlIlIIIIlIIIIlllI = (byte)((zeroIfNull(this.sleepingAndRiptideData.get(lllllllllllllIlIlIlIIIIlIIIIllII)) & 0xFFFFFFFD) | (lllllllllllllIlIlIlIIIIlIIIIllll ? 2 : 0));
        if (lllllllllllllIlIlIlIIIIlIIIIlllI == 0) {
            this.sleepingAndRiptideData.remove(lllllllllllllIlIlIlIIIIlIIIIllII);
        }
        else {
            this.sleepingAndRiptideData.put(lllllllllllllIlIlIlIIIIlIIIIllII, lllllllllllllIlIlIlIIIIlIIIIlllI);
        }
    }
    
    public void setLatestTradeWindowId(final int lllllllllllllIlIlIlIIIIIllllIlII) {
        this.latestTradeWindowId = lllllllllllllIlIlIlIIIIIllllIlII;
    }
    
    public void setInsentientData(final int lllllllllllllIlIlIlIIIIlIIllIIlI, final byte lllllllllllllIlIlIlIIIIlIIllIlII) {
        this.insentientData.put(lllllllllllllIlIlIlIIIIlIIllIIlI, lllllllllllllIlIlIlIIIIlIIllIlII);
    }
    
    public int getChunkCenterX() {
        return this.chunkCenterX;
    }
    
    public boolean isSleeping(final int lllllllllllllIlIlIlIIIIlIIlIlIlI) {
        return (zeroIfNull(this.sleepingAndRiptideData.get(lllllllllllllIlIlIlIIIIlIIlIlIlI)) & 0x1) != 0x0;
    }
    
    public void setEntityFlags(final int lllllllllllllIlIlIlIIIIIllllllll, final byte lllllllllllllIlIlIlIIIIIlllllllI) {
        this.playerEntityFlags.put(lllllllllllllIlIlIlIIIIIllllllll, lllllllllllllIlIlIlIIIIIlllllllI);
    }
    
    public void setChunkCenterZ(final int lllllllllllllIlIlIlIIIIIllIllIIl) {
        this.chunkCenterZ = lllllllllllllIlIlIlIIIIIllIllIIl;
    }
    
    public void setChunkCenterX(final int lllllllllllllIlIlIlIIIIIlllIIIII) {
        this.chunkCenterX = lllllllllllllIlIlIlIIIIIlllIIIII;
    }
    
    public void setSleeping(final int lllllllllllllIlIlIlIIIIlIIlIIIlI, final boolean lllllllllllllIlIlIlIIIIlIIlIIIIl) {
        final byte lllllllllllllIlIlIlIIIIlIIlIIIII = (byte)((zeroIfNull(this.sleepingAndRiptideData.get(lllllllllllllIlIlIlIIIIlIIlIIIlI)) & 0xFFFFFFFE) | (lllllllllllllIlIlIlIIIIlIIlIIIIl ? 1 : 0));
        if (lllllllllllllIlIlIlIIIIlIIlIIIII == 0) {
            this.sleepingAndRiptideData.remove(lllllllllllllIlIlIlIIIIlIIlIIIlI);
        }
        else {
            this.sleepingAndRiptideData.put(lllllllllllllIlIlIlIIIIlIIlIIIlI, lllllllllllllIlIlIlIIIIlIIlIIIII);
        }
    }
    
    public int getLatestTradeWindowId() {
        return this.latestTradeWindowId;
    }
    
    public EntityTracker1_14(final UserConnection lllllllllllllIlIlIlIIIIlIlIIlIIl) {
        super(lllllllllllllIlIlIlIIIIlIlIIlIIl, Entity1_14Types.PLAYER);
        this.insentientData = new ConcurrentHashMap<Integer, Byte>();
        this.sleepingAndRiptideData = new ConcurrentHashMap<Integer, Byte>();
        this.playerEntityFlags = new ConcurrentHashMap<Integer, Byte>();
        this.forceSendCenterChunk = true;
    }
    
    public int getChunkCenterZ() {
        return this.chunkCenterZ;
    }
    
    public void setForceSendCenterChunk(final boolean lllllllllllllIlIlIlIIIIIlllIlIll) {
        this.forceSendCenterChunk = lllllllllllllIlIlIlIIIIIlllIlIll;
    }
    
    public boolean isRiptide(final int lllllllllllllIlIlIlIIIIlIIIllIII) {
        return (zeroIfNull(this.sleepingAndRiptideData.get(lllllllllllllIlIlIlIIIIlIIIllIII)) & 0x2) != 0x0;
    }
    
    public byte getEntityFlags(final int lllllllllllllIlIlIlIIIIlIIIIIllI) {
        return zeroIfNull(this.playerEntityFlags.get(lllllllllllllIlIlIlIIIIlIIIIIllI));
    }
    
    private static byte zeroIfNull(final Byte lllllllllllllIlIlIlIIIIlIIlIllll) {
        if (lllllllllllllIlIlIlIIIIlIIlIllll == null) {
            return 0;
        }
        return lllllllllllllIlIlIlIIIIlIIlIllll;
    }
    
    public byte getInsentientData(final int lllllllllllllIlIlIlIIIIlIIlllllI) {
        final Byte lllllllllllllIlIlIlIIIIlIIllllIl = this.insentientData.get(lllllllllllllIlIlIlIIIIlIIlllllI);
        return (byte)((lllllllllllllIlIlIlIIIIlIIllllIl == null) ? 0 : ((byte)lllllllllllllIlIlIlIIIIlIIllllIl));
    }
}
