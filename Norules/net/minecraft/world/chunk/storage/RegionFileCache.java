package net.minecraft.world.chunk.storage;

import java.util.*;
import com.google.common.collect.*;
import java.io.*;

public class RegionFileCache
{
    private static final /* synthetic */ Map<File, RegionFile> REGIONS_BY_FILE;
    
    public static synchronized RegionFile func_191065_b(final File lllllllllllllIllllIIlIIIIIlIlIII, final int lllllllllllllIllllIIlIIIIIlIIlll, final int lllllllllllllIllllIIlIIIIIlIIllI) {
        final File lllllllllllllIllllIIlIIIIIlIIlIl = new File(lllllllllllllIllllIIlIIIIIlIlIII, "region");
        final File lllllllllllllIllllIIlIIIIIlIIlII = new File(lllllllllllllIllllIIlIIIIIlIIlIl, String.valueOf(new StringBuilder("r.").append(lllllllllllllIllllIIlIIIIIlIIlll >> 5).append(".").append(lllllllllllllIllllIIlIIIIIlIIllI >> 5).append(".mca")));
        final RegionFile lllllllllllllIllllIIlIIIIIlIIIll = RegionFileCache.REGIONS_BY_FILE.get(lllllllllllllIllllIIlIIIIIlIIlII);
        if (lllllllllllllIllllIIlIIIIIlIIIll != null) {
            return lllllllllllllIllllIIlIIIIIlIIIll;
        }
        if (lllllllllllllIllllIIlIIIIIlIIlIl.exists() && lllllllllllllIllllIIlIIIIIlIIlII.exists()) {
            if (RegionFileCache.REGIONS_BY_FILE.size() >= 256) {
                clearRegionFileReferences();
            }
            final RegionFile lllllllllllllIllllIIlIIIIIlIIIlI = new RegionFile(lllllllllllllIllllIIlIIIIIlIIlII);
            RegionFileCache.REGIONS_BY_FILE.put(lllllllllllllIllllIIlIIIIIlIIlII, lllllllllllllIllllIIlIIIIIlIIIlI);
            return lllllllllllllIllllIIlIIIIIlIIIlI;
        }
        return null;
    }
    
    public static DataOutputStream getChunkOutputStream(final File lllllllllllllIllllIIIllllllllllI, final int lllllllllllllIllllIIlIIIIIIIIIIl, final int lllllllllllllIllllIIlIIIIIIIIIII) {
        final RegionFile lllllllllllllIllllIIIlllllllllll = createOrLoadRegionFile(lllllllllllllIllllIIIllllllllllI, lllllllllllllIllllIIlIIIIIIIIIIl, lllllllllllllIllllIIlIIIIIIIIIII);
        return lllllllllllllIllllIIIlllllllllll.getChunkDataOutputStream(lllllllllllllIllllIIlIIIIIIIIIIl & 0x1F, lllllllllllllIllllIIlIIIIIIIIIII & 0x1F);
    }
    
    static {
        REGIONS_BY_FILE = Maps.newHashMap();
    }
    
    public static DataInputStream getChunkInputStream(final File lllllllllllllIllllIIlIIIIIIIlllI, final int lllllllllllllIllllIIlIIIIIIIlIIl, final int lllllllllllllIllllIIlIIIIIIIlIII) {
        final RegionFile lllllllllllllIllllIIlIIIIIIIlIll = createOrLoadRegionFile(lllllllllllllIllllIIlIIIIIIIlllI, lllllllllllllIllllIIlIIIIIIIlIIl, lllllllllllllIllllIIlIIIIIIIlIII);
        return lllllllllllllIllllIIlIIIIIIIlIll.getChunkDataInputStream(lllllllllllllIllllIIlIIIIIIIlIIl & 0x1F, lllllllllllllIllllIIlIIIIIIIlIII & 0x1F);
    }
    
    public static boolean func_191064_f(final File lllllllllllllIllllIIIlllllllIIlI, final int lllllllllllllIllllIIIlllllllIIIl, final int lllllllllllllIllllIIIlllllllIlII) {
        final RegionFile lllllllllllllIllllIIIlllllllIIll = func_191065_b(lllllllllllllIllllIIIlllllllIIlI, lllllllllllllIllllIIIlllllllIIIl, lllllllllllllIllllIIIlllllllIlII);
        return lllllllllllllIllllIIIlllllllIIll != null && lllllllllllllIllllIIIlllllllIIll.isChunkSaved(lllllllllllllIllllIIIlllllllIIIl & 0x1F, lllllllllllllIllllIIIlllllllIlII & 0x1F);
    }
    
    public static synchronized void clearRegionFileReferences() {
        for (final RegionFile lllllllllllllIllllIIlIIIIIIlIlll : RegionFileCache.REGIONS_BY_FILE.values()) {
            try {
                if (lllllllllllllIllllIIlIIIIIIlIlll == null) {
                    continue;
                }
                lllllllllllllIllllIIlIIIIIIlIlll.close();
            }
            catch (IOException lllllllllllllIllllIIlIIIIIIlIllI) {
                lllllllllllllIllllIIlIIIIIIlIllI.printStackTrace();
            }
        }
        RegionFileCache.REGIONS_BY_FILE.clear();
    }
    
    public static synchronized RegionFile createOrLoadRegionFile(final File lllllllllllllIllllIIlIIIIIllllIl, final int lllllllllllllIllllIIlIIIIIllIlIl, final int lllllllllllllIllllIIlIIIIIlllIll) {
        final File lllllllllllllIllllIIlIIIIIlllIlI = new File(lllllllllllllIllllIIlIIIIIllllIl, "region");
        final File lllllllllllllIllllIIlIIIIIlllIIl = new File(lllllllllllllIllllIIlIIIIIlllIlI, String.valueOf(new StringBuilder("r.").append(lllllllllllllIllllIIlIIIIIllIlIl >> 5).append(".").append(lllllllllllllIllllIIlIIIIIlllIll >> 5).append(".mca")));
        final RegionFile lllllllllllllIllllIIlIIIIIlllIII = RegionFileCache.REGIONS_BY_FILE.get(lllllllllllllIllllIIlIIIIIlllIIl);
        if (lllllllllllllIllllIIlIIIIIlllIII != null) {
            return lllllllllllllIllllIIlIIIIIlllIII;
        }
        if (!lllllllllllllIllllIIlIIIIIlllIlI.exists()) {
            lllllllllllllIllllIIlIIIIIlllIlI.mkdirs();
        }
        if (RegionFileCache.REGIONS_BY_FILE.size() >= 256) {
            clearRegionFileReferences();
        }
        final RegionFile lllllllllllllIllllIIlIIIIIllIlll = new RegionFile(lllllllllllllIllllIIlIIIIIlllIIl);
        RegionFileCache.REGIONS_BY_FILE.put(lllllllllllllIllllIIlIIIIIlllIIl, lllllllllllllIllllIIlIIIIIllIlll);
        return lllllllllllllIllllIIlIIIIIllIlll;
    }
}
