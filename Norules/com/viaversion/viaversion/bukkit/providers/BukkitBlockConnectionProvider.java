package com.viaversion.viaversion.bukkit.providers;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers.*;
import com.viaversion.viaversion.api.connection.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;

public class BukkitBlockConnectionProvider extends BlockConnectionProvider
{
    private /* synthetic */ Chunk lastChunk;
    
    public Chunk getChunk(final World llllllllllllllIllIIIIIIIIllIIlIl, final int llllllllllllllIllIIIIIIIIllIlIIl, final int llllllllllllllIllIIIIIIIIllIlIII) {
        if (this.lastChunk != null && this.lastChunk.getX() == llllllllllllllIllIIIIIIIIllIlIIl && this.lastChunk.getZ() == llllllllllllllIllIIIIIIIIllIlIII) {
            return this.lastChunk;
        }
        final Chunk chunk = llllllllllllllIllIIIIIIIIllIIlIl.getChunkAt(llllllllllllllIllIIIIIIIIllIlIIl, llllllllllllllIllIIIIIIIIllIlIII);
        this.lastChunk = chunk;
        return chunk;
    }
    
    @Override
    public int getWorldBlockData(final UserConnection llllllllllllllIllIIIIIIIlIIIIIlI, final int llllllllllllllIllIIIIIIIlIIIlIII, final int llllllllllllllIllIIIIIIIlIIIIlll, final int llllllllllllllIllIIIIIIIIlllllll) {
        final UUID llllllllllllllIllIIIIIIIlIIIIlIl = llllllllllllllIllIIIIIIIlIIIIIlI.getProtocolInfo().getUuid();
        final Player llllllllllllllIllIIIIIIIlIIIIlII = Bukkit.getPlayer(llllllllllllllIllIIIIIIIlIIIIlIl);
        if (llllllllllllllIllIIIIIIIlIIIIlII != null) {
            final World llllllllllllllIllIIIIIIIlIIIllIl = llllllllllllllIllIIIIIIIlIIIIlII.getWorld();
            final int llllllllllllllIllIIIIIIIlIIIllII = llllllllllllllIllIIIIIIIlIIIlIII >> 4;
            final int llllllllllllllIllIIIIIIIlIIIlIll = llllllllllllllIllIIIIIIIIlllllll >> 4;
            if (llllllllllllllIllIIIIIIIlIIIllIl.isChunkLoaded(llllllllllllllIllIIIIIIIlIIIllII, llllllllllllllIllIIIIIIIlIIIlIll)) {
                final Chunk llllllllllllllIllIIIIIIIlIIIllll = this.getChunk(llllllllllllllIllIIIIIIIlIIIllIl, llllllllllllllIllIIIIIIIlIIIllII, llllllllllllllIllIIIIIIIlIIIlIll);
                final Block llllllllllllllIllIIIIIIIlIIIlllI = llllllllllllllIllIIIIIIIlIIIllll.getBlock(llllllllllllllIllIIIIIIIlIIIlIII, llllllllllllllIllIIIIIIIlIIIIlll, llllllllllllllIllIIIIIIIIlllllll);
                return llllllllllllllIllIIIIIIIlIIIlllI.getTypeId() << 4 | llllllllllllllIllIIIIIIIlIIIlllI.getData();
            }
        }
        return 0;
    }
}
