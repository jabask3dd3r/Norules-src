package shadersmod.client;

import java.io.*;
import optifine.*;
import java.util.*;

public class BlockAliases
{
    private static /* synthetic */ BlockAlias[][] blockAliases;
    
    public static int getMappedBlockId(final int lllllllllllllIIIIIIlIllIIllIlIlI, final int lllllllllllllIIIIIIlIllIIllIllll) {
        if (BlockAliases.blockAliases == null) {
            return lllllllllllllIIIIIIlIllIIllIlIlI;
        }
        if (lllllllllllllIIIIIIlIllIIllIlIlI < 0 || lllllllllllllIIIIIIlIllIIllIlIlI >= BlockAliases.blockAliases.length) {
            return lllllllllllllIIIIIIlIllIIllIlIlI;
        }
        final BlockAlias[] lllllllllllllIIIIIIlIllIIllIllIl = BlockAliases.blockAliases[lllllllllllllIIIIIIlIllIIllIlIlI];
        if (lllllllllllllIIIIIIlIllIIllIllIl == null) {
            return lllllllllllllIIIIIIlIllIIllIlIlI;
        }
        for (int lllllllllllllIIIIIIlIllIIllIllII = 0; lllllllllllllIIIIIIlIllIIllIllII < lllllllllllllIIIIIIlIllIIllIllIl.length; ++lllllllllllllIIIIIIlIllIIllIllII) {
            final BlockAlias lllllllllllllIIIIIIlIllIIllIlIll = lllllllllllllIIIIIIlIllIIllIllIl[lllllllllllllIIIIIIlIllIIllIllII];
            if (lllllllllllllIIIIIIlIllIIllIlIll.matches(lllllllllllllIIIIIIlIllIIllIlIlI, lllllllllllllIIIIIIlIllIIllIllll)) {
                return lllllllllllllIIIIIIlIllIIllIlIll.getBlockId();
            }
        }
        return lllllllllllllIIIIIIlIllIIllIlIlI;
    }
    
    private static BlockAlias[][] toArrays(final List<List<BlockAlias>> lllllllllllllIIIIIIlIllIIIIllIII) {
        final BlockAlias[][] lllllllllllllIIIIIIlIllIIIIlIlll = new BlockAlias[lllllllllllllIIIIIIlIllIIIIllIII.size()][];
        for (int lllllllllllllIIIIIIlIllIIIIlIllI = 0; lllllllllllllIIIIIIlIllIIIIlIllI < lllllllllllllIIIIIIlIllIIIIlIlll.length; ++lllllllllllllIIIIIIlIllIIIIlIllI) {
            final List<BlockAlias> lllllllllllllIIIIIIlIllIIIIlIlIl = lllllllllllllIIIIIIlIllIIIIllIII.get(lllllllllllllIIIIIIlIllIIIIlIllI);
            if (lllllllllllllIIIIIIlIllIIIIlIlIl != null) {
                lllllllllllllIIIIIIlIllIIIIlIlll[lllllllllllllIIIIIIlIllIIIIlIllI] = lllllllllllllIIIIIIlIllIIIIlIlIl.toArray(new BlockAlias[lllllllllllllIIIIIIlIllIIIIlIlIl.size()]);
            }
        }
        return lllllllllllllIIIIIIlIllIIIIlIlll;
    }
    
    static {
        BlockAliases.blockAliases = null;
    }
    
    public static void update(final IShaderPack lllllllllllllIIIIIIlIllIIIllllIl) {
        reset();
        final String lllllllllllllIIIIIIlIllIIlIIlIll = "/shaders/block.properties";
        try {
            final InputStream lllllllllllllIIIIIIlIllIIlIIlIlI = lllllllllllllIIIIIIlIllIIIllllIl.getResourceAsStream(lllllllllllllIIIIIIlIllIIlIIlIll);
            if (lllllllllllllIIIIIIlIllIIlIIlIlI == null) {
                return;
            }
            final Properties lllllllllllllIIIIIIlIllIIlIIlIIl = new PropertiesOrdered();
            lllllllllllllIIIIIIlIllIIlIIlIIl.load(lllllllllllllIIIIIIlIllIIlIIlIlI);
            lllllllllllllIIIIIIlIllIIlIIlIlI.close();
            Config.dbg(String.valueOf(new StringBuilder("[Shaders] Parsing block mappings: ").append(lllllllllllllIIIIIIlIllIIlIIlIll)));
            final List<List<BlockAlias>> lllllllllllllIIIIIIlIllIIlIIlIII = new ArrayList<List<BlockAlias>>();
            final ConnectedParser lllllllllllllIIIIIIlIllIIlIIIlll = new ConnectedParser("Shaders");
            for (final Object lllllllllllllIIIIIIlIllIIlIIIllI : ((Hashtable<Object, V>)lllllllllllllIIIIIIlIllIIlIIlIIl).keySet()) {
                final String lllllllllllllIIIIIIlIllIIlIIIlIl = (String)lllllllllllllIIIIIIlIllIIlIIIllI;
                final String lllllllllllllIIIIIIlIllIIlIIIlII = lllllllllllllIIIIIIlIllIIlIIlIIl.getProperty(lllllllllllllIIIIIIlIllIIlIIIlIl);
                final String lllllllllllllIIIIIIlIllIIlIIIIll = "block.";
                if (!lllllllllllllIIIIIIlIllIIlIIIlIl.startsWith(lllllllllllllIIIIIIlIllIIlIIIIll)) {
                    Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid block ID: ").append(lllllllllllllIIIIIIlIllIIlIIIlIl)));
                }
                else {
                    final String lllllllllllllIIIIIIlIllIIlIIIIlI = StrUtils.removePrefix(lllllllllllllIIIIIIlIllIIlIIIlIl, lllllllllllllIIIIIIlIllIIlIIIIll);
                    final int lllllllllllllIIIIIIlIllIIlIIIIIl = Config.parseInt(lllllllllllllIIIIIIlIllIIlIIIIlI, -1);
                    if (lllllllllllllIIIIIIlIllIIlIIIIIl < 0) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid block ID: ").append(lllllllllllllIIIIIIlIllIIlIIIlIl)));
                    }
                    else {
                        final MatchBlock[] lllllllllllllIIIIIIlIllIIlIIIIII = lllllllllllllIIIIIIlIllIIlIIIlll.parseMatchBlocks(lllllllllllllIIIIIIlIllIIlIIIlII);
                        if (lllllllllllllIIIIIIlIllIIlIIIIII != null && lllllllllllllIIIIIIlIllIIlIIIIII.length >= 1) {
                            final BlockAlias lllllllllllllIIIIIIlIllIIIllllll = new BlockAlias(lllllllllllllIIIIIIlIllIIlIIIIIl, lllllllllllllIIIIIIlIllIIlIIIIII);
                            addToList(lllllllllllllIIIIIIlIllIIlIIlIII, lllllllllllllIIIIIIlIllIIIllllll);
                        }
                        else {
                            Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid block ID mapping: ").append(lllllllllllllIIIIIIlIllIIlIIIlIl).append("=").append(lllllllllllllIIIIIIlIllIIlIIIlII)));
                        }
                    }
                }
            }
            if (lllllllllllllIIIIIIlIllIIlIIlIII.size() <= 0) {
                return;
            }
            BlockAliases.blockAliases = toArrays(lllllllllllllIIIIIIlIllIIlIIlIII);
        }
        catch (IOException lllllllllllllIIIIIIlIllIIIlllllI) {
            Config.warn(String.valueOf(new StringBuilder("[Shaders] Error reading: ").append(lllllllllllllIIIIIIlIllIIlIIlIll)));
        }
    }
    
    public static void reset() {
        BlockAliases.blockAliases = null;
    }
    
    private static void addToList(final List<List<BlockAlias>> lllllllllllllIIIIIIlIllIIIlIIIlI, final BlockAlias lllllllllllllIIIIIIlIllIIIlIIIIl) {
        final int[] lllllllllllllIIIIIIlIllIIIlIIllI = lllllllllllllIIIIIIlIllIIIlIIIIl.getMatchBlockIds();
        for (int lllllllllllllIIIIIIlIllIIIlIIlIl = 0; lllllllllllllIIIIIIlIllIIIlIIlIl < lllllllllllllIIIIIIlIllIIIlIIllI.length; ++lllllllllllllIIIIIIlIllIIIlIIlIl) {
            final int lllllllllllllIIIIIIlIllIIIlIIlII = lllllllllllllIIIIIIlIllIIIlIIllI[lllllllllllllIIIIIIlIllIIIlIIlIl];
            while (lllllllllllllIIIIIIlIllIIIlIIlII >= lllllllllllllIIIIIIlIllIIIlIIIlI.size()) {
                lllllllllllllIIIIIIlIllIIIlIIIlI.add(null);
            }
            List<BlockAlias> lllllllllllllIIIIIIlIllIIIlIIIll = lllllllllllllIIIIIIlIllIIIlIIIlI.get(lllllllllllllIIIIIIlIllIIIlIIlII);
            if (lllllllllllllIIIIIIlIllIIIlIIIll == null) {
                lllllllllllllIIIIIIlIllIIIlIIIll = new ArrayList<BlockAlias>();
                lllllllllllllIIIIIIlIllIIIlIIIlI.set(lllllllllllllIIIIIIlIllIIIlIIlII, lllllllllllllIIIIIIlIllIIIlIIIll);
            }
            lllllllllllllIIIIIIlIllIIIlIIIll.add(lllllllllllllIIIIIIlIllIIIlIIIIl);
        }
    }
}
