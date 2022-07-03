package com.viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.concurrent.*;

public class CommandBlockStorage implements StorableObject
{
    private /* synthetic */ boolean permissions;
    private final /* synthetic */ Map<Pair<Integer, Integer>, Map<Position, CompoundTag>> storedCommandBlocks;
    
    public void setPermissions(final boolean lllllllllllllllllIllllllIllIllIl) {
        this.permissions = lllllllllllllllllIllllllIllIllIl;
    }
    
    public Optional<CompoundTag> getCommandBlock(final Position lllllllllllllllllIllllllIlllllII) {
        final Pair<Integer, Integer> lllllllllllllllllIlllllllIIIIIII = this.getChunkCoords(lllllllllllllllllIllllllIlllllII);
        final Map<Position, CompoundTag> lllllllllllllllllIllllllIlllllll = this.storedCommandBlocks.get(lllllllllllllllllIlllllllIIIIIII);
        if (lllllllllllllllllIllllllIlllllll == null) {
            return Optional.empty();
        }
        CompoundTag lllllllllllllllllIllllllIllllllI = lllllllllllllllllIllllllIlllllll.get(lllllllllllllllllIllllllIlllllII);
        if (lllllllllllllllllIllllllIllllllI == null) {
            return Optional.empty();
        }
        lllllllllllllllllIllllllIllllllI = lllllllllllllllllIllllllIllllllI.clone();
        lllllllllllllllllIllllllIllllllI.put("powered", new ByteTag((byte)0));
        lllllllllllllllllIllllllIllllllI.put("auto", new ByteTag((byte)0));
        lllllllllllllllllIllllllIllllllI.put("conditionMet", new ByteTag((byte)0));
        return Optional.of(lllllllllllllllllIllllllIllllllI);
    }
    
    public boolean isPermissions() {
        return this.permissions;
    }
    
    public CommandBlockStorage() {
        this.storedCommandBlocks = new ConcurrentHashMap<Pair<Integer, Integer>, Map<Position, CompoundTag>>();
        this.permissions = false;
    }
    
    private Pair<Integer, Integer> getChunkCoords(final Position lllllllllllllllllIlllllllIIIlIlI) {
        final int lllllllllllllllllIlllllllIIIllII = Math.floorDiv(lllllllllllllllllIlllllllIIIlIlI.getX(), 16);
        final int lllllllllllllllllIlllllllIIIlIll = Math.floorDiv(lllllllllllllllllIlllllllIIIlIlI.getZ(), 16);
        return new Pair<Integer, Integer>(lllllllllllllllllIlllllllIIIllII, lllllllllllllllllIlllllllIIIlIll);
    }
    
    public void addOrUpdateBlock(final Position lllllllllllllllllIlllllllIIllIlI, final CompoundTag lllllllllllllllllIlllllllIIllIIl) {
        final Pair<Integer, Integer> lllllllllllllllllIlllllllIIllIII = this.getChunkCoords(lllllllllllllllllIlllllllIIllIlI);
        if (!this.storedCommandBlocks.containsKey(lllllllllllllllllIlllllllIIllIII)) {
            this.storedCommandBlocks.put(lllllllllllllllllIlllllllIIllIII, new ConcurrentHashMap<Position, CompoundTag>());
        }
        final Map<Position, CompoundTag> lllllllllllllllllIlllllllIIlIlll = this.storedCommandBlocks.get(lllllllllllllllllIlllllllIIllIII);
        if (lllllllllllllllllIlllllllIIlIlll.containsKey(lllllllllllllllllIlllllllIIllIlI) && lllllllllllllllllIlllllllIIlIlll.get(lllllllllllllllllIlllllllIIllIlI).equals(lllllllllllllllllIlllllllIIllIIl)) {
            return;
        }
        lllllllllllllllllIlllllllIIlIlll.put(lllllllllllllllllIlllllllIIllIlI, lllllllllllllllllIlllllllIIllIIl);
    }
    
    public void unloadChunks() {
        this.storedCommandBlocks.clear();
    }
    
    public void unloadChunk(final int lllllllllllllllllIlllllllIlIIIll, final int lllllllllllllllllIlllllllIlIIIlI) {
        final Pair<Integer, Integer> lllllllllllllllllIlllllllIlIIlIl = new Pair<Integer, Integer>(lllllllllllllllllIlllllllIlIIIll, lllllllllllllllllIlllllllIlIIIlI);
        this.storedCommandBlocks.remove(lllllllllllllllllIlllllllIlIIlIl);
    }
}
