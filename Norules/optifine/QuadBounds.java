package optifine;

import net.minecraft.util.*;

public class QuadBounds
{
    private /* synthetic */ float minZ;
    private /* synthetic */ float maxZ;
    private /* synthetic */ float maxY;
    private /* synthetic */ float minX;
    private /* synthetic */ float minY;
    private /* synthetic */ float maxX;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = QuadBounds.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final char lllllllllllllIIlllIlIlIIIlIIlIIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIIlllIlIlIIIlIIlIIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlllIlIlIIIlIIlIIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlllIlIlIIIlIIlIIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlllIlIlIIIlIIlIIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlllIlIlIIIlIIlIIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIlllIlIlIIIlIIlIIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return QuadBounds.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIlllIlIlIIIlIIlIIl;
    }
    
    public boolean isFaceQuad(final EnumFacing lllllllllllllIIlllIlIlIIlIIIIIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIlllIlIlIIlIIIIIll.ordinal()]) {
            case 1: {
                final float lllllllllllllIIlllIlIlIIlIIIIIlI = this.getMinY();
                final float lllllllllllllIIlllIlIlIIIllllIll = this.getMaxY();
                final float lllllllllllllIIlllIlIlIIIlllIlII = 0.0f;
                break;
            }
            case 2: {
                final float lllllllllllllIIlllIlIlIIlIIIIIIl = this.getMinY();
                final float lllllllllllllIIlllIlIlIIIllllIlI = this.getMaxY();
                final float lllllllllllllIIlllIlIlIIIlllIIll = 1.0f;
                break;
            }
            case 3: {
                final float lllllllllllllIIlllIlIlIIlIIIIIII = this.getMinZ();
                final float lllllllllllllIIlllIlIlIIIllllIIl = this.getMaxZ();
                final float lllllllllllllIIlllIlIlIIIlllIIlI = 0.0f;
                break;
            }
            case 4: {
                final float lllllllllllllIIlllIlIlIIIlllllll = this.getMinZ();
                final float lllllllllllllIIlllIlIlIIIllllIII = this.getMaxZ();
                final float lllllllllllllIIlllIlIlIIIlllIIIl = 1.0f;
                break;
            }
            case 5: {
                final float lllllllllllllIIlllIlIlIIIllllllI = this.getMinX();
                final float lllllllllllllIIlllIlIlIIIlllIlll = this.getMaxX();
                final float lllllllllllllIIlllIlIlIIIlllIIII = 0.0f;
                break;
            }
            case 6: {
                final float lllllllllllllIIlllIlIlIIIlllllIl = this.getMinX();
                final float lllllllllllllIIlllIlIlIIIlllIllI = this.getMaxX();
                final float lllllllllllllIIlllIlIlIIIllIllll = 1.0f;
                break;
            }
            default: {
                return false;
            }
        }
        final float lllllllllllllIIlllIlIlIIIlllllII;
        final float lllllllllllllIIlllIlIlIIIllIlllI;
        final float lllllllllllllIIlllIlIlIIIlllIlIl;
        return lllllllllllllIIlllIlIlIIIlllllII == lllllllllllllIIlllIlIlIIIllIlllI && lllllllllllllIIlllIlIlIIIlllIlIl == lllllllllllllIIlllIlIlIIIllIlllI;
    }
    
    public float getMaxY() {
        return this.maxY;
    }
    
    public boolean isFullQuad(final EnumFacing lllllllllllllIIlllIlIlIIIllIIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIlllIlIlIIIllIIIIl.ordinal()]) {
            case 1:
            case 2: {
                final float lllllllllllllIIlllIlIlIIIllIIIII = this.getMinX();
                final float lllllllllllllIIlllIlIlIIIlIlllII = this.getMaxX();
                final float lllllllllllllIIlllIlIlIIIlIllIII = this.getMinZ();
                final float lllllllllllllIIlllIlIlIIIlIlIlII = this.getMaxZ();
                break;
            }
            case 3:
            case 4: {
                final float lllllllllllllIIlllIlIlIIIlIlllll = this.getMinX();
                final float lllllllllllllIIlllIlIlIIIlIllIll = this.getMaxX();
                final float lllllllllllllIIlllIlIlIIIlIlIlll = this.getMinY();
                final float lllllllllllllIIlllIlIlIIIlIlIIll = this.getMaxY();
                break;
            }
            case 5:
            case 6: {
                final float lllllllllllllIIlllIlIlIIIlIllllI = this.getMinY();
                final float lllllllllllllIIlllIlIlIIIlIllIlI = this.getMaxY();
                final float lllllllllllllIIlllIlIlIIIlIlIllI = this.getMinZ();
                final float lllllllllllllIIlllIlIlIIIlIlIIlI = this.getMaxZ();
                break;
            }
            default: {
                return false;
            }
        }
        final float lllllllllllllIIlllIlIlIIIlIlllIl;
        final float lllllllllllllIIlllIlIlIIIlIllIIl;
        final float lllllllllllllIIlllIlIlIIIlIlIlIl;
        final float lllllllllllllIIlllIlIlIIIlIlIIIl;
        return lllllllllllllIIlllIlIlIIIlIlllIl == 0.0f && lllllllllllllIIlllIlIlIIIlIllIIl == 1.0f && lllllllllllllIIlllIlIlIIIlIlIlIl == 0.0f && lllllllllllllIIlllIlIlIIIlIlIIIl == 1.0f;
    }
    
    public float getMinX() {
        return this.minX;
    }
    
    public float getMinZ() {
        return this.minZ;
    }
    
    public QuadBounds(final int[] lllllllllllllIIlllIlIlIIlIlIIIlI) {
        this.minX = Float.MAX_VALUE;
        this.minY = Float.MAX_VALUE;
        this.minZ = Float.MAX_VALUE;
        this.maxX = -3.4028235E38f;
        this.maxY = -3.4028235E38f;
        this.maxZ = -3.4028235E38f;
        final int lllllllllllllIIlllIlIlIIlIlIlIIl = lllllllllllllIIlllIlIlIIlIlIIIlI.length / 4;
        for (int lllllllllllllIIlllIlIlIIlIlIlIII = 0; lllllllllllllIIlllIlIlIIlIlIlIII < 4; ++lllllllllllllIIlllIlIlIIlIlIlIII) {
            final int lllllllllllllIIlllIlIlIIlIlIIlll = lllllllllllllIIlllIlIlIIlIlIlIII * lllllllllllllIIlllIlIlIIlIlIlIIl;
            final float lllllllllllllIIlllIlIlIIlIlIIllI = Float.intBitsToFloat(lllllllllllllIIlllIlIlIIlIlIIIlI[lllllllllllllIIlllIlIlIIlIlIIlll + 0]);
            final float lllllllllllllIIlllIlIlIIlIlIIlIl = Float.intBitsToFloat(lllllllllllllIIlllIlIlIIlIlIIIlI[lllllllllllllIIlllIlIlIIlIlIIlll + 1]);
            final float lllllllllllllIIlllIlIlIIlIlIIlII = Float.intBitsToFloat(lllllllllllllIIlllIlIlIIlIlIIIlI[lllllllllllllIIlllIlIlIIlIlIIlll + 2]);
            if (this.minX > lllllllllllllIIlllIlIlIIlIlIIllI) {
                this.minX = lllllllllllllIIlllIlIlIIlIlIIllI;
            }
            if (this.minY > lllllllllllllIIlllIlIlIIlIlIIlIl) {
                this.minY = lllllllllllllIIlllIlIlIIlIlIIlIl;
            }
            if (this.minZ > lllllllllllllIIlllIlIlIIlIlIIlII) {
                this.minZ = lllllllllllllIIlllIlIlIIlIlIIlII;
            }
            if (this.maxX < lllllllllllllIIlllIlIlIIlIlIIllI) {
                this.maxX = lllllllllllllIIlllIlIlIIlIlIIllI;
            }
            if (this.maxY < lllllllllllllIIlllIlIlIIlIlIIlIl) {
                this.maxY = lllllllllllllIIlllIlIlIIlIlIIlIl;
            }
            if (this.maxZ < lllllllllllllIIlllIlIlIIlIlIIlII) {
                this.maxZ = lllllllllllllIIlllIlIlIIlIlIIlII;
            }
        }
    }
    
    public float getMaxZ() {
        return this.maxZ;
    }
    
    public float getMaxX() {
        return this.maxX;
    }
    
    public float getMinY() {
        return this.minY;
    }
}
