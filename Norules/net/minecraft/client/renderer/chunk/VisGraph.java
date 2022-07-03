package net.minecraft.client.renderer.chunk;

import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.util.*;

public class VisGraph
{
    private static final /* synthetic */ int DZ;
    private static final /* synthetic */ int DY;
    private static final /* synthetic */ int[] INDEX_OF_EDGES;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private static final /* synthetic */ int DX;
    private final /* synthetic */ BitSet bitSet;
    private /* synthetic */ int empty;
    
    public VisGraph() {
        this.bitSet = new BitSet(4096);
        this.empty = 4096;
    }
    
    public void setOpaqueCube(final BlockPos lllllllllllllllIllllIIllIlIIllIl) {
        this.bitSet.set(getIndex(lllllllllllllllIllllIIllIlIIllIl), true);
        --this.empty;
    }
    
    public SetVisibility computeVisibility() {
        final SetVisibility lllllllllllllllIllllIIllIIlllIIl = new SetVisibility();
        if (4096 - this.empty < 256) {
            lllllllllllllllIllllIIllIIlllIIl.setAllVisible(true);
        }
        else if (this.empty == 0) {
            lllllllllllllllIllllIIllIIlllIIl.setAllVisible(false);
        }
        else {
            final boolean lllllllllllllllIllllIIllIIllIIlI;
            final boolean lllllllllllllllIllllIIllIIllIIll = ((int[])(Object)(lllllllllllllllIllllIIllIIllIIlI = (boolean)(Object)VisGraph.INDEX_OF_EDGES)).length != 0;
            for (Exception lllllllllllllllIllllIIllIIllIlII = (Exception)0; lllllllllllllllIllllIIllIIllIlII < lllllllllllllllIllllIIllIIllIIll; ++lllllllllllllllIllllIIllIIllIlII) {
                final int lllllllllllllllIllllIIllIIlllIII = lllllllllllllllIllllIIllIIllIIlI[lllllllllllllllIllllIIllIIllIlII];
                if (!this.bitSet.get(lllllllllllllllIllllIIllIIlllIII)) {
                    lllllllllllllllIllllIIllIIlllIIl.setManyVisible(this.floodFill(lllllllllllllllIllllIIllIIlllIII));
                }
            }
        }
        return lllllllllllllllIllllIIllIIlllIIl;
    }
    
    public Set<EnumFacing> getVisibleFacings(final BlockPos lllllllllllllllIllllIIllIIlIllII) {
        return this.floodFill(getIndex(lllllllllllllllIllllIIllIIlIllII));
    }
    
    private int getNeighborIndexAtFace(final int lllllllllllllllIllllIIlIlllllIll, final EnumFacing lllllllllllllllIllllIIlIllllllII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllllIllllIIlIllllllII.ordinal()]) {
            case 1: {
                if ((lllllllllllllllIllllIIlIlllllIll >> 8 & 0xF) == 0x0) {
                    return -1;
                }
                return lllllllllllllllIllllIIlIlllllIll - VisGraph.DY;
            }
            case 2: {
                if ((lllllllllllllllIllllIIlIlllllIll >> 8 & 0xF) == 0xF) {
                    return -1;
                }
                return lllllllllllllllIllllIIlIlllllIll + VisGraph.DY;
            }
            case 3: {
                if ((lllllllllllllllIllllIIlIlllllIll >> 4 & 0xF) == 0x0) {
                    return -1;
                }
                return lllllllllllllllIllllIIlIlllllIll - VisGraph.DZ;
            }
            case 4: {
                if ((lllllllllllllllIllllIIlIlllllIll >> 4 & 0xF) == 0xF) {
                    return -1;
                }
                return lllllllllllllllIllllIIlIlllllIll + VisGraph.DZ;
            }
            case 5: {
                if ((lllllllllllllllIllllIIlIlllllIll >> 0 & 0xF) == 0x0) {
                    return -1;
                }
                return lllllllllllllllIllllIIlIlllllIll - VisGraph.DX;
            }
            case 6: {
                if ((lllllllllllllllIllllIIlIlllllIll >> 0 & 0xF) == 0xF) {
                    return -1;
                }
                return lllllllllllllllIllllIIlIlllllIll + VisGraph.DX;
            }
            default: {
                return -1;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = VisGraph.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final boolean lllllllllllllllIllllIIlIlllllIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllIllllIIlIlllllIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIllllIIlIlllllIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIllllIIlIlllllIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIllllIIlIlllllIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIllllIIlIlllllIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIllllIIlIlllllIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return VisGraph.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllIllllIIlIlllllIII;
    }
    
    private Set<EnumFacing> floodFill(final int lllllllllllllllIllllIIllIIlIIIII) {
        final Set<EnumFacing> lllllllllllllllIllllIIllIIIlllll = EnumSet.noneOf(EnumFacing.class);
        final ArrayDeque lllllllllllllllIllllIIllIIIllllI = new ArrayDeque(384);
        lllllllllllllllIllllIIllIIIllllI.add(IntegerCache.getInteger(lllllllllllllllIllllIIllIIlIIIII));
        this.bitSet.set(lllllllllllllllIllllIIllIIlIIIII, true);
        while (!lllllllllllllllIllllIIllIIIllllI.isEmpty()) {
            final int lllllllllllllllIllllIIllIIIlllIl = lllllllllllllllIllllIIllIIIllllI.poll();
            this.addEdges(lllllllllllllllIllllIIllIIIlllIl, lllllllllllllllIllllIIllIIIlllll);
            final String lllllllllllllllIllllIIllIIIlIIlI;
            final short lllllllllllllllIllllIIllIIIlIIll = (short)((EnumFacing[])(Object)(lllllllllllllllIllllIIllIIIlIIlI = (String)(Object)EnumFacing.VALUES)).length;
            for (byte lllllllllllllllIllllIIllIIIlIlII = 0; lllllllllllllllIllllIIllIIIlIlII < lllllllllllllllIllllIIllIIIlIIll; ++lllllllllllllllIllllIIllIIIlIlII) {
                final EnumFacing lllllllllllllllIllllIIllIIIlllII = lllllllllllllllIllllIIllIIIlIIlI[lllllllllllllllIllllIIllIIIlIlII];
                final int lllllllllllllllIllllIIllIIIllIll = this.getNeighborIndexAtFace(lllllllllllllllIllllIIllIIIlllIl, lllllllllllllllIllllIIllIIIlllII);
                if (lllllllllllllllIllllIIllIIIllIll >= 0 && !this.bitSet.get(lllllllllllllllIllllIIllIIIllIll)) {
                    this.bitSet.set(lllllllllllllllIllllIIllIIIllIll, true);
                    lllllllllllllllIllllIIllIIIllllI.add(IntegerCache.getInteger(lllllllllllllllIllllIIllIIIllIll));
                }
            }
        }
        return lllllllllllllllIllllIIllIIIlllll;
    }
    
    private static int getIndex(final BlockPos lllllllllllllllIllllIIllIlIIlIll) {
        return getIndex(lllllllllllllllIllllIIllIlIIlIll.getX() & 0xF, lllllllllllllllIllllIIllIlIIlIll.getY() & 0xF, lllllllllllllllIllllIIllIlIIlIll.getZ() & 0xF);
    }
    
    static {
        DX = (int)Math.pow(16.0, 0.0);
        DZ = (int)Math.pow(16.0, 1.0);
        DY = (int)Math.pow(16.0, 2.0);
        INDEX_OF_EDGES = new int[1352];
        final int lllllllllllllllIllllIIllIllIIIIl = 0;
        final int lllllllllllllllIllllIIllIllIIIII = 15;
        int lllllllllllllllIllllIIllIlIlllll = 0;
        for (int lllllllllllllllIllllIIllIlIllllI = 0; lllllllllllllllIllllIIllIlIllllI < 16; ++lllllllllllllllIllllIIllIlIllllI) {
            for (int lllllllllllllllIllllIIllIlIlllIl = 0; lllllllllllllllIllllIIllIlIlllIl < 16; ++lllllllllllllllIllllIIllIlIlllIl) {
                for (int lllllllllllllllIllllIIllIlIlllII = 0; lllllllllllllllIllllIIllIlIlllII < 16; ++lllllllllllllllIllllIIllIlIlllII) {
                    if (lllllllllllllllIllllIIllIlIllllI == 0 || lllllllllllllllIllllIIllIlIllllI == 15 || lllllllllllllllIllllIIllIlIlllIl == 0 || lllllllllllllllIllllIIllIlIlllIl == 15 || lllllllllllllllIllllIIllIlIlllII == 0 || lllllllllllllllIllllIIllIlIlllII == 15) {
                        VisGraph.INDEX_OF_EDGES[lllllllllllllllIllllIIllIlIlllll++] = getIndex(lllllllllllllllIllllIIllIlIllllI, lllllllllllllllIllllIIllIlIlllIl, lllllllllllllllIllllIIllIlIlllII);
                    }
                }
            }
        }
    }
    
    private static int getIndex(final int lllllllllllllllIllllIIllIlIIIllI, final int lllllllllllllllIllllIIllIlIIIIlI, final int lllllllllllllllIllllIIllIlIIIIIl) {
        return lllllllllllllllIllllIIllIlIIIllI << 0 | lllllllllllllllIllllIIllIlIIIIlI << 8 | lllllllllllllllIllllIIllIlIIIIIl << 4;
    }
    
    private void addEdges(final int lllllllllllllllIllllIIllIIIIIlIl, final Set<EnumFacing> lllllllllllllllIllllIIllIIIIlIIl) {
        final int lllllllllllllllIllllIIllIIIIlIII = lllllllllllllllIllllIIllIIIIIlIl >> 0 & 0xF;
        if (lllllllllllllllIllllIIllIIIIlIII == 0) {
            lllllllllllllllIllllIIllIIIIlIIl.add(EnumFacing.WEST);
        }
        else if (lllllllllllllllIllllIIllIIIIlIII == 15) {
            lllllllllllllllIllllIIllIIIIlIIl.add(EnumFacing.EAST);
        }
        final int lllllllllllllllIllllIIllIIIIIlll = lllllllllllllllIllllIIllIIIIIlIl >> 8 & 0xF;
        if (lllllllllllllllIllllIIllIIIIIlll == 0) {
            lllllllllllllllIllllIIllIIIIlIIl.add(EnumFacing.DOWN);
        }
        else if (lllllllllllllllIllllIIllIIIIIlll == 15) {
            lllllllllllllllIllllIIllIIIIlIIl.add(EnumFacing.UP);
        }
        final int lllllllllllllllIllllIIllIIIIIllI = lllllllllllllllIllllIIllIIIIIlIl >> 4 & 0xF;
        if (lllllllllllllllIllllIIllIIIIIllI == 0) {
            lllllllllllllllIllllIIllIIIIlIIl.add(EnumFacing.NORTH);
        }
        else if (lllllllllllllllIllllIIllIIIIIllI == 15) {
            lllllllllllllllIllllIIllIIIIlIIl.add(EnumFacing.SOUTH);
        }
    }
}
