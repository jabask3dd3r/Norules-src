package net.minecraft.client.renderer.chunk;

import net.minecraft.util.*;
import java.util.*;

public class SetVisibility
{
    private static final /* synthetic */ int COUNT_FACES;
    private /* synthetic */ long bits;
    
    public void setVisible(final EnumFacing lllllllllllllIIllIIlIlIIlIlIlllI, final EnumFacing lllllllllllllIIllIIlIlIIlIllIIIl, final boolean lllllllllllllIIllIIlIlIIlIlIllII) {
        this.setBit(lllllllllllllIIllIIlIlIIlIlIlllI.ordinal() + lllllllllllllIIllIIlIlIIlIllIIIl.ordinal() * SetVisibility.COUNT_FACES, lllllllllllllIIllIIlIlIIlIlIllII);
        this.setBit(lllllllllllllIIllIIlIlIIlIllIIIl.ordinal() + lllllllllllllIIllIIlIlIIlIlIlllI.ordinal() * SetVisibility.COUNT_FACES, lllllllllllllIIllIIlIlIIlIlIllII);
    }
    
    private void clearBit(final int lllllllllllllIIllIIlIlIIIllIIllI) {
        this.bits &= ~(1 << lllllllllllllIIllIIlIlIIIllIIllI);
    }
    
    public void setAllVisible(final boolean lllllllllllllIIllIIlIlIIlIlIIllI) {
        if (lllllllllllllIIllIIlIlIIlIlIIllI) {
            this.bits = -1L;
        }
        else {
            this.bits = 0L;
        }
    }
    
    private void setBit(final int lllllllllllllIIllIIlIlIIIlllIIll, final boolean lllllllllllllIIllIIlIlIIIlllIlIl) {
        if (lllllllllllllIIllIIlIlIIIlllIlIl) {
            this.setBit(lllllllllllllIIllIIlIlIIIlllIIll);
        }
        else {
            this.clearBit(lllllllllllllIIllIIlIlIIIlllIIll);
        }
    }
    
    static {
        COUNT_FACES = EnumFacing.values().length;
    }
    
    public boolean isVisible(final EnumFacing lllllllllllllIIllIIlIlIIlIlIIIIl, final EnumFacing lllllllllllllIIllIIlIlIIlIIlllIl) {
        return this.getBit(lllllllllllllIIllIIlIlIIlIlIIIIl.ordinal() + lllllllllllllIIllIIlIlIIlIIlllIl.ordinal() * SetVisibility.COUNT_FACES);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIllIIlIlIIlIIlIIII = new StringBuilder();
        lllllllllllllIIllIIlIlIIlIIlIIII.append(' ');
        short lllllllllllllIIllIIlIlIIlIIIIllI;
        boolean lllllllllllllIIllIIlIlIIlIIIIlll = ((EnumFacing[])(Object)(lllllllllllllIIllIIlIlIIlIIIIllI = (short)(Object)EnumFacing.values())).length != 0;
        for (double lllllllllllllIIllIIlIlIIlIIIlIII = 0; lllllllllllllIIllIIlIlIIlIIIlIII < (lllllllllllllIIllIIlIlIIlIIIIlll ? 1 : 0); ++lllllllllllllIIllIIlIlIIlIIIlIII) {
            final EnumFacing lllllllllllllIIllIIlIlIIlIIIllll = lllllllllllllIIllIIlIlIIlIIIIllI[lllllllllllllIIllIIlIlIIlIIIlIII];
            lllllllllllllIIllIIlIlIIlIIlIIII.append(' ').append(lllllllllllllIIllIIlIlIIlIIIllll.toString().toUpperCase().charAt(0));
        }
        lllllllllllllIIllIIlIlIIlIIlIIII.append('\n');
        lllllllllllllIIllIIlIlIIlIIIIlll = (((EnumFacing[])(Object)(lllllllllllllIIllIIlIlIIlIIIIllI = (short)(Object)EnumFacing.values())).length != 0);
        for (double lllllllllllllIIllIIlIlIIlIIIlIII = 0; lllllllllllllIIllIIlIlIIlIIIlIII < (lllllllllllllIIllIIlIlIIlIIIIlll ? 1 : 0); ++lllllllllllllIIllIIlIlIIlIIIlIII) {
            final EnumFacing lllllllllllllIIllIIlIlIIlIIIlllI = lllllllllllllIIllIIlIlIIlIIIIllI[lllllllllllllIIllIIlIlIIlIIIlIII];
            lllllllllllllIIllIIlIlIIlIIlIIII.append(lllllllllllllIIllIIlIlIIlIIIlllI.toString().toUpperCase().charAt(0));
            final String lllllllllllllIIllIIlIlIIlIIIIIlI;
            final float lllllllllllllIIllIIlIlIIlIIIIIll = ((EnumFacing[])(Object)(lllllllllllllIIllIIlIlIIlIIIIIlI = (String)(Object)EnumFacing.values())).length;
            for (String lllllllllllllIIllIIlIlIIlIIIIlII = (String)0; lllllllllllllIIllIIlIlIIlIIIIlII < lllllllllllllIIllIIlIlIIlIIIIIll; ++lllllllllllllIIllIIlIlIIlIIIIlII) {
                final EnumFacing lllllllllllllIIllIIlIlIIlIIIllIl = lllllllllllllIIllIIlIlIIlIIIIIlI[lllllllllllllIIllIIlIlIIlIIIIlII];
                if (lllllllllllllIIllIIlIlIIlIIIlllI == lllllllllllllIIllIIlIlIIlIIIllIl) {
                    lllllllllllllIIllIIlIlIIlIIlIIII.append("  ");
                }
                else {
                    final boolean lllllllllllllIIllIIlIlIIlIIIllII = this.isVisible(lllllllllllllIIllIIlIlIIlIIIlllI, lllllllllllllIIllIIlIlIIlIIIllIl);
                    lllllllllllllIIllIIlIlIIlIIlIIII.append(' ').append(lllllllllllllIIllIIlIlIIlIIIllII ? 'Y' : 'n');
                }
            }
            lllllllllllllIIllIIlIlIIlIIlIIII.append('\n');
        }
        return String.valueOf(lllllllllllllIIllIIlIlIIlIIlIIII);
    }
    
    private boolean getBit(final int lllllllllllllIIllIIlIlIIIlllllIl) {
        return (this.bits & (long)(1 << lllllllllllllIIllIIlIlIIIlllllIl)) != 0x0L;
    }
    
    private void setBit(final int lllllllllllllIIllIIlIlIIIllIllII) {
        this.bits |= 1 << lllllllllllllIIllIIlIlIIIllIllII;
    }
    
    public void setManyVisible(final Set<EnumFacing> lllllllllllllIIllIIlIlIIlIllllII) {
        for (final EnumFacing lllllllllllllIIllIIlIlIIlIllllll : lllllllllllllIIllIIlIlIIlIllllII) {
            for (final EnumFacing lllllllllllllIIllIIlIlIIlIlllllI : lllllllllllllIIllIIlIlIIlIllllII) {
                this.setVisible(lllllllllllllIIllIIlIlIIlIllllll, lllllllllllllIIllIIlIlIIlIlllllI, true);
            }
        }
    }
}
