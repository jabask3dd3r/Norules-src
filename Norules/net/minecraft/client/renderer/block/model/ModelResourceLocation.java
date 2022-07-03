package net.minecraft.client.renderer.block.model;

import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import java.util.*;

public class ModelResourceLocation extends ResourceLocation
{
    private final /* synthetic */ String variant;
    
    @Override
    public boolean equals(final Object lllllllllllllIllIllllIllIllIIIlI) {
        if (this == lllllllllllllIllIllllIllIllIIIlI) {
            return true;
        }
        if (lllllllllllllIllIllllIllIllIIIlI instanceof ModelResourceLocation && super.equals(lllllllllllllIllIllllIllIllIIIlI)) {
            final ModelResourceLocation lllllllllllllIllIllllIllIllIIIIl = (ModelResourceLocation)lllllllllllllIllIllllIllIllIIIlI;
            return this.variant.equals(lllllllllllllIllIllllIllIllIIIIl.variant);
        }
        return false;
    }
    
    public String getVariant() {
        return this.variant;
    }
    
    protected ModelResourceLocation(final int lllllllllllllIllIllllIlllIIlIIIl, final String... lllllllllllllIllIllllIlllIIlIIII) {
        super(0, new String[] { lllllllllllllIllIllllIlllIIlIIII[0], lllllllllllllIllIllllIlllIIlIIII[1] });
        this.variant = (StringUtils.isEmpty((CharSequence)lllllllllllllIllIllllIlllIIlIIII[2]) ? "normal" : lllllllllllllIllIllllIlllIIlIIII[2].toLowerCase(Locale.ROOT));
    }
    
    public ModelResourceLocation(final String lllllllllllllIllIllllIllIllllIlI, final String lllllllllllllIllIllllIllIlllIllI) {
        this(0, parsePathString(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIllllIllIllllIlI)).append('#').append((lllllllllllllIllIllllIllIlllIllI == null) ? "normal" : lllllllllllllIllIllllIllIlllIllI))));
    }
    
    public ModelResourceLocation(final ResourceLocation lllllllllllllIllIllllIlllIIIIIII, final String lllllllllllllIllIllllIllIlllllll) {
        this(lllllllllllllIllIllllIlllIIIIIII.toString(), lllllllllllllIllIllllIllIlllllll);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(super.toString())).append('#').append(this.variant));
    }
    
    public ModelResourceLocation(final String lllllllllllllIllIllllIlllIIIlIlI) {
        this(0, parsePathString(lllllllllllllIllIllllIlllIIIlIlI));
    }
    
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.variant.hashCode();
    }
    
    protected static String[] parsePathString(final String lllllllllllllIllIllllIllIllIllIl) {
        final String[] lllllllllllllIllIllllIllIlllIIII = { null, lllllllllllllIllIllllIllIllIllIl, null };
        final int lllllllllllllIllIllllIllIllIllll = lllllllllllllIllIllllIllIllIllIl.indexOf(35);
        String lllllllllllllIllIllllIllIllIlllI = lllllllllllllIllIllllIllIllIllIl;
        if (lllllllllllllIllIllllIllIllIllll >= 0) {
            lllllllllllllIllIllllIllIlllIIII[2] = lllllllllllllIllIllllIllIllIllIl.substring(lllllllllllllIllIllllIllIllIllll + 1, lllllllllllllIllIllllIllIllIllIl.length());
            if (lllllllllllllIllIllllIllIllIllll > 1) {
                lllllllllllllIllIllllIllIllIlllI = lllllllllllllIllIllllIllIllIllIl.substring(0, lllllllllllllIllIllllIllIllIllll);
            }
        }
        System.arraycopy(ResourceLocation.splitObjectName(lllllllllllllIllIllllIllIllIlllI), 0, lllllllllllllIllIllllIllIlllIIII, 0, 2);
        return lllllllllllllIllIllllIllIlllIIII;
    }
}
